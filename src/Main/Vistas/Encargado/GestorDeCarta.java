package Vistas.Encargado;

import java.awt.BorderLayout;
import java.awt.EventQueue;

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

public class GestorDeCarta extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTable table2;
	private JTable table3;
	private JTable table4;
	private JTable table5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestorDeCarta frame = new GestorDeCarta();
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
	public GestorDeCarta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 980, 623);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Gestionar Plato");
		btnNewButton.setBounds(76, 11, 130, 43);
		contentPane.add(btnNewButton);
		
		JButton btnGestionarBebida = new JButton("Gestionar Bebida");
		btnGestionarBebida.setBounds(390, 11, 130, 43);
		contentPane.add(btnGestionarBebida);
		
		JButton btnGestionarMenu = new JButton("Gestionar Menu");
		btnGestionarMenu.setBounds(734, 11, 130, 43);
		contentPane.add(btnGestionarMenu);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 66, 285, 509);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("New tab", null, scrollPane, null);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane2 = new JScrollPane();
		tabbedPane.addTab("New tab", null, scrollPane2, null);
		
		table2 = new JTable();
		scrollPane2.setViewportView(table2);
		
		JScrollPane scrollPane3 = new JScrollPane();
		tabbedPane.addTab("New tab", null, scrollPane3, null);
		
		table2 = new JTable();
		scrollPane3.setViewportView(table2);
		
		
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(320, 65, 297, 509);
		contentPane.add(tabbedPane_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		tabbedPane_1.addTab("New tab", null, scrollPane_1, null);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JScrollPane scrollPane4 = new JScrollPane();
		tabbedPane_1.addTab("New tab", null, scrollPane4, null);
		
		table4 = new JTable();
		scrollPane4.setViewportView(table4);
		
		JScrollPane scrollPane5 = new JScrollPane();
		tabbedPane_1.addTab("New tab", null, scrollPane5, null);
		
		table5 = new JTable();
		scrollPane5.setViewportView(table5);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Men\u00FAs", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(641, 50, 319, 532);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(6, 16, 307, 509);
		panel.add(scrollPane_2);
		
		table_2 = new JTable();
		scrollPane_2.setViewportView(table_2);
	}

}
