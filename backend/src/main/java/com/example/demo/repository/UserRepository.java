package com.example.demo.repository;

import java.sql.Array;
import java.util.*;

import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class UserRepository {
    private final Map<Long, User> users = new HashMap<Long, User>();
    private long id = 0;

    public User save(User user) {
        if(user.getId() == null) {
            user.setId(id++);
        }
        users.put(user.getId(), user);
        return user;
    }

    public List<User> getUsersList() {
        List<User> response = new ArrayList<>();
        response.addAll(users.values());
        return response;
    }

    public Optional<User> getUserByEmail(String email) {
        User foundUser = null;
        for(User user: users.values()) {
            if (user.getEmail().equals(email)) {
                foundUser = user;
                break;
            }
        }
        return Optional.of(foundUser);
    }
}
