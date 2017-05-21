package logica.Modulo2.persistencia;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import logica.Config;
import logica.fecha;
import logica.Modulo2.vo.voIngrediente;
import logica.Modulo2.vo.voMesa;
import logica.Modulo2.vo.voRelIngProd;
import logica.vo.voFamilia;
import persistencia.ConectorDB;
import persistencia.Consultas;

public class AccesoBDModulo2 {

	
	private consultasModulo2 consultas;
	private Connection con;
	private fecha f;
	
	public AccesoBDModulo2 () throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		con = ConectorDB.conectar(Config.getInstance().getProperty("base"));
		consultas = new consultasModulo2();
	}


	/*************************************************************************************************************************************************************************/
	/***Crear Objetos //INSERT																																				**/
	/***Crear Objetos //INSERT																																				**/
	/*************************************************************************************************************************************************************************/	
	
	
	/****
	 * Funcionalidad:			Crear una Mesa
	 * Testeado:				?
	 * Fecha Creacion: 			17/04/2017
	 * Fecha Modificacion:  	17/04/2017
	 *
	 * 
	 * Tabla Mesa
	 * int idMesa
	 * varchar (10) fecha creación 
	 * varchar (10) fecha modificación
	 * varchar ( 8) hora modificacion
	 * 
	 * @param _voMesa
	 * @throws SQLException
	 */

	public void crearMesa ( voMesa _voMesa ) throws SQLException {
		if (f==null){
			f = new fecha();
		}
		
		PreparedStatement ps = con.prepareStatement(consultas.crearMesa());
		ps.setInt(1, _voMesa.getIdMesa());
		ps.setInt(2, _voMesa.getEstado());
		ps.setString(3, f.getFecha());
		ps.setString(4, f.getFecha());
		ps.setString(5, f.getHora());
		ps.executeUpdate();
		ps.close();
	}
	
	/******
	 * Funcionalidad:			Ingresar un ingrediente
	 * Testeado:				?
	 * Fecha Creacion: 			23/04/2017
	 * Fecha Modificacion:  	06/05/2017
	 * 
	 * Tabla Ingrediente
	 * int 			idIngrediente
	 * int 			idTipoIngrediente
	 * varchar(50) 	descripcionIngrediente
	 * varchar (10) fecha creación 
	 * varchar (10) fecha modificación
	 * varchar ( 8) hora modificacion
	 * 
	 * @param _voIngrediente
	 * @throws SQLException
	 */
	public void altaIngrediente (voIngrediente _voIngrediente) throws SQLException {
		if(f==null){
			f= new fecha();
		}
		
		PreparedStatement ps = con.prepareStatement(consultas.ingresarIngrediente());
		ps.setInt(1, 0);
		//ps.setInt(2, _voIngrediente.getIdProducto());
		ps.setInt(2, 0);
		ps.setString(3, _voIngrediente.getNombreIngrediente());
		ps.setFloat(4, _voIngrediente.getCosto());
		ps.setString(5, f.getFecha());
		ps.setString(6, f.getFecha());
		ps.setString(7, f.getHora());
		ps.executeUpdate();
		ps.close();
		
		
	}
	
	
	/****
	 * Funcionalidad:			Ingreso la lista de ingredientes asociada a un prodcuto
	 * Testeado:				?
	 * Fecha Creacion: 			23/04/2017
	 * Fecha Modificacion:  	13/05/2017 //Agrego que antes de guardar borre toda la lista
	 * 
	 * @param _listProdIngGua
	 * @param _idProd
	 * @throws SQLException
	 */
	public void guardarListIngProd(ArrayList<voIngrediente> _listProdIngGua,int _idProd) throws SQLException {
		if(f==null){
			f= new fecha();
		}
		borrarListProdIng(_idProd);
		for (int i=0;i<_listProdIngGua.size();i++){
		
			PreparedStatement ps = con.prepareStatement(consultas.guardarListaIngProd());
			ps.setInt(1, _listProdIngGua.get(i).getIdProducto());
			ps.setInt(2, _listProdIngGua.get(i).getIdIngrediente());
			System.out.println(_listProdIngGua.get(i).getIdIngrediente());
			ps.setString(3, _listProdIngGua.get(i).getNombreIngrediente());
			System.out.println(_listProdIngGua.get(i).getNombreIngrediente());
			ps.setString(4, f.getFecha());
			ps.setString(5, f.getFecha());
			ps.setString(6, f.getHora());
			ps.executeUpdate();
			ps.close();
		}
	}

	/*
	 * Quito porque parece ser no necesario lo suplanto con el producto mismo.
	public void crearTipoIngrediente (voTipoIngrediente _voTipoIng) {
		if(f==null){
			f= new fecha();
		}
		
		PreparedStatement ps = con.prepareStatement(consultas.ingresarIngrediente());
		ps.setInt(1, 0);
		ps.setInt(2, _voIngrediente.getIdTipoIngrediente());
		ps.setString(3, _voIngrediente.getNombreIngrediente());
		ps.setFloat(4, _voIngrediente.getCosto());
		ps.setString(5, f.getFecha());
		ps.setString(6, f.getFecha());
		ps.setString(7, f.getHora());
		ps.executeUpdate();
		ps.close();
		
		
	}
		
	}
	*/
	
	
	/*************************************************************************************************************************************************************************/
	/***Modificar Objetos //UPDATE																																			**/
	/***Modificar Objetos //UPDATE																																			**/
	/*************************************************************************************************************************************************************************/
	
	/*****
	 * Funcionalidad:			Modificar el id de una Mesa
	 * Testeado:				?
	 * Fecha Creacion: 			17/04/2017
	 * Fecha Modificacion:  	17/04/2017
	 * 
	 * @param _voMesa1
	 * @param _voMesa2
	 * @throws SQLException
	 */
	public void modificarMesa(voMesa _voMesa1, voMesa _voMesa2) throws SQLException {
		if (f==null){
			f = new fecha();
		}
		
		PreparedStatement ps = con.prepareStatement(consultas.modificarMesa());
		ps.setInt(1, _voMesa2.getIdMesa()); //Nombre nuevo
		System.out.println("NomvoFam2 " +_voMesa2.getIdMesa());
		ps.setString(2, f.getFecha());
		ps.setString(3, f.getHora());
		ps.setInt(4, _voMesa1.getIdMesa()); //Nombre antiguo
		System.out.println("NomvoFam1 " +_voMesa1.getIdMesa());
		int row = ps.executeUpdate();
		System.out.println("row "+row);
		ps.close();
	}
	
	
	
	/*************************************************************************************************************************************************************************/
	/***Borrar Objetos //DELETE																																				**/
	/***Borrar Objetos //DELETE																																				**/
	/*************************************************************************************************************************************************************************/

	
	/*****
	 * Funcionalidad:			Borrar una Mesa
	 * Testeado:				?
	 * Fecha Creacion: 			17/04/2017
	 * Fecha Modificacion:  	17/04/2017
	 *
	 * @param _idMesa
	 * @throws SQLException
	 */
	
	public void borrarMesa( int _idMesa ) throws SQLException {
		PreparedStatement ps = con.prepareStatement(consultas.borrarMesa());
		ps.setInt(1, _idMesa);
		ps.executeUpdate();
		ps.close();
	}
	
	/****
	 * Funcionalidad:			Borrar la lista de ingredientes de un producto
	 * Testeado:				?
	 * Fecha Creacion: 			13/05/2017
	 * Fecha Modificacion:  	13/05/2017
	 *  
	 * @param _idProd
	 * @throws SQLException
	 */
	public void borrarListProdIng( int _idProd) throws SQLException{
		PreparedStatement ps = con.prepareStatement(consultas.borrarLisProdIng());
		ps.setInt(1, _idProd);
		ps.executeUpdate();
		ps.close();
	}
	
	
	/*************************************************************************************************************************************************************************/
	/***Listar Objetos //SELECT																																				**/
	/***Listar Objetos //SELECT																																				**/
	/*************************************************************************************************************************************************************************/

	/*****
	 * Funcionalidad:			Trae una Mesa
	 * Testeado:				?
	 * Fecha Creacion: 			17/04/2017
	 * Fecha Modificacion:  	17/04/2017
	 * 
	 * @param _idMesa
	 * @return
	 * @throws SQLException
	 */
	public voMesa getMesa(int _idMesa) throws SQLException{
		voMesa _voMesa = null;
		PreparedStatement ps = con.prepareStatement(consultas.darMesa());
		ps.setInt(1, _idMesa);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			_voMesa= new voMesa (rs.getInt("idMesa"),rs.getInt("estado"));
		}
		
		return _voMesa;
	}
	
	/******
	 * Funcionalidad:			Trae todas Mesa
	 * Testeado:				?
	 * Fecha Creacion: 			17/04/2017
	 * Fecha Modificacion:  	17/04/2017
	 * 
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<voMesa> listarMesas () throws SQLException {
		ArrayList<voMesa> mesas = new ArrayList<voMesa>();
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery(consultas.listarMesas());

		while (rs.next()) {
				mesas.add(new voMesa(rs.getInt("idMesa"), rs.getInt("estado")));
				System.out.println("rs.getidMesa" +rs.getInt("idMesa"));
		}
		rs.close();
		s.close();
		
		return mesas;
	}
	
	
	/*****
	 * Funcionalidad:			Trae todos los Ingrediente
	 * Testeado:				?
	 * Fecha Creacion: 			23/04/2017
	 * Fecha Modificacion:  	23/04/2017
	 *  
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<voIngrediente> listarIngrediente () throws SQLException {
		ArrayList<voIngrediente> _ingredientes = new ArrayList<voIngrediente>();
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery(consultas.listarIngredientes());
		
		while (rs.next()){
		//	System.out.println(rs.getInt("idIngrediente"));
		//	System.out.println(rs.getInt("idTipoIngrediente"));
	    //	System.out.println(rs.getString("descripcionIngrediente"));
			_ingredientes.add(new voIngrediente (	rs.getInt("idIngrediente"),
													rs.getInt("idTipoIngrediente"),
													rs.getString("descripcionIngrediente"),
													rs.getFloat("costo")
												));
		}
		rs.close();
		s.close();
		
		return _ingredientes;
	}
	
	
	/****
	 * Funcionalidad:			Trae todos los Tipos de ingredientes Ingrediente
	 * Testeado:				?
	 * Fecha Creacion: 			01/05/2017
	 * Fecha Modificacion:  	01/05/2017
	 * 
	 * @return
	 * @throws SQLException
	 */
	/*
	public ArrayList<voTipoIngrediente> listarTipoIngrediente() throws SQLException {
		ArrayList<voTipoIngrediente> _tipoIng = new ArrayList<voTipoIngrediente>();
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery(consultas.listarTipoIngrediente());
		
		while (rs.next()){
			System.out.println(rs.getInt("idTipoIngrediente"));
			System.out.println(rs.getInt("descripcionTipoIng"));
			_tipoIng.add(new voTipoIngrediente(	rs.getInt("idIngrediente"),
														rs.getString("descripcionTipoIng")
													));
		}
		rs.close();
		s.close();
		
		return _tipoIng;
	}
	*/
	
	/*****
	  * Funcionalidad:			Trae los ingredientes de un producto
	 * Testeado:				?
	 * Fecha Creacion: 			13/05/2017
	 * Fecha Modificacion:  	13/05/2017
	 * 
	 * @param _idProd
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<voRelIngProd> listarProdIng(int _idProd) throws SQLException {
		ArrayList<voRelIngProd> _relProdIng = new ArrayList<voRelIngProd>();
		PreparedStatement ps = con.prepareStatement(consultas.listarRelIngProd());
		ps.setInt(1, _idProd);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()){
			System.out.println(rs.getInt("idproducto"));
			System.out.println(rs.getInt("idIngrediente"));
			System.out.println(rs.getString("descripcionIngrediente"));
			_relProdIng.add(new voRelIngProd(			rs.getInt("idproducto"),
														rs.getInt("idIngrediente"),
														rs.getString("descripcionIngrediente")
													));
		}
		rs.close();
		
		return _relProdIng;
		
	}
	
	/*************************************************************************************************************************************************************************/
	/***Funciones auxiliares																																				**/
	/***Funciones auxiliares																																				**/
	/*************************************************************************************************************************************************************************/
	
	
	private voIngrediente voIngrediente(int int1, int int2, String string, float float1) {
		// TODO Auto-generated method stub
		return null;
	}


	/*****
	 * Funcionalidad:			Consulta una Mesa
	 * Testeado:				?
	 * Fecha Creacion: 			17/04/2017
	 * Fecha Modificacion:  	17/04/2017
	 * 
	 * @param _idMesa
	 * @return
	 * @throws SQLException
	 */
	public boolean MesaExiste(int _idMesa) throws SQLException {
		boolean flag = false;
		PreparedStatement pstmt = con.prepareStatement(consultas.mesaExiste());
		pstmt.setInt(1, _idMesa);
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()){
			flag = true;
		}	
		rs.close();
		pstmt.close();
		return flag;
	}

	
}
