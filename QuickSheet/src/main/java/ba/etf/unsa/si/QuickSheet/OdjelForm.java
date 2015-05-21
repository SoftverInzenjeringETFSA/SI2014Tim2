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
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\dzenana\\git\\SI2014Tim2\\QuickSheet\\qs.png"));
		setResizable(false);
		setTitle("Prikaz odjela");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 402, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(22, 11, 350, 447);
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
		
		JLabel label_2 = new JLabel("Rukovodilac odjela:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_2.setBounds(50, 207, 102, 14);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Maksimalni broj zaposlenika:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_3.setBounds(10, 243, 152, 14);
		panel.add(label_3);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(190, 240, 141, 20);
		panel.add(textField_1);
		
		JButton btnSpremiPromjene = new JButton("Spremi promjene");
		btnSpremiPromjene.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnSpremiPromjene.setBounds(210, 414, 121, 22);
		panel.add(btnSpremiPromjene);
		
		JList list = new JList();
		list.setBounds(190, 61, 141, 135);
		panel.add(list);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(190, 207, 141, 20);
		panel.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Dodaj nove zaposlenike:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(30, 272, 121, 14);
		panel.add(lblNewLabel);
		
		JList list_1 = new JList();
		list_1.setBounds(190, 271, 141, 135);
		panel.add(list_1);
		
		JButton btnUkloniZaposlenikaSa = new JButton("Ukloni zaposlenika sa projekta");
		btnUkloniZaposlenikaSa.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnUkloniZaposlenikaSa.setBounds(30, 414, 169, 22);
		panel.add(btnUkloniZaposlenikaSa);
	}
}
