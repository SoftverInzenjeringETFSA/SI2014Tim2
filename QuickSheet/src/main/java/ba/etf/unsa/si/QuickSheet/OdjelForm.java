package ba.etf.unsa.si.QuickSheet;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JComboBox;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractListModel;

public class OdjelForm extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OdjelForm frame = new OdjelForm();
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
	public OdjelForm() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("qs.png"));
		setResizable(false);
		setTitle("Prikaz odjela");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 402, 492);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(22, 11, 350, 435);
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "Podaci o odjelu", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel);
		
		JLabel label = new JLabel("Naziv odjela:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label.setBounds(78, 33, 102, 14);
		panel.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(190, 30, 141, 20);
		panel.add(textField);
		
		JLabel lblZaposlenici = new JLabel("Zaposlenici u odjelu:");
		lblZaposlenici.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblZaposlenici.setBounds(43, 55, 97, 29);
		panel.add(lblZaposlenici);
		
		JLabel label_3 = new JLabel("Maksimalni broj zaposlenika:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_3.setBounds(10, 360, 152, 14);
		panel.add(label_3);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(190, 357, 141, 20);
		panel.add(textField_1);
		
		JButton btnSpremiPromjene = new JButton("Spremi promjene");
		btnSpremiPromjene.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSpremiPromjene.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnSpremiPromjene.setBounds(210, 396, 121, 22);
		panel.add(btnSpremiPromjene);
		
		final JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"zaposlenik1", "zaposlenik2"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(190, 61, 141, 106);
		panel.add(list);
		
		JLabel lblNewLabel = new JLabel("Dodaj nove zaposlenike:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(30, 208, 121, 14);
		panel.add(lblNewLabel);
		
		final JLabel label_1 = new JLabel("");
		label_1.setVisible(false);
		label_1.setBounds(0, 449, 396, 14);
		contentPane.add(label_1);
		
		JButton btnUkloni = new JButton("Ukloni");
		btnUkloni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean greska = true;
				if(list.isSelectionEmpty()){
					greska = false;
				}
				if(greska == false){
					label_1.setVisible(true);
					label_1.setText("Odaberite zaposlenika!");
				}
				else{
					label_1.setVisible(false);
				}
			}
		});
		btnUkloni.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnUkloni.setBounds(257, 174, 74, 22);
		panel.add(btnUkloni);
		
		final JList list_1 = new JList();
		list_1.setBounds(190, 207, 141, 106);
		panel.add(list_1);
		
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean greska = true;
				if(list_1.isSelectionEmpty()){
					greska = false;
				}
				if(greska == false){
					label_1.setVisible(true);
					label_1.setText("Odaberite zaposlenika!");
				}
				else{
					label_1.setVisible(false);
				}
			}
		});
		btnDodaj.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnDodaj.setBounds(257, 317, 74, 22);
		panel.add(btnDodaj);
		
		
	}
}
