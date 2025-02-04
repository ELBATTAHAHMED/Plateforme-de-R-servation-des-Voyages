package com.ahmed.alertsservice.controllers;
import com.ahmed.alertsservice.DTO.CommentairesDTO;
import com.ahmed.alertsservice.models.Commentaires;
import com.ahmed.alertsservice.services.CommentaireServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
@RestController
@RequestMapping("/comments")
public class CommentaireController {
	    @Autowired
	    private CommentaireServices commentairesService;    
	    @GetMapping("/all")
	    public ResponseEntity<List<CommentairesDTO>> getAllCommentaires() {
	        List<CommentairesDTO> allCommentaires = commentairesService.getAllCommentaires();
	        return ResponseEntity.ok(allCommentaires);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Commentaires> getCommentaireById(@PathVariable Long id) {
	        Commentaires commentaire = commentairesService.getCommentaireById(id);
	        if (commentaire == null) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<>(commentaire, HttpStatus.OK);
	    }
	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<Void> deleteCommentaire(@PathVariable Long id) {
	        commentairesService.deleteCommentaire(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	        
	    @PutMapping("/update/{id}") // Use PUT for updates
	    public ResponseEntity<Commentaires> updateCommentaire(@PathVariable Long id, @RequestBody Commentaires updateCommentaire) {
	        updateCommentaire.setId_comment(id); // Ensure ID from path matches the object
	        Commentaires updatedCommentaire = commentairesService.updateCommentaire(updateCommentaire);
	        return new ResponseEntity<>(updatedCommentaire, HttpStatus.OK);
	    }
	    
	    @PostMapping("/create")
	    public ResponseEntity<Commentaires> creerCommentaire(@RequestBody Commentaires commentaire) {
	        Commentaires nouveauCommentaire = commentairesService.creerCommentaire(commentaire);
	        return new ResponseEntity<>(nouveauCommentaire, HttpStatus.CREATED);
	    }

	

	
	}




