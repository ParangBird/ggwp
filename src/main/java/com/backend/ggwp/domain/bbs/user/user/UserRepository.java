package com.backend.ggwp.domain.bbs.user.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<GgwpUser, Long> {
    Optional<GgwpUser> findByName(String username);

    Optional<GgwpUser> findByEmail(String email);

    Optional<GgwpUser> findByProviderAndProviderId(String provider, String providerId);
}
