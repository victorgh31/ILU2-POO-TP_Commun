package model;

public class ReservationRestaurant extends Reservation {
	private int numService;
	private int numTableReservee;
	
	public ReservationRestaurant(int jour, int mois, int numService , int numTableReservee) {
		super(jour, mois);
		this.numService = numService;
		this.numTableReservee = numTableReservee;
	}
	
	@Override
	public String toString() {
		return super.toString() + "table n°"+ numTableReservee + 
				" pour le " + (numService == 1 ? "premier" : "deuxième") + " service.\n";
	}
}
