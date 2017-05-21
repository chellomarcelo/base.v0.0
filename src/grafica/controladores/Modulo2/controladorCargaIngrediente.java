package grafica.controladores.Modulo2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import grafica.ventanas.Modulo2.ventanaCargaIngrediente;
import logica.Modulo2.fachadaModulo2;
import logica.Modulo2.excepciones.ExcIngrediente;
import logica.Modulo2.vo.voIngrediente;
import logica.Modulo2.vo.voRelIngProd;
import logica.excepciones.ExcProducto;
import logica.excepciones.ExcProveedores;
import logica.vo.voFamilia;

public class controladorCargaIngrediente {

	private ventanaCargaIngrediente ventCargaIng;
	private fachadaModulo2 fac;
	
	

	
	public controladorCargaIngrediente (ventanaCargaIngrediente _vent){
		this.ventCargaIng = _vent;
	}



	/*****
	 * Funcionalidad: Trae todos los ingredientes
	 * @return
	 */
	public ArrayList<voIngrediente> listarIngrediente() {
		ArrayList<voIngrediente> aux = null;
		if(fac==null){
			try {
				fac = new fachadaModulo2();
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
			aux =  fac.listarIngrediente();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return aux;
		
	}
	
	/*****
	 * Funcionalidad: Trae todos los ingredientes de un producto especifico
	 * @return
	 */
	public ArrayList<voIngrediente> listarIngProducto(ArrayList<voIngrediente> listIngredientes, int idProd){
		ArrayList<voIngrediente> auxProd = new ArrayList<voIngrediente>();
		
		for(int i=0; i<listIngredientes.size();i++){
			if(idProd==listIngredientes.get(i).getIdProducto())
				auxProd.add(listIngredientes.get(i));
		}
		
		
		return auxProd;
	}
	
	
	public ArrayList<voRelIngProd> listIngProducto (int _idProd){
		ArrayList<voRelIngProd> auxRel = new ArrayList<voRelIngProd>();
		
		try {
			  auxRel = fac.listarProdIng(_idProd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return auxRel;	
	}


	/******
	 * Funcionalidad: Guardar la nueva lista de ingrediente de un producto
	 * 
	 * @param _modeloProdIng
	 * @param _idProd
	 * @param _listProdIng
	 */
	public void guardarlistaProd(DefaultListModel _modeloProdIng, int _idProd, ArrayList<voIngrediente> _listProdIng) {
		ArrayList<voIngrediente> listProdIngGua = new ArrayList<voIngrediente>();
		voIngrediente auxIng;

		System.out.println(_modeloProdIng.size());
		
		if(_modeloProdIng.size() > 0  ){
			for(int i=0;i<_modeloProdIng.size();i++){
				auxIng = new voIngrediente(bIdIngrediente(_modeloProdIng.get(i).toString(), _listProdIng), _idProd, _modeloProdIng.get(i).toString(), 0);
				listProdIngGua.add(auxIng);
				System.out.println("listProdIn " + listProdIngGua.get(i).getIdIngrediente() +"   "+ listProdIngGua.get(i).getNombreIngrediente() +"");
			}
			
			try {
				fac.guardarListIngProd(listProdIngGua, _idProd);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				//if(e.getSQLState())
				System.out.println(e.getSQLState());
				e.printStackTrace();
			}
		}else{
			JOptionPane.showMessageDialog(null, ((ExcIngrediente.ERROR_AL_GUARDAR_INGREDIENTE)), "No hay datos para guardar", JOptionPane.ERROR_MESSAGE);
		}
	
	}
	
	/*******
	 * Funcionalidad: compara los nombres con la lista de ingredientes para buscar el id original.
	 * 
	 * @param nombreIng
	 * @param listProd
	 * @return
	 */
	public int bIdIngrediente(String nombreIng, ArrayList<voIngrediente> listProd){
		Boolean ok=false;
		int i=0, auxId=0;

		while (!ok && i<listProd.size()){
			//System.out.println("Nombre listProd: "+ listProd.get(i).getNombreIngrediente() +"   nombre ing: "+ nombreIng);
			if(listProd.get(i).getNombreIngrediente().equals(nombreIng)){
				ok=true;
				auxId = listProd.get(i).getIdIngrediente();
			}
		i++;	
		}
		return auxId;
	}



	/*****
	 * Funcionalidad: Comparo que no exista el mismo ingrediente en el producto
	 * 
	 * @param _modProdIng
	 * @param _auxLisIng
	 * @return
	 */
	public boolean repetido(DefaultListModel _modProdIng, String _auxLisIng) {
		// TODO Auto-generated method stub
		boolean encontre=false;
		int i=0;
		while (!encontre && i<_modProdIng.getSize()){
			if(_modProdIng.get(i).equals(_auxLisIng)){
				System.out.println("Entro   "+_modProdIng.get(i));
				encontre = true;
				JOptionPane.showMessageDialog(null, ((ExcIngrediente.EXISTE_INGREDIENTE)), "Erro Carga Ingrediente Producto", JOptionPane.ERROR_MESSAGE);
			}
			i++;
		}
		return encontre;
	}




	public ArrayList<String> filtro(ArrayList<voIngrediente> _listIngredientes, String _text) {
		boolean ok=false;
		ArrayList<String> auxListIng = new ArrayList<String>();
		for(int i=0;i<_listIngredientes.size();i++){
			if(_listIngredientes.get(i).getNombreIngrediente().toUpperCase().matches(".*"+_text.toUpperCase()+".*")){
				System.out.println("C"+i+"   "+ _listIngredientes.get(i).getNombreIngrediente());
				auxListIng.add(_listIngredientes.get(i).getNombreIngrediente());
			}
			
		}
		
		return auxListIng;
	}
		
}
