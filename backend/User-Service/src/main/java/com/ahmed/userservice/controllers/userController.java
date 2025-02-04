package com.ahmed.userservice.controllers;
import java.util.List;
import java.util.Optional;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ahmed.userservice.models.Utilisateurs;

import com.ahmed.userservice.services.UtilisateurServices;

@RestController
@RequestMapping("/utilisateurs")
public class userController {


	    private final UtilisateurServices utilisateurServices;

	    public userController(UtilisateurServices utilisateurServices) {
	        this.utilisateurServices = utilisateurServices;
	    }


	    // Get all users
	    @GetMapping("/all")
	    public ResponseEntity<List<Utilisateurs>> getAllUtilisateurs() {
	        return utilisateurServices.getAllUtilisateurs();
	    }

	    // Create a new user
	    @PostMapping("/create")
	    public ResponseEntity<Utilisateurs> createUtilisateur(@RequestBody Utilisateurs utilisateur) {
	        Utilisateurs createdUtilisateur = utilisateurServices.createUtilisateur(utilisateur);
	        return new ResponseEntity<>(createdUtilisateur, HttpStatus.CREATED);
	    }

	    // Update user information
	    @PutMapping("/update/{id}")
	    public ResponseEntity<Utilisateurs> updateUtilisateur(@PathVariable Long id, @RequestBody Utilisateurs utilisateur) {
	        return utilisateurServices.updateUtilisateur(id, utilisateur);
	    }

	    // Delete a user
	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<Void> deleteUtilisateur(@PathVariable Long id) {
	        return utilisateurServices.deleteUtilisateur(id);
	    
	}

	@PostMapping("/search")
	public ResponseEntity<Utilisateurs> getUtilisateurByUsernameAndPassword(@RequestParam String username, @RequestParam String password) {
		Optional<Utilisateurs> utilisateur = utilisateurServices.findUtilisateurByUsernameAndPassword(username, password);
		if (utilisateur.isPresent()) {
			Utilisateurs foundUtilisateur = utilisateur.get();
			// Remarque : Utiliser foundUtilisateur.getIdu() au lieu de foundUtilisateur.getId() car tu utilises 'idu' dans la classe Utilisateurs
			return ResponseEntity.ok(foundUtilisateur); // Renvoie l'utilisateur complet avec l'id
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null); // Code 401 si non trouvé
		}
	}



	@GetMapping("/id/{id}")
	    public Utilisateurs getUserById(@PathVariable("id") Long id) {
	        return utilisateurServices.getUserById(id);
	    }
	    
	    @PostMapping("/{username}")
	    public ResponseEntity<Optional<Utilisateurs>> getUserByUsername(@PathVariable String username) throws NotFoundException {
	      Optional<Utilisateurs> utilisateur = utilisateurServices.rechercherParUsername(username);
	      return ResponseEntity.ok(utilisateur);
	    }
    
}
		
