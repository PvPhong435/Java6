package com.sof306.lab7.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.*;

@Service
public class SecurityRestUrl {

    static ObjectMapper mapper = new ObjectMapper();

    public static JsonNode get(String url) {
        return request(url, "GET", null);
    }

    public static JsonNode post(String url, Object data) {
        return request(url, "POST", data);
    }

    public static JsonNode put(String url, Object data) {
        return request(url, "PUT", data);
    }

    public static JsonNode delete(String url) {
        return request(url, "DELETE", null);
    }

    private static JsonNode request(String url, String method, Object data) {
        HttpURLConnection conn;
        try {
            conn = (HttpURLConnection) new URI(url).toURL().openConnection();
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestMethod(method);
            conn.setRequestProperty("Authorization", "Basic dXNlcjM6MTIz");

            if(data != null) {
                conn.setDoOutput(true);
                mapper.writeValue(conn.getOutputStream(), data);
            }

            int responseCode = conn.getResponseCode();
            if (responseCode == 200) {
                return mapper.readTree(conn.getInputStream());
            }
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

}
