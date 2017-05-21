package grafica.controladores.Modulo1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import grafica.ventanas.Modulo1.ventanaCrearFamilia;
import grafica.ventanas.Modulo1.ventanaLisRep;
import logica.fachada;


public class controladorLisRep {

	private fachada fac;
	private ventanaLisRep ventLisRep;
	
	public controladorLisRep ( ventanaLisRep  _ventLisRep ){
		this.ventLisRep = _ventLisRep;
	}

	public void crearReportePrueba(String _nombreReporte) {
		
		try {
			if (fac==null){
				fac = new fachada();
			}
			fac.crearReporte(_nombreReporte);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
