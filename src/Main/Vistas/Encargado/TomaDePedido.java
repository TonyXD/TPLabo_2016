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
	private JTable tblEntradaSelect;
	private JTable tblPrincipalSelect;
	private JTable tblPostreSelect;
	private JTextField textField;
	private JTable tblBebidaSelect;
	private JTable tbl_Menu;
	private JTable tbl_Entrada;
	private JTable tbl_Principal;
	private JTable tbl_Postres;
	private JTable tbl_Bebidas;
	private JTable tblMenuSelect;

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
		setTitle("Toma De Pedidos");
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
		scPnl_Entrada.setColumnHeaderView(tbl_Entrada);
		
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
		
		JTextPane txtObservaciones = new JTextPane();
		txtObservaciones.setBounds(10, 36, 300, 102);
		pnl_Observaciones.add(txtObservaciones);
		
		JLabel lblNewLabel_1 = new JLabel("Observaciones");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 0, 142, 36);
		pnl_Observaciones.add(lblNewLabel_1);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(700, 104, 120, 34);
		pnl_Observaciones.add(btnAgregar);
		
		JSpinner spnCantidad = new JSpinner();
		spnCantidad.setBounds(607, 104, 83, 34);
		pnl_Observaciones.add(spnCantidad);
		
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
		scrollPane.setBounds(10, 57, 322, 86);
		pnl_PreVisualisacionPedido.add(scrollPane);
		
		tblEntradaSelect = new JTable();
		scrollPane.setViewportView(tblEntradaSelect);
		tblEntradaSelect.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"Nombre", "Observaciones", "Cantidad"
			}
		));
		
		JLabel lblPrincipal = new JLabel("Principal");
		lblPrincipal.setBounds(10, 154, 90, 30);
		pnl_PreVisualisacionPedido.add(lblPrincipal);
		lblPrincipal.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 195, 322, 86);
		pnl_PreVisualisacionPedido.add(scrollPane_1);
		
		tblPrincipalSelect = new JTable();
		tblPrincipalSelect.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"Nombre", "Observaciones", "Cantidad"
			}
		));
		scrollPane_1.setViewportView(tblPrincipalSelect);
		
		JLabel lblPostre = new JLabel("Postre");
		lblPostre.setBounds(10, 292, 90, 30);
		pnl_PreVisualisacionPedido.add(lblPostre);
		lblPostre.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 333, 322, 86);
		pnl_PreVisualisacionPedido.add(scrollPane_2);
		
		tblPostreSelect = new JTable();
		tblPostreSelect.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"Nombre", "Observaciones", "Cantidad"
			}
		));
		scrollPane_2.setViewportView(tblPostreSelect);
		
		JLabel label = new JLabel("Bebida");
		label.setBounds(10, 430, 90, 30);
		pnl_PreVisualisacionPedido.add(label);
		label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 471, 320, 86);
		pnl_PreVisualisacionPedido.add(scrollPane_3);
		
		tblBebidaSelect = new JTable();
		tblBebidaSelect.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"Nombre", "Observaciones", "Cantidad"
			}
		));
		scrollPane_3.setViewportView(tblBebidaSelect);

		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(10, 609, 320, 86);
		pnl_PreVisualisacionPedido.add(scrollPane_4);
		
		tblMenuSelect = new JTable();
		tblMenuSelect.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"Nombre", "Observaciones", "Cantidad"
			}
		));
		scrollPane_4.setViewportView((tblMenuSelect));
		
		textField = new JTextField();
		textField.setBounds(224, 702, 114, 31);
		pnl_PreVisualisacionPedido.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Total:");
		lblNewLabel.setBounds(124, 702, 90, 31);
		pnl_PreVisualisacionPedido.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblMenu.setBounds(10, 568, 90, 30);
		pnl_PreVisualisacionPedido.add(lblMenu);
	}
}
