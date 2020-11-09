import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Webcrawl
 *
 * this is the main class for a web crawl program assigned in CSS436 by professor Dimpsey.
 * this program will take in a initial website from the command line, and a number of hops
 * and hop that amount of times from the initial website through links on the webpage
 */
public class Webcrawl {
    /**
     * confirmHttp
     *
     * this is a function that uses a regular expression to determine if the string given
     * in the parameter begins with http or https extension.
     * @param url
     * @return true if the string begins with https or http and false if it does not
     */
    public static boolean confirmHttp(String url){
        Pattern p = Pattern.compile("^(https?)://.*$");     //creates regular expression pattern to match http
        Matcher m = p.matcher(url);     //checks to see if url matches regular expression
        return m.matches();
    }

    /**
     * findRefs
     *
     * this is a function that will take a string and find all matches of a webpage within a
     * <a href> anchor. this function assumes that the string being passed in is a html from
     * a webpage
     * @param htmlResponse
     * @return an ArrayList of webpages found within <a href> anchors on a webpage
     */
    public static ArrayList<String> findRefs (String htmlResponse){
        Pattern p = Pattern.compile("<a href=\"(.*?)\"");   //regular expression to find <a href anchors
        Matcher m = p.matcher(htmlResponse); // checks entire html response for matches
        ArrayList<String> urls = new ArrayList<>();
        while (m.find()) {  //while there are matches to regular expression
            if(confirmHttp(m.group(1))) {   //if website found in () group of regex
                urls.add(m.group(1)); // this variable should contain the link URL
            }
        }
        return urls;
    }

    /**
     * isVisited
     *
     * this is a function that takes in an ArrayList of strings, and a target string
     * and will return true or false on whether or not the string exists within the ArrayList
     * @param visited
     * @param target
     * @return true if the target String exists in the ArrayList, false if not
     */
    public static boolean isVisited(ArrayList<String> visited, String target){
        return visited.contains(target);
    }

    /**
     * getResponse
     *
     * this is a function that uses httpClient, HttpRequest, and HttpResponse to send a
     * http GET request to a website(passed in as a string in the parameter) and returns the response
     * the function will return null if there is an error in the response
     * @param website
     * @return returns the response from the website if website returns a response, false if GET request has an error
     */
    public static HttpResponse<String> getResponse(String website){
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(website))
                .build();

        // sending a http GET request from given url

        HttpResponse<String> response;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response;    //if given a response return the HTTP response
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * getResponseHTML
     *
     * this is a function that will return the HTML from a Http response as a string
     * this function assumes that the response passed into the parameter is correct
     * @param response
     * @return a string of an html from the given http response
     */
    public static String getResponseHTML(HttpResponse<String> response){
        return response.body();
    }

    /**
     * printResponseHTML
     *
     * this function prints the HTML from a http response to the console
     * this function assumes that the response passed into the parameter is correct
     * @param response
     */
    public static void printResponseHTML(HttpResponse<String> response){
        System.out.println(response.body());
    }

    /**
     * getResponseCode
     *
     * this function takes in a httpResponse and returns the response code
     * this function assumes that the response passed into the parameter is correct
     * @param response
     * @return an int that is an http response code
     */
    public static int getResponseCode (HttpResponse<String> response){
        return response.statusCode();
    }

    /**
     * findFirstGoodURL
     *
     * this is a function that takes in two ArrayLists and searches for the first non duplicate string from the
     * refs list in the visited list. This function also gets a response code from a website given the string found
     * if the string found does not give back good response code it will continually search for the next non
     * duplicate string until that url gives back a good response code.
     * @param visited
     * @param refs
     * @return the string of the first non duplicate website that returns a good response code
     */
    public static String findFirstGoodURL(ArrayList<String> visited, ArrayList<String> refs){
        String website;
        if(visited.size() == 0){    // if first website
            if(refs.size() > 0) {
                for (int i = 0; i < refs.size(); i++) {
                    int code = getResponseCode(getResponse(refs.get(i)));
                    if(code > 299 && code < 400){
                        website = handleRedirect(getResponse(refs.get(i)));
                        code = getResponseCode(getResponse(website));
                        if (isGoodCode(code)) {
                            if (!isVisited(visited, refs.get(i))) {
                                return website;
                            }
                        }
                    }else if (code > 499 & code <600){
                        code = getResponseCode(getResponse(refs.get(i)));
                    }
                    if (isGoodCode(code)) {
                        return refs.get(i);
                    }
                }
            }else{  // no find links on webpage
                return null;
            }
        }else {
            if(refs.size() > 0) {
                for (int i = 0; i < refs.size(); i++) {
                    int code = getResponseCode(getResponse(refs.get(i)));
                    if(code > 299 && code < 400){
                        website = handleRedirect(getResponse(refs.get(i)));
                        code = getResponseCode(getResponse(website));
                        if (isGoodCode(code)) {
                            if (!isVisited(visited, refs.get(i))) {
                                return website;
                            }
                        }
                    }else if (code > 499 & code <600){
                        code = getResponseCode(getResponse(refs.get(i)));
                    }
                    if (isGoodCode(code)) {
                        if (!isVisited(visited, refs.get(i))) {
                            return refs.get(i);
                        }
                    }
                }
            }else{
                return null;
            }
        }
        return null;
    }

    /**
     * isGoodCode
     *
     * this function is used to return whether or not a response code was a 200 response code
     * @param code
     * @return returns true if int code is between 199 > x > 300
     */
    public static boolean isGoodCode(int code){
        return (code > 99 && code < 300);
    }

    /**
     * handleRedirect
     *
     * this is a function that takes a HttpResponse and finds the link the response wants to
     * redirect too. this function assumes that the response has already returned a 300 level response
     * and also assumes that the url to redirect to is the first reference toa website on the html of this webpage
     * @param response
     * @return returns a string of url to redirect too
     */
    public static String handleRedirect(HttpResponse<String> response){
        System.out.println("Error code " + getResponseCode(response) + "\n");
        System.out.println("Handling redirect.\n");
        String html = getResponseHTML(response);
        return findRefs(html).get(0);
    }

    /**
     * main
     *
     * this is the main function that takes in two arguments from the command line
     * the first being a starting url, the second being numHops and will hop
     * numHops times from the beginning url and print the ending html
     * @param args
     */
    public static void main(String[] args) {
        String website = "";
        String htmlResponse = "";
        int numHops = 0;
        int responseCode = 0;
        ArrayList<String> visited = new ArrayList<>();
        ArrayList<String> pulled = new ArrayList<>();


        if(args.length == 2) {
            if(confirmHttp(args[0])) {
                website = args[0];
                numHops = Integer.parseInt(args[1]);
            }else{
                System.out.print("Please enter a valid URL. Exiting Program.");
                System.exit(0);
            }
        }else{
            System.out.println("Please enter a starting url and numHops to command line");
            System.exit(0);
        }

        responseCode = getResponseCode(getResponse(website));

        if(responseCode > 299 && responseCode < 400){
            website = handleRedirect(getResponse(website));
            responseCode = getResponseCode(getResponse(website));
        }else if(responseCode > 499 && responseCode < 600){
            responseCode = getResponseCode(getResponse(website));
        }

        if(isGoodCode(responseCode)){
            visited.add(website);
        }else{
            System.out.println("Given website returns error code " + getResponseCode(getResponse(website)));
            System.exit(0);
        }

        System.out.println("Starting url: " + website);

        htmlResponse = getResponseHTML(getResponse(website));
        pulled = findRefs(htmlResponse);
        if(pulled.size() < 1){
            System.out.println("can not hop anymore.");
            System.out.println("Printing contents of webpage: \n");
            printResponseHTML(getResponse(website));
            System.exit(0);
        }
        website = findFirstGoodURL(visited,pulled);
        visited.add(website);

        for(int i = 0; i < numHops; i++){

            if(i != numHops - 1) {
                System.out.println("hop #" + (i + 1));
                System.out.println("Url: " + website + "\n");

                htmlResponse = getResponseHTML(getResponse(website));
                pulled = findRefs(htmlResponse);
                visited.add(website);
                if(pulled.size() > 1 && findFirstGoodURL(visited,pulled) != null) {
                    website = findFirstGoodURL(visited, pulled);
                }else{
                    System.out.println("can not hop anymore.");
                    System.out.println("Printing contents of webpage: \n");
                    printResponseHTML(getResponse(website));
                    System.exit(0);
                }
            }else{
                System.out.println("Hop #" + (i + 1));
                System.out.println(website);
                System.out.println("printing contents of webpage:\n");
                printResponseHTML(getResponse(website));
            }
        }

    }
}
