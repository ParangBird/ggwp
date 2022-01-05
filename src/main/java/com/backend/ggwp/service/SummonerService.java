package com.backend.ggwp.service;

import com.backend.ggwp.ApiInfo;
import com.backend.ggwp.domain.entity.AccountInfo;
import com.backend.ggwp.domain.Dto.SummonerDto;
import com.backend.ggwp.domain.entity.SummonerLeagueInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Slf4j
@Service
public class SummonerService {
    public SummonerDto getSummonerDto(AccountInfo accountInfo, ArrayList<SummonerLeagueInfo> leagueInfos, ApiInfo apiInfo){

        SummonerLeagueInfo soloRank = new SummonerLeagueInfo();
        SummonerLeagueInfo flexRank = new SummonerLeagueInfo();

        for(SummonerLeagueInfo s : leagueInfos){
            if(s.getQueueType().equals("RANKED_SOLO_5x5")){
                soloRank = s;
                log.info(soloRank.getQueueType());
            }else if(s.getQueueType().equals("RANKED_FLEX_SR")) {
                flexRank = s;
                log.info(flexRank.getQueueType());
            }
        }

        SummonerDto summonerDto = SummonerDto.builder()
                .id(accountInfo.getId())
                .name(accountInfo.getName())
                .profileIconUrl("https://ddragon.leagueoflegends.com/cdn/"+apiInfo.getVersion()+
                        "/img/profileicon/"+ accountInfo.getProfileIconId() +".png")
                .summonerLevel(accountInfo.getSummonerLevel())
                .soloRank(soloRank)
                .flexRank(flexRank)
                .build();

        return summonerDto;
    }
}
