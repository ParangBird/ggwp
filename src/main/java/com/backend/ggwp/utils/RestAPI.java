package com.backend.ggwp.utils;

import com.backend.ggwp.exception.ApiServerException;
import com.backend.ggwp.exception.ApiServerNoSuchDataException;
import com.backend.ggwp.exception.InvalidApiKeyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
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
            int responseCode = conn.getResponseCode();
            if (responseCode >= 200 && responseCode <= 300) {
                rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            } else if (responseCode == 401 || responseCode == 403) {
                rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
                throw new InvalidApiKeyException("invalid api key");
            } else if (responseCode == 404) {
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

    public static String restTemplate(String apiURL) {
        URI uri = UriComponentsBuilder
                .fromUriString(apiURL)
                .encode()
                .build()
                .toUri();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);
        int responseCode = responseEntity.getStatusCodeValue();
        if (responseCode >= 200 && responseCode <= 300) {

        } else if (responseCode == 401 || responseCode == 403) {
            throw new InvalidApiKeyException("invalid api key");
        } else if (responseCode == 404) {
            throw new ApiServerNoSuchDataException("no such data in api server");
        } else {
            throw new ApiServerException("api server has problem");
        }
        return responseEntity.getBody();
    }
}
