package ba.etf.unsa.si.QuickSheet;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTextField;

import ba.etf.unsa.si.Klase.IzvjestajOdjela;
import ba.etf.unsa.si.Klase.IzvjestajZaposlenika;
import ba.etf.unsa.si.KlaseHibernate.IzvjestajOdjelaHibernate;
import ba.etf.unsa.si.KlaseHibernate.IzvjestajZaposlenikaHibernate;

import java.awt.Font;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.component.TextFieldBuilder;
import net.sf.dynamicreports.report.exception.DRException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IzvjestajForm extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	protected static final Logger LOGGER = Logger.getLogger("IzvjestajForm");
	private JTextField textField_8;
	private JTextField textField_9;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IzvjestajForm frame = new IzvjestajForm(null, null, null);
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					LOGGER.log(Level.SEVERE,"context",e);
				}
			}
		});
	}

	public IzvjestajForm(final IzvjestajZaposlenikaHibernate IZ, final IzvjestajOdjelaHibernate IO, final Month mjesec) {
		setTitle("Izvještaj ");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 574, 277);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("TextField.darkShadow"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage("qs.png"));
		JPanel panel = new JPanel();
		panel.setForeground(UIManager.getColor("TextField.highlight"));
		panel.setBackground(UIManager.getColor("TextField.darkShadow"));
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Izvje\u0161taj odjela", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("TextField.highlight")));
		panel.setBounds(10, 11, 266, 198);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Ukupan trošak:");
		label.setForeground(UIManager.getColor("TextField.highlight"));
		label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label.setBounds(40, 112, 73, 14);
		panel.add(label);
		
		JLabel lblNazivOdjela = new JLabel("Naziv odjela:");
		lblNazivOdjela.setForeground(UIManager.getColor("TextField.highlight"));
		lblNazivOdjela.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNazivOdjela.setBounds(51, 26, 62, 14);
		panel.add(lblNazivOdjela);
		
		JLabel label_2 = new JLabel("Ukupan broj taskova:");
		label_2.setForeground(UIManager.getColor("TextField.highlight"));
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_2.setBounds(10, 54, 103, 14);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Ukupno vrijeme rada:");
		label_3.setForeground(UIManager.getColor("TextField.highlight"));
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_3.setBounds(10, 84, 103, 14);
		panel.add(label_3);
		
		textField = new JTextField();
		textField.setDisabledTextColor(Color.BLACK);
		textField.setBackground(Color.WHITE);
		textField.setBorder(null);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textField.setEnabled(false);
		textField.setEditable(false);
		textField.setBounds(130, 23, 126, 20);
		textField.setText(IO.getOdjel().getNaziv());
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setDisabledTextColor(Color.BLACK);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textField_1.setEnabled(false);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBorder(null);
		textField_1.setBackground(Color.WHITE);
		textField_1.setBounds(130, 51, 126, 20);
		textField_1.setText(IO.getUkupanBrojTaskovaOdjela().toString());
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setDisabledTextColor(Color.BLACK);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textField_2.setEnabled(false);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBorder(null);
		textField_2.setBackground(Color.WHITE);
		textField_2.setBounds(130, 81, 126, 20);
		textField_2.setText(IO.getUkupnoVrijemeRada().toString());
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setDisabledTextColor(Color.BLACK);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textField_3.setEnabled(false);
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBorder(null);
		textField_3.setBackground(Color.WHITE);
		textField_3.setBounds(130, 109, 126, 20);
		textField_3.setText(IO.getTrosak().toString());
		panel.add(textField_3);
		
		JLabel label_1 = new JLabel("Procenat urađenog:");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_1.setBounds(17, 140, 103, 14);
		panel.add(label_1);
		
		textField_9 = new JTextField();
		textField_9.setText((String) null);
		textField_9.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textField_9.setEnabled(false);
		textField_9.setEditable(false);
		textField_9.setDisabledTextColor(Color.BLACK);
		textField_9.setColumns(10);
		textField_9.setBorder(null);
		textField_9.setBackground(Color.WHITE);
		textField_9.setBounds(130, 137, 126, 20);
		textField_9.setText(IO.getProcenatZavrsenogRada().toString());
		panel.add(textField_9);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(UIManager.getColor("TextField.highlight"));
		panel_1.setBackground(UIManager.getColor("TextField.darkShadow"));
		panel_1.setBounds(282, 11, 266, 198);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Izvje\u0161taj zaposlenika", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("TextField.highlight")));
		
		JLabel lblImeZaposlenika = new JLabel("Naziv zaposlenika:");
		lblImeZaposlenika.setForeground(UIManager.getColor("TextField.highlight"));
		lblImeZaposlenika.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblImeZaposlenika.setBounds(25, 32, 88, 14);
		panel_1.add(lblImeZaposlenika);
		
		JLabel lblUkupanBrojTaskova = new JLabel("Ukupan broj taskova:");
		lblUkupanBrojTaskova.setForeground(UIManager.getColor("TextField.highlight"));
		lblUkupanBrojTaskova.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblUkupanBrojTaskova.setBounds(10, 60, 103, 14);
		panel_1.add(lblUkupanBrojTaskova);
		
		JLabel lblUkupnoVrijemeRada = new JLabel("Ukupno vrijeme rada:");
		lblUkupnoVrijemeRada.setForeground(UIManager.getColor("TextField.highlight"));
		lblUkupnoVrijemeRada.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblUkupnoVrijemeRada.setBounds(10, 88, 103, 14);
		panel_1.add(lblUkupnoVrijemeRada);
		
		JLabel lblUkupanTro = new JLabel("Ukupan trošak:");
		lblUkupanTro.setForeground(UIManager.getColor("TextField.highlight"));
		lblUkupanTro.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblUkupanTro.setBounds(40, 116, 73, 14);
		panel_1.add(lblUkupanTro);
		
		textField_4 = new JTextField();
		textField_4.setDisabledTextColor(Color.BLACK);
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textField_4.setEnabled(false);
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBorder(null);
		textField_4.setBackground(Color.WHITE);
		textField_4.setBounds(123, 29, 126, 20);
		textField_4.setText(IZ.getZaposlenik().getIme() + " " + IZ.getZaposlenik().getPrezime());
		panel_1.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setDisabledTextColor(Color.BLACK);
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textField_5.setEnabled(false);
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBorder(null);
		textField_5.setBackground(Color.WHITE);
		textField_5.setBounds(123, 57, 126, 20);
		textField_5.setText(IZ.getUkupanBrojTaskova().toString());
		panel_1.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setDisabledTextColor(Color.BLACK);
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textField_6.setEnabled(false);
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBorder(null);
		textField_6.setBackground(Color.WHITE);
		textField_6.setBounds(123, 85, 126, 20);
		textField_6.setText(IZ.getUkupnoVrijemeRada().toString());
		panel_1.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setDisabledTextColor(Color.BLACK);
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textField_7.setEnabled(false);
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBorder(null);
		textField_7.setBackground(Color.WHITE);
		textField_7.setBounds(123, 113, 126, 20);
		textField_7.setText(IZ.getTrosak().toString());
		panel_1.add(textField_7);
		
		JLabel lblProcenatZavrenogRada = new JLabel("Procenat urađenog:");
		lblProcenatZavrenogRada.setForeground(Color.WHITE);
		lblProcenatZavrenogRada.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblProcenatZavrenogRada.setBounds(22, 147, 103, 14);
		panel_1.add(lblProcenatZavrenogRada);
		
		textField_8 = new JTextField();
		textField_8.setDisabledTextColor(Color.BLACK);
		textField_8.setText((String) null);
		textField_8.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textField_8.setEnabled(false);
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		textField_8.setBorder(null);
		textField_8.setBackground(Color.WHITE);
		textField_8.setBounds(123, 144, 126, 20);
		textField_8.setText(IZ.getProcenatZavrsenogRada().toString());
		panel_1.add(textField_8);
		
		JButton btnKreirajpdf = new JButton("Kreiraj .pdf");
		btnKreirajpdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					GenerisiIzvjestaj(IZ, IO, mjesec);
				} catch (DRException e) {
					LOGGER.log(Level.SEVERE,"context",e);
				}
			}
		});

		btnKreirajpdf.setBackground(UIManager.getColor("TextField.selectionBackground"));
		btnKreirajpdf.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnKreirajpdf.setBounds(230, 214, 99, 23);
		contentPane.add(btnKreirajpdf);
	}
	
	public void GenerisiIzvjestaj(IzvjestajZaposlenikaHibernate zaza, IzvjestajOdjelaHibernate dodo, Month mjesec) throws DRException
	{
		JasperReportBuilder report = DynamicReports.report(); 
		TextFieldBuilder<String> title1 = DynamicReports.cmp.text("  Quicksheet, d.o.o\n"); 
		report.title(title1); 
		TextFieldBuilder<String> title2 = DynamicReports.cmp.text("  Zmaja od Bosne 6, Kampus Univerziteta u Sarajevu, 71 000 Sarajevo\n"); 
		report.title(title2); 
		TextFieldBuilder<String> title3 = DynamicReports.cmp.text("  Tel: ++387 33 666 999\n"); 
		report.title(title3);
		TextFieldBuilder<String> title3x = DynamicReports.cmp.text("  Klijent: " + dodo.getProjekat().getNazivKlijenta() + "\n\n\n\n"); 
		report.title(title3x);
		TextFieldBuilder<String> title4 =DynamicReports.cmp.text("   Izvještaj za rad odjela: " + dodo.getOdjel().getNaziv() + ", za mjesec " + mjesec.toString() + " na projektu: " + dodo.getProjekat().getNaziv() + ".\n\n\n");
		report.title(title4);
		TextFieldBuilder<String> title5 =DynamicReports.cmp.text("   -Ukupan broj taskova odjela: " + dodo.getUkupanBrojTaskovaOdjela() + "\n");
		report.title(title5);
		TextFieldBuilder<String> title6 =DynamicReports.cmp.text("   -Ukupno vrijeme rada odjela: " + dodo.getUkupnoVrijemeRada() + "\n");
		report.title(title6);
		TextFieldBuilder<String> title7 =DynamicReports.cmp.text("   -Procenat urađenog rada odjela: " + dodo.getProcenatZavrsenogRada() + "\n");
		report.title(title7);
		TextFieldBuilder<String> title8 =DynamicReports.cmp.text("   -Ukupni trošak odjela: " + dodo.getTrosak() + "\n\n\n");
		report.title(title8);
		TextFieldBuilder<String> title9 =DynamicReports.cmp.text("   Izvještaj za rad zaposlenika: " + zaza.getZaposlenik().getIme() + " " + zaza.getZaposlenik().getPrezime() + ", za mjesec " + mjesec.toString() + " na projektu: " + zaza.getProjekat().getNaziv() + ".\n\n\n");
		report.title(title9);
		TextFieldBuilder<String> title10 =DynamicReports.cmp.text("   -Ukupan broj taskova zaposlenika: " + zaza.getUkupanBrojTaskova() + "\n");
		report.title(title10);
		TextFieldBuilder<String> title11 =DynamicReports.cmp.text("   -Ukupno vrijeme rada zaposlenika: " + zaza.getUkupnoVrijemeRada() + "\n");
		report.title(title11);
		TextFieldBuilder<String> title12 =DynamicReports.cmp.text("   -Procenat urađenog rada zaposlenika: " + zaza.getProcenatZavrsenogRada() + "\n");
		report.title(title12);
		TextFieldBuilder<String> title13 =DynamicReports.cmp.text("   -Ukupni trošak zaposlenika: " + zaza.getTrosak() + "\n\n\n");
		report.title(title13);
		TextFieldBuilder<String> titley =DynamicReports.cmp.text("Potpis ovlaštenog lica: ___________________ \n");
		report.title(titley);
		TextFieldBuilder<String> titlez =DynamicReports.cmp.text("Datum: " + LocalDate.now().toString() + "\n");
		report.title(titlez);
		report.show(false); 		
	}
}

