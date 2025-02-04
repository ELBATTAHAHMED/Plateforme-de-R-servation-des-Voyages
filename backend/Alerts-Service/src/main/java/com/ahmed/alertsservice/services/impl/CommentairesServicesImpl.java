package com.ahmed.alertsservice.services.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.ahmed.alertsservice.DTO.CommentairesDTO;
import com.ahmed.alertsservice.DTO.ReservationDTO;
import com.ahmed.alertsservice.DTO.responseDTO;
import com.ahmed.alertsservice.models.Commentaires;
import com.ahmed.alertsservice.repositories.CommentaireRepository;
import com.ahmed.alertsservice.services.CommentaireServices;


import jakarta.transaction.Transactional;
@Transactional
@Component 
@Service
public class CommentairesServicesImpl implements CommentaireServices {

	    @Autowired
	    private CommentaireRepository commentaireRepository;

	    @Autowired
		private RestTemplate restTemplate;
	    
	    @Override
		public responseDTO getCommentaire(Long id_comment) {

	    	responseDTO responseDto = new responseDTO();

	    	Commentaires commentaires = commentaireRepository.findById(id_comment).orElse(null);
		    if (commentaires == null) {
		        // Gérer le cas où la réservation n'est pas trouvée
		        responseDto.setMessage("Le commentaire avec l'ID " + id_comment + " n'existe pas.");
		        return responseDto;
		    }
		    CommentairesDTO CommentairesDto = mapToCommentaire(commentaires);
            String reservationUrl = "http://localhost:8090/reservations" + commentaires.getId_comment();
		    ResponseEntity<ReservationDTO> responseEntity = restTemplate.getForEntity(reservationUrl, ReservationDTO.class);	    
		    if (responseEntity.getStatusCode().is2xxSuccessful()) {	        
		    	ReservationDTO ReservationDTo = responseEntity.getBody();	        
		        // Configuration des DTO dans la réponse
		        responseDto.setReservation(ReservationDTo);
		        responseDto.setCommentaire(CommentairesDto);
		    } else {
		        // Gérer le cas où la requête n'a pas réussi
		        responseDto.setMessage("Impossible de récupérer les informations de la reservation.");
		    }
		    return responseDto;
		}    
	    private CommentairesDTO mapToCommentaire(Commentaires commentaires){
	    	CommentairesDTO reservationDto = new CommentairesDTO();
			reservationDto.setId_comment(commentaires.getId_comment());
			reservationDto.setContenuComment(commentaires.getContenu());
			reservationDto.setDateHeureComment(commentaires.getDateHeureComment());
	        return reservationDto;
	    }
		
		
	    @Override
	    public List<CommentairesDTO> getAllCommentaires() {
	        return commentaireRepository.findAll().stream()
	                .map(this::convertToDTO)
	                .collect(Collectors.toList());
	    }

	    
	    private CommentairesDTO convertToDTO(Commentaires commentaire) {
	        return new CommentairesDTO(
	            commentaire.getId_comment(),
	            commentaire.getContenu(),
	            commentaire.getDateHeureComment()
	        );
	    }

	    @Override
	    public Commentaires getCommentaireById(Long id) {
	        return commentaireRepository.findById(id).orElse(null);
	    }

	    @Override
	    public void deleteCommentaire(Long id) {
	        commentaireRepository.deleteById(id);
	    }
	    
	    
	    @Override
	    public Commentaires updateCommentaire(Commentaires commentaire) {
	        // Fetch the existing comment by ID (assuming the ID is present)
	        Commentaires existingCommentaire = commentaireRepository.findById(commentaire.getId_comment()).orElse(null);
	        if (existingCommentaire == null) {
	            // Comment not found, potentially return an error
	            throw new RuntimeException("Comment with ID " + commentaire.getId_comment() + " not found.");
	        }
	        // Update relevant fields (consider using a copy method or selective updates)
	        existingCommentaire.setContenu(commentaire.getContenu());
	        existingCommentaire.setDateHeureComment(commentaire.getDateHeureComment()); // Update date/time if needed
	        existingCommentaire.setContenu(commentaire.getContenu()); // Update date/time if needed
	        existingCommentaire.setUsername(commentaire.getUsername()); // Update date/time if needed
	        existingCommentaire.setEmail(commentaire.getEmail()); // Update date/time if needed


	        return commentaireRepository.save(existingCommentaire);
	    }

	    @Override
	    public Commentaires creerCommentaire(Commentaires commentaire) {
	        return commentaireRepository.save(commentaire);
	    }




	}


