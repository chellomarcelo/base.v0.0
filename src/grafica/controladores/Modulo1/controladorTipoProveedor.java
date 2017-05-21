package grafica.controladores.Modulo1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import grafica.ventanas.Modulo1.ventanaCrearFamilia;
import grafica.ventanas.Modulo1.ventanaCrearTipoProveedor;
import logica.fachada;
import logica.excepciones.ExcProducto;
import logica.excepciones.ExcepcionesGeneral;
import logica.vo.voFamilia;
import logica.vo.voTipoProveedor;


public class controladorTipoProveedor {

	private fachada fac;
	private ventanaCrearTipoProveedor ventTipoProveedor;
	
	public controladorTipoProveedor ( ventanaCrearTipoProveedor  _ventCrearTipoProveedor ){
		this.ventTipoProveedor = _ventCrearTipoProveedor;
	}
	
	public void crearTipoProveedor ( voTipoProveedor _voTipoProveedor) throws SQLException{
		boolean chequeo=true;
		try {
			if (fac==null){
				fac = new fachada();
			}
			//1_Verifico que el campo nombre tenga algun valor
			if (!(ingresarTextoVacio(_voTipoProveedor.getNombreTipoProveedor()))){
				chequeo=false;
				JOptionPane.showMessageDialog(null, (new ExcepcionesGeneral().getMessage(ExcepcionesGeneral.ERROR_ESPACIOS_BLANCOS)), "Error al ingresar tipo de proveedor",JOptionPane.ERROR_MESSAGE);
			}
			//Si el chequeo da true se crea la familia
			if (chequeo){
				fac.crearTipoProveedor(_voTipoProveedor);
				JOptionPane.showMessageDialog(null, (new ExcepcionesGeneral().getMessage(ExcepcionesGeneral.OK_GUARDO)), "Guardado OK",JOptionPane.INFORMATION_MESSAGE);
				//JOptionPane.showMessageDialog(null, (new ExcepcionesGeneral(ExcepcionesGeneral.OK_GUARDO)), "Guardado OK", JOptionPane.INFORMATION_MESSAGE);
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
