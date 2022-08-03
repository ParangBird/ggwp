package com.backend.ggwp.domain.repository;

import com.backend.ggwp.domain.user.PageUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PageUserRepository extends JpaRepository<PageUser, Long> {

    Optional<PageUser> findByEmail(String email);
}
