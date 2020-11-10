import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;

/**
 * Main
 *
 * this is the main class for program 2 of CSS436. this program sends http GET requests to
 * two RESTful API's to return information on the current weather for a city entered through
 * the command line, as well as that city's current air quality.
 */
public class Main {

    private static final String URIWEATHER = "http://api.openweathermap.org/data/2.5/weather?q=";
    private static final String ENDURIW = "&appid=4e46acca235a92e65ddf5245cf5d1db8";

    private static final String URIQ = "https://api.waqi.info/feed/";
    private static final String ENDUIRQ = "/?token=62279246481d032df1d6ca4f56fd33cce7d505b9";

    //these constants are both api url's split in half where name of city will be inserted

    /**
     * main
     *
     * this is the main method to run program 2 and will read in a cit name from the command line
     * this program handles cities with spaces in the name, and will exit if no city name is entered
     * through command line
     * @param args
     */
    public static void main(String[] args) {
        String city = "";
        if(args.length > 0) {
            for(int i = 0; i < args.length; i++){//loop through amount of words entered through comand line
                if(i == 0) {
                    city = args[i];
                }else{
                    city = city + "%20" + args[i];//if more than one word in city name add '%20' where there are spaces
                    //this is for HTML URL Encoding, a space is a special character in a URL
                }
            }

            final String GETWURI = URIWEATHER + city + ENDURIW; //add city name into api call
            if(weatherFinder(GETWURI)){ //run api call, which will print weather for the city is successful
                final String GETQURI = URIQ + city + ENDUIRQ; //add city name into 2nd api call
                qFinder(GETQURI);//run api call, which will print air quality for city if successful
            }else{//if call to first api fails (most likely unavailable city name)
                // do not attempt second api request and exit
                System.out.println("Weather API request failed. Could not send request to air quality API. Exiting");
                System.exit(0);
            }
        }else{//if no city entered through command line
            System.out.println("Must enter a city through command line. Exiting program");
            System.exit(0);
        }
    }

    /**
     * qFinder
     *
     * this is a method that sends an API request to the air quality API and prints out the air
     * quality of the city if successful, and an error message if it is not successful
     * @param URItoGet
     */
    public static void qFinder(String URItoGet){
        Gson gson = new Gson();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(URItoGet))
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString());//send GET request to API

        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());//get response form GET request
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        int maxRetry = 3;
        int retryTime = 1;
        for(int i = 0; i <maxRetry; i++){//retry logic for 500 error, retry 3 times with increasing wait time
            if(is500Error(response.statusCode())) {//if 500 error response, then retry
                try {
                    TimeUnit.SECONDS.sleep(retryTime);// wait for 1 second, then 2 seconds, then 4 seconds
                    request = HttpRequest.newBuilder()
                            .GET()
                            .uri(URI.create(URItoGet))
                            .build();
                    client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
                    response = client.send(request, HttpResponse.BodyHandlers.ofString());//get api response if successful
                } catch (InterruptedException | IOException e) {
                    e.printStackTrace();
                }
                retryTime = retryTime * 2;//constantly increase wait time for each retry
            }else{
                break;//if no 500 error then stop retrying
            }
        }

        if(isSuccess(response.statusCode())){//if 200 response code
            AQIRoot quality = gson.fromJson(response.body(), AQIRoot.class);//deserialize json with gson
            System.out.println("The air quality in " + quality.data.city.name + " is " + quality.data.aqi + " AQI.");
        }else{//print error message for bad response code
            System.out.println("request failed with status code: " + response.statusCode());
        }
    }

    /**
     * isSuccess
     *
     * this method checks to see if response code is a 200 response code
     * @param code
     * @return
     */
    public static boolean isSuccess(int code){
        return code > 199 && code < 300;
    }

    /**
     * is500Error
     *
     * this method checks to see if response code is a 500 response code
     * @param code
     * @return
     */
    public static boolean is500Error(int code){
        return code > 499 && code < 600;
    }

    /**
     * weatherFinder
     *
     * this is a method that sends an API request to the Weather API and prints out the weather
     * of the city if successful, and an error message if it is not successful
     * @param URItoGet
     * @return returns true if api request was successful, false if not successful
     */
    public static boolean weatherFinder(String URItoGet) {
        Gson gson = new Gson();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(URItoGet))
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString());

        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        int maxRetry = 3;
        int retryTime = 1;
        for (int i = 0; i < maxRetry; i++) {
            if (is500Error(response.statusCode())) {
                try {
                    TimeUnit.SECONDS.sleep(retryTime);
                    request = HttpRequest.newBuilder()
                            .GET()
                            .uri(URI.create(URItoGet))
                            .build();
                    client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
                    response = client.send(request, HttpResponse.BodyHandlers.ofString());
                } catch (InterruptedException | IOException e) {
                    e.printStackTrace();
                }
                retryTime = retryTime * 2;
            } else {
                break;
            }
        }

        if (isSuccess(response.statusCode())) {
            WeatherRoot weather = gson.fromJson(response.body(), WeatherRoot.class);
            System.out.println("The temperature in " + weather.name + " today is " + getFahrenheit(weather.main.temp)
            + " degrees Fahrenheit.");
            return true;
        } else {
            System.out.println("request failed with status code: " + response.statusCode());
            return false;
        }
    }

    /**
     * getFahrenheit
     *
     * this is a method that converts temperature in kelvin to temperature in fahrenheit
     * and returns the temperature as a double rounded off after the second decimal point
     * @param kelvin
     * @return temperature in fahrenheit rounded to second decimal point
     */
    private static double getFahrenheit(double kelvin){
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.parseDouble(df.format((kelvin - 273.15) * (9/5) + 32));
    }
}

