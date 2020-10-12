package seedu.duke.api;


import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

public class Api {

    private static final String API_KEY = "O8EVQ7YSWDW08BN9";

    public Api() throws IOException {
//        URL url = new URL("https://www.alphavantage.co/query?");
//        URLConnection con = url.openConnection();
//        HttpURLConnection http = (HttpURLConnection)con;
//        http.setRequestMethod("POST");
//        http.setDoOutput(true);

        // Creating a Request
        URL url = new URL("https://www.alphavantage.co/query?");
        URLConnection con = url.openConnection();
        HttpURLConnection http = (HttpURLConnection)con;
        http.setRequestMethod("GET");

        // Set doOutput property to true so that we can add parameters to a request
        http.setDoOutput(true);

        // Adding Request Parameters
        Map<String, String> parameters = new HashMap<>();
        parameters.put("function", "TIME_SERIES_DAILY_ADJUSTED");
        parameters.put("symbol", "IBM");

        DataOutputStream out = new DataOutputStream(http.getOutputStream());
        out.writeBytes(buildParamsString(parameters));
        out.flush();
        out.close();

        // Reading response
        int status = http.getResponseCode();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();

        // Close the connection
        http.disconnect();

        // Reading response on failed requests
        Reader streamReader = null;

        if (status > 299) {
            streamReader = new InputStreamReader(http.getErrorStream());
        } else {
            streamReader = new InputStreamReader(http.getInputStream());
        }

        System.out.println(FullResponseBuilder.getFullResponse(http));

    }

    //To facilitate the transformation of the parameter Map, we create a method, buildParamsString(), that transforms a Map into a String of the required format
    public static String buildParamsString(Map<String, String> params)
            throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();

        for (Map.Entry<String, String> entry : params.entrySet()) {
            result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
            result.append("&");
        }
        
        result.append("&apikey=" + API_KEY);

        String resultString = result.toString();
        return resultString.length() > 0
                ? resultString.substring(0, resultString.length() - 1)
                : resultString;
    }


//    public static void getData(QuoteResponse response){
//        System.out.println("Symbol: " + response.getSymbol());
//        System.out.println("High: " + response.getHigh());
//        System.out.println("Low: " + response.getLow());
//        System.out.println("Open: " + response.getOpen());
//        System.out.println("Price: " + response.getPrice());
//        System.out.println("Volume: " + response.getVolume());
//        System.out.println("Latest Trading Day: " + response.getLatestTradingDay());
//        System.out.println("Previous Close: " + response.getPreviousClose());
//        System.out.println("Change: " + response.getChange());
//        System.out.println("Change Percent: " + response.getChangePercent());
//    }


}
