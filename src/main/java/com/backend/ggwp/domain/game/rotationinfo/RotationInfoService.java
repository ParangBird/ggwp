package com.backend.ggwp.domain.game.rotationinfo;

import com.backend.ggwp.utils.ApiInfo;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.backend.ggwp.utils.RestAPI.restApi;

@RequiredArgsConstructor
@Slf4j
@Service
public class RotationInfoService {
    private final ApiInfo API_INFO;

    public RotationInfo getRotationInfo() {
        String apiURL = "https://kr.api.riotgames.com/lol/platform/v3/champion-rotations?api_key=" + API_INFO.getApiKey();
        StringBuffer result = restApi(apiURL);
        return new Gson().fromJson(result.toString(), RotationInfo.class);
    }

}
