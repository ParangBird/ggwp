package com.backend.ggwp.domain.bbs.user.nickname;

import com.backend.ggwp.utils.RestAPI;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class NicknameGenerateService {

    public String randomNickname(int maxLength) {
        String s = RestAPI.randomNicknameAPI(1, maxLength);
        return new Gson()
                .fromJson(s, NicknameApiResponse.class)
                .getWords()
                .get(0);
    }
}
