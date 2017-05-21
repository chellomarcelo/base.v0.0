package logica.Modulo2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;

import logica.Modulo2.excepciones.ExcIngrediente;
import logica.Modulo2.excepciones.ExcMesa;
import logica.Modulo2.excepciones.ExcTipoIngrediente;
import logica.Modulo2.persistencia.AccesoBDModulo2;
import logica.Modulo2.vo.voIngrediente;
import logica.Modulo2.vo.voMesa;
import logica.Modulo2.vo.voRelIngProd;


public class fachadaModulo2 {

	
	AccesoBDModulo2 acc;
	Connection con;
	ArrayList<voMesa> listMesas = new ArrayList<voMesa>();
	ArrayList<voIngrediente> listIngrediente = new ArrayList<voIngrediente>();
	//ArrayList<voTipoIngrediente> listTipoIngrediente = new ArrayList<voTipoIngrediente>();
	
	/**
	 * Crea una instancia de la conexion de AccesoBD
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public fachadaModulo2 () throws FileNotFoundException, IOException, ClassNotFoundException, SQLException  {
		acc = new AccesoBDModulo2();
	}

/*************************************************************************************************************************************************************************/
/***Funciones Crear Objetos																																				**/
/***Funciones Crear Objetos																																				**/
/*************************************************************************************************************************************************************************/

	
	
	/**
	 * Funcionalidad Crear una Mesa
	 * Testeada: ?
	 * Fecha Creeado: ?
	 * Fecha Modificado: ?
	 * 
	 * @param _Mesa
	 * @throws SQLException
	 */
	public void crearMesa (voMesa _voMesa) throws SQLException {
		//Verifico si existe esa Mesa
		if (!existeMesa(_voMesa.getIdMesa()))
			acc.crearMesa(_voMesa);
		else{
			throw new ExcMesa(ExcMesa.EXISTE_MESA);
		}
	}
	
	/*****
	 * Funcionalidad Crear Ingrediente
	 * Testeada: ?
	 * Fecha Creeado: 			24/04/2017
	 * Fecha Modificado: 		06/05/2017
	 * 
	 * @param _voIng
	 * @throws SQLException
	 */
	public void altaIngrediente(voIngrediente _voIng) throws SQLException{
		if(!existeIngrediente(_voIng.getNombreIngrediente())){
			acc.altaIngrediente(_voIng);
		}else{
			throw new ExcIngrediente(ExcIngrediente.EXISTE_INGREDIENTE);
		}
	}
	
	
	/****
	 * Funcionalidad: Guardar lista de ingredientes de un producto
	 * Testeada: ?
	 * Fecha Creeado: 			07/05/2017
	 * Fecha Modificado: 		07/05/2017
	 *  
	 * @param _listProdIngGua
	 * @throws SQLException 
	 */
	public void guardarListIngProd(ArrayList<voIngrediente> _listProdIngGua, int _idProd) throws SQLException {
		acc.guardarListIngProd(_listProdIngGua, _idProd);
	}
	
	
	/*
	 * Lo quito porque parece ser no cesario lo suplanto con el producto mismo.
	public void crearTipoIngrediente(voTipoIngrediente _voTipIng) throws ExcTipoIngrediente, SQLException{
		if(!existeTipoIng(_voTipIng.getTipoIngNombre())){
			acc.crearTipoIngrediente(_voTipIng);
		}else{
			throw new ExcTipoIngrediente(ExcTipoIngrediente.ERROR_EXISTE_TIP_ING);
		}
	}
	*/

/*************************************************************************************************************************************************************************/
/***Funciones Quitar/Borrar Objetos																																		**/
/***Funciones Quitar/Borrar Objetos 																																	**/
/*************************************************************************************************************************************************************************/
	
	
	
	/**
	 * Funcionalidad Borrar una Mesa
	 * Testeada: ?
	 * Fecha Creeado: ?
	 * Fecha Modificado: ?
	 * 
	 * @param _idMesa
	 * @throws SQLException
	 */
	public void borrarMesa(voMesa _voMesa) throws SQLException {
		acc.borrarMesa(_voMesa.getIdMesa());
	}
	
/*************************************************************************************************************************************************************************/
/***Funciones Modificacion Objetos																																		**/
/***Funciones Modificacion Objetos																																		**/
/*************************************************************************************************************************************************************************/
	

	/*****
	 * Funcionalidad Modificar una Mesa
	 * Testeada: ?
	 * Fecha Creeado: ?
	 * Fecha Modificado: ?
	 *  
	 * @param _voMesa1
	 * @param _voMesa2
	 * @throws SQLException
	 */
	public void modificarMesa (voMesa _voMesa1,voMesa _voMesa2) throws SQLException{
		if(existeMesa(_voMesa1.getIdMesa()) && (!existeMesa(_voMesa2.getIdMesa()))){
			acc.modificarMesa(_voMesa1, _voMesa2);
		}
	}
	
	
/*************************************************************************************************************************************************************************/
/***Funciones Listar																																					**/
/***Funciones Listar																																					**/
/*************************************************************************************************************************************************************************/

	
	/****
	 * Funcionalidad:		Trae 1 mesa 
	 * Testeada: ?
	 * Fecha Creeado: 		17/04/2017
	 * Fecha Modificado: 	17/04/2017
	 * 
	 * 
	 * @param _voMesa
	 * @return
	 * @throws SQLException
	 */
	public voMesa getMesa (voMesa _voMesa) throws SQLException{
		voMesa aux = acc.getMesa(_voMesa.getIdMesa());
		
		return aux; 
	}
	
	/*****
	 * Funcionalidad:		Trae todas las mesa 
	 * Testeada: ?
	 * Fecha Creeado: 		22/04/2017
	 * Fecha Modificado: 	22/04/2017
	 * 
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<voMesa> ListarMesas() throws SQLException{
		return acc.listarMesas();
	}
	
	
	/*******
	 * Funcionalidad: 		Trae todas las mesas 
	 * Testeada: ?
	 * Fecha Creeado: 		17/04/2017
	 * Fecha Modificado: 	17/04/2017
	 * 
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<voMesa> listarMesas() throws SQLException {
		return acc.listarMesas();
	}
	
	/******
	 * Funcionalidad: 		Trae todos los ingredientes 
	 * Testeada: ?
	 * Fecha Creeado: 		23/04/2017
	 * Fecha Modificado: 	23/04/2017
	 * 
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<voIngrediente> listarIngrediente() throws SQLException {
		return acc.listarIngrediente();
	}
	
	
	/*****
	 * Funcionalidad: 		Trae los ingredientes de un producto 
	 * Testeada: ?
	 * Fecha Creeado: 		13/05/2017
	 * Fecha Modificado: 	13/05/2017
	 * 
	 * @param _idProd
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<voRelIngProd> listarProdIng (int _idProd) throws SQLException {
		return acc.listarProdIng(_idProd);
	}
	
	
	/*
	 * Queda en desuso no es necesario
	public ArrayList<voTipoIngrediente> listarTipoIngrediente ( ) throws SQLException{
		return acc.listarTipoIngrediente();		
	}
	*/
	/*************************************************************************************************************************************************************************/
	/***Funciones auxiliares																																				**/
	/***Funciones auxiliares																																				**/
	/*************************************************************************************************************************************************************************/
	
	/*****
	 * Funcionalidad:		Verifica si existe una mesa 
	 * Testeada: ?
	 * Fecha Creeado: 		17/04/2017
	 * Fecha Modificado: 	17/04/2017
	 * 
	 * @param _idMesa
	 * @return
	 * @throws SQLException
	 */
	public boolean existeMesa(int _idMesa) throws SQLException{
		boolean existe = false;
		listMesas = listarMesas();
		Iterator<voMesa> it = listMesas.iterator();
		while(it.hasNext() && !existe){
			voMesa mes = it.next();
			if(mes.getIdMesa()==_idMesa)
				existe= true;
		}
		return existe;
	}
	
	/******
	 * Funcionalidad:		Verifica si existe un ingrediente 
	 * Testeada: 			?
	 * Fecha Creeado: 		23/04/2017
	 * Fecha Modificado: 	23/04/2017
	 * 
	 * 
	 * @param _nombreIngrediente
	 * @return
	 * @throws SQLException
	 */
	public boolean existeIngrediente(String _nombreIngrediente) throws SQLException{
		boolean existe = false;
		listIngrediente = listarIngrediente();
		Iterator<voIngrediente> it = listIngrediente.iterator();
		while(it.hasNext() && !existe){
			voIngrediente ing = it.next();
			if(ing.getNombreIngrediente().equals(_nombreIngrediente))
				existe= true;
		}
		return existe;
	}
	
	
	/*
	 * Queda en desuso
	public boolean existeTipoIng (String _nombreTipoIng) throws SQLException{
		boolean existe = false;
		listTipoIngrediente = listarTipoIngrediente();
		Iterator<voTipoIngrediente> it = listTipoIngrediente.iterator();
		while(it.hasNext() && !existe){
			voTipoIngrediente ing = it.next();
			if(ing.getTipoIngNombre().equals(_nombreTipoIng))
				existe= true;
		}
		return existe;
	}
	*/
	/**
	 * @throws SQLException **
	 * 
	 */
	public ImageIcon ObtenerImagenMesa(int estado) throws SQLException{
		ImageIcon iconoMesa = null;
		if(estado==0){
			iconoMesa = new ImageIcon("C:\\Users\\Chello Marcelo\\Desktop\\Lugar de Trabajo\\base.v0.0\\Documentación\\Pruebas\\Imagenes\\Mesa3.png");
		}else{
			iconoMesa = new ImageIcon("C:\\Users\\Chello Marcelo\\Desktop\\Lugar de Trabajo\\base.v0.0\\Documentación\\Pruebas\\Imagenes\\MesaOn.png");
		}
		return iconoMesa; 
	}

	
	
	
}
