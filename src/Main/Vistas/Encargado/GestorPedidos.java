package Vistas.Encargado;

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

public class GestorPedidos
extends JFrame {

	private JPanel contentPane;
	
	private JTable tblPedido;
	private DefaultTableModel modelPedido;
	private  String[] nombreColumnas = {"N° Mesa", "Capacidad", "Piso", "Sector", "Estado Mesa", "Hora Apertura", "Estado Pedido"};
	
	private JButton btnPedido;
	private JButton btnModfEstado;
	private JButton btnVerDetalle;
	private JButton btnGenCtrl;
	private JButton btnTicket;
	private JButton btnAsignarMesa;

	public GestorPedidos() {
		setResizable(false);
		setAlwaysOnTop(true);
		setTitle("Gestor de Pedidos");
//		setIconImage(Toolkit.getDefaultToolkit().getImage(GestorMesas.class.getResource("/Imagenes/dishes-798316_1280.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		
		btnPedido = new JButton("Pedido");
		btnPedido.setBounds(151, 11, 130, 40);
		panel.add(btnPedido);
		
		btnModfEstado = new JButton("Modf. Estado");
		btnModfEstado.setBounds(291, 11, 130, 40);
		panel.add(btnModfEstado);
		
		btnVerDetalle = new JButton("Ver Detalle");
		btnVerDetalle.setBounds(429, 11, 130, 40);
		panel.add(btnVerDetalle);
		
		btnGenCtrl = new JButton("Generar Control");
		btnGenCtrl.setBounds(569, 11, 130, 40);
		panel.add(btnGenCtrl);
		
		btnTicket = new JButton("Ticket");
		btnTicket.setBounds(709, 11, 130, 40);
		panel.add(btnTicket);
		
		btnAsignarMesa = new JButton("Asignar Mesa");
		btnAsignarMesa.setBounds(10, 11, 130, 40);
		panel.add(btnAsignarMesa);
		
		JScrollPane scrPane = new JScrollPane();
		scrPane.setBounds(10, 89, 845, 377);
		contentPane.add(scrPane);
		
		modelPedido = new DefaultTableModel(null, this.nombreColumnas);
		tblPedido = new JTable(modelPedido);
		tblPedido.getColumnModel().getColumn(0).setPreferredWidth(103);
		tblPedido.getColumnModel().getColumn(0).setResizable(false);
		tblPedido.getColumnModel().getColumn(1).setPreferredWidth(100);
		tblPedido.getColumnModel().getColumn(1).setResizable(false);
		scrPane.setViewportView(tblPedido);
	}

	public JButton getBtnPedido() {
		return btnPedido;
	}

	public void setBtnPedido(JButton btnPedido) {
		this.btnPedido = btnPedido;
	}

	public JButton getBtnModfEstado() {
		return btnModfEstado;
	}

	public void setBtnModfEstado(JButton btnModfEstado) {
		this.btnModfEstado = btnModfEstado;
	}

	public JButton getBtnVerDetalle() {
		return btnVerDetalle;
	}

	public void setBtnVerDetalle(JButton btnVerDetalle) {
		this.btnVerDetalle = btnVerDetalle;
	}

	public JButton getBtnGenCtrl() {
		return btnGenCtrl;
	}

	public void setBtnGenCtrl(JButton btnGenCtrl) {
		this.btnGenCtrl = btnGenCtrl;
	}

	public JButton getBtnTicket() {
		return btnTicket;
	}

	public void setBtnTicket(JButton btnTicket) {
		this.btnTicket = btnTicket;
	}

	public JButton getBtnAsignarMesa() {
		return btnAsignarMesa;
	}

	public void setBtnAsignarMesa(JButton btnAsignarMesa) {
		this.btnAsignarMesa = btnAsignarMesa;
	}

	public DefaultTableModel getModelPedido() {
		return modelPedido;
	}

	public void setModelPedido(DefaultTableModel modelPedido) {
		this.modelPedido = modelPedido;
	}

	public String[] getNombreColumnas() {
		return nombreColumnas;
	}

	public void setNombreColumnas(String[] nombreColumnas) {
		this.nombreColumnas = nombreColumnas;
	}

	public JTable getTblPedido() {
		return tblPedido;
	}

	public void setTblPedido(JTable tblPedido) {
		this.tblPedido = tblPedido;
	}
}
