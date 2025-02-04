package com.ahmed.alertsservice.models;
import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "alerts")
public class Alerts {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_alerts")
	private Long id_alert;
	@Column(name = "titre" )
	private String titreAlert;
	@Column(name = "contenu" )
	private String contenuAlert;
	@Column(name = "date_alerts")
	private LocalDateTime dateHeure;


}
