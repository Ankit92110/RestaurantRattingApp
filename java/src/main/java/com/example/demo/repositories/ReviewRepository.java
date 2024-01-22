package com.example.demo.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import com.example.demo.entities.Rating;
import com.example.demo.entities.Restaurant;
import com.example.demo.entities.Review;

public class ReviewRepository implements IReviewReposiotry {
    private Long autoincrement=1L;
    private Map<Long,Review>reviewMap;
    
   
    public ReviewRepository() {
        reviewMap=new HashMap<>();
    }


    @Override
    public Review save(Long restaurantId, Long userId, Long rating) {
        // TODO Auto-generated method stub
        Review review=new Review();
        review.setId(autoincrement);
        review.setReviewMap(restaurantId, userId, rating);
        this.reviewMap.put(autoincrement,review);
        autoincrement++;
        return review;
        
    }

    @Override
    public List<Review> filterReviews(Long restaurantId,Double low,Double high, Boolean fg) {
        // TODO Auto-generated method stub
         List<Pair>res=new ArrayList<>();
        for(Entry<Long, Review> entry:this.reviewMap.entrySet()){
               Double rating=0d;
               Long n=0L;
           Map<Long, Long> reviewsByRestaurantId = entry.getValue().getreviewByRestaurantId(restaurantId);
            
           if (reviewsByRestaurantId != null) {
               for (Entry<Long, Long> e : reviewsByRestaurantId.entrySet()) {
                   rating += e.getValue();
                   n++;
               }
               rating /= n;
               rating = Math.round(rating * 10.0) / 10.0;
               if(rating>=low && rating <=high)
               res.add(new Pair(rating, entry.getValue()));
           }
        }
            if(fg) res.sort((a,b)->a.first.compareTo(b.first));
            else res.sort((a,b)->b.first.compareTo(a.first));
            List<Review>ans=new ArrayList<>();
           for(Pair a:res) ans.add(a.second);
           return ans;
    }


    @Override
    public Double calReview(Long restaurantId) {
        // TODO Auto-generated method stub
        Double rating=0d;
        Long n=0L;
        for(Entry<Long, Review> entry:this.reviewMap.entrySet()){      
           Map<Long, Long> reviewsByRestaurantId = entry.getValue().getreviewByRestaurantId(restaurantId);   
           if (reviewsByRestaurantId != null) {
               for (Entry<Long, Long> e : reviewsByRestaurantId.entrySet()) {
                   rating += e.getValue();
                   n++;
               }
           }
        }
        rating/=n;   
        return Math.round(rating * 10.0) / 10.0;
    }
    
}
