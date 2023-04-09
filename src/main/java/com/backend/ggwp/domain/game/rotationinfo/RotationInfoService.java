package com.backend.ggwp.domain.game.rotationinfo;

import com.backend.ggwp.config.RedisConfig;
import com.backend.ggwp.utils.ApiInfo;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import static com.backend.ggwp.utils.RestAPI.riotRestAPI;

@RequiredArgsConstructor
@Slf4j
@Service
public class RotationInfoService {
    private final ApiInfo API_INFO;
    private final Gson gson;

    @Cacheable(key = "#key", value = RedisConfig.CACHE_KEY_TEST, cacheManager = "redisCacheManager")
    public RotationInfo getRotationInfo(String key) {
        String apiURL = "https://kr.api.riotgames.com/lol/platform/v3/champion-rotations?api_key=" + API_INFO.getApiKey();
        String s = riotRestAPI(apiURL);
        RotationInfo rotationInfo = gson.fromJson(s, RotationInfo.class);
        return rotationInfo;
    }

}
