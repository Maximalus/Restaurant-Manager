package com.maximalus.controler;

import com.maximalus.dto.IngredientGroupDto;
import com.maximalus.dto.converter.IngredientGroupDtoConverter;
import com.maximalus.model.product.ingredient.IngredientGroup;
import com.maximalus.service.IngredientGroupService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/ingredient_groups")
@AllArgsConstructor
public class IngredientGroupController {
    private final IngredientGroupService ingredientGroupService;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public IngredientGroupDto getIngredientGroupById(@PathVariable Long id){
        IngredientGroup ingredientGroup = ingredientGroupService.findById(id);
        return IngredientGroupDtoConverter.toDto(ingredientGroup);
    }

    @GetMapping
    public ResponseEntity<List<IngredientGroupDto>> getAllIngredientGroups(){
        List<IngredientGroupDto> ingredientGroupDtoList = ingredientGroupService.findAll().stream()
                .filter(ingredient -> !ingredient.isDeleted())
                .map(IngredientGroupDtoConverter::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(ingredientGroupDtoList);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public IngredientGroup createIngredientGroup(String name){
        IngredientGroup ingredientGroup = new IngredientGroup();
        ingredientGroup.setName(name);
        ingredientGroup.setCreationDate(LocalDateTime.now());
        ingredientGroup.setChangingDate(LocalDateTime.now());
        return ingredientGroupService.save(ingredientGroup);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public IngredientGroup updateIngredientGroup(@PathVariable Long id,
                                       String name){
        IngredientGroup ingredientGroup = ingredientGroupService.findById(id);
        ingredientGroup.setName(name);
        ingredientGroup.setChangingDate(LocalDateTime.now());
        return ingredientGroupService.update(ingredientGroup);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteIngredientGroupById(@PathVariable Long id){
        ingredientGroupService.deleteById(id);
    }


}
