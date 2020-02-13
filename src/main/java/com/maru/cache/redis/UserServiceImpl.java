package com.maru.cache.redis;

import com.maru.cache.redis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by : maru
 * Date  : 1/14/2020
 * Time  : 2:14 PM
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User show(String id) {
        return userRepository.findById(id).orElse(null);
    }

}
