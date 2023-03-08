package com.backend.ggwp.domain.game.search;

import com.backend.ggwp.domain.game.summoner.summonerinfo.SummonerInfoDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;


@Slf4j
@RestController
@RequiredArgsConstructor
public class SearchController {

    private final SearchService searchService;

    @GetMapping("/reactSearch/{name}")
    public SummonerInfoDTO summonerDTO(@PathVariable(value = "name") String summonerName) throws UnsupportedEncodingException {
        log.info("reactSearch");
        return searchService.search(summonerName);
    }

}
