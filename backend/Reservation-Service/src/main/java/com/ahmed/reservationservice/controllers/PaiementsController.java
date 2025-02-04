package com.ahmed.reservationservice.controllers;

import com.ahmed.reservationservice.models.Paiements;
import com.ahmed.reservationservice.models.ResourceNotFoundException;
import com.ahmed.reservationservice.services.PaiementsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paiements")
@CrossOrigin(origins = "http://localhost:63342")
public class PaiementsController {

    private final PaiementsServices paiementsServices;

    @Autowired
	public PaiementsController(PaiementsServices paiementsServices) {
	    this.paiementsServices = paiementsServices;
	}

	@GetMapping("/all")
    public ResponseEntity<List<Paiements>> getAllPaiements() {
        List<Paiements> paiementsList = paiementsServices.getAllPaiements();
        return ResponseEntity.ok(paiementsList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paiements> getPaymentById(@PathVariable("id") Long id) {
        try {
            Paiements paiement = paiementsServices.getPaymentById(id);
            return ResponseEntity.ok(paiement);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Paiements> createPaiement(@RequestBody Paiements paiement) {
        Paiements createdPaiement = paiementsServices.createPaiement(paiement);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPaiement);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Paiements> updatePaiement(@PathVariable("id") Long id, @RequestBody Paiements paiement) {
        try {
            Paiements updatedPaiement = paiementsServices.updatePaiement(id, paiement);
            return ResponseEntity.ok(updatedPaiement);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePaiement(@PathVariable("id") Long id) {
        paiementsServices.deletePaiement(id);
        return ResponseEntity.noContent().build();
    }
}