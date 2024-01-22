package com.example.demo.commands;

import java.util.List;
import javax.swing.Icon;
import com.example.demo.services.IRestaurantService;

public class GetReviewsCommand implements ICommand{
    private final IRestaurantService restaurantService;
    
    public GetReviewsCommand(IRestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @Override
    public void invoke(List<String> tokens) {
        // TODO Auto-generated method stub
        restaurantService.getReviews(tokens);
        
    }
    
}
