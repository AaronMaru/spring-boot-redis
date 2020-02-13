package com.maru.cache.redis;

import com.maru.cache.redis.model.User;
import com.maru.cache.redis.model.UserRedist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * Created by : maru
 * Date  : 1/14/2020
 * Time  : 10:37 AM
 */

@RestController
@RequestMapping("/rest/user")
public class UserResource {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRedisRP userRedisRP;

    private UserFluxRepository userFluxRepository;

    @GetMapping("/redis")
    public Object indexRedis() {

        List<User> users = userService.getAll();

        List<UserRedist> items = (List<UserRedist>) userRedisRP.findAll();

        if (items.size() > 0) {
            System.out.println("abc");
            return items;
        }


        for (User data : users) {
            UserRedist userData = new UserRedist();

            userData.setId(data.getId());
            userData.setName(data.getName());
            userData.setSalary(data.getSalary());

            userRedisRP.save(userData);
        }

        return users;

    }

    @GetMapping("")
    public Object index() {

        List<User> users = userService.getAll();

        return users;

    }

    @GetMapping("/get-user/{id}")
    public ResponseEntity show(@PathVariable("id") final String id) {

        List<UserRedist> items = (List<UserRedist>) userRedisRP.findAll();

        if (items.size() > 0) {

            UserRedist user = userRedisRP.findById(id).orElse(null);
            return new ResponseEntity(user, HttpStatus.OK);
        }else {
            List<User> users = userService.getAll();
            for (User data : users) {
                UserRedist userData = new UserRedist();

                userData.setId(data.getId());
                userData.setName(data.getName());
                userData.setSalary(data.getSalary());

                userRedisRP.save(userData);
            }

            User user = userService.show(id);
            return new ResponseEntity(user, HttpStatus.OK);
        }
    }

    @GetMapping("/mono/{id}")
    public Mono<User> getUserMono(@PathVariable String id) {
        return userFluxRepository.findById(id);
    }

}
