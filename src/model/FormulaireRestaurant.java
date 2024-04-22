package model;

public class FormulaireRestaurant extends Formulaire {
	private int nombrePersonnes;
	private int numService;
	
	public FormulaireRestaurant(int jour, int mois) {
		super(jour, mois);
		this.nombrePersonnes = nombrePersonnes;
		this.numService = numService;
	}
	
	public int getNombrePersonnes() {
		return nombrePersonnes;
	}
	
	public int getNumService() {
		return numService;
	}
}
