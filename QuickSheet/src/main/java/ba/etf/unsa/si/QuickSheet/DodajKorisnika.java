package ba.etf.unsa.si.QuickSheet;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.border.TitledBorder;
import javax.swing.JList;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.AbstractListModel;
import java.awt.SystemColor;

public class DodajKorisnika extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DodajKorisnika frame = new DodajKorisnika();
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
	public DodajKorisnika() {
		setResizable(false);
		setTitle("Dodaj korisnika");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\dzenana\\git\\SI2014Tim2\\QuickSheet\\qs.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 293, 366);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("TextField.darkShadow"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(SystemColor.textHighlightText);
		panel.setBackground(UIManager.getColor("TextField.darkShadow"));
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Korisnici", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("TextField.highlight")));
		panel.setBounds(22, 11, 244, 301);
		contentPane.add(panel);
		panel.setLayout(null);
		
		final JList list = new JList();
		list.setForeground(UIManager.getColor("TextField.highlight"));
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"korisnik 1", "korisnik 2"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(20, 46, 203, 210);
		list.setFont(new Font("Tahoma", Font.PLAIN, 10));
		list.setBackground(UIManager.getColor("TextField.darkShadow"));
		panel.add(list);
		
		final JLabel label = new JLabel("");
		label.setVisible(false);
		label.setBounds(0, 323, 287, 14);
		contentPane.add(label);
		
		JButton btnDodajKorisnika = new JButton("Dodaj");
		btnDodajKorisnika.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDodajKorisnika.setForeground(UIManager.getColor("Button.foreground"));
		btnDodajKorisnika.setBackground(UIManager.getColor("TextArea.selectionBackground"));
		btnDodajKorisnika.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean greska = true;
				
				if(list.isSelectionEmpty()){
					greska = false;
					label.setText("Morate označiti korisnika da bi ga dodali!");
				}
				if(greska == false){
					label.setVisible(true);
				}
				else label.setVisible(false);
			}
		});
		btnDodajKorisnika.setBounds(142, 267, 81, 23);
		panel.add(btnDodajKorisnika);
		
		JLabel lblIzaberiteKorisnikeDa = new JLabel("Izaberite korisnike da bi ih dodali:");
		lblIzaberiteKorisnikeDa.setForeground(UIManager.getColor("TextField.highlight"));
		lblIzaberiteKorisnikeDa.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblIzaberiteKorisnikeDa.setBounds(20, 21, 166, 14);
		panel.add(lblIzaberiteKorisnikeDa);
		
		
	}
}
