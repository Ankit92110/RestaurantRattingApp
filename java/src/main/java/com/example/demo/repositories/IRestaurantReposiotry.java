package com.example.demo.repositories;

import java.util.List;
import com.example.demo.entities.Restaurant;

public interface IRestaurantReposiotry {
    public Restaurant save(Restaurant restaurant);
    public Restaurant getById(Long restaurantId);
    public String findNamebyId(Long restaurantId);
    public List<Restaurant> findAll();
}
