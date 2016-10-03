package Ticket;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Modelo.DTO.General.pedidoDTO;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Ticket {

	private JasperReport reporte;
	private JasperViewer reporteViewer;
	private JasperPrint	reporteLleno;
	
	//Recibe la lista de personas para armar el reporte
    public Ticket(List<pedidoDTO> pedido)
    {
    	Collections.sort(pedido, new Comparator<pedidoDTO>() {

			@Override
			public int compare(pedidoDTO o1, pedidoDTO o2) {
				// TODO Auto-generated method stub
				return 0;
			}
		});
    	//Hardcodeado
		Map<String, Object> parametersMap = new HashMap<String, Object>();
		parametersMap.put("Fecha", new SimpleDateFormat("dd/MM/yyyy").format(new Date()));		
    	try		{

			this.reporte = (JasperReport) JRLoader.loadObjectFromFile( "ticket\\Ticket.jasper" );
			this.reporteLleno = JasperFillManager.fillReport(this.reporte, parametersMap, new JRBeanCollectionDataSource(pedido));
			
		}
		catch( JRException ex ) 
		{
			ex.printStackTrace();
		}
    }       
    
    public void mostrar()
	{
		this.reporteViewer = new JasperViewer(this.reporteLleno,false);
		this.reporteViewer.setVisible(true);
	}
}
