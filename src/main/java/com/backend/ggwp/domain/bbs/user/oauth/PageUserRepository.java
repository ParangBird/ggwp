package com.backend.ggwp.domain.bbs.user.oauth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PageUserRepository extends JpaRepository<PageUser, Long> {

    Optional<PageUser> findByEmail(String email);
}
