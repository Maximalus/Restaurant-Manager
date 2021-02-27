package com.maximalus.controler;

import com.maximalus.dto.IngredientDto;
import com.maximalus.model.Ingredient;
import com.maximalus.model.IngredientGroup;
import com.maximalus.service.impl.IngredientGroupServiceImpl;
import com.maximalus.service.impl.IngredientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;


@Controller
@RequestMapping("admin/manage/ingredient")
public class IngredientController {
    @Autowired
    private IngredientServiceImpl ingredientServiceImpl;
    @Autowired
    public IngredientGroupServiceImpl ingredientGroupServiceImpl;

    @GetMapping(value = "admin/createIngredient")
    public String getCreateIngredientPage(Model model){
        model.addAttribute("ingredientDto", new IngredientDto());
        List<String> ingredientGroups = ingredientGroupServiceImpl.findAll().stream()
                .map(IngredientGroup::getName).collect(Collectors.toList());
        model.addAttribute("ingredientGroups", ingredientGroups);
        return "admin/manage/ingredient/createIngredient";
    }

    @PostMapping(value = "admin/createIngredient")
    public String createIngredient(@RequestParam String name,
                                   @RequestParam Long costPerUnit,
                                   @RequestParam String nameOfUnit,
                                   @RequestParam String ingredientGroupName){
        Ingredient ingredient = new Ingredient();
        ingredient.setName(name);
        ingredient.setCostPerUnit(BigDecimal.valueOf(costPerUnit));
        ingredient.setCurrentQuantity(0);
        ingredient.setInitialQuantity(0);
        ingredient.setUnitName(nameOfUnit);
        IngredientGroup ingredientGroup = ingredientGroupServiceImpl.findByName(ingredientGroupName);
        ingredientGroup.addIngredient(ingredient);
        ingredientServiceImpl.save(ingredient);
        return "admin/admin";
    }
}
