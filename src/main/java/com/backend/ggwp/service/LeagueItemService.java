package com.backend.ggwp.service;

import com.backend.ggwp.domain.entity.leagueList.LeagueItem;
import com.backend.ggwp.domain.repository.LeagueItemRepository;
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



    public ArrayList<Optional<LeagueItem>> findRank50(Long startId){
        ArrayList<Optional<LeagueItem>> leagueItems = new ArrayList<>();
        for(int i=0;i<50;i++){
            Optional<LeagueItem> leagueItem = leagueItemRepository.findById(startId+i);
            if(leagueItem != null)
                leagueItems.add(leagueItem);
        }
        return leagueItems;
    }

    @Transactional
    public void saveAll(ArrayList<LeagueItem> leagueItems){
        for(LeagueItem leagueItem : leagueItems){
            leagueItemRepository.save(leagueItem);
        }
    }
}
