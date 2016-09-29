package Vistas.Vistas_AM;

import java.awt.BorderLayout;
import java.awt.EventQueue;

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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class AM_Bebida extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AM_Bebida frame = new AM_Bebida();
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
	public AM_Bebida() {
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
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(110, 66, 150, 20);
		contentPane.add(comboBox);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 657, 80, 14);
		contentPane.add(lblNombre);
		
		textField = new JTextField();
		textField.setBounds(81, 654, 150, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(255, 657, 46, 14);
		contentPane.add(lblPrecio);
		
		textField_1 = new JTextField();
		textField_1.setBounds(324, 654, 150, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 685, 464, 2);
		contentPane.add(separator_1);
		
		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(385, 698, 89, 23);
		contentPane.add(btnNewButton);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 641, 464, 2);
		contentPane.add(separator_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 100, 464, 496);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"Nombre", "Precio"
			}
		));
		
		JButton btnNewButton_1 = new JButton("Cargar Tabla");
		btnNewButton_1.setBounds(340, 65, 134, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Seleccionar Bebida");
		btnNewButton_2.setBounds(324, 607, 150, 23);
		contentPane.add(btnNewButton_2);
	}
}
