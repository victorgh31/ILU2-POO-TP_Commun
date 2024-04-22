package model;

public class ReservationHotel extends Reservation {
	private int nbLitSimples;
	private int nbLitDoubles;
	
	public ReservationHotel(int jour, int mois, int nbLitSimples, int nbLitDoubles) {
		super(jour, mois);
		this.nbLitSimples = nbLitSimples;
		this.nbLitDoubles = nbLitDoubles;
	}
	
}
