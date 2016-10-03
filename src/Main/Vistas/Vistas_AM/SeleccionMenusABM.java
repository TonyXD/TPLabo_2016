package Main.Vistas.Vistas_AM;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Toolkit;

public class SeleccionMenusABM extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeleccionMenusABM frame = new SeleccionMenusABM();
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
	public SeleccionMenusABM() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SeleccionMenusABM.class.getResource("/Main/Imagenes/dishes-798316_1280.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 561);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSeleccionDeMenu = new JLabel("Selecci\u00F3n de Menu");
		lblSeleccionDeMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccionDeMenu.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblSeleccionDeMenu.setBounds(0, 0, 484, 44);
		contentPane.add(lblSeleccionDeMenu);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 55, 464, 2);
		contentPane.add(separator);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 74, 464, 394);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(385, 479, 89, 23);
		contentPane.add(btnEliminar);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(187, 479, 89, 23);
		contentPane.add(btnAgregar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(286, 479, 89, 23);
		contentPane.add(btnEditar);
	}
}
