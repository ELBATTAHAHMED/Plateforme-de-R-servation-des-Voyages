package com.ahmed.reservationservice.config;

import com.ahmed.reservationservice.models.Activitees;
import com.ahmed.reservationservice.models.Hebergements;
import com.ahmed.reservationservice.models.Paiements;
import com.ahmed.reservationservice.models.Reservations;
import com.ahmed.reservationservice.models.Transports;
import com.ahmed.reservationservice.repositories.ActiviteesRepository;
import com.ahmed.reservationservice.repositories.HebergementsRepository;
import com.ahmed.reservationservice.repositories.PaiementsRepository;
import com.ahmed.reservationservice.repositories.ReservationRepository;
import com.ahmed.reservationservice.repositories.TransportsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Date;
import java.util.List;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(ActiviteesRepository activiteesRepo,
                                   HebergementsRepository hebergementsRepo,
                                   TransportsRepository transportsRepo,
                                   ReservationRepository reservationsRepo,
                                   PaiementsRepository paiementsRepo) {
        return args -> {
            if (activiteesRepo.count() == 0) {
                activiteesRepo.saveAll(List.of(
                        new Activitees(null, 150.0, "Marrakech", "Excursion dans les montagnes", "2 heures", "Voyage Maroc", "Maroc", Date.valueOf("2025-05-01"), "0667894561", "url_photo"),
                        new Activitees(null, 200.0, "Fès", "Visite culturelle", "3 heures", "Explore Maroc", "Maroc", Date.valueOf("2025-06-15"), "0671234567", "url_photo")
                ));
            }

            if (hebergementsRepo.count() == 0) {
                hebergementsRepo.saveAll(List.of(
                        new Hebergements(null, "Hotel Atlas", "Hôtel", "Rue Atlas, Marrakech", "Hôtel 4 étoiles", 80.0f, 2, "Voyage Maroc", 0601234567L, "Marrakech", "Maroc", List.of("photo1.jpg", "photo2.jpg")),
                        new Hebergements(null, "Riad Fès", "Riad", "Rue des Écoles, Fès", "Riad traditionnel", 120.0f, 4, "Explore Maroc", 0603334567L, "Fès", "Maroc", List.of("photo3.jpg", "photo4.jpg"))
                ));
            }

            if (transportsRepo.count() == 0) {
                transportsRepo.saveAll(List.of(
                       new Transports(null, "Avion", "Vol direct", "Royal Air Maroc", "Casablanca", "Marrakech", "Aéroport", "Boeing 737", 800, "RAM", "0644444444", "Maroc", "Casablanca", "Maroc", "Marrakech", List.of("avion.jpg")),
                       new Transports(null, "Train", "TGV", "ONCF", "Casablanca", "Marrakech", "Gare", "Al Boraq", 200, "ONCF", "0655555555", "Maroc", "Casablanca", "Maroc", "Marrakech", List.of("train.jpg"))
                ));
            }

            if (reservationsRepo.count() == 0) {
                reservationsRepo.saveAll(List.of(
                        new Reservations(null, Date.valueOf("2025-05-01"), 2L, activiteesRepo.findById(1L).orElse(null), transportsRepo.findById(1L).orElse(null), hebergementsRepo.findById(1L).orElse(null), 300.0, 2.0, 1L),
                        new Reservations(null, Date.valueOf("2025-06-15"), 3L, activiteesRepo.findById(2L).orElse(null), transportsRepo.findById(2L).orElse(null), hebergementsRepo.findById(2L).orElse(null), 480.0, 4.0, 2L)
                ));
            }

            if (paiementsRepo.count() == 0) {
                paiementsRepo.saveAll(List.of(
                        new Paiements(null, 1L, reservationsRepo.findById(1L).orElse(null), "credit card", "1234567812345678", Date.valueOf("2025-05-01"), 123L),
                        new Paiements(null, 2L, reservationsRepo.findById(2L).orElse(null), "PayPal", "pending", Date.valueOf("2025-06-15"), 456L)
                ));
            }
        };
    }
}
