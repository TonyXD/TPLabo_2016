package Vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Panel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Insets;
import javax.swing.border.BevelBorder;
import java.awt.Component;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Toolkit;

public class LogIn_View {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn_View window = new LogIn_View();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LogIn_View() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(LogIn_View.class.getResource("/Images/dishes-798316_1280.png")));
		frame.setBounds(100, 100, 369, 620);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(10, 10, 329, 315);
		frame.getContentPane().add(panel);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnNewButton.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)));
		btnNewButton.setMargin(new Insets(0, 0, 0, 0));
		btnNewButton.setIcon(new ImageIcon(LogIn_View.class.getResource("/Images/LogInIcon_300x300px.jpg")));
		panel.add(btnNewButton);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 331, 333, 2);
		frame.getContentPane().add(separator);
		
		textField = new JTextField();
		textField.setBounds(74, 389, 200, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(74, 440, 200, 20);
		frame.getContentPane().add(textField_1);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(250, 548, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(74, 420, 110, 14);
		frame.getContentPane().add(lblContrasea);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(74, 364, 63, 14);
		frame.getContentPane().add(lblUsuario);
	}
}
