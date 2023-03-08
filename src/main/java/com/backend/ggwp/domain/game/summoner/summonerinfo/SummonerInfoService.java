package com.backend.ggwp.domain.game.summoner.summonerinfo;

import com.backend.ggwp.domain.game.summoner.summonerleagueinfo.SummonerLeagueInfo;
import com.backend.ggwp.utils.ApiInfo;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import static com.backend.ggwp.utils.RestAPI.restApi;

@Slf4j
@Service
@RequiredArgsConstructor
public class SummonerInfoService {

    private final ApiInfo API_INFO;
    private final SummonerInfoRepository summonerInfoRepository;

    @Transactional
    public SummonerInfo getSummonerInfo(String summonerName) {
        Optional<SummonerInfo> byName = summonerInfoRepository.findByName(summonerName);
        if (byName.isPresent()) {
            SummonerInfo summonerInfo = byName.get();
            // 업데이트 시간이 24시간 이내면 그대로 반환
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime modifiedDate = summonerInfo.getModifiedDate();
            if (now.isBefore(modifiedDate.plusDays(1))) {
                return summonerInfo;
            }
        }
        return updateSummonerInfo(summonerName);
    }

    @Transactional
    public SummonerInfo updateSummonerInfo(String summonerName) {
        String apiURL = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/" + summonerName + "?api_key=" + API_INFO.getApiKey();
        StringBuffer result = restApi(apiURL);
        SummonerInfo summonerInfo = new Gson().fromJson(result.toString(), SummonerInfo.class);
        summonerInfoRepository.findByName(summonerName).ifPresent((prev) -> {
            summonerInfo.setSummonerInfoId(prev.getSummonerInfoId());
        });
        summonerInfoRepository.save(summonerInfo);
        return summonerInfo;
    }


    @Transactional
    public String getPuuidBySummonerName(String summonerName) {
        String apiURL = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/" + summonerName + "?api_key=" + API_INFO.getApiKey();
        StringBuffer result = restApi(apiURL);
        SummonerInfo summonerInfo = new Gson().fromJson(result.toString(), SummonerInfo.class);
        SummonerInfo summonerInfo1 = summonerInfoRepository.findByName(summonerName).orElseThrow();
        if (!summonerInfo1.getPuuid().equals(summonerInfo1.getPuuid())) {
        }

        return summonerInfo.getPuuid();
    }


    public SummonerInfoDTO getSummonerInfoDTO(SummonerInfo summonerInfo, ArrayList<SummonerLeagueInfo> leagueInfos, ApiInfo apiInfo) {

        SummonerLeagueInfo soloRank = new SummonerLeagueInfo();
        SummonerLeagueInfo flexRank = new SummonerLeagueInfo();

        for (SummonerLeagueInfo s : leagueInfos) {
            if (s.getQueueType().equals("RANKED_SOLO_5x5")) {
                soloRank = s;
                log.info(soloRank.getQueueType());
            } else if (s.getQueueType().equals("RANKED_FLEX_SR")) {
                flexRank = s;
                log.info(flexRank.getQueueType());
            }
        }

        SummonerInfoDTO summonerInfoDto = SummonerInfoDTO.builder()
                .id(summonerInfo.getSummonerId())
                .name(summonerInfo.getName())
                .profileIconUrl("https://ddragon.leagueoflegends.com/cdn/" + apiInfo.getVersion() +
                        "/img/profileicon/" + summonerInfo.getProfileIconId() + ".png")
                .summonerLevel(summonerInfo.getSummonerLevel())
                .soloRank(soloRank)
                .flexRank(flexRank)
                .build();

        return summonerInfoDto;
    }

}
