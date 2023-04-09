package com.backend.ggwp.domain.bbs.user.nickname;

import com.backend.ggwp.utils.RestAPI;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class RandomNicknameService {

    private final RandomNicknameRepository randomNicknameRepository;
    private final Gson gson;

    public String randomNickname(int maxLength) {
        if (maxLength < 6) {
            log.warn("maxLength 는 6 이상이어야 하므로 자동으로 length = 6인 닉네임 생성");
        }
        String nickname = "";
        do {
            String response = RestAPI.randomNicknameAPI(1, maxLength);
            nickname = gson.fromJson(response, RandomNicknameApiResponse.class).getWords().get(0);
        } while (randomNicknameRepository.findByNickname(nickname).isPresent());
        return nickname;
    }
}
