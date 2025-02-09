package com.ahmed.reservationservice.models;

import java.sql.Date;
import jakarta.persistence.*;

import lombok.*;

@Entity
@Getter
@Setter
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "RESERVATIONS")
public class Reservations {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idr", nullable = false)
	private Long idr;

	@Column(name = "date")
	private Date date;

	@Column(name = "duree")
	private Long duree;

	@ManyToOne
	@JoinColumn(name = "ida", referencedColumnName = "ida") // Foreign key referencing Activitees.id_activitee
	private Activitees activitee;

	@ManyToOne
	@JoinColumn(name = "idt", referencedColumnName = "idt") // Foreign key referencing Transports.id_transport
	private Transports transport;

	@ManyToOne
	@JoinColumn(name = "id_hebergement", referencedColumnName = "id_hebergement") // Foreign key referencing Hebergements.id_hebergement
	private Hebergements hebergement;

	@Column(name = "prixtot")
	private Double prixtot;

	@Column(name = "nombrepersonne")
	private Double nombrepersonne;

	@Column(name = "idu")
	private Long idu;

	public Double calculateTotalPrice() {
		// Vérification de la présence des objets nécessaires et si le prix a déjà été calculé
		if (activitee == null || transport == null || hebergement == null || prixtot != null) {
			return prixtot; // Retourne le prix total si déjà calculé ou s'il manque des données nécessaires
		}

		double totalPrice = 0.0;

		// Calcul du coût de l'activité en fonction de la durée et du prix de l'activité
		totalPrice += activitee.getPrix_activitee() * duree;

		// Calcul du coût du transport (en supposant que le prix est par personne)
		totalPrice += transport.getPrix_transport() * nombrepersonne;

		// Calcul du coût de l'hébergement (en supposant que le prix est par nuit)
		totalPrice += hebergement.getPrix_hebergement() * duree;

		// Si vous avez des réductions ou des ajustements supplémentaires selon le nombre de personnes, vous pouvez les appliquer ici.
		// Par exemple, si le nombre de personnes est supérieur à 1, appliquer une réduction ou multiplier le coût total.
		if (nombrepersonne > 1) {
			totalPrice = totalPrice * nombrepersonne; // Ajustement en fonction du nombre de personnes, si nécessaire.
		}

		// Affectation du prix total calculé
		prixtot = totalPrice;

		return totalPrice;
	}
}
