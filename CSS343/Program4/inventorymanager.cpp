//
// Created by Jordan Quigtar on 3/11/20.
//

#include "inventorymanager.h"

using namespace std;

void InventoryManager::buildMovies(ifstream &inFile) {
    string line;
    char type;
    int stock;
    string director;
    string title;
    int year;
    string actor;
    int month;

    if (inFile.is_open()) {
        while (getline(inFile, line)) {
            if(line[0] == 'C'){
                parseClassic(line, type, stock, director, title, actor, month, year);
                ClassicMovie *theMovie = new ClassicMovie(stock, director,title, actor, month, year);
                classicInventory.InsertClassic(theMovie);
            }else if (line[0] == 'F'){
                parseFD(line, type, stock, director, title, year);
                Funny *theMovie = new Funny(stock, director, title, year);
                comedyInventory.InsertFunny(theMovie);
            }else if(line[0] == 'D'){
                parseFD(line,type, stock, director, title, year);
                Drama *theMovie = new Drama(stock, director, title, year);
                dramaInventory.InsertDrama(theMovie);
            }
        }
    }
}

void InventoryManager::parseClassic(string toParse, char &type, int &stock,
        string &director, string &title, string &actor, int &month, int &year) {

    istringstream iss(toParse);
    string data;

    getline(iss, data, ',');
    istringstream(data) >> type;

    getline(iss, data, ',');
    istringstream(data) >> stock;

    getline(iss, data, ',');
    director = data;

    getline(iss, data, ',');
    title = data;

    //getline(iss, data, ',');
    string first;
    string last;

    iss >> first >> last >> month >> year;
    actor = first + " " + last;

}

void InventoryManager::parseFD(string toParse, char &type, int &stock,
        string &director, string &title, int &year) {

    istringstream iss(toParse);
    string data;

    getline(iss, data, ',');
    istringstream(data) >> type;
    getline(iss, data, ',');
    istringstream(data) >> stock;
    getline(iss, data, ',');
    director = data;
    getline(iss, data, ',');
    title = data;
    getline(iss, data, ',');
    istringstream(data) >> year;
}

void InventoryManager::buildCustomers(ifstream &inFile) {
    string line;
    int ID;
    string first;
    string last;
    if (inFile.is_open()) {
        while (getline(inFile, line)) {
            istringstream iss(line);
            iss >> ID >> last >> first;
            Customer *newCustomer = new Customer(ID, first, last);
            customers.insert(newCustomer);
        }
    }
}

void InventoryManager::processTransactions(ifstream &inFile) {
    string line;
    int ID;
    char type;
    char mediaType;
    char genre;
    string title;
    int year;
    int month;
    string actor;
    string director;
    if (inFile.is_open()) {
        while (getline(inFile, line)) {
            string lineToSave = line;
            istringstream iss(line);
            iss >> type;
            if(type == 'I'){
                comedyInventory.Display();
                dramaInventory.Display();
                classicInventory.Display();
            }else if (type == 'H'){
                iss >> ID;
                Customer *toFind = nullptr;
                if(customers.retrieve(ID, toFind)){
                    toFind->displayHistory();
                }
            }else if(type == 'B'){
                Transaction *borrowed = nullptr;
                Customer* customer = nullptr;
                Movie* movie = nullptr;
                iss >> ID >> mediaType >> genre;
                string data;
                getline(iss,data,',');
                title = data;
                iss >> year;
                if(genre == 'F') {
                    if (customers.retrieve(ID, customer) && comedyInventory.RetrieveFunny(title, movie) &&
                        mediaType == 'D') {
                        if (movie->getStock()!= 0) {
                            //borrowed = new Borrow(movie);
                            customer->addTransaction(lineToSave);
                        }
                    } else {
                        cout << "ERROR: invalid borrow request" << lineToSave << endl;
                    }
                }else if(genre == 'D') {
                    iss >> ID >> mediaType >> genre;
                    string data;
                    getline(iss,data,',');
                    director = data;
                    iss >> title;
                    if (customers.retrieve(ID, customer) && dramaInventory.RetrieveDrama(director, movie) &&
                        mediaType == 'D') {
                        if (movie->getStock() != 0) {
                            //borrowed = new Borrow(movie);
                            customer->addTransaction(lineToSave);
                        }
                    } else {
                        cout << "ERROR: invalid borrow request" <<  lineToSave << endl;
                    }
                } else if(genre == 'C') {
                    string first;
                    string last;
                    iss >> ID >> mediaType >> genre >> month >> year >> first >> last;
                    actor = first + " " + last;
                    if (customers.retrieve(ID, customer) && classicInventory.RetrieveClassic(year, movie) &&
                        mediaType == 'D') {
                        if (movie->getStock() != 0) {
                            //borrowed = new Borrow(movie);
                            customer->addTransaction(lineToSave);

                        }
                    } else {
                        cout << "ERROR: invalid borrow request" << lineToSave << endl;
                    }
                }else{
                    cout << "ERROR: invalid borrow request" << lineToSave << endl;
                }
            }else if(type == 'R'){
                Transaction *returnT = nullptr;
                Customer* customer = nullptr;
                Movie* movie = nullptr;
                iss >> ID >> mediaType >> genre;
                string data;
                getline(iss,data,',');
                title = data;
                iss >> year;
                if(genre == 'F') {
                    if (customers.retrieve(ID, customer) && comedyInventory.RetrieveFunny(title, movie) &&
                        mediaType == 'D') {
                        if (movie->getStock()!= 0) {
                            //returnT = new Return(movie);
                            customer->addTransaction(lineToSave);
                        }
                    } else {
                        cout << "ERROR: invalid return request" << lineToSave << endl;
                    }
                }else if(genre == 'D') {
                    iss >> ID >> mediaType >> genre;
                    string data;
                    getline(iss,data,',');
                    director = data;
                    iss >> title;
                    if (customers.retrieve(ID, customer) && dramaInventory.RetrieveDrama(director, movie) &&
                        mediaType == 'D') {
                        if (movie->getStock() != 0) {
                            //returnT = new Return(movie);
                            customer->addTransaction(lineToSave);
                        }
                    } else {
                        cout << "ERROR: invalid return request" << lineToSave << endl;
                    }
                } else if(genre == 'C') {
                    string first;
                    string last;
                    iss >> ID >> mediaType >> genre >> month >> year >> first >> last;
                    actor = first + " " + last;
                    if (customers.retrieve(ID, customer) && classicInventory.RetrieveClassic(year, movie) &&
                        mediaType == 'D') {
                        if (movie->getStock() != 0) {
                            //returnT = new Return(movie);
                            customer->addTransaction(lineToSave);
                        }
                    } else {
                        cout << "ERROR: invalid return request" <<  lineToSave << endl;
                    }
                }else{
                    cout << "ERROR: invalid return request" << lineToSave << endl;
                }
            }else{
                cout << "invalid transaction: " << lineToSave << endl;
            }
        }
    }
}
