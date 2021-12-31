package com.backend.ggwp.service;

import com.backend.ggwp.domain.entity.leagueList.LeagueItem;
import com.backend.ggwp.domain.repository.LeagueItemRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LeagueItemService{
    private final LeagueItemRepository leagueItemRepository;

    public LeagueItemService(LeagueItemRepository leagueItemRepository) {
        this.leagueItemRepository = leagueItemRepository;
    }

    public void saveAll(ArrayList<LeagueItem> leagueItems){
        for(LeagueItem leagueItem : leagueItems)
            leagueItemRepository.save(leagueItem);
    }
    public void updateAll(ArrayList<LeagueItem> leagueItems){

    }


}
