package com.backend.ggwp.domain.game.match;

import com.backend.ggwp.domain.game.summoner.SummonerService;
import com.backend.ggwp.domain.game.summoner.model.AccountInfo;
import com.backend.ggwp.utils.StringFormat;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

@RequiredArgsConstructor
@RestController
@Slf4j
public class MatchSummaryController {

    private final MatchSummaryService matchSummaryService;
    private final SummonerService summonerService;

    //전적 갱신
    @GetMapping("/api/matches/update/{name}")
    public void updateMatches(@PathVariable(value = "name") String name) throws UnsupportedEncodingException {
        String summonerName = StringFormat.setApiString(name);
        //String encodedName = URLEncoder.encode(summonerName, "UTF-8");
        AccountInfo accountInfo = summonerService.getAccountInfo(summonerName);
        //log.info(accountInfo.toString());
        matchSummaryService.updateMatchSummary(accountInfo);
    }

    //디비에 저장된 전적 정보 가져와서 반환
    //추가로 저장된 전적이 부족하면 자동으로 갱신하도록 변경 예정
    //솔랭, 일반, 자유랭 등 큐타입 선택해서 받는것도 추가해야할듯
    //전적검색 속도는 충분히 빠른것 같고 추가로 해당 전적의 상세정보 받아오는 것은 이전 방식으로 진행할것
    @GetMapping("/api/matches/{name}")
    public ArrayList<MatchSummary> getMatches(@PathVariable(value = "name") String name) throws UnsupportedEncodingException {
        String summonerName = StringFormat.setApiString(name);
        //String encodedName = URLEncoder.encode(summonerName, "UTF-8");
        AccountInfo accountInfo = summonerService.getAccountInfo(summonerName);
        ArrayList<MatchSummary> matchSummaries = matchSummaryService.getAll30Matches(accountInfo);
        return matchSummaries;
    }

    @GetMapping("/api/matches/{name}/solo")
    public ArrayList<MatchSummary> getSoloMatches(@PathVariable(value = "name") String name) {
        String summonerName = StringFormat.setApiString(name);
        AccountInfo accountInfo = summonerService.getAccountInfo(summonerName);
        ArrayList<MatchSummary> matchSummaries = matchSummaryService.get30SoloRankMatches(accountInfo);
        return matchSummaries;
    }
}
