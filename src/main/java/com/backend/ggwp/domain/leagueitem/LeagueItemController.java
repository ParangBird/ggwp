package com.backend.ggwp.domain.leagueitem;

import com.backend.ggwp.restapi.RestApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.Collections;


@RestController
@RequiredArgsConstructor
public class LeagueItemController {

    private final RestApiService restApiService;
    private final LeagueItemService leagueItemService;

    @GetMapping("/api/rankinfo")
    public ArrayList<LeagueItem> getC2MInfo(){
        // 챌린저 ~ 마스터 정보 받아옴
        LeagueList challengerLeagueList = restApiService.getChallengerList();
        LeagueList gmLeagueList = restApiService.getGrandMasterList();
        LeagueList masterLeagueList = restApiService.getMasterList();

        // 챌린저 ~ 마스터 각각 점수순 정렬
        ArrayList<LeagueItem> challengerList = challengerLeagueList.getEntries();
        Collections.sort(challengerList, new LeagueItemComparator());
        ArrayList<LeagueItem> gmList = gmLeagueList.getEntries();
        Collections.sort(gmList, new LeagueItemComparator());
        ArrayList<LeagueItem> masterList = masterLeagueList.getEntries();
        Collections.sort(masterList, new LeagueItemComparator());

        // 각각 정렬한 친구들을 챌-그마-마 순서로 합침
        ArrayList<LeagueItem> challenger2MasterList = new ArrayList<>();
        for(LeagueItem c : challengerList)
            challenger2MasterList.add(c);
        for(LeagueItem gm : gmList)
            challenger2MasterList.add(gm);
        for(LeagueItem m : masterList)
            challenger2MasterList.add(m);

        for(long i=0;i<challenger2MasterList.size();i++){
            challenger2MasterList.get((int) i).setRanking(i+1);
        }

        leagueItemService.clearAll();
        leagueItemService.saveAll(challenger2MasterList);
        return (challenger2MasterList);
    }
}
