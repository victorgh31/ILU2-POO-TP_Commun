package model;

public abstract class EntiteReservable <T extends Formulaire> {
	private CalendrierAnnuel calendrier;
	private int numIdentification;
	
	public EntiteReservable() {
		this.calendrier = new CalendrierAnnuel();
	}
	
	public CalendrierAnnuel getCalendrier() {
		return calendrier;
	}
	
	public int getNumIdentification() {
		return numIdentification;
	}
	
	public void setNumIdentification(int numIdentification) {
		this.numIdentification = numIdentification;
	}
	
	public boolean estLibre(T formulaire) {
		return calendrier.estLibre(formulaire.getJour(),formulaire.getMois());
	}
	
	public abstract Reservation reserver(T formulaire);
	
	public abstract boolean compatible(T formulaire);
}
