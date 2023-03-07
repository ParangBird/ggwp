package com.backend.ggwp.domain.game.summoner.leagueentry;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class LeagueEntryController {
    private final LeagueEntryService leagueEntryService;

    @GetMapping("/api/entry/update/")
    public String updateLeagueEntry() {

        return "";
    }
}
