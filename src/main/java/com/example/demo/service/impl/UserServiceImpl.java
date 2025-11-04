package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public void save(User user) {
        log.info("save user: {}", user.getName());
        try {
            userRepository.save(user);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
        finally {
            log.info("try to save user: {}", user.getName());
        }
    }

    @Override
    public User findByUsername(String username) {
        log.info("findByUsername: {}", username);
        return userRepository.findByName(username);
    }
}
