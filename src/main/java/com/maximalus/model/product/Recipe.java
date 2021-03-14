package com.maximalus.model;

import com.maximalus.model.product.ingredient.Ingredient;
import com.maximalus.model.product.item.MenuItem;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "recipes")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recipe_generator")
    @SequenceGenerator(allocationSize = 1, name = "recipe_generator")
    private Long id;

    @ManyToOne
    @JoinColumn(name="ingredient_id")
    private Ingredient ingredient;

    @ManyToOne
    @JoinColumn(name="menu_item_id")
    private MenuItem menuItem;

    @ManyToOne
    @JoinColumn(name="outlet_id")
    private Outlet outlet;

    @Column(nullable = false)
    private Double amountOfIngredient;

    @Column(nullable = false)
    private boolean isDeleted;

    @Column(nullable = false)
    private LocalDateTime creationDate;

    @Column(nullable = false)
    private LocalDateTime changingDate;
}
