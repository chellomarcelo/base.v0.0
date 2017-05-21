package grafica.controladores.Modulo1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import grafica.ventanas.Modulo1.ventanaAbmFamilia;
import grafica.ventanas.Modulo1.ventanaCrearFamilia;
import grafica.ventanas.Modulo1.ventanaModFamilia;
import logica.fachada;
import logica.excepciones.ExcFamilia;
import logica.vo.voFamilia;

public class controladorAbmFamilia {

	private fachada fac;
	private ventanaAbmFamilia ventListFam;
	
	public controladorAbmFamilia ( ventanaAbmFamilia  _ventanaListarFamilia ){
		this.ventListFam = _ventanaListarFamilia;
	}
	
	public void ventCrearFamilia(){
		try {
			ventanaCrearFamilia ventana = new ventanaCrearFamilia();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	/******
	 * Función que devuelve la lista de las familias que hay en base
	 * @return
	 * @throws Exception
	 */
	public ArrayList<voFamilia> listarFamilias() throws Exception{
		try {
			if (fac==null){
				fac = new fachada();
			}
			return fac.listarNombreFamilia();
		} catch (ExcFamilia e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, (new ExcFamilia(ExcFamilia.ERROR_NO_HAY_FAMILIAS)), "Error al crear repuesto", JOptionPane.ERROR_MESSAGE);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//System.out.println(e.getCause());
			JOptionPane.showMessageDialog(null, (e.getMessage()), "Error al crear repuesto", JOptionPane.ERROR_MESSAGE);
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
		return null;
	}
	
	/*****
	 * 
	 * @param _voFamilia
	 */
	public void borrarFamilia(voFamilia _voFamilia){
		try {
			fac.borrarFamilia(_voFamilia);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e1){
			e1.getMessage();
		}
	}

	public void ventModFamilia(String _nombreActual) {
		// TODO Auto-generated method stub
		ventanaModFamilia _ventModFam = new ventanaModFamilia(_nombreActual);
	}
	
}
