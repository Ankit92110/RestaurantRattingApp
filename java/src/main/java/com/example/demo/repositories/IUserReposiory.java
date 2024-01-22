package com.example.demo.repositories;

import com.example.demo.entities.User;

public interface IUserReposiory {
    public User save(User user);
    public User findById(Long id);
}
