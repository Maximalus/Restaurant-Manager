package com.maximalus.repository;

import com.maximalus.model.Ingredient;
import com.maximalus.model.IngredientGroup;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestData {
    public static IngredientGroup getIngredientGroup(){
        IngredientGroup ingredientGroup = new IngredientGroup();
        ingredientGroup.setId(4L);
        ingredientGroup.setName("Juices");
        return ingredientGroup;
    }

    public static IngredientGroup getIngredientGroupForUpdate(){
        IngredientGroup ingredientGroup = new IngredientGroup();
        ingredientGroup.setId(2L);
        ingredientGroup.setName("Oil");
        return ingredientGroup;
    }

    public static List<IngredientGroup> getListOfIngredientGroups(){
        IngredientGroup ingredientGroup = new IngredientGroup();
        ingredientGroup.setId(1L);
        ingredientGroup.setName("Milk");

        IngredientGroup ingredientGroup2 = new IngredientGroup();
        ingredientGroup2.setId(2L);
        ingredientGroup2.setName("Water");

        IngredientGroup ingredientGroup3 = new IngredientGroup();
        ingredientGroup3.setId(3L);
        ingredientGroup3.setName("Spices");

        return Stream.of(ingredientGroup, ingredientGroup2, ingredientGroup3).collect(Collectors.toList());
    }

    public static Ingredient getIngredient(){
        Ingredient ingredient = new Ingredient();
        ingredient.setId(6L);
        ingredient.setName("Watermelon juice");
        ingredient.setCostPerUnit(BigDecimal.valueOf(12.00).setScale(2));
        ingredient.setInitialQuantity(2000);
        ingredient.setCurrentQuantity(1980);
        ingredient.setTotalPrice(BigDecimal.valueOf(24000.00).setScale(2));
        return ingredient;
    }

    public static Ingredient getIngredientForUpdate(){
        Ingredient ingredient = new Ingredient();
        ingredient.setId(1L);
        ingredient.setName("Strawberry juice");
        ingredient.setCostPerUnit(BigDecimal.valueOf(12).setScale(2));
        ingredient.setInitialQuantity(2000);
        ingredient.setCurrentQuantity(1980);
        ingredient.setTotalPrice(BigDecimal.valueOf(24000).setScale(2));
        return ingredient;
    }

    public static List<Ingredient> getListOfIngredients(){
        Ingredient ingredient = new Ingredient();
        ingredient.setId(1L);
        ingredient.setName("Grapefruit juice");
        ingredient.setCostPerUnit(BigDecimal.valueOf(12.00).setScale(2));
        ingredient.setInitialQuantity(2000);
        ingredient.setCurrentQuantity(1980);
        ingredient.setTotalPrice(BigDecimal.valueOf(24000.00).setScale(2));

        Ingredient ingredient2 = new Ingredient();
        ingredient2.setId(2L);
        ingredient2.setName("Orange juice");
        ingredient2.setCostPerUnit(BigDecimal.valueOf(12).setScale(2));
        ingredient2.setInitialQuantity(2000);
        ingredient2.setCurrentQuantity(1980);
        ingredient2.setTotalPrice(BigDecimal.valueOf(24000).setScale(2));

        Ingredient ingredient3 = new Ingredient();
        ingredient3.setId(3L);
        ingredient3.setName("Apple juice");
        ingredient3.setCostPerUnit(BigDecimal.valueOf(12).setScale(2));
        ingredient3.setInitialQuantity(2000);
        ingredient3.setCurrentQuantity(1980);
        ingredient3.setTotalPrice(BigDecimal.valueOf(24000).setScale(2));

        Ingredient ingredient4 = new Ingredient();
        ingredient4.setId(4L);
        ingredient4.setName("Pineapple juice");
        ingredient4.setCostPerUnit(BigDecimal.valueOf(12).setScale(2));
        ingredient4.setInitialQuantity(2000);
        ingredient4.setCurrentQuantity(1980);
        ingredient4.setTotalPrice(BigDecimal.valueOf(24000).setScale(2));

        Ingredient ingredient5 = new Ingredient();
        ingredient5.setId(5L);
        ingredient5.setName("Mango juice");
        ingredient5.setCostPerUnit(BigDecimal.valueOf(12).setScale(2));
        ingredient5.setInitialQuantity(2000);
        ingredient5.setCurrentQuantity(1980);
        ingredient5.setTotalPrice(BigDecimal.valueOf(24000).setScale(2));

        return Stream.of(ingredient, ingredient2,
                ingredient3, ingredient4, ingredient5).collect(Collectors.toList());
    }
}
