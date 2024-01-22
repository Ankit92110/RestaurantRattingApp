package com.example.demo.commands;

import java.util.List;
import com.example.demo.services.IRestaurantService;

public class DescribeRestaurantCommand  implements ICommand{
    private final IRestaurantService restaurantService;
    
  

    public DescribeRestaurantCommand(IRestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }
    @Override
    public void invoke(List<String> tokens) {
        // TODO Auto-generated method stub
        restaurantService.describeRestaurant(tokens);
        
    }
    
}
