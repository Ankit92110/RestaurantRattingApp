package com.example.demo.commands;

import java.util.List;
import com.example.demo.services.IRestaurantService;

public class ListRestaurantCommand implements ICommand{

    private final IRestaurantService restaurantService;
    
    public ListRestaurantCommand(IRestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @Override
    public void invoke(List<String> tokens) {
        // TODO Auto-generated method stub
        restaurantService.listRestaurant();
        
    }
    
    
}
