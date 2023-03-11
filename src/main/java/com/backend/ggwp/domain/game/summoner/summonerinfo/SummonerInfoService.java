package com.backend.ggwp.domain.game.summoner.summonerinfo;

import com.backend.ggwp.domain.game.summoner.summonerleagueinfo.SummonerLeagueInfo;
import com.backend.ggwp.utils.ApiInfo;
import com.backend.ggwp.utils.StringFormat;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

import static com.backend.ggwp.utils.RestAPI.restApi;

@Slf4j
@Service
@RequiredArgsConstructor
public class SummonerInfoService {

    private final ApiInfo API_INFO;
    private final SummonerInfoRepository summonerInfoRepository;

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public SummonerInfo getSummonerInfo(String summonerName) {
        summonerName = StringFormat.setApiString(summonerName);
        return updateSummonerInfo(summonerName);
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public SummonerInfo updateSummonerInfo(String summonerName) {
        String apiURL = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/" + summonerName + "?api_key=" + API_INFO.getApiKey();
        String result = restApi(apiURL);
        SummonerInfo summonerInfo = new Gson().fromJson(result, SummonerInfo.class);
        return summonerInfo;
    }


    @Transactional
    public String getPuuidBySummonerName(String summonerName) {
        String apiURL = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/" + summonerName + "?api_key=" + API_INFO.getApiKey();
        String result = restApi(apiURL);
        SummonerInfo summonerInfo = new Gson().fromJson(result, SummonerInfo.class);
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
