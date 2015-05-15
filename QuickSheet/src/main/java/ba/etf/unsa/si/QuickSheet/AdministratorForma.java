package ba.etf.unsa.si.QuickSheet;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class AdministratorForma extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textField_24;
	private JTextField textField_25;
	private JTextField textField_26;
	private JTextField textField_27;
	private JTextField textField_28;
	private JTextField textField_29;
	private JTextField textField_30;
	private JTextField textField_31;
	private JTextField textField_32;
	private JTextField textField_33;
	private JTextField textField_34;
	private JTextField textField_35;
	private JLabel lblPonedjeljak;
	private JLabel lblUtorak;
	private JLabel lblSrijeda;
	private JLabel lbletvrtak;
	private JLabel lblPetak;
	private JLabel lblSubota;
	private JLabel lblNedjelja;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblDatum;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblSati;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdministratorForma frame = new AdministratorForma();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdministratorForma() {
		setTitle("QuickSheet");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 793, 460);
		getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 777, 421);
		getContentPane().add(tabbedPane);
		
		JPanel timeSheetPanel = new JPanel();
		tabbedPane.addTab("Moj Timesheet", null, timeSheetPanel, null);
		timeSheetPanel.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(32, 43, 108, 20);
		timeSheetPanel.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(149, 43, 108, 20);
		timeSheetPanel.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(32, 74, 108, 20);
		timeSheetPanel.add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(149, 74, 108, 20);
		timeSheetPanel.add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(32, 105, 108, 20);
		timeSheetPanel.add(comboBox_4);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setBounds(149, 105, 108, 20);
		timeSheetPanel.add(comboBox_5);
		
		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setBounds(32, 135, 108, 20);
		timeSheetPanel.add(comboBox_6);
		
		JComboBox comboBox_7 = new JComboBox();
		comboBox_7.setBounds(149, 135, 108, 20);
		timeSheetPanel.add(comboBox_7);
		
		JComboBox comboBox_8 = new JComboBox();
		comboBox_8.setBounds(32, 166, 108, 20);
		timeSheetPanel.add(comboBox_8);
		
		JComboBox comboBox_9 = new JComboBox();
		comboBox_9.setBounds(149, 166, 108, 20);
		timeSheetPanel.add(comboBox_9);
		
		textField_1 = new JTextField();
		textField_1.setBounds(263, 43, 59, 20);
		timeSheetPanel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(263, 74, 59, 20);
		timeSheetPanel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(263, 105, 59, 20);
		timeSheetPanel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(263, 135, 59, 20);
		timeSheetPanel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(263, 166, 59, 20);
		timeSheetPanel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(335, 43, 59, 20);
		timeSheetPanel.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(335, 105, 59, 20);
		timeSheetPanel.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(335, 74, 59, 20);
		timeSheetPanel.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(335, 135, 59, 20);
		timeSheetPanel.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(335, 166, 59, 20);
		timeSheetPanel.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(404, 43, 59, 20);
		timeSheetPanel.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(404, 105, 59, 20);
		timeSheetPanel.add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(404, 135, 59, 20);
		timeSheetPanel.add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(404, 166, 59, 20);
		timeSheetPanel.add(textField_14);
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(404, 74, 59, 20);
		timeSheetPanel.add(textField_15);
		
		textField_16 = new JTextField();
		textField_16.setColumns(10);
		textField_16.setBounds(473, 43, 59, 20);
		timeSheetPanel.add(textField_16);
		
		textField_17 = new JTextField();
		textField_17.setColumns(10);
		textField_17.setBounds(473, 74, 59, 20);
		timeSheetPanel.add(textField_17);
		
		textField_18 = new JTextField();
		textField_18.setColumns(10);
		textField_18.setBounds(473, 105, 59, 20);
		timeSheetPanel.add(textField_18);
		
		textField_19 = new JTextField();
		textField_19.setColumns(10);
		textField_19.setBounds(473, 135, 59, 20);
		timeSheetPanel.add(textField_19);
		
		textField_20 = new JTextField();
		textField_20.setColumns(10);
		textField_20.setBounds(473, 166, 59, 20);
		timeSheetPanel.add(textField_20);
		
		textField_21 = new JTextField();
		textField_21.setColumns(10);
		textField_21.setBounds(542, 43, 59, 20);
		timeSheetPanel.add(textField_21);
		
		textField_22 = new JTextField();
		textField_22.setColumns(10);
		textField_22.setBounds(611, 43, 59, 20);
		timeSheetPanel.add(textField_22);
		
		textField_23 = new JTextField();
		textField_23.setColumns(10);
		textField_23.setBounds(676, 43, 59, 20);
		timeSheetPanel.add(textField_23);
		
		textField_24 = new JTextField();
		textField_24.setColumns(10);
		textField_24.setBounds(542, 74, 59, 20);
		timeSheetPanel.add(textField_24);
		
		textField_25 = new JTextField();
		textField_25.setColumns(10);
		textField_25.setBounds(542, 105, 59, 20);
		timeSheetPanel.add(textField_25);
		
		textField_26 = new JTextField();
		textField_26.setColumns(10);
		textField_26.setBounds(542, 135, 59, 20);
		timeSheetPanel.add(textField_26);
		
		textField_27 = new JTextField();
		textField_27.setColumns(10);
		textField_27.setBounds(542, 166, 59, 20);
		timeSheetPanel.add(textField_27);
		
		textField_28 = new JTextField();
		textField_28.setColumns(10);
		textField_28.setBounds(611, 74, 59, 20);
		timeSheetPanel.add(textField_28);
		
		textField_29 = new JTextField();
		textField_29.setColumns(10);
		textField_29.setBounds(611, 105, 59, 20);
		timeSheetPanel.add(textField_29);
		
		textField_30 = new JTextField();
		textField_30.setColumns(10);
		textField_30.setBounds(611, 135, 59, 20);
		timeSheetPanel.add(textField_30);
		
		textField_31 = new JTextField();
		textField_31.setColumns(10);
		textField_31.setBounds(611, 166, 59, 20);
		timeSheetPanel.add(textField_31);
		
		textField_32 = new JTextField();
		textField_32.setColumns(10);
		textField_32.setBounds(676, 74, 59, 20);
		timeSheetPanel.add(textField_32);
		
		textField_33 = new JTextField();
		textField_33.setColumns(10);
		textField_33.setBounds(676, 105, 59, 20);
		timeSheetPanel.add(textField_33);
		
		textField_34 = new JTextField();
		textField_34.setColumns(10);
		textField_34.setBounds(676, 135, 59, 20);
		timeSheetPanel.add(textField_34);
		
		textField_35 = new JTextField();
		textField_35.setColumns(10);
		textField_35.setBounds(676, 166, 59, 20);
		timeSheetPanel.add(textField_35);
		
		lblPonedjeljak = new JLabel("Ponedjeljak");
		lblPonedjeljak.setBounds(263, 21, 59, 20);
		timeSheetPanel.add(lblPonedjeljak);
		
		lblUtorak = new JLabel("Utorak");
		lblUtorak.setBounds(346, 21, 59, 20);
		timeSheetPanel.add(lblUtorak);
		
		lblSrijeda = new JLabel("Srijeda");
		lblSrijeda.setBounds(414, 21, 59, 20);
		timeSheetPanel.add(lblSrijeda);
		
		lbletvrtak = new JLabel("Četvrtak");
		lbletvrtak.setBounds(483, 21, 59, 20);
		timeSheetPanel.add(lbletvrtak);
		
		lblPetak = new JLabel("Petak");
		lblPetak.setBounds(552, 21, 59, 20);
		timeSheetPanel.add(lblPetak);
		
		lblSubota = new JLabel("Subota");
		lblSubota.setBounds(621, 21, 59, 20);
		timeSheetPanel.add(lblSubota);
		
		lblNedjelja = new JLabel("Nedjelja");
		lblNedjelja.setBounds(687, 21, 59, 20);
		timeSheetPanel.add(lblNedjelja);
		
		lblNewLabel = new JLabel("Sedmica od:");
		lblNewLabel.setBounds(119, 0, 71, 20);
		timeSheetPanel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("datum1");
		lblNewLabel_1.setBounds(189, 3, 91, 14);
		timeSheetPanel.add(lblNewLabel_1);
		
		lblDatum = new JLabel("datum2");
		lblDatum.setBounds(335, 3, 91, 14);
		timeSheetPanel.add(lblDatum);
		
		lblNewLabel_2 = new JLabel("do");
		lblNewLabel_2.setBounds(266, 3, 30, 14);
		timeSheetPanel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Ukupno:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(432, 197, 91, 20);
		timeSheetPanel.add(lblNewLabel_3);
		
		lblSati = new JLabel("sati");
		lblSati.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSati.setBounds(529, 197, 91, 20);
		timeSheetPanel.add(lblSati);
		
		JButton btnNewButton = new JButton("Pošalji na reviziju");
		btnNewButton.setBounds(621, 197, 114, 23);
		timeSheetPanel.add(btnNewButton);
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Ponedjeljak"); 
		model.addColumn("Utorak"); 
		model.addColumn("Srijeda"); 
		model.addColumn("Četvrtak"); 
		model.addColumn("Petak"); 
		model.addColumn("Subota"); 
		model.addColumn("Nedjelja");
		
		JPanel historijaPanel = new JPanel();
		tabbedPane.addTab("Moja Historija", null, historijaPanel, null);
		historijaPanel.setLayout(null);
		
		JPanel korisniciPanel = new JPanel();
		tabbedPane.addTab("New tab", null, korisniciPanel, null);
		korisniciPanel.setLayout(null);
		
		JPanel odjeliPanel = new JPanel();
		tabbedPane.addTab("Odjeli", null, odjeliPanel, null);
		odjeliPanel.setLayout(null);
		
		JPanel projektiPanel = new JPanel();
		tabbedPane.addTab("Projekti", null, projektiPanel, null);
		projektiPanel.setLayout(null);
		
		JPanel izvjestajiPanel = new JPanel();
		tabbedPane.addTab("Izvjestaji", null, izvjestajiPanel, null);
		izvjestajiPanel.setLayout(null);
		
	}
}
