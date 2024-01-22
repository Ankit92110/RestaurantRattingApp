package com.example.demo.entities;

public class Restaurant {
 private  Long id;
 private String name;
public Restaurant(String name) {
    this.name = name;
}
public Long getId() {
    return id;
}
public void setId(Long id) {
    this.id = id;
}
public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}
@Override
public String toString() {
    return "Restaurant [id=" + id + "]";
}

 
    
}
