package Vistas.Vistas_AM;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controllers.ABM_Bebida_Controller;
import Controllers.GestorDeCarta_Controller;
import Vistas.Encargado.GestorDeCarta;

import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;

public class ABM_Bebida extends JFrame {

	private JPanel contentPane;
	private JTextField txfNombre;
	private JTextField txfPrecio;
	
	private JComboBox<String> cbxTipoBebida;
	
	private JTable tblBebidas;
	private DefaultTableModel modelBebida;

	private JButton btnCargar;
	private JButton btnEditarBebida;
	private JButton btnBorrarBebida;
	private JButton btnAgregarBebida;

	private  String[] nombreColumnas = {"Nombre", "Precio"};
	private JLabel lblBebidaSeleccionada;
	private JLabel label;
	private JTextField txfNombreSe;
	private JLabel label_1;
	private JTextField txfPrecioSe;
	private JLabel label_2;

	public ABM_Bebida(GestorDeCarta_Controller padre) {

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				padre.getVistaCarta().setEnabled(true);
				padre.inicializar();
			}
		});
		
		setAlwaysOnTop(true);
		setResizable(false);
		
		setTitle("Gestion de Bebidas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 770);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 56, 464, 2);
		contentPane.add(separator);

		JLabel lblGestionDePlato = new JLabel("Gestion de Bebida");
		lblGestionDePlato.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblGestionDePlato.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionDePlato.setBounds(10, 11, 464, 34);
		contentPane.add(lblGestionDePlato);

		JLabel lblTipoDePlato = new JLabel("Tipo de Bebida");
		lblTipoDePlato.setBounds(10, 69, 80, 14);
		contentPane.add(lblTipoDePlato);

		cbxTipoBebida = new JComboBox<String>();
		cbxTipoBebida.setModel(new DefaultComboBoxModel(new String[] { "Sin Alcohol", "Con Alcohol", "Cafe" }));
		cbxTipoBebida.setBounds(110, 66, 150, 20);
		contentPane.add(cbxTipoBebida);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 672, 80, 14);
		contentPane.add(lblNombre);

		txfNombre = new JTextField();
		txfNombre.setBounds(81, 669, 150, 20);
		contentPane.add(txfNombre);
		txfNombre.setColumns(10);

		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(255, 672, 46, 14);
		contentPane.add(lblPrecio);

		txfPrecio = new JTextField();
		txfPrecio.setBounds(324, 669, 150, 20);
		contentPane.add(txfPrecio);
		txfPrecio.setColumns(10);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 611, 464, 2);
		contentPane.add(separator_2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 100, 464, 393);
		contentPane.add(scrollPane);

		modelBebida = new DefaultTableModel(null, new String[] { "Nombre", "Precio" });
		tblBebidas = new JTable(modelBebida);
		tblBebidas.getColumnModel().getColumn(0).setPreferredWidth(103);
		tblBebidas.getColumnModel().getColumn(0).setResizable(false);
		tblBebidas.getColumnModel().getColumn(1).setPreferredWidth(100);
		tblBebidas.getColumnModel().getColumn(1).setResizable(false);
		
		scrollPane.setViewportView(tblBebidas);

		btnAgregarBebida = new JButton("Agregar Bebida");
		btnAgregarBebida.setBounds(324, 697, 150, 23);
		contentPane.add(btnAgregarBebida);

		btnCargar = new JButton("Cargar Tabla");
		btnCargar.setBounds(340, 65, 134, 23);
		contentPane.add(btnCargar);

		btnEditarBebida = new JButton("Editar Bebida");
		btnEditarBebida.setBounds(324, 577, 150, 23);
		contentPane.add(btnEditarBebida);

		btnBorrarBebida = new JButton("Borrar Bebida");
		btnBorrarBebida.setBounds(10, 577, 150, 23);
		contentPane.add(btnBorrarBebida);
		
		lblBebidaSeleccionada = new JLabel("Bebida Seleccionada:");
		lblBebidaSeleccionada.setHorizontalAlignment(SwingConstants.LEFT);
		lblBebidaSeleccionada.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblBebidaSeleccionada.setBounds(10, 504, 221, 34);
		contentPane.add(lblBebidaSeleccionada);
		
		label = new JLabel("Nombre");
		label.setBounds(10, 552, 80, 14);
		contentPane.add(label);
		
		txfNombreSe = new JTextField();
		txfNombreSe.setColumns(10);
		txfNombreSe.setBounds(81, 549, 150, 20);
		contentPane.add(txfNombreSe);
		
		label_1 = new JLabel("Precio");
		label_1.setBounds(255, 552, 46, 14);
		contentPane.add(label_1);
		
		txfPrecioSe = new JTextField();
		txfPrecioSe.setColumns(10);
		txfPrecioSe.setBounds(324, 549, 150, 20);
		contentPane.add(txfPrecioSe);
		
		label_2 = new JLabel("Bebida Seleccionada:");
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		label_2.setBounds(10, 624, 221, 34);
		contentPane.add(label_2);
	}
	
	public JTextField getNombre(){
		return this.txfNombre;
	}
	
	public JTextField getPrecio(){
		return this.txfPrecio;
	}
	
	public JButton getBtnCargar() {
		return btnCargar;
	}

	public void setBtnCargar(JButton btnCargar) {
		this.btnCargar = btnCargar;
	}

	public JButton getBtnEditarBebida() {
		return btnEditarBebida;
	}

	public void setBtnEditarBebida(JButton btnEditarBebida) {
		this.btnEditarBebida = btnEditarBebida;
	}

	public JButton getBtnBorrarBebida() {
		return btnBorrarBebida;
	}

	public void setBtnBorrarBebida(JButton btnBorrarBebida) {
		this.btnBorrarBebida = btnBorrarBebida;
	}

	public JButton getBtnAgregarBebida() {
		return btnAgregarBebida;
	}

	public void setBtnAgregarBebida(JButton btnAgregarBebida) {
		this.btnAgregarBebida = btnAgregarBebida;
	}

	public JComboBox<String> getCbxTipoBebidas() {
		return cbxTipoBebida;
	}
	
	public void setCbxTipoBebidas(JComboBox<String> cbxTipoBebidas) {
		this.cbxTipoBebida = cbxTipoBebidas;
	}
	
	public JTable getTablaBebida(){
		return this.tblBebidas;
	}

	public String[] getNombreColumnas() {
		return nombreColumnas;
	}

	public void setNombreColumnas(String[] nombreColumnas) {
		this.nombreColumnas = nombreColumnas;
	}

	public DefaultTableModel getModelPersonas() {
		return modelBebida;
	}

	public void setModelPersonas(DefaultTableModel modelPersonas) {
		this.modelBebida = modelPersonas;
	}

	public JTextField getTxfNombreSe() {
		return txfNombreSe;
	}

	public void setTxfNombreSe(JTextField txfNombreSe) {
		this.txfNombreSe = txfNombreSe;
	}

	public JTextField getTxfPrecioSe() {
		return txfPrecioSe;
	}

	public void setTxfPrecioSe(JTextField txfPrecioSe) {
		this.txfPrecioSe = txfPrecioSe;
	}
}
