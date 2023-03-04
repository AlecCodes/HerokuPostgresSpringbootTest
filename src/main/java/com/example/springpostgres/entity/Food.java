package com.example.springpostgres.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name = "FOODS")
public class Food {
    @Id @GeneratedValue
    private int id;
    private String name;
    private int carbs;
    private String date;

    /////////////////////ID
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    /////////////////////name
    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /////////////////////carbs
    public int getCarbs(){
        return carbs;
    }

    public void setCarbs(int carbs){
        this.carbs = carbs;
    }

    /////////////////////date
    public String getDate(){
        return date;
    }
    public void setDate(String date){
        this.date = date;
    }
}
