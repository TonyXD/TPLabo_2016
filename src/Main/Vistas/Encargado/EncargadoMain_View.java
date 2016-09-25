package Vistas.Encargado;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

import Utils.MainBackGround;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import java.awt.Panel;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;

public class EncargadoMain_View extends JFrame {

	private static final long serialVersionUID = -6200816652032876979L;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EncargadoMain_View frame = new EncargadoMain_View();
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
	public EncargadoMain_View() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(EncargadoMain_View.class.getResource("/Imagenes/dishes-798316_1280.png")));
		setTitle("Nombre a definir");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 720);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Desplegable 01");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("Desplegable 02");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("New menu item");
		mnNewMenu_1.add(mntmNewMenuItem_1);


		MainBackGround mainPanel = new MainBackGround();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPanel);
		mainPanel.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 10, 627, 641);
		mainPanel.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Salon", null, scrollPane, null);
		
		table = new JTable();
		table.setDragEnabled(true);
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"Sector 01", "Sector 02", "Entrada", "Entrada", "Sector 03", "Sector 04"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(5).setPreferredWidth(87);
		
		JScrollPane scrollPane2 = new JScrollPane();
		tabbedPane.addTab("Cocina", null, scrollPane2, null);
		
		table = new JTable();
		scrollPane2.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null},
			},
			new String[] {
				"New column"
			}
		));
		
		JSeparator separator = new JSeparator();
		separator.setBounds(647, 10, 1, 640);
		separator.setForeground(new Color(0, 0, 0));
		separator.setOrientation(SwingConstants.VERTICAL);
		mainPanel.add(separator);
		
		JPanel pnl_Acciones = new JPanel();
		pnl_Acciones.setBounds(654, 10, 320, 641);
		pnl_Acciones.setOpaque(false);
		mainPanel.add(pnl_Acciones);
		pnl_Acciones.setLayout(null);
		
		JLabel lbl_NombreResto = new JLabel("Nombre del Lugar");
		lbl_NombreResto.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl_NombreResto.setFocusable(false);
		lbl_NombreResto.setFont(new Font("Segoe Print", lbl_NombreResto.getFont().getStyle() | Font.BOLD | Font.ITALIC, 20));
		lbl_NombreResto.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_NombreResto.setBounds(10, 0, 300, 42);
		pnl_Acciones.add(lbl_NombreResto);
		
		JButton btnStock = new JButton("Control Stock");
		btnStock.setBounds(173, 194, 130, 130);
		pnl_Acciones.add(btnStock);
		
		JButton btnPedido = new JButton("Pedido");
		btnPedido.setBounds(20, 53, 130, 130);
		pnl_Acciones.add(btnPedido);
		
		JButton btnCarta = new JButton("Carta");
		btnCarta.setBounds(20, 194, 130, 130);
		pnl_Acciones.add(btnCarta);
		
		JButton btnPlato = new JButton("Gestionar Platos");
		btnPlato.setBounds(20, 335, 130, 130);
		pnl_Acciones.add(btnPlato);
		
		JButton btnGestionarMesas = new JButton("Gestionar Mesas");
		btnGestionarMesas.setBounds(20, 476, 130, 130);
		pnl_Acciones.add(btnGestionarMesas);
		
		JButton btnGestionarSalon = new JButton("Gestionar Salon");
		btnGestionarSalon.setBounds(173, 476, 130, 130);
		pnl_Acciones.add(btnGestionarSalon);
		
		JButton btnMenu = new JButton("Gestionar Menu");
		btnMenu.setBounds(173, 335, 130, 130);
		pnl_Acciones.add(btnMenu);
		
		JButton btnGenerarControl = new JButton("Generar Control");
		btnGenerarControl.setBounds(173, 53, 130, 130);
		pnl_Acciones.add(btnGenerarControl);
		
		
	}
}