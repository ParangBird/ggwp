package com.backend.ggwp.utils;

import com.backend.ggwp.exception.ApiServerException;
import com.backend.ggwp.exception.ApiServerNoSuchDataException;
import com.backend.ggwp.exception.InvalidApiKeyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

@Slf4j
public class RestAPI {

    public static String riotRestAPI(String apiURL) {
        URI uri = UriComponentsBuilder
                .fromUriString(apiURL)
                .encode()
                .build()
                .toUri();
        log.info("Riot API called : {}", uri);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity req = new HttpEntity(headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                req,
                String.class
        );
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

    public static String randomNicknameAPI(int count, int maxLength) {
        URI uri = UriComponentsBuilder
                .fromUriString("https://nickname.hwanmoo.kr/?format=json&count=" + count + "&max_length=" + maxLength)
                .encode()
                .build()
                .toUri();
        log.info("Random Nickname Generate API called : {}", uri.toString());
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);
        int responseCode = responseEntity.getStatusCodeValue();
        if (!(responseCode >= 200 && responseCode <= 300)) {
            throw new ApiServerException("api server has problem");
        }
        return responseEntity.getBody();
    }

    public static StringBuffer deprecatedRestApi(String apiURL) {
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
}
