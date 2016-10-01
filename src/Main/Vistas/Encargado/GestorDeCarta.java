package Vistas.Encargado;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JTabbedPane;
import java.awt.Dialog.ModalExclusionType;

public class GestorDeCarta extends JFrame {

	private JPanel contentPane;
	
	private JTable tblEntrada;
	private JTable tblPrincipal;
	private JTable tblPostre;
	private JTable tblConAlcohol;
	private JTable tblSinAlcohol;
	private JTable tblCafe;
	private JTable tblMenu;
	
	private DefaultTableModel modelEntrada;
	private DefaultTableModel modelPrincipal;
	private DefaultTableModel modelPostre;
	private DefaultTableModel modelConAlcohol;
	private DefaultTableModel modelSinAlcohol;
	private DefaultTableModel modelCafe;
	private DefaultTableModel modelMenu;
	
	private JButton btnGestionarPlatos;
	private JButton btnGestionarBebida;
	private JButton btnGestionarMenu;
	
	private  String[] nombreColumnas = {"Nombre", "Precio"};

	public GestorDeCarta() {
		setResizable(false);
		setAlwaysOnTop(true);
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setTitle("Carta");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(150, 10, 980, 623);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnGestionarPlatos = new JButton("Gestionar Plato");
		btnGestionarPlatos.setBounds(10, 11, 285, 43);
		contentPane.add(btnGestionarPlatos);

		btnGestionarBebida = new JButton("Gestionar Bebida");
		btnGestionarBebida.setBounds(320, 11, 285, 43);
		contentPane.add(btnGestionarBebida);

		btnGestionarMenu = new JButton("Gestionar Menu");
		btnGestionarMenu.setBounds(641, 11, 313, 43);
		contentPane.add(btnGestionarMenu);

		JTabbedPane tbdPlatos = new JTabbedPane(JTabbedPane.TOP);
		tbdPlatos.setBounds(10, 66, 285, 509);
		contentPane.add(tbdPlatos);

		JScrollPane scrEntrada = new JScrollPane();
		tbdPlatos.addTab("Entradas", null, scrEntrada, null);

		modelEntrada = new DefaultTableModel(null, this.nombreColumnas);
		tblEntrada =new JTable(modelEntrada);
		tblEntrada.getColumnModel().getColumn(0).setPreferredWidth(103);
		tblEntrada.getColumnModel().getColumn(0).setResizable(false);
		tblEntrada.getColumnModel().getColumn(1).setPreferredWidth(100);
		tblEntrada.getColumnModel().getColumn(1).setResizable(false);
		scrEntrada.setViewportView(tblEntrada);

		JScrollPane scrPrincipal = new JScrollPane();
		tbdPlatos.addTab("Principales", null, scrPrincipal, null);

		modelPrincipal = new DefaultTableModel(null, this.nombreColumnas);
		tblPrincipal = new JTable(modelPrincipal);
		tblPrincipal.getColumnModel().getColumn(0).setPreferredWidth(103);
		tblPrincipal.getColumnModel().getColumn(0).setResizable(false);
		tblPrincipal.getColumnModel().getColumn(1).setPreferredWidth(100);
		tblPrincipal.getColumnModel().getColumn(1).setResizable(false);
		scrPrincipal.setViewportView(tblPrincipal);

		JScrollPane scrPostre = new JScrollPane();
		tbdPlatos.addTab("Postres", null, scrPostre, null);

		modelPostre = new DefaultTableModel(null, this.nombreColumnas);
		tblPostre = new JTable(modelPostre);
		tblPostre.getColumnModel().getColumn(0).setPreferredWidth(103);
		tblPostre.getColumnModel().getColumn(0).setResizable(false);
		tblPostre.getColumnModel().getColumn(1).setPreferredWidth(100);
		tblPostre.getColumnModel().getColumn(1).setResizable(false);
		scrPostre.setViewportView(tblPostre);

		JTabbedPane tbdBebidas = new JTabbedPane(JTabbedPane.TOP);
		tbdBebidas.setBounds(320, 65, 298, 509);
		contentPane.add(tbdBebidas);

		JScrollPane scrConAlcohol = new JScrollPane();
		tbdBebidas.addTab("ConAlcohol", null, scrConAlcohol, null);

		modelConAlcohol = new DefaultTableModel(null, this.nombreColumnas);
		tblConAlcohol = new JTable(modelConAlcohol);
		tblConAlcohol.getColumnModel().getColumn(0).setPreferredWidth(103);
		tblConAlcohol.getColumnModel().getColumn(0).setResizable(false);
		tblConAlcohol.getColumnModel().getColumn(1).setPreferredWidth(100);
		tblConAlcohol.getColumnModel().getColumn(1).setResizable(false);
		scrConAlcohol.setViewportView(tblConAlcohol);
		
		JScrollPane scrSinAlcohol = new JScrollPane();
		tbdBebidas.addTab("SinAlcohol", null, scrSinAlcohol, null);

		modelSinAlcohol = new DefaultTableModel(null, this.nombreColumnas);
		tblSinAlcohol = new JTable(modelSinAlcohol);
		tblSinAlcohol.getColumnModel().getColumn(0).setPreferredWidth(103);
		tblSinAlcohol.getColumnModel().getColumn(0).setResizable(false);
		tblSinAlcohol.getColumnModel().getColumn(1).setPreferredWidth(100);
		tblSinAlcohol.getColumnModel().getColumn(1).setResizable(false);
		scrSinAlcohol.setViewportView(tblSinAlcohol);

		JScrollPane scrCafe = new JScrollPane();
		tbdBebidas.addTab("Cafeteria", null, scrCafe, null);

		modelCafe = new DefaultTableModel(null, this.nombreColumnas);
		tblCafe = new JTable(modelCafe);
		tblCafe.getColumnModel().getColumn(0).setPreferredWidth(103);
		tblCafe.getColumnModel().getColumn(0).setResizable(false);
		tblCafe.getColumnModel().getColumn(1).setPreferredWidth(100);
		tblCafe.getColumnModel().getColumn(1).setResizable(false);
		scrCafe.setViewportView(tblCafe);

		JPanel pnlMenu = new JPanel();
		pnlMenu.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Men\u00FAs", TitledBorder.CENTER,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlMenu.setBounds(641, 65, 319, 508);
		contentPane.add(pnlMenu);
		pnlMenu.setLayout(null);

		JScrollPane scrMenu = new JScrollPane();
		scrMenu.setBounds(6, 26, 307, 471);
		pnlMenu.add(scrMenu);

		modelMenu = new DefaultTableModel(null, this.nombreColumnas);
		tblMenu = new JTable(modelMenu);
		tblMenu.getColumnModel().getColumn(0).setPreferredWidth(103);
		tblMenu.getColumnModel().getColumn(0).setResizable(false);
		tblMenu.getColumnModel().getColumn(1).setPreferredWidth(100);
		tblMenu.getColumnModel().getColumn(1).setResizable(false);
		scrMenu.setViewportView(tblMenu);
	}

	public JButton getBtnGestionarMenu() {
		return btnGestionarMenu;
	}

	public void setBtnGestionarMenu(JButton btnGestionarMenu) {
		this.btnGestionarMenu = btnGestionarMenu;
	}

	public JButton getBtnGestionarPlatos() {
		return btnGestionarPlatos;
	}

	public void setBtnGestionarPlatos(JButton btnGestionarPlatos) {
		this.btnGestionarPlatos = btnGestionarPlatos;
	}

	public JButton getBtnGestionarBebida() {
		return btnGestionarBebida;
	}

	public void setBtnGestionarBebida(JButton btnGestionarBebida) {
		this.btnGestionarBebida = btnGestionarBebida;
	}

	public JTable getTblEntrada() {
		return tblEntrada;
	}

	public void setTblEntrada(JTable tblEntrada) {
		this.tblEntrada = tblEntrada;
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

	public JTable getTblConALcohol() {
		return tblConAlcohol;
	}

	public void setTblConALcohol(JTable tblConALcohol) {
		this.tblConAlcohol = tblConALcohol;
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

	public JTable getTblMenu() {
		return tblMenu;
	}

	public void setTblMenu(JTable tblMenu) {
		this.tblMenu = tblMenu;
	}

	public String[] getNombreColumnas() {
		return nombreColumnas;
	}

	public void setNombreColumnas(String[] nombreColumnas) {
		this.nombreColumnas = nombreColumnas;
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

	public DefaultTableModel getModelMenu() {
		return modelMenu;
	}

	public void setModelMenu(DefaultTableModel modelMenu) {
		this.modelMenu = modelMenu;
	}

	public DefaultTableModel getModelConAlcohol() {
		return modelConAlcohol;
	}

	public void setModelConAlcohol(DefaultTableModel modelConAlcohol) {
		this.modelConAlcohol = modelConAlcohol;
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
