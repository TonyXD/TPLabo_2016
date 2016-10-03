package Vistas.Vistas_AM;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controllers.GestorDeCarta_Controller;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ABM_Menus extends JFrame {

	private JPanel contentPane;
	
	private JTable tblMenu;
	private DefaultTableModel modelMenus;
	private  String[] nombreColumnas = {"Nombre", "Precio"};
	
	
	private JButton btnEliminar;
	private JButton btnEditar;
	private JButton btnAgregar;

	
	public ABM_Menus(GestorDeCarta_Controller padre) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				
				padre.getVistaCarta().setEnabled(true);
				padre.inicializar();
			}
		});
		setTitle("Administracion de Menus");
//		setIconImage(Toolkit.getDefaultToolkit().getImage(ABM_Menus.class.getResource("/Main/Imagenes/dishes-798316_1280.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 561);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSeleccionDeMenu = new JLabel("Selecci\u00F3n de Menu");
		lblSeleccionDeMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccionDeMenu.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblSeleccionDeMenu.setBounds(0, 0, 484, 44);
		contentPane.add(lblSeleccionDeMenu);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 55, 464, 2);
		contentPane.add(separator);
		
		JScrollPane scrPaneMenus = new JScrollPane();
		scrPaneMenus.setBounds(10, 74, 464, 394);
		contentPane.add(scrPaneMenus);
		
		modelMenus = new DefaultTableModel(null, this.nombreColumnas);
		tblMenu = new JTable(modelMenus);
		tblMenu.getColumnModel().getColumn(0).setPreferredWidth(103);
		tblMenu.getColumnModel().getColumn(0).setResizable(false);
		tblMenu.getColumnModel().getColumn(1).setPreferredWidth(100);
		tblMenu.getColumnModel().getColumn(1).setResizable(false);
		scrPaneMenus.setViewportView(tblMenu);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(187, 479, 89, 23);
		contentPane.add(btnEliminar);
	
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(385, 479, 89, 23);
		contentPane.add(btnAgregar);
		
		btnEditar = new JButton("Editar");
		btnEditar.setBounds(286, 479, 89, 23);
		contentPane.add(btnEditar);
	}


	public JTable getTblMenu() {
		return tblMenu;
	}


	public void setTblMenu(JTable tblMenu) {
		this.tblMenu = tblMenu;
	}


	public JButton getBtnEditar() {
		return btnEditar;
	}


	public void setBtnEditar(JButton btnEditar) {
		this.btnEditar = btnEditar;
	}


	public JButton getBtnAgregar() {
		return btnAgregar;
	}


	public void setBtnAgregar(JButton btnAgregar) {
		this.btnAgregar = btnAgregar;
	}


	public JButton getBtnEliminar() {
		return btnEliminar;
	}


	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}


	public DefaultTableModel getModelMenus() {
		return modelMenus;
	}


	public void setModelMenus(DefaultTableModel modelMenus) {
		this.modelMenus = modelMenus;
	}


	public String[] getNombreColumnas() {
		return nombreColumnas;
	}


	public void setNombreColumnas(String[] nombreColumnas) {
		this.nombreColumnas = nombreColumnas;
	}
}
