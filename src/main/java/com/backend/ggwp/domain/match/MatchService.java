package com.backend.ggwp.domain.match;

import com.backend.ggwp.domain.summoner.AccountInfo;
import com.backend.ggwp.restapi.RestApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class MatchService {
    private final MatchSummaryRepository matchSummaryRepository;
    private final RestApiService restApiService;

    public MatchService(MatchSummaryRepository matchSummaryRepository, RestApiService restApiService) {
        this.matchSummaryRepository = matchSummaryRepository;
        this.restApiService = restApiService;
    }

    public Boolean matchExist(String name, String matchId) {
        ArrayList<MatchSummary> matchSummary = matchSummaryRepository.findByMatchId(matchId);

        for (MatchSummary m : matchSummary) {
            if (m.getName().equals(name)) return true;
        }
        return false;
    }

    public ArrayList<MatchSummary> getAll30Matches(AccountInfo accountInfo) throws UnsupportedEncodingException {
        String summonerName = accountInfo.getName();
        //String encodedName = URLEncoder.encode(summonerName, "UTF-8");
        ArrayList<MatchSummary> matchSummaries = matchSummaryRepository.find30ByName(summonerName);
        return matchSummaries;
    }

    public ArrayList<MatchSummary> get30SoloRankMatches(AccountInfo accountInfo) {
        ArrayList<MatchSummary> matchSummaries = matchSummaryRepository.find30SoloRankByName(accountInfo.getName(), "420");
        return matchSummaries;
    }

    public void updateMatchSummary(AccountInfo accountInfo) {
        ArrayList<String> matches = restApiService.getMatchIds(accountInfo.getPuuid());
        matches.addAll(restApiService.getSoloMatchIds(accountInfo.getPuuid()));
        String summonerName = accountInfo.getName();
        //log.info(" UPDATE MATCH SUMMARY ---");
        for (String s : matches) {
            if (matchExist(summonerName, s)) continue;
            Match match = restApiService.getMatchInfo(s);

            Participant my = new Participant();
            int myNumber = 0;
            int myTeam = 0; // 0 : 블루팀 , 1 : 레드팀
            Long gameTimestamp = 0L;
            List<String> champList = new ArrayList<String>();
            List<String> nameList = new ArrayList<String>();

            for (Participant p : match.getInfo().getParticipants()) {
                myNumber++;
                champList.add(p.getChampionName());
                nameList.add(p.getSummonerName());
                if (p.getSummonerName().equals(accountInfo.getName())) {
                    my = p;
                    if (myNumber > 5) myTeam = 1;
                }
            }

            if (match.getInfo().getGameEndTimestamp() == null)
                gameTimestamp = match.getInfo().getGameStartTimestamp();
            else
                gameTimestamp = match.getInfo().getGameEndTimestamp();

            MatchSummary matchSummary = MatchSummary.builder()
                    .queueId(match.getInfo().getQueueId())
                    .matchId(s)
                    .gameEndTimestamp(gameTimestamp)
                    .name(summonerName)
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

    public void saveMatchSummary(MatchSummary matchSummary) {
        matchSummaryRepository.save(matchSummary);
    }
}
