package com.maximalus.repository;

import com.maximalus.model.Ingredient;
import com.maximalus.model.IngredientGroup;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestData {
    public static IngredientGroup getIngredientGroup(){
        IngredientGroup ingredientGroup = new IngredientGroup();
        ingredientGroup.setId(5L);
        ingredientGroup.setName("Sauces");
        ingredientGroup.setCreationDate(LocalDateTime.of(2021,3,1,16,6,44, 332858000));
        ingredientGroup.setChangingDate(LocalDateTime.of(2021,3,1,16,6,44, 332858000));
        return ingredientGroup;
    }

    public static IngredientGroup getIngredientGroupForUpdate(){
        IngredientGroup ingredientGroup = new IngredientGroup();
        ingredientGroup.setId(2L);
        ingredientGroup.setName("Oil");
        ingredientGroup.setCreationDate(LocalDateTime.of(2021,3,1,16,6,44, 332858000));
        ingredientGroup.setChangingDate(LocalDateTime.of(2021,3,1,16,6,44, 332858000));
        return ingredientGroup;
    }

    public static List<IngredientGroup> getListOfIngredientGroups(){
        IngredientGroup ingredientGroup = new IngredientGroup();
        ingredientGroup.setId(1L);
        ingredientGroup.setName("Milk");
        ingredientGroup.setCreationDate(LocalDateTime.of(2021,3,1,16,6,44, 332858000));
        ingredientGroup.setChangingDate(LocalDateTime.of(2021,3,1,16,6,44, 332858000));

        IngredientGroup ingredientGroup2 = new IngredientGroup();
        ingredientGroup2.setId(2L);
        ingredientGroup2.setName("Water");
        ingredientGroup2.setCreationDate(LocalDateTime.of(2021,3,1,16,6,44, 332858000));
        ingredientGroup2.setChangingDate(LocalDateTime.of(2021,3,1,16,6,44, 332858000));

        IngredientGroup ingredientGroup3 = new IngredientGroup();
        ingredientGroup3.setId(3L);
        ingredientGroup3.setName("Spices");
        ingredientGroup3.setCreationDate(LocalDateTime.of(2021,3,1,16,6,44, 332858000));
        ingredientGroup3.setChangingDate(LocalDateTime.of(2021,3,1,16,6,44, 332858000));

        IngredientGroup ingredientGroup4 = new IngredientGroup();
        ingredientGroup4.setId(4L);
        ingredientGroup4.setName("Juices");
        ingredientGroup4.setCreationDate(LocalDateTime.of(2021,3,1,16,6,44, 332858000));
        ingredientGroup4.setChangingDate(LocalDateTime.of(2021,3,1,16,6,44, 332858000));

        return Stream.of(ingredientGroup, ingredientGroup2, ingredientGroup3, ingredientGroup4)
                .collect(Collectors.toList());
    }

    public static Ingredient getIngredient(){
        Ingredient ingredient = new Ingredient();
        ingredient.setId(6L);
        ingredient.setName("Watermelon juice");
        ingredient.setCostPerUnit(BigDecimal.valueOf(12.00).setScale(2));
        ingredient.setInitialQuantity(BigDecimal.valueOf(2000).setScale(2));
        ingredient.setCurrentQuantity(BigDecimal.valueOf(1980).setScale(2));
        ingredient.setTotalPrice(BigDecimal.valueOf(24000.00).setScale(2));
        ingredient.setUnitName("Liter");
        ingredient.setCreationDate(LocalDateTime.of(2021,3,1,16,6,44, 332858000));
        ingredient.setChangingDate(LocalDateTime.of(2021,3,1,16,6,44, 332858000));
        return ingredient;
    }

    public static Ingredient getIngredientForUpdate(){
        Ingredient ingredient = new Ingredient();
        ingredient.setId(1L);
        ingredient.setName("Strawberry juice");
        ingredient.setCostPerUnit(BigDecimal.valueOf(12).setScale(2));
        ingredient.setInitialQuantity(BigDecimal.valueOf(2000).setScale(2));
        ingredient.setCurrentQuantity(BigDecimal.valueOf(1980).setScale(2));
        ingredient.setTotalPrice(BigDecimal.valueOf(24000).setScale(2));
        ingredient.setUnitName("Liter");
        ingredient.setCreationDate(LocalDateTime.of(2021,3,1,16,6,44, 332858000));
        ingredient.setChangingDate(LocalDateTime.of(2021,3,1,16,6,44, 332858000));
        return ingredient;
    }

    public static List<Ingredient> getListOfIngredients(){
        Ingredient ingredient = new Ingredient();
        ingredient.setId(1L);
        ingredient.setName("Grapefruit juice");
        ingredient.setCostPerUnit(BigDecimal.valueOf(12.00).setScale(2));
        ingredient.setInitialQuantity(BigDecimal.valueOf(2000).setScale(2));
        ingredient.setCurrentQuantity(BigDecimal.valueOf(1980).setScale(2));
        ingredient.setTotalPrice(BigDecimal.valueOf(24000.00).setScale(2));
        ingredient.setUnitName("Liter");
        ingredient.setCreationDate(LocalDateTime.of(2021,3,1,16,6,44, 332858000));
        ingredient.setChangingDate(LocalDateTime.of(2021,3,1,16,6,44, 332858000));

        Ingredient ingredient2 = new Ingredient();
        ingredient2.setId(2L);
        ingredient2.setName("Orange juice");
        ingredient2.setCostPerUnit(BigDecimal.valueOf(12).setScale(2));
        ingredient2.setInitialQuantity(BigDecimal.valueOf(2000).setScale(2));
        ingredient2.setCurrentQuantity(BigDecimal.valueOf(1980).setScale(2));
        ingredient2.setTotalPrice(BigDecimal.valueOf(24000).setScale(2));
        ingredient2.setUnitName("Liter");
        ingredient2.setCreationDate(LocalDateTime.of(2021,3,1,16,6,44, 332858000));
        ingredient2.setChangingDate(LocalDateTime.of(2021,3,1,16,6,44, 332858000));

        Ingredient ingredient3 = new Ingredient();
        ingredient3.setId(3L);
        ingredient3.setName("Apple juice");
        ingredient3.setCostPerUnit(BigDecimal.valueOf(12).setScale(2));
        ingredient3.setInitialQuantity(BigDecimal.valueOf(2000).setScale(2));
        ingredient3.setCurrentQuantity(BigDecimal.valueOf(1980).setScale(2));
        ingredient3.setTotalPrice(BigDecimal.valueOf(24000).setScale(2));
        ingredient3.setUnitName("Liter");
        ingredient3.setCreationDate(LocalDateTime.of(2021,3,1,16,6,44, 332858000));
        ingredient3.setChangingDate(LocalDateTime.of(2021,3,1,16,6,44, 332858000));

        Ingredient ingredient4 = new Ingredient();
        ingredient4.setId(4L);
        ingredient4.setName("Pineapple juice");
        ingredient4.setCostPerUnit(BigDecimal.valueOf(12).setScale(2));
        ingredient4.setInitialQuantity(BigDecimal.valueOf(2000).setScale(2));
        ingredient4.setCurrentQuantity(BigDecimal.valueOf(1980).setScale(2));
        ingredient4.setTotalPrice(BigDecimal.valueOf(24000).setScale(2));
        ingredient4.setUnitName("Liter");
        ingredient4.setCreationDate(LocalDateTime.of(2021,3,1,16,6,44, 332858000));
        ingredient4.setChangingDate(LocalDateTime.of(2021,3,1,16,6,44, 332858000));

        Ingredient ingredient5 = new Ingredient();
        ingredient5.setId(5L);
        ingredient5.setName("Mango juice");
        ingredient5.setCostPerUnit(BigDecimal.valueOf(12).setScale(2));
        ingredient5.setInitialQuantity(BigDecimal.valueOf(2000).setScale(2));
        ingredient5.setCurrentQuantity(BigDecimal.valueOf(1980).setScale(2));
        ingredient5.setTotalPrice(BigDecimal.valueOf(24000).setScale(2));
        ingredient5.setUnitName("Liter");
        ingredient5.setCreationDate(LocalDateTime.of(2021,3,1,16,6,44, 332858000));
        ingredient5.setChangingDate(LocalDateTime.of(2021,3,1,16,6,44, 332858000));

        return Stream.of(ingredient, ingredient2,
                ingredient3, ingredient4, ingredient5).collect(Collectors.toList());
    }
}