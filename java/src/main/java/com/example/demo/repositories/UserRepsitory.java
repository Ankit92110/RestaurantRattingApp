package com.example.demo.repositories;

import java.util.HashMap;
import java.util.Map;
import com.example.demo.entities.User;

public class UserRepsitory implements IUserReposiory {
    private Long autoIncrement = 1L;
    private final Map<Long,User>userMap;
    
    public UserRepsitory() {
        this.userMap=new HashMap<>();
    }

    @Override
    public User findById(Long id) {
        // TODO Auto-generated method stub
       return  userMap.get(id);
    }

    @Override
    public User save(User user) {
        // TODO Auto-generated method stub
        user.setId(autoIncrement);
        userMap.put(autoIncrement,user);
        autoIncrement++;
        return user;
    }
    
    
}
