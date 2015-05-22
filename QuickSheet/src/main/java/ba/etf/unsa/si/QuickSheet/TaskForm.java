package ba.etf.unsa.si.QuickSheet;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JList;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.JButton;
import java.awt.Font;

public class TaskForm extends JFrame {

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
					TaskForm frame = new TaskForm();
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
	public TaskForm() {
		setResizable(false);
		setTitle("Dodavanje taskova");
		setIconImage(Toolkit.getDefaultToolkit().getImage("qs.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 399, 257);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(22, 11, 337, 197);
		panel.setBorder(new TitledBorder(null, "Dodaj task", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNazivTaska = new JLabel("Naziv taska:");
		lblNazivTaska.setBounds(26, 25, 59, 14);
		panel.add(lblNazivTaska);
		
		textField = new JTextField();
		textField.setBounds(95, 22, 202, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblOpisTaska = new JLabel("Opis taska:");
		lblOpisTaska.setBounds(31, 62, 54, 14);
		panel.add(lblOpisTaska);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(95, 59, 202, 20);
		panel.add(textField_1);
		
		JLabel lblPrioritet = new JLabel("Prioritet:");
		lblPrioritet.setBounds(42, 121, 42, 14);
		panel.add(lblPrioritet);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		spinner.setBounds(96, 118, 29, 20);
		panel.add(spinner);
		
		JLabel lblNewLabel = new JLabel("Rok:");
		lblNewLabel.setBounds(63, 96, 22, 14);
		panel.add(lblNewLabel);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerDateModel(new Date(1432245600000L), null, null, Calendar.DAY_OF_YEAR));
		spinner_1.setBounds(95, 90, 202, 20);
		panel.add(spinner_1);
		
		JButton btnNewButton = new JButton("Dodaj task");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton.setBounds(156, 154, 141, 23);
		panel.add(btnNewButton);
	}
}
