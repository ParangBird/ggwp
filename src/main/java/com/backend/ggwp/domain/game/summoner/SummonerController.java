package com.backend.ggwp.domain.game.summoner;

import com.backend.ggwp.domain.game.summoner.model.SummonerInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class SummonerController {
    private final SummonerService summonerService;

    @GetMapping("/api/summoner/test")
    public SummonerInfo test() {
        return summonerService.getSummonerInfo("돈까스치즈퐁당");
    }
}
