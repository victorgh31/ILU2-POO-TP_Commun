package dialog;

import java.awt.EventQueue;

import javax.swing.AbstractListModel;

import com.github.lgooddatepicker.zinternaltools.DateChangeEvent;

import control.ControlReserverTable;
import control.ControlVisualiserCarnetClientele;
import presentation.JFrameReservation;

public class DialogueReservation {
	
	private String date;
	private String time;
	private String numPersons;
	private ControlReserverTable controlReserverTable;
	private ControlVisualiserCarnetClientele contrClientele;
	private int numTable;

	private int numClient;
	private int numService;
	private int nombrePersonnes;
	private int jour;
	private int mois;
	private int[] proposition;
	
	private JFrameReservation presentationReservation;
	
	public DialogueReservation(ControlReserverTable controlReserverTable,ControlVisualiserCarnetClientele controlClientele) {
		this.controlReserverTable = controlReserverTable;
		this.contrClientele = controlClientele;

	}
	
	public void handleUserConnected(int numClient) {
		this.nombrePersonnes = Integer.parseInt(numPersons);
		proposition = controlReserverTable.trouverPossibilite(jour, mois, nombrePersonnes, numService);
		presentationReservation.initTableMap(proposition);
		presentationReservation.enableTableMap();
	}
	
	public void initDialog() {
		//Create presentation frame
		presentationReservation = new JFrameReservation();
		//Associate dialogue to presentation
		presentationReservation.setDialogue(this);
		//Initialize and enable presentation frame
		presentationReservation.initPresentation();
		presentationReservation.setVisible(true);
		
	}
		
	
	public void handleDateSelectedEvent(String date) {
		this.date = date;
		presentationReservation.enableTime();
	}
	
	public void handleTimeSelectedEvent(String time) {
		this.time = time;
		presentationReservation.enableNumofPersons();
	}
	
	public void handleNumofPersonsSelectedEvent(String numPersons) {
		this.numPersons = numPersons;
		presentationReservation.enableTableMap();
	}
	
	public void handleTableSelectedEvent(String table) {
		this.numTable = table.charAt(6) - '0';
		presentationReservation.enableBoutonValider();
	}
	
	
	public void handleCancelEvent() {
		presentationReservation.initPresentation();
	}
	
	public void handleValidateEvent() {
		//Display confirmation window using JOptionPane
		presentationReservation.enableValidationInformation(date, time, numPersons,numTable);
	}
	
	public void handleOkEvent() {
		presentationReservation.initPresentation();
	}
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		//Create dialogReservation
		DialogueReservation dialogReservation = new DialogueReservation();
				
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dialogReservation.initDialog();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
}