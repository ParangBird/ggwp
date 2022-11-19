package com.backend.ggwp.domain.user;

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
