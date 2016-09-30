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

public class ABM_Plato extends JFrame {

	private JPanel contentPane;
	private JTextField txfNombre;
	private JTextField txfPrecio;
	
	private JComboBox<String> cbxTipoPlato;
	
	private JTable tblPlato;
	private DefaultTableModel modelPersonas;
	
	private JButton btnCargarPlato;
	private JButton btnEditarPlato;
	private JButton btnBorrarPlato;
	private JButton btnAgregarPlato;
	
	private  String[] nombreColumnas = {"Nombre", "Precio"};
	private JTextField txfNombreSe;
	private JTextField txfPrecioSe;

	
	public ABM_Plato() {

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
		
		modelPersonas = new DefaultTableModel(null, this.nombreColumnas);
		tblPlato = new JTable(modelPersonas);
		tblPlato.getColumnModel().getColumn(0).setPreferredWidth(103);
		tblPlato.getColumnModel().getColumn(0).setResizable(false);
		tblPlato.getColumnModel().getColumn(1).setPreferredWidth(100);
		tblPlato.getColumnModel().getColumn(1).setResizable(false);
		scrollPane.setViewportView(tblPlato);
		
		tblPlato.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		        int row = tblPlato.rowAtPoint(evt.getPoint());
		        int col = tblPlato.columnAtPoint(evt.getPoint());
		        if (row >= 0 && col >= 0) {
		        	txfNombreSe.setText((String) tblPlato.getValueAt(row, 0));
		        	txfPrecioSe.setText((String) tblPlato.getValueAt(row, 1));
		        }
		    }
		});
		
		btnAgregarPlato = new JButton("Agregar Plato");
		btnAgregarPlato.setBounds(340, 697, 134, 23);
		contentPane.add(btnAgregarPlato);

		btnCargarPlato = new JButton("Cargar Tabla");
		btnCargarPlato.setBounds(340, 65, 134, 23);
		contentPane.add(btnCargarPlato);

		btnEditarPlato = new JButton("Editar Plato");
		btnEditarPlato.setBounds(340, 577, 134, 23);
		contentPane.add(btnEditarPlato);

		btnBorrarPlato = new JButton("Borrar Plato");
		btnBorrarPlato.setBounds(10, 577, 150, 23);
		contentPane.add(btnBorrarPlato);
		
		JLabel lblPlatoSeleccionado = new JLabel("Plato Seleccionado:");
		lblPlatoSeleccionado.setHorizontalAlignment(SwingConstants.LEFT);
		lblPlatoSeleccionado.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblPlatoSeleccionado.setBounds(10, 504, 221, 34);
		contentPane.add(lblPlatoSeleccionado);
		
		JLabel label = new JLabel("Nombre");
		label.setBounds(10, 552, 80, 14);
		contentPane.add(label);
		
		txfNombreSe = new JTextField();
		txfNombreSe.setColumns(10);
		txfNombreSe.setBounds(81, 549, 150, 20);
		contentPane.add(txfNombreSe);
		
		JLabel label_1 = new JLabel("Precio");
		label_1.setBounds(255, 552, 46, 14);
		contentPane.add(label_1);
		
		txfPrecioSe = new JTextField();
		txfPrecioSe.setColumns(10);
		txfPrecioSe.setBounds(324, 549, 150, 20);
		contentPane.add(txfPrecioSe);
		
		JLabel lblPlatoNuevo = new JLabel("Plato Nuevo:");
		lblPlatoNuevo.setHorizontalAlignment(SwingConstants.LEFT);
		lblPlatoNuevo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblPlatoNuevo.setBounds(10, 624, 221, 34);
		contentPane.add(lblPlatoNuevo);
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

	public DefaultTableModel getModelPersonas() {
		return modelPersonas;
	}

	public void setModelPersonas(DefaultTableModel modelPersonas) {
		this.modelPersonas = modelPersonas;
	}

	public JTable getTabla() {
		return tblPlato;
	}

	public void setTabla(JTable tabla) {
		this.tblPlato = tabla;
	}

	public String[] getNombreColumnas() {
		return nombreColumnas;
	}

	public void setNombreColumnas(String[] nombreColumnas) {
		this.nombreColumnas = nombreColumnas;
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
