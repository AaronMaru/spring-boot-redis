package com.maru.cache.redis.model;

import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;

/**
 * Created by : maru
 * Date  : 1/14/2020
 * Time  : 3:03 PM
 */

@RedisHash(value = "user_salary", timeToLive = 60 * 60 * 24)
public class UserRedist {

    @Id
    private String id;

    private String name;
    private Long salary;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }
}