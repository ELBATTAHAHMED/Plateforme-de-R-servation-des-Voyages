package com.ahmed.reservationservice.feigh;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "USER-SERVICE")
public interface UtilisateurFeign {

    @GetMapping("/utilisateurs/id/{id}")
    UtilisateursFeign getUtilisateurById(@PathVariable("id") Long id);
}
