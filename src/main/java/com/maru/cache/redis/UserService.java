package com.maru.cache.redis;

import com.maru.cache.redis.model.User;

import java.util.List;

/**
 * Created by : maru
 * Date  : 1/14/2020
 * Time  : 10:25 AM
 */

public interface UserService {

    List<User> getAll();

    User show(String id);

}
