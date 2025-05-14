package com.example.boulangerie.repository;

import com.example.boulangerie.model.Gateaux;
import org.springframework.data.repository.CrudRepository;

public interface Gateaurepository extends CrudRepository<Gateaux, Long> {
    Gateaux findByNom(String nom);
    Gateaux findByDisponible(boolean disponible);
}
