package com.backend.ggwp.service;

import com.backend.ggwp.domain.entity.user.User;
import com.backend.ggwp.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void save(User user){
        userRepository.save(user);
    }

    public Optional<User> findByUserName(String username){
        return userRepository.findByUserName(username);
    }
}
