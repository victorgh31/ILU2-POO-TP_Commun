package presentation;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import com.github.lgooddatepicker.components.DatePicker;

import dialog.DialogueReservation;

import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JButton;

import com.github.lgooddatepicker.optionalusertools.DateChangeListener;
import com.github.lgooddatepicker.zinternaltools.DateChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JDesktopPane;
import javax.swing.border.MatteBorder;
import javax.swing.SwingConstants;


public class JFrameReservation extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelDateTime;
	private JLabel lblChooseDate;
	private JLabel lblChooseTime;
	private JPanel panelNumofPersons;
	private JLabel lblNumofPersons;
	private DatePicker datePicker;
	private JPanel panelTable;
	private JLabel lblTableMap;
	private JButton btnValidate;
	private JPanel panelConfirmCancel;
	private DialogueReservation dialogueReservation;
	private JComboBox comboBoxNumOfPersons;
	private JComboBox comboBoxChooseHour;
	private JList<String> listOfTables;
	private JLabel lblRservationConfirmeLe;
	private JButton btnOkFinal;
	private JButton btnAnnuler;
	private JOptionPane paneConfirmer;

	/**
	 * Create the frame.
	 */
	public JFrameReservation() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFrameReservation.class.getResource("/resources/Plan_tables.JPG")));
		setTitle("R\u00E9servez une table");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 501, 736);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		panelDateTime = new JPanel();
		panelDateTime.setBounds(5, 5, 459, 137);
		
		panelNumofPersons = new JPanel();
		panelNumofPersons.setBounds(5, 160, 459, 112);
		
		panelTable = new JPanel();
		panelTable.setBounds(5, 290, 459, 313);
		
		panelConfirmCancel = new JPanel();
		panelConfirmCancel.setBounds(5, 621, 459, 61);
		
		lblTableMap = new JLabel("");
		lblTableMap.setBounds(12, 57, 304, 251);
		lblTableMap.setIcon(new ImageIcon(JFrameReservation.class.getResource("/resources/Plan_tables.JPG")));
		
		paneConfirmer = new JOptionPane();

		DefaultListModel<String> listOfTablesItems = new DefaultListModel<>();
        listOfTablesItems.addElement("Table 1");
        listOfTablesItems.addElement("Table 2");
        listOfTablesItems.addElement("Table 3");
        listOfTablesItems.addElement("Table 4");
        listOfTablesItems.addElement("Table 5");
        listOfTablesItems.addElement("Table 6");

        listOfTables = new JList<>(listOfTablesItems);
        listOfTables.setBounds(328, 66, 118, 231);
        listOfTables.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		do_listOfTablesSelectTable_listOfTablesChanged(e);
        	}
        });

        listOfTables.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> listOfTables, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Component renderer = super.getListCellRendererComponent(listOfTables, value, index, isSelected, cellHasFocus);
                if (value.equals("Table 3") || value.equals("Table 5")) {
                    renderer.setEnabled(false);
                }
                return renderer;
            }
        });
		panelTable.setLayout(null);
		panelTable.add(lblTableMap);
		panelTable.add(listOfTables);
		
		btnValidate = new JButton("Valider");
		btnValidate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnValiderSelected_ValidateChanged(e);
			}
		});
		btnValidate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnCancel_CancelIsPressed(e);
			}
		});
		btnAnnuler.setFont(new Font("Dialog", Font.PLAIN, 14));
		GroupLayout gl_panelConfirmCancel = new GroupLayout(panelConfirmCancel);
		gl_panelConfirmCancel.setHorizontalGroup(
			gl_panelConfirmCancel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelConfirmCancel.createSequentialGroup()
					.addContainerGap(234, Short.MAX_VALUE)
					.addComponent(btnValidate, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnAnnuler, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panelConfirmCancel.setVerticalGroup(
			gl_panelConfirmCancel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelConfirmCancel.createSequentialGroup()
					.addContainerGap(24, Short.MAX_VALUE)
					.addGroup(gl_panelConfirmCancel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnValidate, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAnnuler))
					.addContainerGap())
		);
		panelConfirmCancel.setLayout(gl_panelConfirmCancel);
		
		lblNumofPersons = new JLabel("2. Indiquez le nombre de personnes");
		lblNumofPersons.setBounds(12, 12, 330, 32);
		lblNumofPersons.setEnabled(false);
		lblNumofPersons.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		comboBoxNumOfPersons = new JComboBox();
		comboBoxNumOfPersons.setBounds(117, 50, 59, 24);
		comboBoxNumOfPersons.setEnabled(false);
		comboBoxNumOfPersons.addItem("2");
		comboBoxNumOfPersons.addItem("3");
		comboBoxNumOfPersons.addItem("4");
		comboBoxNumOfPersons.addItem("5");
		comboBoxNumOfPersons.addItem("6");
		comboBoxNumOfPersons.addItem("7");
		comboBoxNumOfPersons.addItem("8");
		comboBoxNumOfPersons.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_numOfPersCombo_numChanged(e);
			}
		});
		panelNumofPersons.setLayout(null);
		panelNumofPersons.add(comboBoxNumOfPersons);
		panelNumofPersons.add(lblNumofPersons);
		
		lblChooseDate = new JLabel("1. Choisissez la date");
		lblChooseDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		lblChooseTime = new JLabel("et l'heure");
		lblChooseTime.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		datePicker = new DatePicker();
		datePicker.getComponentToggleCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		datePicker.addDateChangeListener(new DateChangeListener() {
			public void dateChanged(DateChangeEvent arg0) {
				do_datePicker_dateChanged(arg0);
			}
		});
		
		comboBoxChooseHour = new JComboBox();
		comboBoxChooseHour.setEnabled(false);
		comboBoxChooseHour.addItem("12h30");
		comboBoxChooseHour.addItem("13h00");
		comboBoxChooseHour.addItem("19h30");
		comboBoxChooseHour.addItem("20h00");
		comboBoxChooseHour.addItem("20h30");
		comboBoxChooseHour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_hourPicker_hourChanged(e);
			}
		});

		GroupLayout gl_panelDateTime = new GroupLayout(panelDateTime);
		gl_panelDateTime.setHorizontalGroup(
			gl_panelDateTime.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelDateTime.createSequentialGroup()
					.addGroup(gl_panelDateTime.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelDateTime.createSequentialGroup()
							.addGap(10)
							.addComponent(lblChooseDate, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblChooseTime, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelDateTime.createSequentialGroup()
							.addGap(103)
							.addComponent(datePicker, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(comboBoxChooseHour, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)))
					.addGap(28))
		);
		gl_panelDateTime.setVerticalGroup(
			gl_panelDateTime.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelDateTime.createSequentialGroup()
					.addGap(35)
					.addGroup(gl_panelDateTime.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblChooseDate, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblChooseTime, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_panelDateTime.createParallelGroup(Alignment.BASELINE)
						.addComponent(datePicker, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBoxChooseHour, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(3))
		);
		panelDateTime.setLayout(gl_panelDateTime);
		contentPane.setLayout(null);
			
		lblRservationConfirmeLe = new JLabel();
		lblRservationConfirmeLe.setBounds(35, 71, 361, 74);
		
		btnOkFinal = new JButton("OK");
		btnOkFinal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnOk_OkIsPressed(e);
			}
		});
		btnOkFinal.setBounds(308, 157, 54, 29);
		contentPane.add(panelConfirmCancel);
		contentPane.add(panelTable);
		contentPane.add(panelNumofPersons);
		contentPane.add(panelDateTime);
		
	}
	
	public void initPresentation() {
		lblChooseDate.setEnabled(true);
		datePicker.setEnabled(true);
		lblChooseTime.setEnabled(false);
		lblNumofPersons.setEnabled(false);
		lblTableMap.setEnabled(false);
		btnValidate.setEnabled(false);
		listOfTables.setEnabled(false);
		listOfTables.setVisible(false);
		btnAnnuler.setEnabled(true);
		comboBoxChooseHour.setEnabled(false);
		comboBoxNumOfPersons.setEnabled(false);
		
		System.out.println("InitPresentation done");
	}
	
	public void enableTime() {
		lblChooseTime.setEnabled(true);
		comboBoxChooseHour.setEnabled(true);
	}
	
	public void enableNumofPersons() {
		lblNumofPersons.setEnabled(true);
		comboBoxNumOfPersons.setEnabled(true);
				
	}
	
	public void enableTableMap() {
		lblTableMap.setEnabled(true);
		listOfTables.setEnabled(true);
		listOfTables.setVisible(true);

	}
	
	public void enableBoutonValider() {
		btnValidate.setEnabled(true);
	}
	
	public void enableValidationInformation(String date, String time, String numPersons, int numTable) {
		paneConfirmer.showMessageDialog(this, "<html>Réservation confirmée le " + date + " à " + time + "<br/>" 
				+ "pour " + numPersons + " personnes à la table " + numTable + "</html>","Confirmation réservation",1);
	}
	
	
	public void setDialogue(DialogueReservation dialogReservation) {
		dialogueReservation = dialogReservation;
	}
	
	protected void do_datePicker_dateChanged(DateChangeEvent dateHasChanged) {
		dialogueReservation.handleDateSelectedEvent(dateHasChanged.getNewDate().toString());
	}
	
	protected void do_hourPicker_hourChanged(ActionEvent e) {
		dialogueReservation.handleTimeSelectedEvent(comboBoxChooseHour.getSelectedItem().toString());
	}
	
	protected void do_numOfPersCombo_numChanged(ActionEvent e) {
		dialogueReservation.handleNumofPersonsSelectedEvent(comboBoxNumOfPersons.getSelectedItem().toString());
	}
	
	protected void do_listOfTablesSelectTable_listOfTablesChanged(MouseEvent e) {
		dialogueReservation.handleTableSelectedEvent(listOfTables.getSelectedValue().toString());
	}
	
	protected void do_btnValiderSelected_ValidateChanged(ActionEvent e) {
		dialogueReservation.handleValidateEvent();
	}
	
	protected void do_btnOk_OkIsPressed(ActionEvent e) {
		dialogueReservation.handleOkEvent();
	}
	
	protected void do_btnCancel_CancelIsPressed(ActionEvent e) {
		dialogueReservation.handleCancelEvent();
	}

	public void initTableMap(int[] propositions) {
		int nbProposition = 0;
		int[] propositionRetenue = new int[propositions.length-1];
		for(int i = 1 ; i<propositions.length -1; i++) {
			if(propositions[i] != 0) {
				propositionRetenue[nbProposition] = propositions[i];
				nbProposition++;
			}
		}
		String[] propString = new String[nbProposition];
		for (int i = 0; i < nbProposition; i++) {
		propString[i] = "" + propositionRetenue[i];
		}
		listTableMap.setModel(new AbstractListModel() {
		String[] values = propString;
		public int getSize() {
		return values.length;
		}
		public Object getElementAt(int index) {
		return values[index];
		}
		});	
	}
}