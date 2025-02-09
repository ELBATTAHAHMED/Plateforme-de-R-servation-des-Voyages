package com.ahmed.alertsservice.DTO;

import lombok.*;

import java.sql.Date;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDTO {

    private Long id_reservation;
    private Date dateReservation;
    private Long dureeReservation;
    private Double prixTotalReservation;
    private String statutReservation;
    private Long id_utilisateur; // Identifiant de l'utilisateur associé à la réservation.
}
