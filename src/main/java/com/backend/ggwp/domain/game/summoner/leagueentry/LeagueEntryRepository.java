package com.backend.ggwp.domain.game.summoner.leagueentry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LeagueEntryRepository extends JpaRepository<LeagueEntry, Long> {
    Optional<LeagueEntry> findBySummonerId(String summonerId);
}
