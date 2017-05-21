package grafica.controladores.Modulo2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import grafica.ventanas.Modulo2.ventanaAbmMesas;
import grafica.ventanas.Modulo2.ventanaCrearMesa;
import logica.fachada;
import logica.Modulo2.fachadaModulo2;
import logica.Modulo2.excepciones.ExcMesa;
import logica.Modulo2.vo.voMesa;
import logica.excepciones.ExcFamilia;;

public class controladorAbmMesas {

	private fachadaModulo2 fac;
	private ventanaAbmMesas ventListMes;
	
	public controladorAbmMesas ( ventanaAbmMesas  _ventanaListarMesa ){
		this.ventListMes = _ventanaListarMesa;
	}
	
	public void ventCrearMesa(){
		try {
			ventanaCrearMesa ventana = new ventanaCrearMesa();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void crearMesa ( int _idMesa) throws SQLException{
		boolean chequeo=true;
		try {
			if (fac==null)
				fac = new fachadaModulo2();
			
			voMesa voMes = new voMesa(_idMesa,0);
			//ACA hay que ingresar todos los chequeos como se hizo para crear el repuesto
			fac.crearMesa(voMes);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExcMesa e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, ExcMesa.EXISTE_MESA, "Error al cargar las mesas", JOptionPane.ERROR_MESSAGE);
		} 
		
	}
	
	/******
	 * Función que devuelve la lista de las Mesas que hay en base
	 * @return
	 * @throws Exception
	 */
	public ArrayList<voMesa> listarMesas() throws Exception{
		try {
			if (fac==null){
				fac = new fachadaModulo2();
			}
			return fac.listarMesas();
		} catch (ExcMesa e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, ExcMesa.ERROR_NO_HAY_MESA, "Error al cargar las mesas", JOptionPane.ERROR_MESSAGE);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//System.out.println(e.getCause());
			JOptionPane.showMessageDialog(null, (e.getMessage()), "Error al cargar las mesas", JOptionPane.ERROR_MESSAGE);
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
	 * @param _voMesa
	 */
	public void borrarMesa(voMesa _voMesa){
		try {
			fac.borrarMesa(_voMesa);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e1){
			e1.getMessage();
		}
	}

	/*
	public void ventModMesa(int _nombreActual) {
		// TODO Auto-generated method stub
		ventanaModMesa _ventModFam = new ventanaModMesa(_nombreActual);
	}
	*/
	
}
