package com.example.demo.entities;

public class DescribeRestaurant {
    private Long id;
    private  String name;
    private Double rating;
    public DescribeRestaurant(Long id, String name, Double rating) {
        this.id = id;
        this.name = name;
        this.rating = rating;
    }
    @Override
    public String toString() {
        return "Restaurant [id=" + id + ", name=" + name + ", rating=" + rating + "]";
    }
    
}
