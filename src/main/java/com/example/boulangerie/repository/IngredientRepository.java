package com.example.boulangerie.repository;

import com.example.boulangerie.model.Ingredients;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredients, Long> {
    Ingredients findByNom(String nom);
    Ingredients findByQuantite(double quantite);
    Ingredients findByUnite(String unite);
    Ingredients findByPrix(double prix);
}
