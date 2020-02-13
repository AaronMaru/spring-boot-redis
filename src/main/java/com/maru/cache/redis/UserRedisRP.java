package com.maru.cache.redis;

import com.maru.cache.redis.model.UserRedist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by : maru
 * Date  : 1/14/2020
 * Time  : 2:34 PM
 */
@Repository
public interface UserRedisRP extends CrudRepository<UserRedist, String> {
}
