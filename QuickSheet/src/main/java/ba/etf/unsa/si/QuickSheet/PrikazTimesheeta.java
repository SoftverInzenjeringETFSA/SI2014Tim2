package ba.etf.unsa.si.QuickSheet;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import java.awt.Font;
import javax.swing.border.TitledBorder;

public class PrikazTimesheeta extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrikazTimesheeta frame = new PrikazTimesheeta();
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
	public PrikazTimesheeta() {
		setResizable(false);
		setTitle("Prikaz timesheeta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 418, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JButton button = new JButton("Prikazi");
		button.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button.setBounds(124, 358, 74, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Odobri");
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button_1.setBounds(208, 358, 74, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Odbij");
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button_2.setBounds(287, 358, 74, 23);
		contentPane.add(button_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Timesheet", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(30, 22, 341, 370);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 165, 320, 157);
		panel_1.add(panel);
		JLabel lblImeIPrezime = new JLabel("Ime i prezime uposlenika:");
		lblImeIPrezime.setBounds(10, 31, 120, 14);
		panel_1.add(lblImeIPrezime);
		
		JLabel lblImenkoPrezimenkovic = new JLabel("Imenko Prezimenkovic");
		lblImenkoPrezimenkovic.setBounds(156, 31, 114, 14);
		panel_1.add(lblImenkoPrezimenkovic);
		
		JLabel lblTimesheetZaPeriod = new JLabel("Timesheet za period:");
		lblTimesheetZaPeriod.setBounds(30, 56, 100, 14);
		panel_1.add(lblTimesheetZaPeriod);
		
		JLabel lblOd = new JLabel("Od:");
		lblOd.setBounds(156, 56, 25, 14);
		panel_1.add(lblOd);
		
		JLabel lblDo = new JLabel("Do:");
		lblDo.setBounds(156, 105, 25, 14);
		panel_1.add(lblDo);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerDateModel(new Date(1432072800000L), null, null, Calendar.DAY_OF_YEAR));
		spinner.setBounds(156, 79, 141, 20);
		panel_1.add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerDateModel(new Date(1432072800000L), null, null, Calendar.DAY_OF_YEAR));
		spinner_1.setBounds(156, 122, 141, 20);
		panel_1.add(spinner_1);
	}

}
