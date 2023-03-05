package com.example.springpostgres.FoodController;

import com.example.springpostgres.logic.FoodLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import com.example.springpostgres.entity.Food;
import com.example.springpostgres.repository.FoodRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/foods")
public class FoodController {
    public FoodRepository FOODS;
    public FoodController(FoodRepository FOODS){this.FOODS = FOODS;}
    @Autowired
    private FoodLogic foodLogic;

//    @GetMapping()
//    @ResponseBody()
//    public List<Food> food(){
//        return foodLogic.getFoods();
//    }

    @GetMapping()
    public List<Food> showFood(){
        return FOODS.findAll();
    }
    //SHOW individual food
    @GetMapping("/{id}")
    public Optional<Food> showAFood(@PathVariable int id){
        return FOODS.findById(id);
    }


    @PostMapping
    public List<Food> createFood(@RequestBody Food newFood){
        FOODS.save(newFood);
        return FOODS.findAll();
    }

    //PUT route
    @PutMapping("/{id}")
    public Optional<Food> updateFood(@RequestBody Food updatedFood, @PathVariable int id){
        FOODS.findById(id)
                .map(food -> {
                    food.setCarbs(updatedFood.getCarbs());
                    food.setDate(updatedFood.getDate());
                    food.setName(updatedFood.getName());
                    return FOODS.save(food);
                })
                .orElseGet(() -> {
                    return FOODS.save(updatedFood);
                });
        return FOODS.findById(id);
    }



}
