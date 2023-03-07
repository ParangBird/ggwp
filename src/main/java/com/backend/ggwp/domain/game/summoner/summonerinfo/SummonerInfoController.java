package com.backend.ggwp.domain.game.summoner.summonerinfo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class SummonerInfoController {
    private final SummonerInfoService summonerInfoService;

    @GetMapping("/api/summoner/test")
    public SummonerInfo test() {
        return summonerInfoService.getSummonerInfo("돈까스치즈퐁당");
    }

    @GetMapping("/api/summoner/{name}")
    public SummonerInfo getSummonerInfo(@PathVariable("name") String name) {
        return summonerInfoService.getSummonerInfo(name);
    }

    @GetMapping("/api/summoner/update/{name}")
    public SummonerInfo updateSummonerInfo(@PathVariable("name") String name) {
        return summonerInfoService.updateSummonerInfo(name);
    }
}
