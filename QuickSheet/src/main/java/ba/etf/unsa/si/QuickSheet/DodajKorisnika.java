package ba.etf.unsa.si.QuickSheet;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;

import javax.swing.border.TitledBorder;
import javax.swing.JList;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.UIManager;
import javax.swing.AbstractListModel;

import java.awt.SystemColor;
import java.awt.Color;

public class DodajKorisnika extends JFrame {

	protected static final Logger LOGGER = Logger.getLogger("DodajKorisnika");
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DodajKorisnika frame = new DodajKorisnika();
					frame.setVisible(true);
				} catch (Exception e) {
					LOGGER.log(Level.SEVERE,"context",e);
				}
			}
		});
	}

	public DodajKorisnika() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("qs.png"));
		setResizable(false);
		setTitle("Dodaj korisnika");
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
		list.setForeground(Color.BLACK);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"korisnik 1", "korisnik 2"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		JScrollPane scrollPane1 = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane1.setBounds(20, 46, 203, 210);
		list.setBounds(20, 46, 203, 210);
		list.setFont(new Font("Tahoma", Font.PLAIN, 10));
		list.setBackground(Color.WHITE);
		panel.add(scrollPane1);
		
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
