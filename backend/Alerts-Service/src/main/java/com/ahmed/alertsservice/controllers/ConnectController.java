/*
package com.ahmed.alertsservice.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConnectController {


	    @Autowired
	    private RestTemplate restTemplate;

	    @GetMapping("/sendRequest")
	    public String sendRequest() {
	        String url = "http://localhost:8081/api/utilisateurs/utilisateurs/{id}";
	        String response = restTemplate.getForObject(url, String.class);
	        return response;
	    }
	    
	    
	    @GetMapping("/getAlerts")
	    public String getResponse(@PathVariable("id") Long userId) {
	        String url = "http://localhost:8081/api/utilisateurs/utilisateurs/" + userId;
	        try {
	            ResponseEntity<UtilisateurResponse> responseEntity = restTemplate.getForEntity(url, UserResponse.class);

	            if (responseEntity.getStatusCode().is2xxSuccessful()) {
	                UserResponse userResponse = responseEntity.getBody();
	                // Traiter la réponse ici
	                return userResponse.toString(); // Assuming UserResponse has a toString() method
	            } else {
	                // Gérer les cas d'erreur
	                return "Erreur lors de la récupération de la réponse: " + responseEntity.getStatusCodeValue();
	            }
	        } catch (RestClientResponseException e) {
	            // Handle specific exceptions based on error codes
	            return "Erreur API: " + e.getMessage();
	        } catch (Exception e) {
	            // Handle unexpected errors
	            return "Erreur interne: " + e.getMessage();
	        }
	    }
	}

*/
