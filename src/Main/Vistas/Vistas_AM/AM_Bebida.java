package Vistas.Vistas_AM;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controllers.AM_Bebida_Controller;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;

public class AM_Bebida extends JFrame {

	private JPanel contentPane;
	private JTextField txfNombre;
	private JTextField txfPrecio;
	
	private JComboBox<String> cbxTipoBebida;
	private JTable tblBebidas;

	private JButton btnCargar;
	private JButton btnEditarBebida;
	private JButton btnBorrarBebida;
	private JButton btnAgregarBebida;

	private AM_Bebida_Controller controlador;

	public AM_Bebida(AM_Bebida_Controller controlador) {

		setTitle("Gestion de Bebidas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		lblNombre.setBounds(10, 657, 80, 14);
		contentPane.add(lblNombre);

		txfNombre = new JTextField();
		txfNombre.setBounds(81, 654, 150, 20);
		contentPane.add(txfNombre);
		txfNombre.setColumns(10);

		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(255, 657, 46, 14);
		contentPane.add(lblPrecio);

		txfPrecio = new JTextField();
		txfPrecio.setBounds(324, 654, 150, 20);
		contentPane.add(txfPrecio);
		txfPrecio.setColumns(10);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 685, 464, 2);
		contentPane.add(separator_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 641, 464, 2);
		contentPane.add(separator_2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 100, 464, 496);
		contentPane.add(scrollPane);

		tblBebidas = new JTable();
		scrollPane.setViewportView(tblBebidas);
		tblBebidas.setModel(
				new DefaultTableModel(new Object[][] { { null, null }, }, new String[] { "Nombre", "Precio" }));

		this.controlador = controlador;

		btnAgregarBebida = new JButton("Agregar Bebida");
		btnAgregarBebida.setBounds(324, 698, 150, 23);
		btnAgregarBebida.addActionListener(this.controlador);
		contentPane.add(btnAgregarBebida);

		btnCargar = new JButton("Cargar Tabla");
		btnCargar.setBounds(340, 65, 134, 23);
		btnCargar.addActionListener(this.controlador);
		contentPane.add(btnCargar);

		btnEditarBebida = new JButton("Editar Bebida");
		btnEditarBebida.setBounds(324, 607, 150, 23);
		btnEditarBebida.addActionListener(this.controlador);
		contentPane.add(btnEditarBebida);

		btnBorrarBebida = new JButton("Borrar Bebida");
		btnBorrarBebida.setBounds(10, 607, 150, 23);
		btnBorrarBebida.addActionListener(this.controlador);
		contentPane.add(btnBorrarBebida);
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
}
