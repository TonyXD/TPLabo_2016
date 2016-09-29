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

import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;

public class AM_Plato extends JFrame {

	private JPanel contentPane;
	private JTextField txfNombre;
	private JTextField txfPrecio;
	
	private JComboBox<String> cbxTipoPlato;
	private JTable tblPlato;
	
	private JButton btnCargarPlato;
	private JButton btnEditarPlato;
	private JButton btnBorrarPlato;
	private JButton btnAgregarPlato;

	
	public AM_Plato() {

		setTitle("Gesti\u00F3n de Platos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 770);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 56, 464, 2);
		contentPane.add(separator);

		JLabel lblGestionDePlato = new JLabel("Gestion de Plato");
		lblGestionDePlato.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblGestionDePlato.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionDePlato.setBounds(10, 11, 464, 34);
		contentPane.add(lblGestionDePlato);

		JLabel lblTipoDePlato = new JLabel("Tipo de Plato");
		lblTipoDePlato.setBounds(10, 69, 80, 14);
		contentPane.add(lblTipoDePlato);

		cbxTipoPlato = new JComboBox<String>();
		cbxTipoPlato.setToolTipText("Elija el tipo de plato");
		cbxTipoPlato.setModel(new DefaultComboBoxModel(new String[] { "Entrada", "Principal", "Postre" }));
		cbxTipoPlato.setBounds(100, 66, 150, 20);
		contentPane.add(cbxTipoPlato);

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

		tblPlato = new JTable();
		scrollPane.setViewportView(tblPlato);
		tblPlato.setModel(
				new DefaultTableModel(new Object[][] { { null, null }, }, new String[] { "Nombre", "Precio" }));
		
		btnAgregarPlato = new JButton("Agregar Plato");
		btnAgregarPlato.setBounds(340, 698, 134, 23);
		contentPane.add(btnAgregarPlato);

		btnCargarPlato = new JButton("Cargar Tabla");
		btnCargarPlato.setBounds(340, 65, 134, 23);
		contentPane.add(btnCargarPlato);

		btnEditarPlato = new JButton("Editar Plato");
		btnEditarPlato.setBounds(376, 607, 98, 23);
		contentPane.add(btnEditarPlato);

		btnBorrarPlato = new JButton("Borrar Plato");
		btnBorrarPlato.setBounds(10, 607, 150, 23);
		contentPane.add(btnBorrarPlato);
	}
	
	public JTextField getNombre(){
		return this.txfNombre;
	}
	
	public JTextField getPrecio(){
		return this.txfPrecio;
	}
	
	public JButton getBtnAgregar(){
		return this.btnAgregarPlato;
	}
	
	public JButton getBtnCargar(){
		return this.btnCargarPlato;
	}
	
	public JButton getBtnEditar(){
		return this.btnEditarPlato;
	}
	
	public JButton getBtnBorrar(){
		return this.btnBorrarPlato;
	}

	public JComboBox<String> getCbxTipoPlato() {
		return cbxTipoPlato;
	}

	public void setCbxTipoPlato(JComboBox<String> cbxTipoPlato) {
		this.cbxTipoPlato = cbxTipoPlato;
	}
	
	public JTable getTablaPlato(){
		return this.tblPlato;
	}
}
