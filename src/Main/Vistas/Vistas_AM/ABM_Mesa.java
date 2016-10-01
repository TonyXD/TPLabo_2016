package Vistas.Vistas_AM;

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
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSpinner;

public class ABM_Mesa extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ABM_Mesa frame = new ABM_Mesa();
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
	public ABM_Mesa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 687);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGestionarMesas = new JLabel("Gestionar Mesas");
		lblGestionarMesas.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionarMesas.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblGestionarMesas.setBounds(10, 0, 464, 51);
		contentPane.add(lblGestionarMesas);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 46, 464, 2);
		contentPane.add(separator);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 62, 464, 400);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"Capacidad", "Piso"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblAgregar = new JLabel("Mesa Seleccionada");
		lblAgregar.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgregar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblAgregar.setBounds(10, 473, 464, 33);
		contentPane.add(lblAgregar);
		
		JLabel lblCapacidad = new JLabel("Capacidad");
		lblCapacidad.setBounds(10, 517, 65, 22);
		contentPane.add(lblCapacidad);
		
		JLabel lblPiso = new JLabel("Piso");
		lblPiso.setBounds(176, 521, 46, 14);
		contentPane.add(lblPiso);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 550, 464, 2);
		contentPane.add(separator_1);
		
		JLabel lblModificar = new JLabel("Agregar");
		lblModificar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblModificar.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificar.setBounds(10, 563, 464, 33);
		contentPane.add(lblModificar);
		
		JLabel label_1 = new JLabel("Capacidad");
		label_1.setBounds(10, 607, 65, 22);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Piso");
		label_2.setBounds(176, 611, 46, 14);
		contentPane.add(label_2);
		
		JButton btnNewButton = new JButton("Eliminar");
		btnNewButton.setBounds(385, 517, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(385, 607, 89, 23);
		contentPane.add(btnAgregar);
		
		JButton btnNewButton_1 = new JButton("Editar");
		btnNewButton_1.setBounds(292, 517, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(70, 518, 55, 20);
		contentPane.add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(227, 518, 55, 20);
		contentPane.add(spinner_1);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setBounds(70, 608, 55, 20);
		contentPane.add(spinner_2);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setBounds(227, 608, 55, 20);
		contentPane.add(spinner_3);
	}
}
