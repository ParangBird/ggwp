package com.backend.ggwp.domain.repository;

import com.backend.ggwp.domain.entity.leagueList.LeagueItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeagueItemRepository extends JpaRepository<LeagueItem, Long> {

}
