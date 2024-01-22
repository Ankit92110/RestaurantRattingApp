package com.example.demo.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import com.example.demo.entities.Restaurant;

public class RestaurantRepository implements IRestaurantReposiotry {
    private Long autoIncrement = 1L;
    private final Map<Long,Restaurant>restaurantMap;
    public RestaurantRepository() {
        restaurantMap=new HashMap<>();
    }
    @Override
    public Restaurant save(Restaurant restaurant) {
        // TODO Auto-generated method stub
        restaurant.setId(autoIncrement);
        restaurantMap.put(autoIncrement,restaurant);
        autoIncrement++;
        return restaurant;
      
    }
    @Override
    public Restaurant getById(Long restaurantId) {
        // TODO Auto-generated method stub
        return restaurantMap.get(restaurantId);
    }
    @Override
    public String findNamebyId(Long restaurantId) {
        // TODO Auto-generated method stub
        return restaurantMap.get(restaurantId).getName();
    }
    @Override
   public List<Restaurant> findAll(){
         return restaurantMap.values().stream().collect(Collectors.toList());
    }
    

    
    
}
