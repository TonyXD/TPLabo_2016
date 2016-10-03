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
import java.awt.Color;

public class EncargadoMain_View extends JFrame {

	private static final long serialVersionUID = -6200816652032876979L;
	
	private JButton btnAdmMesas;
	private JButton btnVerReserva;
	private JButton btnVerCarta;
	private JButton btnVerStock;
	private JButton btnVerPedido;
	private JButton btnVerCocina;
	
	
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
		
		setBackground(new Color(255, 255, 255));
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(EncargadoMain_View.class.getResource("/Imagenes/dishes-798316_1280.png")));
		setTitle("Delicatessen S.A.");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 10, 1218, 720);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Desplegable 01");
		mnNewMenu.setEnabled(false);
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("Desplegable 02");
		mnNewMenu_1.setEnabled(false);
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
		
		btnVerCocina = new JButton("Ver Cocina");
		btnVerCocina.setEnabled(false);
		btnVerCocina.setBounds(420, 0, 130, 43);
		panel.add(btnVerCocina);
		
		btnVerPedido = new JButton("Adm. Pedido");
		btnVerPedido.setBounds(140, 0, 130, 43);
		panel.add(btnVerPedido);
		
		btnVerReserva = new JButton("Reserva");
		btnVerReserva.setEnabled(false);
		btnVerReserva.setBounds(280, 0, 130, 43);
		panel.add(btnVerReserva);
		
		btnVerStock = new JButton("Ver Stock");
		btnVerStock.setEnabled(false);
		btnVerStock.setBounds(700, 0, 130, 43);
		panel.add(btnVerStock);
		
		btnVerCarta = new JButton("Adm. Carta");
		btnVerCarta.setBounds(560, 0, 130, 43);
		panel.add(btnVerCarta);
		
		btnAdmMesas = new JButton("Adm. Mesas");
		btnAdmMesas.setActionCommand("Control\r\n\r\nMesa");
		btnAdmMesas.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnAdmMesas.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAdmMesas.setBounds(0, 0, 130, 43);
		panel.add(btnAdmMesas);
		
		JButton button_5 = new JButton("");
		button_5.setEnabled(false);
		button_5.setBounds(840, 0, 130, 43);
		panel.add(button_5);
		
		JButton button_6 = new JButton("");
		button_6.setEnabled(false);
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

	public JButton getBtnVerCocina() {
		return btnVerCocina;
	}

	public void setBtnVerCocina(JButton btnVerCocina) {
		this.btnVerCocina = btnVerCocina;
	}

	public JButton getBtnVerPedido() {
		return btnVerPedido;
	}

	public void setBtnVerPedido(JButton btnVerPedido) {
		this.btnVerPedido = btnVerPedido;
	}

	public JButton getBtnVerStock() {
		return btnVerStock;
	}

	public void setBtnVerStock(JButton btnVerStock) {
		this.btnVerStock = btnVerStock;
	}

	public JButton getBtnVerCarta() {
		return btnVerCarta;
	}

	public void setBtnVerCarta(JButton btnVerCarta) {
		this.btnVerCarta = btnVerCarta;
	}

	public JButton getBtnVerReserva() {
		return btnVerReserva;
	}

	public void setBtnVerReserva(JButton btnVerReserva) {
		this.btnVerReserva = btnVerReserva;
	}

	public JButton getBtnVerMesas() {
		return btnAdmMesas;
	}

	public void setBtnVerMesas(JButton btnVerMesas) {
		this.btnAdmMesas = btnVerMesas;
	}
}