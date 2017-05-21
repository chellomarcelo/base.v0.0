package grafica.controladores.Modulo1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import grafica.ventanas.Modulo1.ventanaModFamilia;
import logica.fachada;
import logica.excepciones.ExcFamilia;
import logica.excepciones.ExcepcionesGeneral;
import logica.vo.voFamilia;

public class controladorModificarFamilia {
	
	private fachada fac;
	private ventanaModFamilia ventModFamilia;
	
	public controladorModificarFamilia ( ventanaModFamilia  _ventModFamilia ){
		this.ventModFamilia = _ventModFamilia;
	}

	public void modificarFamilia(voFamilia voData1, voFamilia voData2) {
		// TODO Auto-generated method stub
		try {
				System.out.println("voData1:"+voData1.getNombreFamilia());
				System.out.println("voData2:"+voData2.getNombreFamilia());
				if (fac==null){
					fac = new fachada();
				}
				fac.modificarFamilia(voData1, voData2);
		} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
