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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class TaskForm extends JFrame {

	private JPanel contentPane;
	private JTextField textField_2;
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
		setBounds(100, 100, 383, 260);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("TextField.darkShadow"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("TextField.darkShadow"));
		panel.setBounds(22, 11, 327, 197);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Dodaj task", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("TextField.highlight")));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNazivTaska = new JLabel("Naziv taska:");
		lblNazivTaska.setForeground(UIManager.getColor("TextField.highlight"));
		lblNazivTaska.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNazivTaska.setBounds(26, 25, 59, 14);
		panel.add(lblNazivTaska);
		
		textField_2 = new JTextField();
		textField_2.setBounds(95, 22, 202, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblOpisTaska = new JLabel("Opis taska:");
		lblOpisTaska.setForeground(UIManager.getColor("TextField.highlight"));
		lblOpisTaska.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblOpisTaska.setBounds(31, 62, 54, 14);
		panel.add(lblOpisTaska);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(95, 59, 202, 20);
		panel.add(textField_1);
		
		JLabel lblPrioritet = new JLabel("Prioritet:");
		lblPrioritet.setForeground(UIManager.getColor("TextField.highlight"));
		lblPrioritet.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPrioritet.setBounds(42, 121, 42, 14);
		panel.add(lblPrioritet);
		
		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 11));
		spinner.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		spinner.setBounds(96, 118, 29, 20);
		panel.add(spinner);
		
		JLabel lblNewLabel = new JLabel("Rok:");
		lblNewLabel.setForeground(UIManager.getColor("TextField.highlight"));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(63, 96, 22, 14);
		panel.add(lblNewLabel);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		spinner_1.setModel(new SpinnerDateModel(new Date(1432245600000L), null, null, Calendar.DAY_OF_YEAR));
		spinner_1.setBounds(95, 90, 202, 20);
		panel.add(spinner_1);
		
		final JLabel label = new JLabel("");
		label.setVisible(false);
		label.setBounds(0, 217, 377, 14);
		contentPane.add(label);
		
		JButton btnNewButton = new JButton("Dodaj task");
		btnNewButton.setForeground(UIManager.getColor("Button.foreground"));
		btnNewButton.setBackground(UIManager.getColor("TextArea.selectionBackground"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean greska = true;
				
				if(textField_2.getText().equals("")){
					greska = false;
					label.setText("Unesite naziv taska!");
				}
				else if(textField_1.getText().equals("")){
					greska = false;
					label.setText("Unesite opis taska!");
				}
				else greska = true;
				if(greska == false){
					label.setVisible(true);
				}
				else label.setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton.setBounds(196, 154, 101, 23);
		panel.add(btnNewButton);
		
		
		
	}
}
