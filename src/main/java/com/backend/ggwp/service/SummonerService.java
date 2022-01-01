package com.backend.ggwp.service;

import com.backend.ggwp.ApiInfo;
import org.springframework.stereotype.Service;

@Service
public class SummonerService {

    private final ApiInfo API_INFO;

    public SummonerService(ApiInfo api_info) {
        API_INFO = api_info;
    }

}
