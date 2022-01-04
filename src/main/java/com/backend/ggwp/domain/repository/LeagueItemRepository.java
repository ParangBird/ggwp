package com.backend.ggwp.domain.repository;

import com.backend.ggwp.domain.entity.leagueList.LeagueItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LeagueItemRepository extends JpaRepository<LeagueItem, Long> {
    Optional<LeagueItem> findById(Long id);
}
