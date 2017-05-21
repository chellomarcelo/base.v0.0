package grafica.controladores.Modulo1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import grafica.ventanas.Modulo1.ventanaCrearFamilia;
import grafica.ventanas.Modulo1.ventanaCrearProducto;
import logica.fachada;
import logica.excepciones.ExcFamilia;
import logica.excepciones.ExcProducto;
import logica.vo.voFamilia;

public class controladorCrearFamilia {
	
	private fachada fac;
	private ventanaCrearFamilia ventCrearFamilia;
	
	public controladorCrearFamilia ( ventanaCrearFamilia  _ventCrearFamilia ){
		this.ventCrearFamilia = _ventCrearFamilia;
	}
	
	public void crearFamilia ( voFamilia _voFamilia) throws SQLException{
		boolean chequeo=true;
		try {
			if (fac==null){
				fac = new fachada();
			}
			//ACA hay que ingresar todos los chequeos como se hizo para crear el repuesto
			
			//1_Verifico que el campo nombre tenga algun valor
			if (!(ingresarTextoVacio(_voFamilia.getNombreFamilia()))){
				chequeo=false;
				JOptionPane.showMessageDialog(null, (new ExcProducto().getMessage(ExcProducto.ERROR_ESPACIOS_BLANCOS)), "Error al crear familia", JOptionPane.ERROR_MESSAGE);
			}
			//Si el chequeo da true se crea la familia
			if (chequeo){
				fac.crearFamilia(_voFamilia);
			}	
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
