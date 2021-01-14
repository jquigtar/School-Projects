import logo from './logo.svg';
import './App.css';

var AWS = require('aws-sdk');
var myConfig = new AWS.Config({
  accessKeyId: process.env.REACT_APP_AWS_ACCESS_KEY_ID,
  secretAccessKey: process.env.REACT_APP_AWS_SECRET_ACCESS_KEY,
  region: process.env.REACT_APP_AWS_REGION,
})
const s3 = new AWS.S3(myConfig);
var bucketName = process.env.REACT_APP_AWS_BUCKET_NAME;
const docClient = new AWS.DynamoDB.DocumentClient(myConfig);
var table = process.env.REACT_APP_TABLE_NAME;

var firstName;
var lastName;
var storeFirst;
var storeLast;
var nameRE = /[a-zA-z]+\s/g;
var attributeRE = /\s?[a-zA-Z]+=[a-zA-Z0-9-]+\s?/g;
var spaceRE = /\s/g;
var peoples = [];

const App = () => {
  /**
   * handleLoad
   * 
   * handles when load data button is clicked, will put data from given url in program 4
   * in an s3 bucket and load the data from this url into a dynamodb table.
   * handles if there is different data loaded from same url multiple times.
   * https://stackoverflow.com/questions/19761086/javascript-to-split-string-by-end-of-line-character-and-read-each-line/42617914
   */
  const handleLoad = () =>{
    document.getElementById('status-area').innerHTML="Loading Data...";
    //put data from hardcoded url into my own s3 bucket
    fetch('https://s3-us-west-2.amazonaws.com/css490/input.txt')
      .then(Response => Response.blob())
      .then(data => {
        var uploadParams = {
          Bucket: bucketName,
          Key: 'input.txt',
          Body: data,
          ACL: 'public-read',
        };
        s3.upload(uploadParams, (err,dater) =>{
          if(err){
            console.log("error", err);
          } if(dater) {
            console.log("upload success", dater.Location);
          }
        });
      });

    //load data from url into dynamodb table
    fetch('https://s3-us-west-2.amazonaws.com/css490/input.txt')
      .then(Response => Response.text())
      .then(dataFromFile => {
        var char = '\n';
        var i = 0;
        var j = 0;
        while((j = dataFromFile.indexOf(char, i)) !== -1){
          var tableParams = {
            TableName: table,
            Item: {},
          }
          var person = {};
          var line = dataFromFile.substring(i,j)
          if(line){
            var names = line.match(nameRE);
            if (names){
              storeLast = names[0].replaceAll(spaceRE, '');
              storeFirst = names[1].replaceAll(spaceRE, '');
              person['FirstName'] = storeFirst;
              person['LastName'] = storeLast;
              var attributes = line.match(attributeRE);
              if(attributes){
                for(let k = 0; k < attributes.length; k++){
                  var words = attributes[k].split('=');
                  person[words[0].replaceAll(spaceRE, '')] = words[1].replaceAll(spaceRE, '');
                }
                tableParams.Item = person;
                docClient.put(tableParams, function(err, data) {
                  if(err){
                    console.error("Unable to add item. Erro JSON:", JSON.stringify(err,null,2));
                  } else {
                    console.log("added item:", JSON.stringify(data,null,2))
                  }
                })
              }
            }
          }
          i = j + 1;
        }
        document.getElementById('status-area').innerHTML="Done Loading";
      })
      .catch((error) => {
        console.log(error);
      });
  }

  /**
   * handleClear
   * 
   * this will clear the object from my s3 storage and remove all items from the 
   * dynamodb table when the clear data button is hit
   */
  const handleClear = () =>{
    document.getElementById('status-area').innerHTML="Clearing Data..."

    //deleting obect in s3
    var deletes3Params = { 
      Bucket: bucketName,
      Key: 'input.txt',
    };
    s3.deleteObject(deletes3Params, function(err, data){
      if(err){
        console.log("error", err);
      }else{
        console.log("delete Success");
      }
    });

    //making sure that data is cleared from table if just accessing site
    var scanParams = {
      TableName: table,
    }
    docClient.scan(scanParams, onScan);
    function onScan(err, data) {
      if (err) {
        console.error("Unable to scan the table. Error JSON:", JSON.stringify(err, null, 2));
      } else {
        console.log("Scan succeeded.");
        data.Items.forEach(function(person) {
            peoples.unshift(person);
        });
        if (typeof data.LastEvaluatedKey != "undefined") {
          console.log("Scanning for more...");
          scanParams.ExclusiveStartKey = data.LastEvaluatedKey;
          docClient.scan(scanParams, onScan);
        }
      }
    }

    //clearing dynamodb table
    for(let i = 0; i < peoples.length; i++){
      let fnameToGet = peoples[i].FirstName;
      let lnameToGet = peoples[i].LastName;
      var deletedbparams = {
        TableName: table,
        Key: {
          FirstName: fnameToGet,
          LastName: lnameToGet,
        }
      };
      docClient.delete(deletedbparams, function(err,data) {
        if (err){
          console.error("unable to delete item. error JSON:", JSON.stringify(err, null, 2));
        } else {
            console.log("Delete Item succeeded:", JSON.stringify(data, null, 2));
        }
      });
    }
    peoples = [];
    
    document.getElementById('status-area').innerHTML="Data Cleared"
  }

  /**
   * handleSearchInput
   * 
   * this will query the database table for either the first name, last name,
   * or both first and last name, from the given names in the query section
   * of the webpage
   */
  const handleSearchInput = () => {
    document.getElementById('printHere').innerHTML="";
    if(firstName){
      if(lastName){
        //if first name and last name query for both
        var queryParams = {
          TableName: table,
          KeyConditionExpression: "#FirstName = :fname AND LastName = :lname",
          ExpressionAttributeValues: {
            ":fname": firstName,
            ":lname": lastName,
          }
        };
        docClient.query(queryParams, function (err, data) {
          if (err) {
            console.log("unable to query. error: ", JSON.stringify(err, null, 2));
          } else {
            data.Items.forEach(function(item) {
              let newDiv = document.createElement("div");
              let newContent = document.createTextNode(JSON.stringify(item));
              newDiv.appendChild(newContent);
              document.getElementById('printHere').insertAdjacentElement('beforeend',newDiv);            })
          }
        });
      } else {
        //if only first name query for just first name
        queryParams = {
          TableName: table,
          KeyConditionExpression: "FirstName = :fname",
          ExpressionAttributeValues: {
            ":fname": firstName,
          }
        };
        docClient.query(queryParams, function (err, data) {
          if (err) {
            console.log("unable to query. error: ", JSON.stringify(err, null, 2));
          } else {
            data.Items.forEach(function(item) {
              let newDiv = document.createElement("div");
              let newContent = document.createTextNode(JSON.stringify(item));
              newDiv.appendChild(newContent);
              document.getElementById('printHere').insertAdjacentElement('beforeend',newDiv);            })
          }
        });
      }
    }else if(lastName){
      //if no firstname, query for only lastname 
      queryParams = {
        TableName: table,
        IndexName: 'LastName-index',
        KeyConditionExpression: "LastName = :lname",
        ExpressionAttributeValues: {
          ":lname": lastName,
        }
      };
      docClient.query(queryParams, function (err, data) {
        if (err) {
          console.log("unable to query. error: ", JSON.stringify(err, null, 2));
        } else {
          data.Items.forEach(function(item) {
            let newDiv = document.createElement("div");
            let newContent = document.createTextNode(JSON.stringify(item));
            newDiv.appendChild(newContent);
            document.getElementById('printHere').insertAdjacentElement('beforeend',newDiv);
          })
        }
      });
    } else {
      //no names
      console.log("no names.");
      document.getElementById('printHere').innerHTML="";
    }
  }
  const handleSearchInputFirst = Event =>{
    firstName = Event.target.value;
  }
  
  const handleSearchInputLast = Event => {
    lastName = Event.target.value;
  }

  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p className="App-text">Jordan Quigtar CSS436 Program 4</p>
      </header>
      <div id="big-container">
        <div id="middle-div">
          <div id="data-div">
            <div>
              <h2>Data Section:</h2>
            </div>
            <div>
              <input type="button" value="Load Data" onClick={handleLoad}/>
              <input type="button" value="Clear Data" onClick={handleClear}/>
            </div>
            <div id="status-area"></div>
          </div>
          <div id="query-div">
            <div>
              <h2>Query section:</h2>
            </div>
            <div>
              <form>
                <label for="fname">First name:</label>
                <input type="text" id="fname" name="fname" onChange={handleSearchInputFirst}/><br/><br/>
                <label for="lname">Last name:</label>
                <input type="text" id="lname" name="lname" onChange={handleSearchInputLast}/><br/><br/>
              </form>
            </div>
              <input type="button" value="Query" onClick={handleSearchInput}/>
          </div>
        </div>
        <div id="query-results">
          <h2>Query Results:</h2>
          <div id="printHere"></div>
        </div>
      </div>
      <div id="footer">
        <h3>Location of object: &nbsp;</h3>
        <a href="https://jqcss436program4.s3-us-west-2.amazonaws.com/input.txt">Link</a>
      </div>
    </div>
  );
}

export default App;
