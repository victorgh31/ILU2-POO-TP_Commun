package model;

public class Formulaire {
	private int jour;
	private int mois;
	private int numEntiteReservee;
	
	public Formulaire(int jour, int mois) {
		this.jour = jour;
		this.mois = mois;
	}
	
	public int getIdentificationEntite() {
		return numEntiteReservee;
	}
	
	public void setIdentificationEntite(int numEntiteReservee) {
		this.numEntiteReservee = numEntiteReservee;
	}
	
	public int getJour() {
		return jour;
	}
	
	public int getMois() {
		return mois;
	}
}
