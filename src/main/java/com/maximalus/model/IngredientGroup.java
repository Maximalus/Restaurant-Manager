package com.maximalus.model;

import lombok.*;
import org.springframework.context.annotation.ComponentScan;

import javax.persistence.*;
import javax.validation.Constraint;
import javax.validation.constraints.NotNull;
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
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "ingredientGroup")
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
