package com.maximalus;

import com.maximalus.model.product.ingredient.Ingredient;
import com.maximalus.model.product.ingredient.IngredientGroup;
import com.maximalus.model.Outlet;

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
        ingredient.setId(5L);
        ingredient.setName("Soy milk");
        ingredient.setUnitName("Liter");
        ingredient.setCreationDate(LocalDateTime.of(2021,3,1,16,6,44, 332858000));
        ingredient.setChangingDate(LocalDateTime.of(2021,3,1,16,6,44, 332858000));
        return ingredient;
    }

    public static Ingredient getIngredientForUpdate(){
        Ingredient ingredient = new Ingredient();
        ingredient.setId(1L);
        ingredient.setName("Strawberry juice");
        ingredient.setUnitName("Liter");
        ingredient.setCreationDate(LocalDateTime.of(2021,3,1,16,6,44, 332858000));
        ingredient.setChangingDate(LocalDateTime.of(2021,3,1,16,6,44, 332858000));
        return ingredient;
    }

    public static List<Ingredient> getListOfIngredients(){
        Ingredient ingredient = new Ingredient();
        ingredient.setId(1L);
        ingredient.setName("Grapefruit juice");
        ingredient.setUnitName("Liter");
        ingredient.setCreationDate(LocalDateTime.of(2021,3,1,16,6,44, 332858000));
        ingredient.setChangingDate(LocalDateTime.of(2021,3,1,16,6,44, 332858000));

        Ingredient ingredient2 = new Ingredient();
        ingredient2.setId(2L);
        ingredient2.setName("Orange juice");
        ingredient2.setUnitName("Liter");
        ingredient2.setCreationDate(LocalDateTime.of(2021,3,1,16,6,44, 332858000));
        ingredient2.setChangingDate(LocalDateTime.of(2021,3,1,16,6,44, 332858000));

        Ingredient ingredient3 = new Ingredient();
        ingredient3.setId(3L);
        ingredient3.setName("Apple juice");
        ingredient3.setUnitName("Liter");
        ingredient3.setCreationDate(LocalDateTime.of(2021,3,1,16,6,44, 332858000));
        ingredient3.setChangingDate(LocalDateTime.of(2021,3,1,16,6,44, 332858000));

        Ingredient ingredient4 = new Ingredient();
        ingredient4.setId(4L);
        ingredient4.setName("Pineapple juice");
        ingredient4.setUnitName("Liter");
        ingredient4.setCreationDate(LocalDateTime.of(2021,3,1,16,6,44, 332858000));
        ingredient4.setChangingDate(LocalDateTime.of(2021,3,1,16,6,44, 332858000));

        Ingredient ingredient5 = new Ingredient();
        ingredient5.setId(5L);
        ingredient5.setName("Mango juice");
        ingredient5.setUnitName("Liter");
        ingredient5.setCreationDate(LocalDateTime.of(2021,3,1,16,6,44, 332858000));
        ingredient5.setChangingDate(LocalDateTime.of(2021,3,1,16,6,44, 332858000));

        return Stream.of(ingredient, ingredient2,
                ingredient3, ingredient4, ingredient5).collect(Collectors.toList());
    }

    public static Outlet getOutlet(){
        Outlet outlet = new Outlet();
        outlet.setId(7L);
        outlet.setName("Sazeli");
        outlet.setDeleted(false);
        outlet.setCreationDate(LocalDateTime.of(2021,3,1,16,6,44, 332858000));
        outlet.setChangingDate(LocalDateTime.of(2021,3,1,16,6,44, 332858000));
        return outlet;
    }

    public static Outlet getOutletForUpdate(){
        Outlet outlet = new Outlet();
        outlet.setId(1L);
        outlet.setName("Baladna farm");
        outlet.setDeleted(false);
        outlet.setCreationDate(LocalDateTime.of(2021,3,1,16,6,44, 332858000));
        outlet.setChangingDate(LocalDateTime.of(2021,3,1,16,6,44, 332858000));
        return outlet;
    }

    public static List<Outlet> getListOfOutlets(){
        Outlet outlet = new Outlet();
        outlet.setId(1L);
        outlet.setName("Crystal");
        outlet.setDeleted(false);
        outlet.setCreationDate(LocalDateTime.of(2021,3,1,16,6,44, 332858000));
        outlet.setChangingDate(LocalDateTime.of(2021,3,1,16,6,44, 332858000));

        Outlet outlet2 = new Outlet();
        outlet2.setId(2L);
        outlet2.setName("La Spiga");
        outlet2.setDeleted(false);
        outlet2.setCreationDate(LocalDateTime.of(2021,3,1,16,6,44, 332858000));
        outlet2.setChangingDate(LocalDateTime.of(2021,3,1,16,6,44, 332858000));

        Outlet outlet3 = new Outlet();
        outlet3.setId(3L);
        outlet3.setName("Market");
        outlet3.setDeleted(false);
        outlet3.setCreationDate(LocalDateTime.of(2021,3,1,16,6,44, 332858000));
        outlet3.setChangingDate(LocalDateTime.of(2021,3,1,16,6,44, 332858000));

        Outlet outlet4 = new Outlet();
        outlet4.setId(4L);
        outlet4.setName("Spice market");
        outlet4.setDeleted(false);
        outlet4.setCreationDate(LocalDateTime.of(2021,3,1,16,6,44, 332858000));
        outlet4.setChangingDate(LocalDateTime.of(2021,3,1,16,6,44, 332858000));

        Outlet outlet5 = new Outlet();
        outlet5.setId(5L);
        outlet5.setName("Wahm");
        outlet5.setDeleted(false);
        outlet5.setCreationDate(LocalDateTime.of(2021,3,1,16,6,44, 332858000));
        outlet5.setChangingDate(LocalDateTime.of(2021,3,1,16,6,44, 332858000));

        Outlet outlet6 = new Outlet();
        outlet6.setId(6L);
        outlet6.setName("W cafe");
        outlet6.setDeleted(false);
        outlet6.setCreationDate(LocalDateTime.of(2021,3,1,16,6,44, 332858000));
        outlet6.setChangingDate(LocalDateTime.of(2021,3,1,16,6,44, 332858000));

        return Stream.of(outlet, outlet2, outlet3, outlet4, outlet5, outlet6).collect(Collectors.toList());
    }
}