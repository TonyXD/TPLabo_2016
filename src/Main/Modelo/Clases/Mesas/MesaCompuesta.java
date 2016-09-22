package Modelo.Clases.Mesas;

import java.util.Set;
import Modelo.Interfaces.AccionesMesa;

public class MesaCompuesta implements AccionesMesa {

	private Set<MesaSimple> mesasQueLaForman;
	
	public MesaCompuesta(Set<MesaSimple> mesasQueLaForman) {
		this.mesasQueLaForman = mesasQueLaForman;
	}
	
	@Override public int getCapacidad() {
		int ret = 0;
		for (MesaSimple m: this.mesasQueLaForman)
			ret += m.getCapacidad();
		return ret;
	}
	
}
