package model;

public class CentraleReservation <E extends EntiteReservable <F>, F extends Formulaire> {
	private int nombreEntite = 0;
	private EntiteReservable [] entites;
	
	public CentraleReservation(EntiteReservable <F> [] entites) {
		this.entites = entites;
	}
	
	public int ajouterEntite(EntiteReservable <F> entite) {
		this.entites[nombreEntite++] = entite;
		return nombreEntite;
	}
	
	public int[] donnerPossibilites(F formulaire) {
		int [] tab = new int[nombreEntite];
		for (int i = 0 ; i < nombreEntite ; i++) {
			if(entites[i].compatible(formulaire))
				tab[i] = entites[i].getNumIdentification();
			else
				tab[i] = 0;
		}
		return tab;
	}
	
	public Reservation reserver(int numEntiteAReserver , Formulaire formulaire) {
		formulaire.setIdentificationEntite(numEntiteAReserver);
		return entites[numEntiteAReserver-1].reserver(formulaire);
	}
	
}
