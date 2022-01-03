package com.backend.ggwp.service;

import com.backend.ggwp.domain.entity.leagueList.LeagueItem;
import com.backend.ggwp.domain.repository.LeagueItemRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
public class LeagueItemService {
    private final LeagueItemRepository leagueItemRepository;

    public LeagueItemService(LeagueItemRepository leagueItemRepository) {
        this.leagueItemRepository = leagueItemRepository;
    }

    @Transactional
    public void saveAll(ArrayList<LeagueItem> leagueItems){
        for(LeagueItem leagueItem : leagueItems){
            leagueItemRepository.save(leagueItem);
        }
    }
}
