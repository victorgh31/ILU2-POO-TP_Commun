package model;

public class Restaurant implements IEtablissement <FormulaireRestaurant> {
	private static final int NB_MAX_TABLES = 30;
	private CentraleReservation <Table, FormulaireRestaurant> centrale = new CentraleReservation<>(new Table[NB_MAX_TABLES]);
	
	public Restaurant() {
	}
	
	public static class Table extends EntiteReservable <FormulaireRestaurant> {
		private CalendrierAnnuel calendrierDeuxiemeService;
		private int nombreChaises;
		
		public Table(int nombreChaises) {
			this.calendrierDeuxiemeService = new CalendrierAnnuel();
			this.nombreChaises = nombreChaises;
		}
		
		@Override
		public boolean compatible(FormulaireRestaurant formulaire) {
			return (formulaire.getNombrePersonnes() <= nombreChaises
				&& (formulaire.getNumService() == 1 ? getCalendrier().estLibre(formulaire.getJour(),formulaire.getMois())
				: calendrierDeuxiemeService.estLibre(formulaire.getJour(), formulaire.getMois())));
//			return (formulaire.getNombrePersonnes() == nombreChaises
//					|| formulaire.getNombrePersonnes() == (nombreChaises - 1)
//					&& (formulaire.getNumService() == 1 ? getCalendrier().estLibre(formulaire.getJour(),formulaire.getMois())
//					: calendrierDeuxiemeService.estLibre(formulaire.getJour(), formulaire.getMois())));
		}
		
		@Override
		public ReservationRestaurant reserver(FormulaireRestaurant formulaire) {
			boolean reservationAboutie = false;
			
			if (compatible(formulaire)) {
				if (formulaire.getNumService() == 1)
					reservationAboutie = getCalendrier().reserver(formulaire.getJour(), formulaire.getMois());
				else
					reservationAboutie = calendrierDeuxiemeService.reserver(formulaire.getJour(), formulaire.getMois());
			}
			
			if (reservationAboutie)
				return new ReservationRestaurant(formulaire.getJour(), formulaire.getMois(), formulaire.getNumService(), formulaire.getIdentificationEntite());
			else 
				return null;		
		}
	}
	
	public void ajouterTable(int nbChaise) {
		Table table = new Table(nbChaise);
		table.setNumIdentification(centrale.ajouterEntite(table));
	}
	
	@Override
	public  Reservation reserver(int numEntite,FormulaireRestaurant formulaire) {
		return centrale.reserver(numEntite, formulaire);
	}
	
	@Override
	public int[] donnerPossibilites(FormulaireRestaurant formulaire) {
		return centrale.donnerPossibilites(formulaire);
	}
}
