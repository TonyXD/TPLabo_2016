package Vistas.Encargado;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Toolkit;

public class GestorMesas extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestorMesas frame = new GestorMesas();
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
	public GestorMesas() {
		setTitle("Gestor de Mesas");
		setIconImage(Toolkit.getDefaultToolkit().getImage(GestorMesas.class.getResource("/Imagenes/dishes-798316_1280.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 881, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(6, 16, 853, 63);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnPedido = new JButton("Pedido");
		btnPedido.setBounds(151, 11, 130, 40);
		panel.add(btnPedido);
		
		JButton btnModfEstado = new JButton("Modf. Estado");
		btnModfEstado.setBounds(291, 11, 130, 40);
		panel.add(btnModfEstado);
		
		JButton btnVerDetalle = new JButton("Ver Detalle");
		btnVerDetalle.setBounds(429, 11, 130, 40);
		panel.add(btnVerDetalle);
		
		JButton btnGenerarControl = new JButton("Generar Control");
		btnGenerarControl.setBounds(569, 11, 130, 40);
		panel.add(btnGenerarControl);
		
		JButton btnTicket = new JButton("Ticket");
		btnTicket.setBounds(709, 11, 130, 40);
		panel.add(btnTicket);
		
		JButton btnNewButton = new JButton("Asignar Mesa");
		btnNewButton.setBounds(10, 11, 130, 40);
		panel.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 89, 845, 377);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Nro Mesa", "Sector", "Nro Piso", "Estado", "Capacidad", "Hora Apertura", "New column", "Estado"
			}
		));
		scrollPane.setViewportView(table);
	}
}
