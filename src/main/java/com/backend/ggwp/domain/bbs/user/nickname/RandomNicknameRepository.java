package com.backend.ggwp.domain.bbs.user.nickname;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RandomNicknameRepository extends JpaRepository<RandomNickname, Long> {
    Optional<RandomNickname> findByNickname(String nickname);

    void deleteByNickname(String nickname);
}
