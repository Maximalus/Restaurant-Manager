package com.maximalus;

import com.maximalus.model.Ingredient;
import com.maximalus.repository.IngredientRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.math.BigDecimal;

@SpringBootApplication
public class Application {
        public static void main(String[] args) {
			ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
			IngredientRepository ingredientRepository = context.getBean("ingredientRepository", IngredientRepository.class);

			Ingredient ingredient = new Ingredient();
			ingredient.setName("Milk");
			ingredient.setCostPerUnit(BigDecimal.valueOf(12));
			ingredient.setInitialQuantity(2000);
			ingredient.setCurrentQuantity(1980);
			ingredient.setTotalPrice(BigDecimal.valueOf(24000));

			ingredientRepository.save(ingredient);
		}
}
