package com.ahmed.alertsservice.DTO;

import java.sql.Date;

public class ReservationDTO {

    private Long id_reservation;
    private Date dateReservation;
    private Long dureeReservation;
    private Double prixTotalReservation;
    private String statutReservation;
    private Long id_utilisateur; // Identifiant de l'utilisateur associé à la réservation.

    // Constructeur par défaut
    public ReservationDTO() {
    }

    // Constructeur avec tous les champs
    public ReservationDTO(Long id_reservation, Date dateReservation, Long dureeReservation, Double prixTotalReservation, String statutReservation, Long id_utilisateur) {
        this.id_reservation = id_reservation;
        this.dateReservation = dateReservation;
        this.dureeReservation = dureeReservation;
        this.prixTotalReservation = prixTotalReservation;
        this.statutReservation = statutReservation;
        this.id_utilisateur = id_utilisateur;
    }

    // Getters et setters
    public Long getId_reservation() {
        return id_reservation;
    }

    public void setId_reservation(Long id_reservation) {
        this.id_reservation = id_reservation;
    }

    public Date getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(Date dateReservation) {
        this.dateReservation = dateReservation;
    }

    public Long getDureeReservation() {
        return dureeReservation;
    }

    public void setDureeReservation(Long dureeReservation) {
        this.dureeReservation = dureeReservation;
    }

    public Double getPrixTotalReservation() {
        return prixTotalReservation;
    }

    public void setPrixTotalReservation(Double prixTotalReservation) {
        this.prixTotalReservation = prixTotalReservation;
    }

    public String getStatutReservation() {
        return statutReservation;
    }

    public void setStatutReservation(String statutReservation) {
        this.statutReservation = statutReservation;
    }

    public Long getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(Long id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    @Override
    public String toString() {
        return "ReservationDTO{" +
                "id_reservation=" + id_reservation +
                ", dateReservation=" + dateReservation +
                ", dureeReservation=" + dureeReservation +
                ", prixTotalReservation=" + prixTotalReservation +
                ", statutReservation='" + statutReservation + '\'' +
                ", id_utilisateur=" + id_utilisateur +
                '}';
    }
}
