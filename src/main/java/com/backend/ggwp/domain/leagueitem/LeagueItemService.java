package com.backend.ggwp.domain.leagueitem;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class LeagueItemService {
    private final LeagueItemRepository leagueItemRepository;

    public LeagueItemService(LeagueItemRepository leagueItemRepository) {
        this.leagueItemRepository = leagueItemRepository;
    }

    public ArrayList<Optional<LeagueItem>> findRank50BySummonerName(String summonerName) {
        ArrayList<Optional<LeagueItem>> leagueItems = new ArrayList<>();
        Long startRank = -1L;
        Optional<LeagueItem> leagueItem = leagueItemRepository.findBySummonerName(summonerName);
        if (leagueItem.isPresent())
            startRank = leagueItem.get().getId();
        if (startRank != -1L) {
            for (int i = 0; i < 50; i++) {
                Optional<LeagueItem> addLeagueItem = leagueItemRepository.findByRanking(startRank + i);
                if (addLeagueItem.isPresent())
                    leagueItems.add(addLeagueItem);
            }
        }
        return leagueItems;
    }


    public ArrayList<Optional<LeagueItem>> findRank50(Long startId) {
        ArrayList<Optional<LeagueItem>> leagueItems = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Optional<LeagueItem> leagueItem = leagueItemRepository.findByRanking(startId + i);
            if (leagueItem != null)
                leagueItems.add(leagueItem);
        }
        return leagueItems;
    }

    @Transactional
    public void saveAll(ArrayList<LeagueItem> leagueItems) {
        for (LeagueItem leagueItem : leagueItems) {
            leagueItemRepository.save(leagueItem);
        }
    }

    @Transactional
    public void clearAll() {
        leagueItemRepository.deleteAllInBatch();
    }
}
