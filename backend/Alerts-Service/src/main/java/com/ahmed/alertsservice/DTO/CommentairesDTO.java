package com.ahmed.alertsservice.DTO;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class CommentairesDTO {



	private Long id_comment;

	private String contenu;

	private LocalDateTime dateHeureComment;
	
	

	public CommentairesDTO() {}


	public CommentairesDTO(Long id_comment, String contenu, LocalDateTime dateHeureComment) {
		super();
		this.id_comment = id_comment;
		this.contenu = contenu;
		this.dateHeureComment = dateHeureComment;
	}
	public Long getId_comment() {
		return id_comment;
	}
	public void setId_comment(Long id_comment) {
		this.id_comment = id_comment;
	}
	public String getContenuComment() {
		return contenu;
	}
	public void setContenuComment(String contenuComment) {
		this.contenu = contenuComment;
	}
	public LocalDateTime getDateHeureComment() {
		return dateHeureComment;
	}
	public void setDateHeureComment(LocalDateTime dateHeureComment) {
		this.dateHeureComment = dateHeureComment;
	}

	@Override
	  public String toString() {
	    return "Activitee [id_Commentaire=" +id_comment + ", contenu_Commentaire=" + contenu
	        + ", Date_Commenatire=" + dateHeureComment  +  "]" ;
	  }

	
}
