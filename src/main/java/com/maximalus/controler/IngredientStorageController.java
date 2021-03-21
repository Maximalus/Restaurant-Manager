package com.maximalus.controler;

import com.maximalus.dto.IngredientStorageDto;
import com.maximalus.model.product.ingredient.Ingredient;
import com.maximalus.service.impl.IngredientServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
public class IngredientStorageController {
    private final IngredientServiceImpl ingredientService;

    @GetMapping(value = "/admin/createIngredientStorage")
    public String createIngredientStorage(Model model){
        List<Ingredient> ingredients = ingredientService.findAll()
                .stream().filter(ingredient -> !ingredient.isDeleted())
                .collect(Collectors.toList());
        model.addAttribute("listIngredients", ingredients);
        model.addAttribute("ingredientStorage", new IngredientStorageDto());
        model.addAttribute("selectedIngredients", new ArrayList<Ingredient>());
        return "admin/manage/ingredient/createIngredientStorage";
    }
}
