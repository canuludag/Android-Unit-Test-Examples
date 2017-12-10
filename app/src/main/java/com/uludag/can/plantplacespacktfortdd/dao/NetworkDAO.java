package com.uludag.can.plantplacespacktfortdd.dao;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetworkDAO {

    // Simple way of fetching data from url
    public String fetch(String requestUrl) throws IOException {

        StringBuilder sb = new StringBuilder();
        HttpURLConnection connection = null;

        try {

            URL url = new URL(requestUrl);
            connection = (HttpURLConnection) url.openConnection();

            InputStream inputStream = new BufferedInputStream(connection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }

        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }

        return sb.toString();

    }

}
