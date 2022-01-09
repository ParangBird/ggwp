package com.backend.ggwp.service;

import com.backend.ggwp.domain.entity.AccountInfo;
import com.backend.ggwp.domain.entity.match.Match;
import com.backend.ggwp.domain.entity.match.Participant;
import com.backend.ggwp.domain.entity.record.MatchSummary;
import com.backend.ggwp.domain.repository.MatchSummaryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class MatchApiService {
    @Autowired
    private MatchSummaryRepository matchSummaryRepository;
    @Autowired
    private RestApiService restApiService;

    public Boolean matchExist(String matchId){
        Optional<MatchSummary> matchSummary = matchSummaryRepository.findByMatchId(matchId);
        return matchSummary.isPresent();
    }

    public ArrayList<MatchSummary> getAll30Matches(AccountInfo accountInfo){
        ArrayList<MatchSummary> matchSummaries =  matchSummaryRepository.find30ByName(accountInfo.getName());
        log.info(matchSummaries.toString());
        return matchSummaries;
    }

    public void updateMatchSummary(AccountInfo accountInfo){
        ArrayList<String> matches = restApiService.getMatchIds(accountInfo.getPuuid());

        for(String s : matches){
            if(matchExist(s)) continue;
            Match match = restApiService.getMatchInfo(s);

            Participant my = new Participant();
            int myNumber = 0;
            int myTeam = 0; // 0 : 블루팀 , 1 : 레드팀
            Long gameTimestamp = 0L;
            List<String> champList = new ArrayList<String>();
            List<String> nameList = new ArrayList<String>();

            for(Participant p : match.getInfo().getParticipants()){
                myNumber++;
                champList.add(p.getChampionName());
                nameList.add(p.getSummonerName());
                if(p.getSummonerName().equals(accountInfo.getName())){
                    my = p;
                    if(myNumber > 5) myTeam = 1;
                }
            }

            if(match.getInfo().getGameEndTimestamp() == null)
                gameTimestamp = match.getInfo().getGameStartTimestamp();
            else
                gameTimestamp = match.getInfo().getGameEndTimestamp();

            MatchSummary matchSummary = MatchSummary.builder()
                    .queueId(match.getInfo().getQueueId())
                    .matchId(s)
                    .gameEndTimestamp(gameTimestamp)
                    .name(accountInfo.getName())
                    .champ(my.getChampionName())
                    .blueChamp1(champList.get(0))
                    .blueChamp2(champList.get(1))
                    .blueChamp3(champList.get(2))
                    .blueChamp4(champList.get(3))
                    .blueChamp5(champList.get(4))
                    .redChamp1(champList.get(5))
                    .redChamp2(champList.get(6))
                    .redChamp3(champList.get(7))
                    .redChamp4(champList.get(8))
                    .redChamp5(champList.get(9))
                    .perkMain(my.getPerks().getStyles().get(0).getSelections().get(0).getPerk())
                    .perkSub(my.getPerks().getStyles().get(1).getStyle())
                    .spell1(my.getSummoner1Id())
                    .spell2(my.getSummoner2Id())
                    .level(my.getChampLevel())
                    .kills(my.getKills())
                    .deaths(my.getDeaths())
                    .assists(my.getAssists())
                    .time(my.getTimePlayed())
                    .cs(my.getTotalMinionsKilled() + my.getNeutralMinionsKilled())
                    .totalKill(match.getInfo().getTeams().get(myTeam).getObjectives().getChampion().getKills())
                    .item0(my.getItem0())
                    .item1(my.getItem1())
                    .item2(my.getItem2())
                    .item3(my.getItem3())
                    .item4(my.getItem4())
                    .item5(my.getItem5())
                    .item6(my.getItem6())
                    .win(my.getWin())
                    .build();
            saveMatchSummary(matchSummary);
        }
    }

    public void saveMatchSummary(MatchSummary matchSummary){
        matchSummaryRepository.save(matchSummary);
    }
}
