package Vistas.Vistas_AM;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ABM_Mercaderia extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ABM_Mercaderia frame = new ABM_Mercaderia();
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
	public ABM_Mercaderia() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 785);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGestorDeMercaderia = new JLabel("Gestor de Mercaderia");
		lblGestorDeMercaderia.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestorDeMercaderia.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblGestorDeMercaderia.setBounds(10, 11, 464, 38);
		contentPane.add(lblGestorDeMercaderia);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 48, 464, 2);
		contentPane.add(separator);
		
		JLabel lblTipoMercaderia = new JLabel("Tipo Mercaderia");
		lblTipoMercaderia.setBounds(10, 75, 89, 19);
		contentPane.add(lblTipoMercaderia);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(109, 74, 130, 20);
		contentPane.add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 105, 464, 400);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblMercaderiaSeleccionada = new JLabel("Mercaderia Seleccionada");
		lblMercaderiaSeleccionada.setHorizontalAlignment(SwingConstants.CENTER);
		lblMercaderiaSeleccionada.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblMercaderiaSeleccionada.setBounds(10, 520, 464, 26);
		contentPane.add(lblMercaderiaSeleccionada);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 564, 46, 14);
		contentPane.add(lblNombre);
		
		textField = new JTextField();
		textField.setBounds(61, 561, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(156, 564, 46, 14);
		contentPane.add(lblPrecio);
		
		textField_1 = new JTextField();
		textField_1.setBounds(207, 561, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblProveedor = new JLabel("Proveedor");
		lblProveedor.setBounds(299, 564, 62, 14);
		contentPane.add(lblProveedor);
		
		textField_2 = new JTextField();
		textField_2.setBounds(376, 561, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(376, 592, 89, 23);
		contentPane.add(btnEliminar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(272, 592, 89, 23);
		contentPane.add(btnEditar);
		
		JLabel lblAgregarMercaderia = new JLabel("Agregar Mercaderia");
		lblAgregarMercaderia.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgregarMercaderia.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblAgregarMercaderia.setBounds(10, 641, 464, 26);
		contentPane.add(lblAgregarMercaderia);
		
		JLabel label_1 = new JLabel("Nombre");
		label_1.setBounds(10, 685, 46, 14);
		contentPane.add(label_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(61, 682, 86, 20);
		contentPane.add(textField_3);
		
		JLabel label_2 = new JLabel("Precio");
		label_2.setBounds(156, 685, 46, 14);
		contentPane.add(label_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(207, 682, 86, 20);
		contentPane.add(textField_4);
		
		JLabel label_3 = new JLabel("Proveedor");
		label_3.setBounds(299, 685, 62, 14);
		contentPane.add(label_3);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(376, 682, 86, 20);
		contentPane.add(textField_5);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(376, 713, 89, 23);
		contentPane.add(btnAgregar);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 628, 464, 2);
		contentPane.add(separator_1);
	}
}
