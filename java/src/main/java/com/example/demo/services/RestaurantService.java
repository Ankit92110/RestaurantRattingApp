package com.example.demo.services;

import java.util.List;
import com.example.demo.entities.DescribeRestaurant;
import com.example.demo.entities.Rating;
import com.example.demo.entities.Restaurant;
import com.example.demo.entities.User;
import com.example.demo.repositories.IRestaurantReposiotry;
import com.example.demo.repositories.IReviewReposiotry;
import com.example.demo.repositories.IUserReposiory;

public class RestaurantService implements IRestaurantService{
   private final IUserReposiory userReposiory;
   private final IRestaurantReposiotry restaurantReposiotry;
   private final IReviewReposiotry reviewReposiotry;
    public RestaurantService(IUserReposiory userReposiory, IRestaurantReposiotry restaurantReposiotry,
        IReviewReposiotry reviewReposiotry) {
    this.userReposiory = userReposiory;
    this.restaurantReposiotry = restaurantReposiotry;
    this.reviewReposiotry = reviewReposiotry;
}

    @Override
    public void registerUser(List<String> tokens) {
        // TODO Auto-generated method stub
        User user=new User(tokens.get(1));
        System.out.println(userReposiory.save(user));
    }

    @Override
    public void addRating(List<String> tokens) {
        // TODO Auto-generated method stub
        Long restaurantId=Long.parseLong(tokens.get(3));
        Long userId=Long.parseLong(tokens.get(2));
        Long rating=Long.parseLong(tokens.get(1));
        System.out.println(reviewReposiotry.save(restaurantId,userId,rating)+" added successfully for "+restaurantReposiotry.getById(restaurantId)+" by "+userReposiory.findById(userId)+"!");
    }

    @Override
    public void registerRestaurant(List<String> tokens) {
        // TODO Auto-generated method stub
        Restaurant restaurant=new Restaurant(tokens.get(1));
        System.out.println(restaurantReposiotry.save(restaurant));
        
    }

    @Override
    public void getReviews(List<String> tokens) {
        // TODO Auto-generated method stub
        if(tokens.get(2).equals("RATING_ASC")) System.out.println(reviewReposiotry.filterReviews(Long.parseLong(tokens.get(1)),Double.MIN_VALUE,Double.MAX_VALUE,true));
        else System.out.println(reviewReposiotry.filterReviews(Long.parseLong(tokens.get(1)),Double.MIN_VALUE,Double.MAX_VALUE,false));
        
    }

    @Override
    public void getReviewsfilterOrder(List<String> tokens) {
        // TODO Auto-generated method stub
        if(tokens.get(4).equals("RATING_ASC")) System.out.println(reviewReposiotry.filterReviews(Long.parseLong(tokens.get(1)),Double.parseDouble(tokens.get(2)),Double.parseDouble(tokens.get(3)),true));
        else System.out.println(reviewReposiotry.filterReviews(Long.parseLong(tokens.get(1)),Double.parseDouble(tokens.get(2)),Double.parseDouble(tokens.get(3)),false));
        
    }

    @Override
    public void describeRestaurant(List<String> token) {
        // TODO Auto-generated method stub
        Long restaurantId=Long.parseLong(token.get(1));
        String name=restaurantReposiotry.findNamebyId(restaurantId);
        Double rating=reviewReposiotry.calReview(restaurantId);
        DescribeRestaurant d=new DescribeRestaurant(restaurantId, name, rating);
        System.out.println(d);
        
    }

    @Override
    public void listRestaurant() {
        // TODO Auto-generated method stub
        System.out.println(restaurantReposiotry.findAll());
        
    }
    
    
    
}
