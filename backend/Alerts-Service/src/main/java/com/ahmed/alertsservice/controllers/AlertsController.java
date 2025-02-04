package com.ahmed.alertsservice.controllers;
import com.ahmed.alertsservice.models.Alerts;
import com.ahmed.alertsservice.models.ResourceNotFoundException;
import com.ahmed.alertsservice.repositories.AlertsRepository;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ahmed.alertsservice.services.AlertsServices;

@RestController
@RequestMapping("/alerts")
public class AlertsController {

	    @Autowired
	    private AlertsServices alertsService;

	    @PostMapping("/create")
	    public ResponseEntity<Alerts> createAlert(@RequestBody Alerts alert) {
	        Alerts savedAlert = alertsService.saveAlert(alert);
	        return new ResponseEntity<>(savedAlert, HttpStatus.CREATED);
	    }

	    @GetMapping("/all")
	    public ResponseEntity<List<Alerts>> getAllAlerts() {
	        List<Alerts> alerts = alertsService.getAllAlerts();
	        return new ResponseEntity<>(alerts, HttpStatus.OK);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Alerts> getAlertById(@PathVariable Long id) throws ResourceNotFoundException {
	        Alerts alert = alertsService.getAlertById(id);
	        if (alert == null) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<>(alert, HttpStatus.OK);
	    }

	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<Void> deleteAlert(@PathVariable Long id) {
	        alertsService.deleteAlert(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	}


	
	
	
	
	
	
	
    /*private final AlertsRepository alertsRepo;

    @Autowired
    public AlertsController(AlertsRepository alertsRepo) {
        this.alertsRepo = alertsRepo;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Alerts>> getAllAlerts() {
        List<Alerts> alerts = alertsRepo.findAll();
        return ResponseEntity.ok(alerts);
    }
    
    



    @GetMapping("/{id}")
    public ResponseEntity<Alerts> getAlertById(@PathVariable Long id) {
        Alerts alert = alertsRepo.findById(id).orElse(null);
        if (alert != null) {
            return ResponseEntity.ok(alert);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Alerts> createAlert(@RequestBody Alerts alert) {
        Alerts createdAlert = alertsRepo.save(alert);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAlert);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlert(@PathVariable Long id) {
        alertsRepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/updateAlerts/{id}")
    public ResponseEntity<Alerts> updateAlert(@PathVariable Long id, @RequestBody Alerts alertRequest) {
        Alerts existingAlert = alertsRepo.findById(id).orElse(null);
        if (existingAlert != null) {
            existingAlert.setTitreAlert(alertRequest.getTitreAlert());
            existingAlert.setContenuAlert(alertRequest.getContenuAlert());
            existingAlert.setDateHeure(alertRequest.getDateHeure());
            Alerts updatedAlert = alertsRepo.save(existingAlert);
            return ResponseEntity.ok(updatedAlert);
        } else {
            return ResponseEntity.notFound().build();
        }
    }*/

