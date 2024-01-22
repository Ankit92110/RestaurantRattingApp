package com.example.demo.entities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Review {
    private Long id;
    private Map<Long,Map<Long,Long>>reviewMap;   // restaurnnt id, userid,rating
    
    
    public Review() {
        reviewMap=new HashMap<>();
    }
   
    public Map<Long, Map<Long, Long>> getReviewMap() {
        return reviewMap;
    }
    public Map<Long,Long> getreviewByRestaurantId(Long restaurantId){
        return reviewMap.get(restaurantId);
    }

    public void setReviewMap(Long restaurantId, Long userId, Long rating) {
        // Compute the inner map if absent for the given restaurantId
        reviewMap.computeIfAbsent(restaurantId, e -> new HashMap<>());
    
        // Retrieve the inner map for the given restaurantId
        Map<Long, Long> userRatings = reviewMap.get(restaurantId);
    
        // Put the rating for the given userId in the inner map
        if (userRatings != null) {
            userRatings.put(userId, rating);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Review [id=" + id + "]";
    }
    
    
    
    
}
