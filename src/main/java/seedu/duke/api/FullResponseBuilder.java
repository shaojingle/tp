package seedu.duke.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.util.Iterator;
import java.util.List;

public class FullResponseBuilder {
    public static String getFullResponse(HttpURLConnection con) throws IOException {
        StringBuilder fullResponseBuilder = new StringBuilder();

        Reader streamReader = null;
        if (con.getResponseCode() > 299) {
            streamReader = new InputStreamReader(con.getErrorStream());
        } else {
            streamReader = new InputStreamReader(con.getInputStream(), "utf-8");
        }

        BufferedReader br = new BufferedReader(streamReader);
        String responseLine = null;
        StringBuilder content = new StringBuilder();
        while ((responseLine = br.readLine()) != null) {
            content.append(responseLine);
        }

        br.close();

        fullResponseBuilder.append("Response: ")
                .append(content);

        return fullResponseBuilder.toString();
    }
}