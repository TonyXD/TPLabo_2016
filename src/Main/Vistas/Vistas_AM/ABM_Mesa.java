package Vistas.Vistas_AM;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ABM_Mesa extends JFrame {

	private JPanel contentPane;
	private JTable tblMenus;
	private DefaultTableModel modelMenus;
	
	private JTextField txfNumeroEd;
	private JTextField txfSectorEd;
	private JTextField txtNumero;
	private JTextField txfSector;

	private JSpinner spnPiso;
	private JSpinner spnPisoEd;
	private JSpinner spnCapacidad;
	private JSpinner spnCapacidadEd;

	private JButton btnAgregar;
	private JButton btnEliminar;
	private JButton btnEditar;

	private String[] nombreColumnas = { "N° Mesa", "Capacidad", "Piso", "Sector" };

	public ABM_Mesa() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
			}
		});
		setTitle("Administracion de Mesas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 687);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblGestionarMesas = new JLabel("Gestionar Mesas");
		lblGestionarMesas.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionarMesas.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblGestionarMesas.setBounds(10, 0, 464, 51);
		contentPane.add(lblGestionarMesas);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 46, 464, 2);
		contentPane.add(separator);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 62, 464, 256);
		contentPane.add(scrollPane);

		modelMenus = new DefaultTableModel(null, this.nombreColumnas);
		tblMenus = new JTable(modelMenus);
		tblMenus.getColumnModel().getColumn(0).setPreferredWidth(103);
		tblMenus.getColumnModel().getColumn(0).setResizable(false);
		tblMenus.getColumnModel().getColumn(1).setPreferredWidth(100);
		tblMenus.getColumnModel().getColumn(1).setResizable(false);
		scrollPane.setViewportView(tblMenus);

		JLabel lblAgregar = new JLabel("Mesa Seleccionada");
		lblAgregar.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgregar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblAgregar.setBounds(10, 329, 464, 33);
		contentPane.add(lblAgregar);

		JLabel lblCapacidad = new JLabel("Capacidad");
		lblCapacidad.setBounds(10, 406, 65, 22);
		contentPane.add(lblCapacidad);

		JLabel lblPiso = new JLabel("Piso");
		lblPiso.setBounds(210, 376, 46, 14);
		contentPane.add(lblPiso);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 497, 464, 2);
		contentPane.add(separator_1);

		JLabel lblModificar = new JLabel("Agregar");
		lblModificar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblModificar.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificar.setBounds(10, 510, 464, 33);
		contentPane.add(lblModificar);

		JLabel label_1 = new JLabel("Capacidad");
		label_1.setBounds(10, 587, 65, 22);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("Piso");
		label_2.setBounds(210, 557, 46, 14);
		contentPane.add(label_2);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(261, 463, 89, 23);
		contentPane.add(btnEliminar);

		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(385, 607, 89, 23);
		contentPane.add(btnAgregar);

		btnEditar = new JButton("Editar");
		btnEditar.setBounds(385, 463, 89, 23);
		contentPane.add(btnEditar);

		spnCapacidadEd = new JSpinner();
		spnCapacidadEd.setBounds(85, 407, 65, 20);
		contentPane.add(spnCapacidadEd);

		spnPisoEd = new JSpinner();
		spnPisoEd.setBounds(285, 373, 65, 20);
		contentPane.add(spnPisoEd);

		spnCapacidad = new JSpinner();
		spnCapacidad.setBounds(85, 588, 65, 20);
		contentPane.add(spnCapacidad);

		spnPiso = new JSpinner();
		spnPiso.setBounds(285, 554, 65, 20);
		contentPane.add(spnPiso);

		JLabel lblNumero = new JLabel("Numero");
		lblNumero.setBounds(10, 373, 65, 22);
		contentPane.add(lblNumero);

		txfNumeroEd = new JTextField();
		txfNumeroEd.setBounds(85, 373, 65, 20);
		contentPane.add(txfNumeroEd);
		txfNumeroEd.setColumns(10);

		JLabel lblSector = new JLabel("Sector");
		lblSector.setBounds(210, 406, 65, 22);
		contentPane.add(lblSector);

		txfSectorEd = new JTextField();
		txfSectorEd.setColumns(10);
		txfSectorEd.setBounds(285, 406, 65, 20);
		contentPane.add(txfSectorEd);

		JLabel label = new JLabel("Numero");
		label.setBounds(10, 554, 65, 22);
		contentPane.add(label);

		txtNumero = new JTextField();
		txtNumero.setColumns(10);
		txtNumero.setBounds(85, 554, 65, 20);
		contentPane.add(txtNumero);

		JLabel lblSector_1 = new JLabel("Sector");
		lblSector_1.setBounds(210, 587, 65, 22);
		contentPane.add(lblSector_1);

		txfSector = new JTextField();
		txfSector.setColumns(10);
		txfSector.setBounds(285, 587, 65, 20);
		contentPane.add(txfSector);
	}

	public JSpinner getSpnPiso() {
		return spnPiso;
	}

	public void setSpnPiso(JSpinner spnPiso) {
		this.spnPiso = spnPiso;
	}

	public JSpinner getSpnPisoEd() {
		return spnPisoEd;
	}

	public void setSpnPisoEd(JSpinner spnPisoEd) {
		this.spnPisoEd = spnPisoEd;
	}

	public JSpinner getSpnCapacidad() {
		return spnCapacidad;
	}

	public void setSpnCapacidad(JSpinner spnCapacidad) {
		this.spnCapacidad = spnCapacidad;
	}

	public JSpinner getSpnCapacidadEd() {
		return spnCapacidadEd;
	}

	public void setSpnCapacidadEd(JSpinner spnCapacidadEd) {
		this.spnCapacidadEd = spnCapacidadEd;
	}

	public JButton getBtnAgregar() {
		return btnAgregar;
	}

	public void setBtnAgregar(JButton btnAgregar) {
		this.btnAgregar = btnAgregar;
	}

	public JButton getBtnEditar() {
		return btnEditar;
	}

	public void setBtnEditar(JButton btnEditar) {
		this.btnEditar = btnEditar;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}

	public String[] getNombreColumnas() {
		return nombreColumnas;
	}

	public void setNombreColumnas(String[] nombreColumnas) {
		this.nombreColumnas = nombreColumnas;
	}

	public DefaultTableModel getModelMenus() {
		return modelMenus;
	}

	public void setModelMenus(DefaultTableModel modelMenus) {
		this.modelMenus = modelMenus;
	}

	public JTable getTable() {
		return tblMenus;
	}

	public void setTable(JTable table) {
		this.tblMenus = table;
	}

	public JTextField getTxfNumeroEd() {
		return txfNumeroEd;
	}

	public void setTxfNumeroEd(JTextField txfNumeroEd) {
		this.txfNumeroEd = txfNumeroEd;
	}

	public JTextField getTxfSectorEd() {
		return txfSectorEd;
	}

	public void setTxfSectorEd(JTextField txfSectorEd) {
		this.txfSectorEd = txfSectorEd;
	}

	public JTextField getTxtNumero() {
		return txtNumero;
	}

	public void setTxtNumero(JTextField txtNumero) {
		this.txtNumero = txtNumero;
	}

	public JTextField getTxfSector() {
		return txfSector;
	}

	public void setTxfSector(JTextField txfSector) {
		this.txfSector = txfSector;
	}
}
