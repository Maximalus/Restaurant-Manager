package com.maximalus.repository;

import com.maximalus.model.Ingredient;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestData {
    public static Ingredient getIngredient(){
        Ingredient ingredient = new Ingredient();
        ingredient.setName("Milk");
        ingredient.setCostPerUnit(BigDecimal.valueOf(12.00));
        ingredient.setInitialQuantity(2000);
        ingredient.setCurrentQuantity(1980);
        return ingredient;
    }

    public static Ingredient getIngredientForUpdate(){
        Ingredient ingredient = new Ingredient();
        ingredient.setId(1L);
        ingredient.setName("Apple juice");
        ingredient.setCostPerUnit(BigDecimal.valueOf(12.00));
        ingredient.setInitialQuantity(2000);
        ingredient.setCurrentQuantity(1980);
        ingredient.setTotalPrice(BigDecimal.valueOf(24000.00));
        return ingredient;
    }

    public static List<Ingredient> getSetOfIngredients(){
        Ingredient ingredient = new Ingredient();
        ingredient.setName("Milk");
        ingredient.setCostPerUnit(BigDecimal.valueOf(12.00));
        ingredient.setInitialQuantity(2000);
        ingredient.setCurrentQuantity(1980);

        Ingredient ingredient2 = new Ingredient();
        ingredient2.setName("Orange juice");
        ingredient2.setCostPerUnit(BigDecimal.valueOf(12.00));
        ingredient2.setInitialQuantity(2000);
        ingredient2.setCurrentQuantity(1980);

        Ingredient ingredient3 = new Ingredient();
        ingredient3.setName("Apple juice");
        ingredient3.setCostPerUnit(BigDecimal.valueOf(12.00));
        ingredient3.setInitialQuantity(2000);
        ingredient3.setCurrentQuantity(1980);

        Ingredient ingredient4 = new Ingredient();
        ingredient4.setName("Pineapple juice");
        ingredient4.setCostPerUnit(BigDecimal.valueOf(12.00));
        ingredient4.setInitialQuantity(2000);
        ingredient4.setCurrentQuantity(1980);

        Ingredient ingredient5 = new Ingredient();
        ingredient5.setName("Mango juice");
        ingredient5.setCostPerUnit(BigDecimal.valueOf(12.00));
        ingredient5.setInitialQuantity(2000);
        ingredient5.setCurrentQuantity(1980);

        return Stream.of(ingredient, ingredient2,
                ingredient3, ingredient4, ingredient5).collect(Collectors.toList());
    }
}
