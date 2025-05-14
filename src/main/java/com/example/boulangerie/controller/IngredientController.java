package com.example.boulangerie.controller;

import com.example.boulangerie.model.Ingredients;
import com.example.boulangerie.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {

    @Autowired
    private IngredientRepository ingredientsRepository;

    @GetMapping
    public List<Ingredients> getAllIngredients() {
        return (List<Ingredients>) ingredientsRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Ingredients> getIngredientById(@PathVariable Long id) {
        return ingredientsRepository.findById(id);
    }

    @PostMapping
    public Ingredients createIngredient(@RequestBody Ingredients ingredient) {
        return ingredientsRepository.save(ingredient);
    }

    @PutMapping("/{id}")
    public Ingredients updateIngredient(@PathVariable Long id, @RequestBody Ingredients ingredientDetails) {
        Ingredients ingredient = ingredientsRepository.findById(id).orElseThrow();
        ingredient.setNom(ingredientDetails.getNom());
        ingredient.setQuantite(ingredientDetails.getQuantite());
        ingredient.setUnite(ingredientDetails.getUnite());
        return ingredientsRepository.save(ingredient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteIngredient(@PathVariable Long id) {
        if (!ingredientsRepository.existsById(id)) {
            return ResponseEntity.status(404).body("Ingredient n'existe plus");
        }
        ingredientsRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
