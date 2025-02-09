package com.ahmed.alertsservice.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ahmed.alertsservice.models.Alerts;
import com.ahmed.alertsservice.repositories.AlertsRepository;
import com.ahmed.alertsservice.services.AlertsServices;

@Service
public class AlertsServicesImpl implements AlertsServices {

	    @Autowired
	    private AlertsRepository alertsRepository;

	    @Override
	    public Alerts saveAlert(Alerts alert) {
	        return alertsRepository.save(alert);
	    }

	    @Override
	    public List<Alerts> getAllAlerts() {
	        return alertsRepository.findAll();
	    }

	    @Override
	    public Alerts getAlertById(Long id) {
	        return alertsRepository.findById(id).orElse(null);
	    }

	    @Override
	    public void deleteAlert(Long id) {
	        alertsRepository.deleteById(id);
	    }
	}


