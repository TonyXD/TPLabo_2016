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
import javax.swing.JPasswordField;

public class LogIn_View {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

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
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(LogIn_View.class.getResource("/Imagenes/dishes-798316_1280.png")));
		frame.setBounds(100, 100, 369, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 331, 333, 2);
		frame.getContentPane().add(separator);
		
		textField = new JTextField();
		textField.setBounds(139, 361, 200, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btn_LogIn = new JButton("Ingresar");
		btn_LogIn.setBounds(254, 427, 89, 23);
		frame.getContentPane().add(btn_LogIn);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(29, 395, 110, 14);
		frame.getContentPane().add(lblContrasea);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(29, 364, 63, 14);
		frame.getContentPane().add(lblUsuario);
		
		passwordField = new JPasswordField();
		passwordField.setEchoChar('X');
		passwordField.setBounds(139, 392, 200, 20);
		frame.getContentPane().add(passwordField);
		
		JButton btn_ImagenPerfil = new JButton("");
		btn_ImagenPerfil.setMargin(new Insets(0, 0, 0, 0));
		btn_ImagenPerfil.setIcon(new ImageIcon(LogIn_View.class.getResource("/Imagenes/LogInIcon_300x300px.jpg")));
		btn_ImagenPerfil.setBounds(29, 11, 300, 300);
		frame.getContentPane().add(btn_ImagenPerfil);
	}
}
