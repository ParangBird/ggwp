package com.backend.ggwp.domain.game.summoner.summonerinfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SummonerInfoRepository extends JpaRepository<SummonerInfo, Long> {
    Optional<SummonerInfo> findByName(String name);
}
