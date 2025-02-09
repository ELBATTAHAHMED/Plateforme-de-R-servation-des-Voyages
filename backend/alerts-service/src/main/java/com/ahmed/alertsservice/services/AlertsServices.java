package com.ahmed.alertsservice.services;

import java.util.List;
import com.ahmed.alertsservice.models.Alerts;

public interface AlertsServices {

	    Alerts saveAlert(Alerts alert);

	    List<Alerts> getAllAlerts();

	    Alerts getAlertById(Long id);

	    void deleteAlert(Long id);
	}


