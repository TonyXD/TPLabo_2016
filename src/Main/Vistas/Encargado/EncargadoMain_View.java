package Vistas.Encargado;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Utils.PA_PreView;
import Utils.PB_PreView;

public class EncargadoMain_View extends JFrame {

	private static final long serialVersionUID = -6200816652032876979L;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EncargadoMain_View frame = new EncargadoMain_View();
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
	public EncargadoMain_View() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(EncargadoMain_View.class.getResource("/Imagenes/dishes-798316_1280.png")));
		setTitle("Nombre a definir");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1218, 720);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Desplegable 01");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("Desplegable 02");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("New menu item");
		mnNewMenu_1.add(mntmNewMenuItem_1);


		JPanel mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPanel);
		mainPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 1178, 43);
		mainPanel.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Ver Conina");
		btnNewButton.setBounds(0, 0, 130, 43);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Pedido");
		btnNewButton_1.setBounds(140, 0, 130, 43);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Reserva");
		btnNewButton_2.setBounds(280, 0, 130, 43);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Ver Stock");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_3.setBounds(700, 0, 130, 43);
		panel.add(btnNewButton_3);
		
		JButton btnPlatos = new JButton("Carta");
		btnPlatos.setBounds(560, 0, 130, 43);
		panel.add(btnPlatos);
		
		JButton btnBebidas = new JButton("Control Mesa");
		btnBebidas.setActionCommand("Control\r\n\r\nMesa");
		btnBebidas.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnBebidas.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBebidas.setBounds(420, 0, 130, 43);
		panel.add(btnBebidas);
		
		JButton button_5 = new JButton("New button");
		button_5.setBounds(840, 0, 130, 43);
		panel.add(button_5);
		
		JButton button_6 = new JButton("New button");
		button_6.setBounds(980, 0, 130, 43);
		panel.add(button_6);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 65, 1178, 585);
		mainPanel.add(panel_1);
		panel_1.setLayout(null);
		
		
		PA_PreView pnl_PA = new PA_PreView();
		pnl_PA.setBounds(592, 11, 576, 563);
		panel_1.add(pnl_PA);		
		
		PB_PreView pnl_PB = new PB_PreView();
		pnl_PB.setBounds(10, 11, 576, 563);
		panel_1.add(pnl_PB);
		
		
	}
}