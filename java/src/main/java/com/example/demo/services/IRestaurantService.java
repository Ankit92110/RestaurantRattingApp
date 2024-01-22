package com.example.demo.services;

import java.util.List;

public interface IRestaurantService {
    public void registerUser(List<String>tokens);
    public void registerRestaurant(List<String>tokens);
    public void addRating(List<String>tokens);
    public void getReviews(List<String>tokens);
    public void getReviewsfilterOrder(List<String>token);
    public void describeRestaurant(List<String>token);
    public void listRestaurant();
}
