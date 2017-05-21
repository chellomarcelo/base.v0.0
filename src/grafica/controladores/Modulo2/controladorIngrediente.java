package grafica.controladores.Modulo2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import grafica.ventanas.Modulo2.ventanaIngrediente;
import logica.Modulo2.fachadaModulo2;
import logica.Modulo2.vo.voIngrediente;

public class controladorIngrediente {

	
	private ventanaIngrediente ventTipoIng;
	private fachadaModulo2 fac2;
	
	public controladorIngrediente(ventanaIngrediente _ventTipoIng){
		
		this.ventTipoIng = _ventTipoIng;
	}
	
	
	public void ingresoIngrediente( voIngrediente _voIng){
		if(fac2==null){
			try {
				fac2 = new fachadaModulo2();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			fac2.altaIngrediente(_voIng);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
