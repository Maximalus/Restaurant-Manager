package com.maximalus.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.LocalDateTime;
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

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @Setter(AccessLevel.PRIVATE)
    @OneToMany(mappedBy = "ingredientGroup", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ingredient> ingredients = new ArrayList<>();

    @Column(nullable = false)
    private boolean isDeleted;

    @Column(nullable = false)
    private LocalDateTime creationDate;

    @Column(nullable = false)
    private LocalDateTime changingDate;

    public void addIngredient(Ingredient ingredient){
        ingredients.add(ingredient);
        ingredient.setIngredientGroup(this);
    }

    public void removeIngredient(Ingredient ingredient){
        ingredients.remove(ingredient);
        ingredient.setIngredientGroup(null);
    }
}
