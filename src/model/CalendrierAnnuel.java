package model;

public class CalendrierAnnuel {
	private Mois[] calendrier = new Mois[12];
	
	private class Mois {
		private String nom;
		private boolean[] jours;
		
		private Mois(String nom,int nbJours) {
			this.nom = nom;
			this.jours = new boolean[nbJours];
		}
		private boolean estLibre(int jour) {
			return !jours[jour-1];
		}

		private void reserver(int jour) throws IllegalStateException {
			if (!estLibre(jour))
				throw new IllegalStateException();
			else
				jours[jour-1] = true;
		}
	}

	public CalendrierAnnuel() {
		int[] tailleDesMois = {31 , 28 , 31 , 30 , 31 , 30 , 31 , 31 , 30 , 31 , 30 , 31};
		String[] nomDesMois = {"Janvier","Février","Mars","Avril","Mai","Juin","Juillet","Août","Septembre","Octobre","Novembre","Décembre"};
		
		for (int i = 0 ; i < 12 ; i++) {
			this.calendrier[i] = new Mois(nomDesMois[i],tailleDesMois[i]);
		}
	}

	public boolean estLibre(int jour , int mois) {
		return calendrier[mois-1].estLibre(jour);
	}
	
	public boolean reserver(int jour , int mois) {
		boolean libre;
		if (libre = estLibre(jour,mois)) {
			calendrier[mois-1].reserver(jour);
		}
		return libre;
		
	}
	
}