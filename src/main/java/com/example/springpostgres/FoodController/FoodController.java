package com.example.springpostgres.FoodController;

import com.example.springpostgres.logic.FoodLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import com.example.springpostgres.entity.Food;

import java.util.List;
@RestController
@RequestMapping("/foods")
public class FoodController {
    @Autowired
    private FoodLogic foodLogic;

    @GetMapping()
    @ResponseBody()
    public List<Food> food(){
        return foodLogic.getFoods();
    }

}
