package com.backend.ggwp.service;

import com.backend.ggwp.domain.user.GgwpUser;
import com.backend.ggwp.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    @Transactional
    public void save(GgwpUser ggwpUser){
        userRepository.save(ggwpUser);
    }
    public Optional<GgwpUser> findByName(String username){
        return userRepository.findByName(username);
    }
    public Optional<GgwpUser> findByEmail(String email){
        return userRepository.findByEmail(email);
    }
}
