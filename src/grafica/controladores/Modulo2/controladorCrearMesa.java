package grafica.controladores.Modulo2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import grafica.ventanas.Modulo1.ventanaCrearFamilia;
import grafica.ventanas.Modulo1.ventanaCrearProducto;
import grafica.ventanas.Modulo2.ventanaCrearMesa;
import logica.fachada;
import logica.Modulo2.fachadaModulo2;
import logica.Modulo2.vo.voMesa;
import logica.excepciones.ExcFamilia;
import logica.excepciones.ExcProducto;
import logica.vo.voFamilia;

public class controladorCrearMesa {
	
	private fachadaModulo2 fac2;
	private ventanaCrearMesa ventCrearMesa;
	
	public controladorCrearMesa ( ventanaCrearMesa  _ventCrearMesa ){
		this.ventCrearMesa = _ventCrearMesa;
	}
	
	public void crearMesa ( voMesa _voMesa) throws SQLException{
		boolean chequeo=true;
		try {
			if (fac2==null)
				fac2 = new fachadaModulo2();
			
			//ACA hay que ingresar todos los chequeos como se hizo para crear el repuesto
			fac2.crearMesa(_voMesa);
			
		} catch (FileNotFoundException e) {
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

	///Seguridad de ingresos de datos
	public boolean ingresarTextoVacio(String texto) {
		boolean correcto = true;
		//Primero chequeo el nombre del repuesto que no este vacio
		if( texto.contentEquals("")) {
			System.out.println("No puede ser un campo vacio");
			correcto = false;
		}
		if( texto.contentEquals(" ")) {
			System.out.println("No puede ser un espacio en blanco el nombre.");
			correcto = false;
		}
		return correcto;
	}
	
	//Finalizo Seguridad de ingreso de datos
	
}
