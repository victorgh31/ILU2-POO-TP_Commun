package control;

import model.CarnetClientele;
import model.Client;
import model.FormulaireRestaurant;
import model.Reservation;
import model.ReservationRestaurant;
import model.Restaurant;

public class ControlReserverTable {
	private static final int NB_MAX_RESTO = 10;
	private Restaurant restaurant;
	private FormulaireRestaurant[] formulaires = new FormulaireRestaurant[NB_MAX_RESTO];
	private CarnetClientele carnet;
	
	public ControlReserverTable(Restaurant  restaurant, CarnetClientele carnet) {
		this.restaurant = restaurant;
		this.carnet = carnet;
	}
	
	public int[] trouverPossibilite(int jour, int mois, int nombrePersonnes, int numService) {
		FormulaireRestaurant formulaire = new FormulaireRestaurant(jour, mois, nombrePersonnes, numService); //
		boolean formulaireEnregistrer = false;
		int numeroFormulaire = -1;
		
		for (int i = 0; i < formulaires.length && !formulaireEnregistrer; i++) {
			if (formulaires[i] == null) {
				formulaires[i] = formulaire;
				formulaireEnregistrer = true;
				numeroFormulaire = i;
			}
		}
		int[] possibilites = restaurant.donnerPossibilites(formulaire); //
		
		int[] retour = new int[possibilites.length + 1];
		retour[0] = numeroFormulaire;
		
		for (int i = 1; i < possibilites.length + 1; i++)
			retour[i] = possibilites[i - 1];
		
		return retour;
	}
	
	public void reserver(int numClient, int numProposition, int numeroFormulaire) {
		FormulaireRestaurant formulaireRestaurant = formulaires[numeroFormulaire];
		formulaires[numeroFormulaire] = null;
		Reservation reservation = restaurant.reserver(numProposition, formulaireRestaurant);
		
		if (reservation instanceof ReservationRestaurant) {
			ReservationRestaurant reservationRestaurant = (ReservationRestaurant) reservation;
			Client client = carnet.getClient(numClient); //
			client.ajouterReservation(reservation); //
		}
	}
	
	
}
