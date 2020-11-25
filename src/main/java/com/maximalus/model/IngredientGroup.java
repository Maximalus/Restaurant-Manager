package com.maximalus.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
@Entity
@Table(name="INGREDIENT_GROUPS")
public class IngredientGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name="NAME_OF_INGREDIENT_GROUP")
    private String nameOfIngredientGroup;

    @Setter(AccessLevel.PRIVATE)
    @OneToMany(mappedBy = "ingredientGroup", orphanRemoval = true)
    private List<Ingredient> ingredientList = new ArrayList<>();

    public IngredientGroup(String nameOfIngredientGroup, List<Ingredient> ingredientList) {
        this.nameOfIngredientGroup = nameOfIngredientGroup;
        this.ingredientList = ingredientList;
    }

    public void addIngredient(List<Ingredient> ingredientList){
        this.ingredientList.addAll(ingredientList);
        ingredientList.forEach(ingredient -> ingredient.setIngredientGroup(this));
    }
}
