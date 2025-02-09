package com.ahmed.alertsservice.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class responseDTO {

	
	private ReservationDTO reservation;

	private CommentairesDTO commentaire;


	public void setReservation(ReservationDTO reservationDTo) {
		// TODO Auto-generated method stub

	}

	public void setCommentaire(CommentairesDTO commentairesDto) {
		// TODO Auto-generated method stub

	}

	public void setMessage(String string) {
		// TODO Auto-generated method stub

	}
}
