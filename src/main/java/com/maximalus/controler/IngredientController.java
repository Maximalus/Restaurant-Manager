package com.maximalus.controler;

import com.maximalus.model.Ingredient;
import com.maximalus.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("admin/manage/ingredient")
public class IngredientController {
    @Autowired
    private IngredientService ingredientService;

    @GetMapping
    public String getIngredientList(Model model){
        List<Ingredient> ingredientList = ingredientService.findAll();
        model.addAttribute("ingredients", ingredientList);
        return "admin/manage/ingredient/allIngredients";
    }
}
