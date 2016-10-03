package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import ControlDeMesa.ControlDeMesa;
import Modelo.DTO.General.mesaDTO;
import Modelo.DTO.General.pedidoDTO;
import Modelo.Negocio.Carta;
import Modelo.Negocio.Pedido;
import Modelo.Negocio.Restorant;
import Ticket.Ticket;
import Vistas.Encargado.GestorPedidos;
import Vistas.Encargado.TomaDePedido;
import Vistas.Vistas_AM.ABM_Mesa;

public class GestorPedidos_Controller implements ActionListener {

	private GestorPedidos vistaMesas;
	private Pedido pedido;
	private Restorant resto;
	private Carta carta;
	private List<mesaDTO> mesas;
	private List<pedidoDTO> pedidos;
	private ControlDeMesa genControl;
	private Ticket genTicket;

	public GestorPedidos_Controller(GestorPedidos vistaMesas, Pedido pedido, Restorant resto) {

		this.setVistaMesas(vistaMesas);
		this.setPedido(pedido);
		this.setResto(resto);

		this.vistaMesas.getBtnAsignarMesa().addActionListener(this);
		this.vistaMesas.getBtnPedido().addActionListener(this);
		this.vistaMesas.getBtnModfEstado().addActionListener(this);
		this.vistaMesas.getBtnVerDetalle().addActionListener(this);
		this.vistaMesas.getBtnGenCtrl().addActionListener(this);
		this.vistaMesas.getBtnTicket().addActionListener(this);

		this.inicializar();
	}

	public void inicializar() {

		this.mesas = resto.obtenerMesas();
		// this.pedidos = pedido.obtenerPedidos();
		this.cargarTabla();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == this.vistaMesas.getBtnAsignarMesa()) {

		} else if (e.getSource() == this.vistaMesas.getBtnPedido()) {

			TomaDePedido altaPedido = new TomaDePedido();
			TomaDePedido_Controller controlAltaPedido = new TomaDePedido_Controller(altaPedido, pedido, carta);
			altaPedido.setVisible(true);

		} else if (e.getSource() == this.vistaMesas.getBtnModfEstado()) {

		} else if (e.getSource() == this.vistaMesas.getBtnVerDetalle()) {

		} else if (e.getSource() == this.vistaMesas.getBtnGenCtrl()) {

			int filaSelect = this.vistaMesas.getTblPedido().getSelectedRow();

			if (filaSelect >= 0) {

				mesaDTO aux = this.mesas.get(filaSelect);
				for (int i = 0; i < this.pedidos.size(); i++) {

					for (int j = 0; j < this.pedidos.get(i).getMesa().size(); j++) {

						if (pedidos.get(i).getMesa().get(j).getIdMesa() == aux.getIdMesa()) {

							List<pedidoDTO> ped = new ArrayList<pedidoDTO>();
							ped.add(pedidos.get(i));
							this.genControl = new ControlDeMesa(ped);
						}
					}
				}
			}
		} else if (e.getSource() == this.vistaMesas.getBtnTicket()) {

			int filaSelect = this.vistaMesas.getTblPedido().getSelectedRow();

			if (filaSelect >= 0) {

				mesaDTO aux = this.mesas.get(filaSelect);
				for (int i = 0; i < this.pedidos.size(); i++) {

					for (int j = 0; j < this.pedidos.get(i).getMesa().size(); j++) {

						if (pedidos.get(i).getMesa().get(j).getIdMesa() == aux.getIdMesa()) {

							List<pedidoDTO> ped = new ArrayList<pedidoDTO>();
							ped.add(pedidos.get(i));
							this.setGenTicket(new Ticket(ped));
						}
					}
				}

			}
		}
	}

	public void cargarTabla() {

		for (int i = 0; i < mesas.size(); i++) {

			Object[] fila = { this.mesas.get(i).getNumero(), this.mesas.get(i).getCapacidad(),
					this.mesas.get(i).getPiso(), this.mesas.get(i).getSector(),
					this.mesas.get(i).getEstado().getDescripcion() };
			this.vistaMesas.getModelPedido().addRow(fila);
		}

	}

	public GestorPedidos getVistaMesas() {
		return vistaMesas;
	}

	public void setVistaMesas(GestorPedidos vistaMesas) {
		this.vistaMesas = vistaMesas;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public List<mesaDTO> getMesas() {
		return mesas;
	}

	public void setMesas(List<mesaDTO> mesas) {
		this.mesas = mesas;
	}

	public List<pedidoDTO> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<pedidoDTO> pedidos) {
		this.pedidos = pedidos;
	}

	public Restorant getResto() {
		return resto;
	}

	public void setResto(Restorant resto) {
		this.resto = resto;
	}

	public ControlDeMesa getGenControl() {
		return genControl;
	}

	public void setGenControl(ControlDeMesa genControl) {
		this.genControl = genControl;
	}

	public Ticket getGenTicket() {
		return genTicket;
	}

	public void setGenTicket(Ticket genTicket) {
		this.genTicket = genTicket;
	}

}
