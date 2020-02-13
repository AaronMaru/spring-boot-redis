package com.maru.cache.redis.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by : maru
 * Date  : 1/14/2020
 * Time  : 10:17 AM
 */

@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    private String id;

    private String name;
    private Long salary;

    public User() {
    }

    public User(String id, String name, Long salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

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
