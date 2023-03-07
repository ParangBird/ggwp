package com.backend.ggwp.domain.game.summoner.leagueentry;

import com.backend.ggwp.domain.game.summoner.leagueentry.LeagueEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeagueEntryRepository extends JpaRepository<LeagueEntry, Long> {
}
