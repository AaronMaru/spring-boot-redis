package com.maru.cache.redis;

import com.maru.cache.redis.model.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by : maru
 * Date  : 1/14/2020
 * Time  : 10:23 AM
 */

@Repository
public interface UserFluxRepository extends ReactiveMongoRepository<User, String> {

}
