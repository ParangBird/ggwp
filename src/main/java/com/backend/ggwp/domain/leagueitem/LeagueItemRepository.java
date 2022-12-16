package com.backend.ggwp.domain.leagueitem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LeagueItemRepository extends JpaRepository<LeagueItem, Long> {
    Optional<LeagueItem> findByRanking(Long ranking);

    Optional<LeagueItem> findBySummonerName(String summonerName);

}
