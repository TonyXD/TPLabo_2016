package Vistas.Vistas_AM;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Controllers.ABM_Menu_Controller;
import Controllers.GestorDeCarta_Controller;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Alta_Menu extends JFrame {

	private JPanel contentPane;
	
	private JTable tblEntrada;
	private JTable tblConAlcohol;
	private JTable tblSinAlcohol;
	private JTable tblCafe;
	private JTable tblMenu;
	private JTable tblPrincipal;
	private JTable tblPostre;
	
	private DefaultTableModel modelEntrada;
	private DefaultTableModel modelPrincipal;
	private DefaultTableModel modelPostre;
	private DefaultTableModel modelConAlcohol;
	private DefaultTableModel modelSinAlcohol;
	private DefaultTableModel modelCafe;
	private DefaultTableModel modelMenu;
	
	private JTabbedPane tbdPaneComidas;
	private JTabbedPane tbdPaneBebidas;
	
	private JButton btnAgregarAlMenu;
	private JButton btnQuitarDelMenu;
	private JButton btnCancelarMenu;
	private JButton btnCrearMenu;
	
	private  String[] nombreColumnas = {"Nombre", "Precio"};
	private JTextField txfNombre;
	private JTextField txfPrecio;
	
	public Alta_Menu(ABM_Menu_Controller padre) {
		setTitle("Alta de Menu");

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				padre.getVistaMenus().setEnabled(true);
				padre.inicializar();
			}
		});
		
		setResizable(false);
		setAlwaysOnTop(true);
		setForeground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Alta_Menu.class.getResource("/Imagenes/dishes-798316_1280.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1218, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 723, 725);
		contentPane.add(panel);
		panel.setLayout(null);
		
		tbdPaneComidas = new JTabbedPane(JTabbedPane.TOP);
		tbdPaneComidas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
//				tbdPaneBebidas.setSelectedIndex(-1);
				
			}
		});
		tbdPaneComidas.setBounds(10, 11, 703, 349);
		panel.add(tbdPaneComidas);
		
		JScrollPane scpEntrada = new JScrollPane();
		tbdPaneComidas.addTab("Entrada", null, scpEntrada, null);
		
		modelEntrada = new DefaultTableModel(null, this.nombreColumnas);
		tblEntrada =new JTable(modelEntrada);
		tblEntrada.getColumnModel().getColumn(0).setPreferredWidth(103);
		tblEntrada.getColumnModel().getColumn(0).setResizable(false);
		tblEntrada.getColumnModel().getColumn(1).setPreferredWidth(100);
		tblEntrada.getColumnModel().getColumn(1).setResizable(false);
		scpEntrada.setViewportView(tblEntrada);
		
		JScrollPane scrPrincipal = new JScrollPane();
		tbdPaneComidas.addTab("Principal", null, scrPrincipal, null);
		
		modelPrincipal = new DefaultTableModel(null, this.nombreColumnas);
		tblPrincipal = new JTable(modelPrincipal);
		tblPrincipal.getColumnModel().getColumn(0).setPreferredWidth(103);
		tblPrincipal.getColumnModel().getColumn(0).setResizable(false);
		tblPrincipal.getColumnModel().getColumn(1).setPreferredWidth(100);
		tblPrincipal.getColumnModel().getColumn(1).setResizable(false);
		scrPrincipal.setViewportView(tblPrincipal);
		
		JScrollPane scrPostre = new JScrollPane();
		tbdPaneComidas.addTab("Postre", null, scrPostre, null);
		
		modelPostre = new DefaultTableModel(null, this.nombreColumnas);
		tblPostre = new JTable(modelPostre);
		tblPostre.getColumnModel().getColumn(0).setPreferredWidth(103);
		tblPostre.getColumnModel().getColumn(0).setResizable(false);
		tblPostre.getColumnModel().getColumn(1).setPreferredWidth(100);
		tblPostre.getColumnModel().getColumn(1).setResizable(false);
		scrPostre.setViewportView(tblPostre);
		
		
		tbdPaneBebidas = new JTabbedPane(JTabbedPane.TOP);
		tbdPaneBebidas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
//				tbdPaneComidas.setSelectedIndex(-1);
			}
		});
		tbdPaneBebidas.setBounds(10, 370, 703, 344);
		panel.add(tbdPaneBebidas);
		
		JScrollPane scrConAlcohol = new JScrollPane();
		tbdPaneBebidas.addTab("Con Alcohol", null, scrConAlcohol, null);
		
		modelConAlcohol = new DefaultTableModel(null, this.nombreColumnas);
		tblConAlcohol = new JTable(modelConAlcohol);
		tblConAlcohol.getColumnModel().getColumn(0).setPreferredWidth(103);
		tblConAlcohol.getColumnModel().getColumn(0).setResizable(false);
		tblConAlcohol.getColumnModel().getColumn(1).setPreferredWidth(100);
		tblConAlcohol.getColumnModel().getColumn(1).setResizable(false);
		scrConAlcohol.setViewportView(tblConAlcohol);
		
		JScrollPane scrSinAlcohol = new JScrollPane();
		tbdPaneBebidas.addTab("Sin Alcohol", null, scrSinAlcohol, null);
		
		modelSinAlcohol = new DefaultTableModel(null, this.nombreColumnas);
		tblSinAlcohol = new JTable(modelSinAlcohol);
		tblSinAlcohol.getColumnModel().getColumn(0).setPreferredWidth(103);
		tblSinAlcohol.getColumnModel().getColumn(0).setResizable(false);
		tblSinAlcohol.getColumnModel().getColumn(1).setPreferredWidth(100);
		tblSinAlcohol.getColumnModel().getColumn(1).setResizable(false);
		scrSinAlcohol.setViewportView(tblSinAlcohol);
		
		JScrollPane scrCafe = new JScrollPane();
		tbdPaneBebidas.addTab("Cafeteria", null, scrCafe, null);
		
		modelCafe = new DefaultTableModel(null, this.nombreColumnas);
		tblCafe = new JTable(modelCafe);
		tblCafe.getColumnModel().getColumn(0).setPreferredWidth(103);
		tblCafe.getColumnModel().getColumn(0).setResizable(false);
		tblCafe.getColumnModel().getColumn(1).setPreferredWidth(100);
		tblCafe.getColumnModel().getColumn(1).setResizable(false);
		scrCafe.setViewportView(tblCafe);
		
		btnQuitarDelMenu = new JButton("<<");
		btnQuitarDelMenu.setBounds(743, 378, 89, 59);
		contentPane.add(btnQuitarDelMenu);
		
		btnAgregarAlMenu = new JButton(">>");
		btnAgregarAlMenu.setBounds(743, 308, 89, 59);
		contentPane.add(btnAgregarAlMenu);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Menu", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(844, 11, 354, 470);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrMenu = new JScrollPane();
		scrMenu.setBounds(6, 16, 338, 450);
		panel_1.add(scrMenu);
		
		modelMenu = new DefaultTableModel(null, this.nombreColumnas);
		tblMenu = new JTable(modelMenu);
		tblMenu.getColumnModel().getColumn(0).setPreferredWidth(103);
		tblMenu.getColumnModel().getColumn(0).setResizable(false);
		tblMenu.getColumnModel().getColumn(1).setPreferredWidth(100);
		tblMenu.getColumnModel().getColumn(1).setResizable(false);
		scrMenu.setViewportView(tblMenu);
		
		btnCrearMenu = new JButton("Crear");
		btnCrearMenu.setBounds(1109, 717, 89, 23);
		contentPane.add(btnCrearMenu);
		
		btnCancelarMenu = new JButton("Cancelar");
		btnCancelarMenu.setBounds(1010, 717, 89, 23);
		contentPane.add(btnCancelarMenu);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(844, 554, 79, 14);
		contentPane.add(lblNombre);
		
		txfNombre = new JTextField();
		txfNombre.setBounds(961, 551, 86, 20);
		contentPane.add(txfNombre);
		txfNombre.setColumns(10);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(844, 610, 79, 14);
		contentPane.add(lblPrecio);
		
		txfPrecio = new JTextField();
		txfPrecio.setColumns(10);
		txfPrecio.setBounds(961, 607, 86, 20);
		contentPane.add(txfPrecio);
	}

	public DefaultTableModel getModelEntrada() {
		return modelEntrada;
	}

	public void setModelEntrada(DefaultTableModel modelEntrada) {
		this.modelEntrada = modelEntrada;
	}

	public DefaultTableModel getModelPrincipal() {
		return modelPrincipal;
	}

	public void setModelPrincipal(DefaultTableModel modelPrincipal) {
		this.modelPrincipal = modelPrincipal;
	}

	public DefaultTableModel getModelPostre() {
		return modelPostre;
	}

	public void setModelPostre(DefaultTableModel modelPostre) {
		this.modelPostre = modelPostre;
	}

	public DefaultTableModel getModelBebida() {
		return modelConAlcohol;
	}

	public void setModelBebida(DefaultTableModel modelBebida) {
		this.modelConAlcohol = modelBebida;
	}

	public DefaultTableModel getModelMenu() {
		return modelMenu;
	}

	public void setModelMenu(DefaultTableModel modelMenu) {
		this.modelMenu = modelMenu;
	}

	public JButton getBtnAgregarAlMenu() {
		return btnAgregarAlMenu;
	}

	public void setBtnAgregarAlMenu(JButton btnAgregarAlMenu) {
		this.btnAgregarAlMenu = btnAgregarAlMenu;
	}

	public JButton getBtnQuitarDelMenu() {
		return btnQuitarDelMenu;
	}

	public void setBtnQuitarDelMenu(JButton btnQuitarDelMenu) {
		this.btnQuitarDelMenu = btnQuitarDelMenu;
	}

	public JTextField getTxfNombre() {
		return txfNombre;
	}

	public void setTxfNombre(JTextField txfNombre) {
		this.txfNombre = txfNombre;
	}

	public JTextField getTxfPrecio() {
		return txfPrecio;
	}

	public void setTxfPrecio(JTextField txfPrecio) {
		this.txfPrecio = txfPrecio;
	}

	public JButton getBtnCrearMenu() {
		return btnCrearMenu;
	}

	public void setBtnCrearMenu(JButton btnCrearMenu) {
		this.btnCrearMenu = btnCrearMenu;
	}

	public JButton getBtnCancelarMenu() {
		return btnCancelarMenu;
	}

	public void setBtnCancelarMenu(JButton btnCancelarMenu) {
		this.btnCancelarMenu = btnCancelarMenu;
	}

	public JTabbedPane getTbdPaneBebidas() {
		return tbdPaneBebidas;
	}

	public void setTbdPaneBebidas(JTabbedPane tbdPaneBebidas) {
		this.tbdPaneBebidas = tbdPaneBebidas;
	}

	public JTabbedPane getTbdPaneComidas() {
		return tbdPaneComidas;
	}

	public void setTbdPaneComidas(JTabbedPane tbdPaneComidas) {
		this.tbdPaneComidas = tbdPaneComidas;
	}

	public JTable getTblEntrada() {
		return tblEntrada;
	}

	public void setTblEntrada(JTable tblEntrada) {
		this.tblEntrada = tblEntrada;
	}

	public JTable getTblMenu() {
		return tblMenu;
	}

	public void setTblMenu(JTable tblMenu) {
		this.tblMenu = tblMenu;
	}

	public JTable getTblBebida() {
		return tblConAlcohol;
	}

	public void setTblBebida(JTable tblBebida) {
		this.tblConAlcohol = tblBebida;
	}

	public JTable getTblPrincipal() {
		return tblPrincipal;
	}

	public void setTblPrincipal(JTable tblPrincipal) {
		this.tblPrincipal = tblPrincipal;
	}

	public JTable getTblPostre() {
		return tblPostre;
	}

	public void setTblPostre(JTable tblPostre) {
		this.tblPostre = tblPostre;
	}

	public JTable getTblSinAlcohol() {
		return tblSinAlcohol;
	}

	public void setTblSinAlcohol(JTable tblSinAlcohol) {
		this.tblSinAlcohol = tblSinAlcohol;
	}

	public JTable getTblCafe() {
		return tblCafe;
	}

	public void setTblCafe(JTable tblCafe) {
		this.tblCafe = tblCafe;
	}

	public DefaultTableModel getModelSinAlcohol() {
		return modelSinAlcohol;
	}

	public void setModelSinAlcohol(DefaultTableModel modelSinAlcohol) {
		this.modelSinAlcohol = modelSinAlcohol;
	}

	public DefaultTableModel getModelCafe() {
		return modelCafe;
	}

	public void setModelCafe(DefaultTableModel modelCafe) {
		this.modelCafe = modelCafe;
	}
}
