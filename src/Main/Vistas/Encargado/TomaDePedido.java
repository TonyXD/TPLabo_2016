package Vistas.Encargado;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;

public class TomaDePedido extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTextField textField;
	private JTable table_3;
	private JTable tbl_Menu;
	private JTable tbl_Entrada;
	private JTable tbl_Principal;
	private JTable tbl_Postres;
	private JTable tbl_Bebidas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TomaDePedido frame = new TomaDePedido();
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
	public TomaDePedido() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1218, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnl_Seleccion = new JPanel();
		pnl_Seleccion.setBounds(10, 11, 830, 580);
		contentPane.add(pnl_Seleccion);
		pnl_Seleccion.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 830, 580);
		pnl_Seleccion.add(tabbedPane);
		
		JScrollPane scPnl_Entrada = new JScrollPane();
		tabbedPane.addTab("Entrada", null, scPnl_Entrada, null);
		
		tbl_Entrada = new JTable();
		tbl_Entrada.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"Nombre", "Precio"
			}
		));
		scPnl_Entrada.setViewportView(tbl_Entrada);
		
		JScrollPane scPnl_Principal = new JScrollPane();
		tabbedPane.addTab("Principal", null, scPnl_Principal, null);
		
		tbl_Principal = new JTable();
		tbl_Principal.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"Nombre", "Precio"
			}
		));
		scPnl_Principal.setViewportView(tbl_Principal);
		
		JScrollPane scPnl_Postres = new JScrollPane();
		tabbedPane.addTab("Postres", null, scPnl_Postres, null);
		
		tbl_Postres = new JTable();
		tbl_Postres.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"Nombre", "Precio"
			}
		));
		scPnl_Postres.setViewportView(tbl_Postres);
		
		JScrollPane scPnl_Bebidas = new JScrollPane();
		tabbedPane.addTab("Bebidas", null, scPnl_Bebidas, null);
		
		tbl_Bebidas = new JTable();
		tbl_Bebidas.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"Nombre", "Precio"
			}
		));
		scPnl_Bebidas.setViewportView(tbl_Bebidas);
		
		JScrollPane scPnl_Menu = new JScrollPane();
		tabbedPane.addTab("Menús", null, scPnl_Menu, null);
		
		tbl_Menu = new JTable();
		tbl_Menu.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"Nombre", "Precio"
			}
		));
		scPnl_Menu.setViewportView(tbl_Menu);
		
		JPanel pnl_Observaciones = new JPanel();
		pnl_Observaciones.setBounds(10, 602, 830, 149);
		contentPane.add(pnl_Observaciones);
		pnl_Observaciones.setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 36, 300, 102);
		pnl_Observaciones.add(textPane);
		
		JLabel lblNewLabel_1 = new JLabel("Observaciones");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 0, 142, 36);
		pnl_Observaciones.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.setBounds(700, 104, 120, 34);
		pnl_Observaciones.add(btnNewButton);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(607, 104, 83, 34);
		pnl_Observaciones.add(spinner);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCantidad.setBounds(507, 104, 90, 34);
		pnl_Observaciones.add(lblCantidad);
		
		JPanel pnl_PreVisualisacionPedido = new JPanel();
		pnl_PreVisualisacionPedido.setBounds(848, 11, 344, 740);
		contentPane.add(pnl_PreVisualisacionPedido);
		pnl_PreVisualisacionPedido.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Pedido", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnl_PreVisualisacionPedido.setLayout(null);
		
		JLabel lblEntrada = new JLabel("Entrada");
		lblEntrada.setBounds(10, 16, 90, 30);
		pnl_PreVisualisacionPedido.add(lblEntrada);
		lblEntrada.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 57, 322, 120);
		pnl_PreVisualisacionPedido.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"Nombre", "Observaciones", "Cantidad"
			}
		));
		
		JLabel lblPrincipal = new JLabel("Principal");
		lblPrincipal.setBounds(10, 188, 90, 30);
		pnl_PreVisualisacionPedido.add(lblPrincipal);
		lblPrincipal.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 229, 322, 120);
		pnl_PreVisualisacionPedido.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"Nombre", "Observaciones", "Cantidad"
			}
		));
		scrollPane_1.setViewportView(table_1);
		
		JLabel lblBebida = new JLabel("Bebida");
		lblBebida.setBounds(10, 357, 90, 30);
		pnl_PreVisualisacionPedido.add(lblBebida);
		lblBebida.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 398, 322, 120);
		pnl_PreVisualisacionPedido.add(scrollPane_2);
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"Nombre", "Observaciones", "Cantidad"
			}
		));
		scrollPane_2.setViewportView(table_2);
		
		JLabel label = new JLabel("Bebida");
		label.setBounds(10, 530, 90, 30);
		pnl_PreVisualisacionPedido.add(label);
		label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 571, 320, 120);
		pnl_PreVisualisacionPedido.add(scrollPane_3);
		
		table_3 = new JTable();
		table_3.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"Nombre", "Observaciones", "Cantidad"
			}
		));
		scrollPane_3.setViewportView(table_3);
		
		textField = new JTextField();
		textField.setBounds(224, 702, 114, 31);
		pnl_PreVisualisacionPedido.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Total:");
		lblNewLabel.setBounds(124, 702, 90, 31);
		pnl_PreVisualisacionPedido.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
	}
}
