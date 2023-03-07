package com.backend.ggwp.utils;

import com.backend.ggwp.exception.ApiServerException;
import com.backend.ggwp.exception.ApiServerNoSuchDataException;
import com.backend.ggwp.exception.InvalidApiKeyException;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Slf4j
public class RestAPI {
    public static StringBuffer restApi(String apiURL) {
        StringBuffer result = new StringBuffer();
        try {
            StringBuilder urlBuilder = new StringBuilder(apiURL);
            URL url = new URL(urlBuilder.toString());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader rd;
            if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
                rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            } else if (conn.getResponseCode() == 403) {
                rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
                throw new InvalidApiKeyException("invalid api key");
            } else if (conn.getResponseCode() == 404) {
                rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
                throw new ApiServerNoSuchDataException("no such data in api server");
            } else {
                rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
                throw new ApiServerException("api server has problem");
            }
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line + "\n");
            }
            rd.close();
            conn.disconnect();
        } catch (InvalidApiKeyException e) {
            throw new InvalidApiKeyException("invalid api key");
        } catch (ApiServerNoSuchDataException e) {
            throw new ApiServerNoSuchDataException("no such data in api server");
        } catch (Exception e) {
            throw new ApiServerException("api server has problem");
        }
        return result;
    }
}
