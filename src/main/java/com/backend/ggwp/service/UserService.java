package com.backend.ggwp.service;

import com.backend.ggwp.domain.user.User;
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
    public void save(User user){
        userRepository.save(user);
    }
    public Optional<User> findByUserName(String username){
        return userRepository.findByUserName(username);
    }
    public Optional<User> findByEmail(String email){
        return userRepository.findByEmail(email);
    }
}
