package com.maximalus.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name="ingredient_groups")
public class IngredientGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String nameOfIngredientGroup;

    @Setter(AccessLevel.PRIVATE)
    @OneToMany(mappedBy = "ingredientGroup", orphanRemoval = true)
    private List<Ingredient> ingredientList = new ArrayList<>();

    public IngredientGroup(String nameOfIngredientGroup, List<Ingredient> ingredientList) {
        this.nameOfIngredientGroup = nameOfIngredientGroup;
        this.ingredientList = ingredientList;
    }

    public void addIngredient(Ingredient ingredient){
        ingredientList.add(ingredient);
        ingredient.setIngredientGroup(this);
    }

    public void removeIngredient(Ingredient ingredient){
        ingredientList.remove(ingredient);
        ingredient.setIngredientGroup(null);
    }


}
