package com.backend.ggwp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application-API-KEY.properties")
public class ApiInfo {
    @Value("${riot-api-key}")
    private String apiKey;

    @Value("${riot-version}")
    private String version;

    public String getApiKey(){
        return apiKey;
    }

    public String getVersion(){
        return version;
    }

    @Override
    public String toString() {
        return "ApiKey{" +
                "apiKey='" + apiKey + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}
