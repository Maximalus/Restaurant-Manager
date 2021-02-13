package com.maximalus.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="ingredient_groups")
public class IngredientGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ingredient_group_generator")
    @SequenceGenerator(allocationSize = 1, name = "ingredient_group_generator")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Setter(AccessLevel.PRIVATE)
    @OneToMany(mappedBy = "ingredientGroup", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ingredient> ingredients = new ArrayList<>();

    public void addIngredient(Ingredient ingredient){
        ingredients.add(ingredient);
        ingredient.setIngredientGroup(this);
    }

    public void removeIngredient(Ingredient ingredient){
        ingredients.remove(ingredient);
        ingredient.setIngredientGroup(null);
    }


}
