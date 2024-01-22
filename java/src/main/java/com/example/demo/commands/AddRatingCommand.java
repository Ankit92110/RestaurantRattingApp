package com.example.demo.commands;

import java.util.List;
import com.example.demo.services.IRestaurantService;

public class AddRatingCommand  implements ICommand{
   private final IRestaurantService restaurantService;
    

    public AddRatingCommand(IRestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }


    @Override
    public void invoke(List<String> tokens) {
        // TODO Auto-generated method stub
        restaurantService.addRating(tokens);
        
    }
    
    
}
