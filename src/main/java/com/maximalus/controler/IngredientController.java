package com.maximalus.controler;

import com.maximalus.dto.IngredientDto;
import com.maximalus.dto.converter.IngredientDtoConverter;
import com.maximalus.model.product.ingredient.Ingredient;
import com.maximalus.model.product.ingredient.IngredientGroup;
import com.maximalus.service.IngredientGroupService;
import com.maximalus.service.IngredientService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.QueryParam;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/ingredients")
@AllArgsConstructor
public class IngredientController {
    private final IngredientService ingredientService;
    private final IngredientGroupService ingredientGroupService;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public IngredientDto getIngredientById(@PathVariable Long id){
        Ingredient ingredient = ingredientService.findById(id);
        IngredientDto ingredientDto = IngredientDtoConverter.toDto(ingredient);
        return ingredientDto;
    }

    @GetMapping
    public ResponseEntity<List<IngredientDto>> getAllIngredients(){
        List<IngredientDto> ingredientDtoList = ingredientService.findAll().stream()
                .filter(ingredient -> !ingredient.isDeleted())
                .map(IngredientDtoConverter::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(ingredientDtoList);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Ingredient createIngredient(@RequestBody IngredientDto ingredientDto){
        Ingredient ingredient = IngredientDtoConverter.fromDto(ingredientDto);
        String ingredientGroupName = ingredientDto.getIngredientGroupName();
        IngredientGroup ingredientGroup = ingredientGroupService.findByName(ingredientGroupName);
        ingredient.setIngredientGroup(ingredientGroup);
        return ingredientService.save(ingredient);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Ingredient updateIngredient(@PathVariable Long id,
                                       @RequestBody IngredientDto ingredientDto){
        Ingredient ingredient = IngredientDtoConverter.fromDto(ingredientDto);
        ingredient.setId(id);
        String ingredientGroupName = ingredientDto.getIngredientGroupName();
        IngredientGroup ingredientGroup = ingredientGroupService.findByName(ingredientGroupName);
        ingredient.setIngredientGroup(ingredientGroup);
        return ingredientService.save(ingredient);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteIngredientById(@PathVariable Long id){
        ingredientService.deleteById(id);
    }

    @GetMapping("/search")
    public List<Ingredient> getByPageAndSize(@QueryParam("page")Integer page,
                                             @QueryParam("size")Integer size){
        return ingredientService.findAll(PageRequest.of(page, size)).getContent();
    }
}
