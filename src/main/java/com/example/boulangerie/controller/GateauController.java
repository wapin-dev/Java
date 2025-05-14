package com.example.boulangerie.controller;

import com.example.boulangerie.model.Gateaux;
import com.example.boulangerie.repository.Gateaurepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("gateaux")
public class GateauController {

    @Autowired
    private Gateaurepository gateauxRepository;

    @GetMapping
    public Iterable<Gateaux> getAllGateaux() {
        return gateauxRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Gateaux> getGateauById(@PathVariable Long id) {
        return gateauxRepository.findById(id);
    }

    @PostMapping
    public Gateaux createGateau(@RequestBody Gateaux gateau) {
        return gateauxRepository.save(gateau);
    }

    @PutMapping("/{id}")
    public Gateaux updateGateau(@PathVariable Long id, @RequestBody Gateaux gateauDetails) {
        Gateaux gateau = gateauxRepository.findById(id).orElseThrow();
        gateau.setNom(gateauDetails.getNom());
        gateau.setDescription(gateauDetails.getDescription());
        gateau.setPrix(gateauDetails.getPrix());
        gateau.setStock(gateauDetails.getStock());
        gateau.setDisponible(gateauDetails.isDisponible());
        return gateauxRepository.save(gateau);
    }

    @DeleteMapping("/{id}")
    public void deleteGateau(@PathVariable Long id) {
        gateauxRepository.deleteById(id);
    }


}
