package com.backend.ggwp.service;

import com.backend.ggwp.domain.entity.user.User;
import com.backend.ggwp.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(User user){
        userRepository.save(user);
    }

    public User findByUserName(String username){
        return userRepository.findByUserName(username);
    }
}
