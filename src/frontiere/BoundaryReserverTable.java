package frontiere;

import java.util.Scanner;

import control.ControlReserverTable;

public class BoundaryReserverTable {
	private ControlReserverTable control;
	
	public BoundaryReserverTable(ControlReserverTable control) {
		this.control = control;
	}
	
	public void reserverTable(int numClient) {
		System.out.println("Quand souhaitez-vous réserver ?\n");
		System.out.println("Pour quel mois ?\n");
		
		Scanner clavier = new Scanner(System.in); 
		
		int mois = clavier.nextInt();
		System.out.println("Pour quel jour ?\n");
		int jour = clavier.nextInt();
		System.out.println("Pour combien de personnes ?\n");
		int nombrePersonnes = clavier.nextInt();
		System.out.println("Pour quel service ?\n");
		int numService = clavier.nextInt();
		int[] possibilites = control.trouverPossibilite(jour, mois, nombrePersonnes, numService);
		
		for (int i = 1 ; i < possibilites.length ; i++) {
			System.out.println("numéro de table :");
			System.out.println("- " + possibilites[i]);
		}
		
		System.out.println("Choississez votre table");
		int numTable = clavier.nextInt();
		control.reserver(numClient, numTable, possibilites[0]);
	}
}	
