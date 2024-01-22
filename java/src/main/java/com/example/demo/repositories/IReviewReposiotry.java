package com.example.demo.repositories;

import java.util.List;
import com.example.demo.entities.Rating;
import com.example.demo.entities.Review;

public interface IReviewReposiotry {
     public Review save(Long restaurantid,Long userid,Long rating);
     public List<Review> filterReviews(Long restaurantId,Double low,Double high,Boolean r);
     public Double calReview(Long restaurantId);
    // public List<Review>filterReviewsOrder(Long restaurantId,Double low,Double high,Boolean fg);
   
}
