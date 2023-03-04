package com.example.springpostgres.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.springpostgres.repository.FoodRepository;
import com.example.springpostgres.entity.Food;
import java.util.List;

@Service
public class FoodLogic {
    @Autowired
    private FoodRepository foodRepository;
    public List<Food> getFoods(){
        return foodRepository.findAll();
    }

}
