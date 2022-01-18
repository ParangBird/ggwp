package com.backend.ggwp.controller;

import com.backend.ggwp.domain.Dto.MatchDto;
import com.backend.ggwp.domain.entity.AccountInfo;
import com.backend.ggwp.domain.entity.common.StringFormat;
import com.backend.ggwp.domain.entity.leagueList.LeagueItem;
import com.backend.ggwp.domain.entity.leagueList.LeagueItemComparator;
import com.backend.ggwp.domain.entity.leagueList.LeagueList;
import com.backend.ggwp.domain.entity.match.Match;
import com.backend.ggwp.domain.entity.match.Participant;
import com.backend.ggwp.domain.entity.record.MatchSummary;
import com.backend.ggwp.service.LeagueItemService;
import com.backend.ggwp.service.MatchApiService;
import com.backend.ggwp.service.RestApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class DbController {

    private final RestApiService restApiService;
    private final LeagueItemService leagueItemService;
    private final MatchApiService matchApiService;

    public DbController(RestApiService restApiService, LeagueItemService leagueItemService, MatchApiService matchApiService) {
        this.restApiService = restApiService;
        this.leagueItemService = leagueItemService;
        this.matchApiService = matchApiService;
    }

    @ResponseBody
    @GetMapping("/rankinfo")
    public ArrayList<LeagueItem> getC2MInfo(){
        // 챌린저 ~ 마스터 정보 받아옴
        // 실제로 이짓거리 하면 느려져서 DB 저장해서 필요할때만 업데이트하고 불러오는 식으로 해야할듯 싶다

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

        long beforeTime = System.currentTimeMillis();
        leagueItemService.saveAll(challenger2MasterList);
        long afterTime = System.currentTimeMillis();
        long secDiffTime = (afterTime - beforeTime)/1000;
        //System.out.println("시간차이(m) : "+secDiffTime);
        //System.out.println("challenger2MasterList = " + challenger2MasterList.size());
        return (challenger2MasterList);
    }
}
