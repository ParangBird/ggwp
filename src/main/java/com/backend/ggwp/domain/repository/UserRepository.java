package com.backend.ggwp.domain.repository;

import com.backend.ggwp.domain.user.GgwpUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<GgwpUser, Long> {
    Optional<GgwpUser> findByUserName(String username);
    Optional<GgwpUser> findByEmail(String email);
}
