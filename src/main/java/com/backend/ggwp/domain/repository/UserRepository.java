package com.backend.ggwp.domain.repository;

import com.backend.ggwp.domain.entity.leagueList.LeagueItem;
import com.backend.ggwp.domain.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
