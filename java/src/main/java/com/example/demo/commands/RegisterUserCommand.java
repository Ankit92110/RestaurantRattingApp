package com.example.demo.commands;

import java.util.List;
import com.example.demo.services.IRestaurantService;

public class RegisterUserCommand implements ICommand {
    private final IRestaurantService restaurantService;
    
    public RegisterUserCommand(IRestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @Override
    public void invoke(List<String> tokens) {
        // TODO Auto-generated method stub
        restaurantService.registerUser(tokens);
        
    }
    
    
}
