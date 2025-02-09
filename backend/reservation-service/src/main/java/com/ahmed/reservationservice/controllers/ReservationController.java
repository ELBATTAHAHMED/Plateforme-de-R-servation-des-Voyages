package com.ahmed.reservationservice.controllers;

import java.util.List;
import com.ahmed.reservationservice.feigh.UtilisateurFeign;
import com.ahmed.reservationservice.feigh.UtilisateursFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ahmed.reservationservice.DTO.ResponseDto;
import com.ahmed.reservationservice.models.Reservations;
import com.ahmed.reservationservice.services.ReservationServices;
import com.ahmed.reservationservice.models.ResourceNotFoundException;

@RestController
@RequestMapping("/reservations")
@CrossOrigin(origins = "http://localhost:63342")
public class ReservationController {

	private final ReservationServices reservationServices;
	private final UtilisateurFeign utilisateurFeign;

	@Autowired
	public ReservationController(ReservationServices reservationServices, UtilisateurFeign utilisateurFeign) {
		this.reservationServices = reservationServices;
		this.utilisateurFeign = utilisateurFeign;
	}

	@GetMapping("/utilisateurs/id/{id}")
	public ResponseEntity<UtilisateursFeign> getUtilisateurById(@PathVariable("id") Long id) {
		System.out.println("➡ Appel Feign pour récupérer l'utilisateur avec ID : " + id);
		UtilisateursFeign utilisateur = utilisateurFeign.getUtilisateurById(id);
		System.out.println("✅ Utilisateur récupéré : " + utilisateur);
		return ResponseEntity.ok(utilisateur);
	}

	// Get all reservations
	@GetMapping("/all")
	public ResponseEntity<List<Reservations>> getAllReservations() {
		return ResponseEntity.ok(reservationServices.getAllReservations());
	}

	@PostMapping("/create/{idu}")
	public ResponseEntity<Reservations> createReservation(@PathVariable Long idu, @RequestBody Reservations reservation) {
		try {
			System.out.println("➡ Création de réservation pour l'utilisateur ID : " + idu);

			// Vérifier si l'utilisateur existe via Feign
			UtilisateursFeign utilisateur = utilisateurFeign.getUtilisateurById(idu);
			if (utilisateur == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			}

			// Assigner l'ID utilisateur à la réservation
			reservation.setIdu(idu);

			// Vérification des données reçues
			System.out.println("Données de réservation reçues : " + reservation);

			// Calculer le prix total avant de sauvegarder
			reservation.calculateTotalPrice();
			Reservations savedReservation = reservationServices.createReservation(reservation);

			System.out.println("✅ Réservation créée avec succès !");
			return ResponseEntity.ok(savedReservation);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().build();
		}
	}


	@PutMapping("/update/{id}")
	public ResponseEntity<Reservations> updateReservation(@PathVariable Long id, @RequestBody Reservations reservation)
			throws ResourceNotFoundException {
		return ResponseEntity.ok(reservationServices.updateReservation(id, reservation));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
		reservationServices.deleteReservation(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponseDto> getReservation(@PathVariable("id") Long idr) throws ResourceNotFoundException {
		ResponseDto responseDto = reservationServices.getReservation(idr);
		return ResponseEntity.ok(responseDto);
	}
}
