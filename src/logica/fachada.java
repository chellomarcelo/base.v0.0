package logica;

import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;

import com.mysql.jdbc.SQLError;

import logica.excepciones.ExcFamilia;
import logica.excepciones.ExcProducto;
import logica.excepciones.ExcProveedores;
import logica.excepciones.ExcTipoProveedor;
import logica.vo.voFamilia;
import logica.vo.voProveedor;
import logica.vo.voProducto;
import logica.vo.voTipoProveedor;


import persistencia.AccesoBD;

public class fachada {
	
	AccesoBD acc;
	Connection con;
	ArrayList<voFamilia> listFamilias = new ArrayList<voFamilia>();
	ArrayList<voProveedor> listProveedores = new ArrayList<voProveedor>();
	ArrayList<voProducto> listProducto = new ArrayList<voProducto>();
	
	/**
	 * Crea una instancia de la conexion de AccesoBD
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public fachada() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException  {
		acc = new AccesoBD();
	}
	
	/**
	 * Testeada y anda bien.
	 * 
	 * @param _familia
	 * @throws SQLException
	 */
	public void crearFamilia (voFamilia _voFamilia) throws SQLException {
		//Verifico si existe esa Familia
		if (!existeFamilia(_voFamilia.getNombreFamilia()))
			acc.crearFamilia(_voFamilia);
		else{
			throw new ExcFamilia(ExcFamilia.FAMILIA_EXISTS);
		}
	}
	
	/***
	 * Testear.
	 * 
	 * @param _voTipoProveedor
	 * @throws SQLException
	 */
	public void crearTipoProveedor(voTipoProveedor _voTipoProveedor) throws SQLException {
		//Verifico si existe el tipo de proovedor
		if (!existeProveedor(_voTipoProveedor.getNombreTipoProveedor()))
			acc.crearTipoProveedor(_voTipoProveedor);
		else{
			throw new ExcTipoProveedor(ExcTipoProveedor.TPROVEEDOR_EXISTS);
		}
	}
	
	/**
	 * Testear - Provisoria.
	 * 
	 * @param _familia
	 * @throws SQLException
	 */
	public void crearProveedor (voProveedor _voProveedor) throws SQLException {
		//Verifico si existe ese Proveedor //Tener en cuenta de buscar por id tambien
		if (!existeProveedor(_voProveedor.getNombreProveedor()))
			acc.crearProveedor(_voProveedor);
		else{
			throw new ExcFamilia(ExcProveedores.PROVEEDOR_NOM_EXISTS);
		}
	}
	
	/***
	 * Testear esta funcion 
	 * Esta funcion crea un provedor verificando el rut si existe o no.
	 * @param _voProveedor
	 * @throws SQLException
	 */
	public void crearProvedor2 (voProveedor _voProveedor) throws SQLException {
		//Verifico por id si existe o no, su identificador es el rut
		if(!existeProveedorRut (_voProveedor.getIdProveedor()))
			acc.crearProveedor(_voProveedor);
		else{
			throw new ExcFamilia(ExcFamilia.FAMILIA_EXISTS);
			}
		
	}
	
	/***
	 * Testeada y anda bien, repuesto con foreing key con nombrefamilia y idrepuesto como key
	 * @param voProducto
	 * @throws SQLException
	 * @throws IOException 
	 */
	public void crearProducto (voProducto _voProducto, int estado) throws SQLException, ExcProducto, IOException {
		if(estado==1){
			if (!existeProducto(_voProducto.getNombreProducto())){
				if(_voProducto.getUrlFoto().equals("")){
					_voProducto.setUrlFoto(Config.getInstance().getProperty(Config.SIN_IMAGEN));
				}
					acc.crearProducto(_voProducto);
			}else{
				throw new  SQLException("El Producto ya existe en la base","", 1060);//ExcProducto();
			}
		}else{
			if(estado== 3){
				if(_voProducto.getUrlFoto().equals("")){
					_voProducto.setUrlFoto(Config.getInstance().getProperty(Config.SIN_IMAGEN));
				}
				acc.modificarProducto(_voProducto); 
			}
		}
	}
		
	
	/**
	 * Testeada y anda bien //Ver de incorporar que al borrar la familia borra los repuestos tambien
	 * 
	 * Se borra la Familia de la BD
	 * @param _nombreFamilia
	 * @throws SQLException
	 */
	public void borrarFamilia(voFamilia _voFamilia) throws SQLException {
		acc.borrarFamilia(_voFamilia.getNombreFamilia());
	}

	/***  No se utiliza 
	 * Borra el repuesto de la familia y la BD, con idRepuesto y la familia asociada
	 * @param _nombreFamilia
	 * @param _idRepuesto
	 * @throws SQLException
	 
	public void borrarProductoFamilia ( producto _voRepuesto) throws SQLException {
		 acc.borrarRepuestoFamilia(_voRepuesto.getidFamilia(), _voRepuesto.getIdRepuesto());
	}
	*/
	
	/*** 2017/02/12
	 * Borra Producto de la BD, con el ID
	 * @param _idRepuesto
	 * @throws SQLException
	 */
	public void borrarProducto( voProducto _voProducto ) throws SQLException {
			acc.borrarProducto(_voProducto.getIdProducto());
	}
	
	/****
	 * Borra un unico Proveedor
	 * @param _voProveedor
	 * @throws SQLException
	 */
	public void borrarProveedor(voProveedor _voProveedor) throws SQLException {
		acc.borrarProveedor(_voProveedor.getIdProveedor());
	}
	
		
	/***
	 * Para el stock tener presenter de crear una tabla como registro, las cantidades van en el producto
	 * Inserto un stock, se le pasa un idMatricula, idRepuesto y cantidades
	 * @param _idMatricula
	 * @param _voRepuesto
	 * @throws SQLException
	 */
	public void insertarStock ( String _idMatricula, producto _voRepuesto ) throws SQLException {
		acc.insertarStock(_idMatricula, _voRepuesto.getIdRepuesto(), _voRepuesto.getCantidadRepuesto());
	}
	
	/***
	 * Se pasa un voStock, y se quita un repuesto relacionado con dicho stock
	 * @param _voStock
	 * @throws SQLException
	 */
	public void quitarArticuloStock ( stock _voStock ) throws SQLException {
		acc.quitarProductoStock(_voStock.getIdStock(), _voStock.getIdRepuesto());
	}
	
	public void setRepuesto ( producto _voRepuesto ) {
		
	}
	
	/***
	 * Se le pasa un idProducto y devuelve un Producto
	 * @param _idProducto
	 * @return
	 * @throws SQLException
	 */
	public producto getProducto ( int _idProducto ) throws SQLException {
		return acc.getProducto(_idProducto);
	}
	
	/****
	 * Devuelve un producto // 2016/11/28 M.A.
	 * @param _rut
	 * @return
	 * @throws SQLException
	 */
	public voProducto getProductoTotal(String _nombreProducto) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("GetProductoTotal antes: "+_nombreProducto);
		voProducto auxProd = acc.getProducto (_nombreProducto);
		System.out.println("ControlCrearProv: "+auxProd.getNombreProducto());
		return auxProd;
	}
	
	public voFamilia getFamilia (voFamilia _voFamilia) throws SQLException{
		voFamilia aux = acc.getFamilia(_voFamilia.getNombreFamilia());
		
		return aux; 
	}
	
	public voProveedor getProveedor (voProveedor _voProveedor) throws SQLException{
		voProveedor aux = acc.getProveedor(_voProveedor.getNombreProveedor());
		
		return aux; 
	}
	
	/*****
	 * Devuelve un ArrayList de Producto, devolviendo id y nombre
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<voProducto> listarNombreProducto() throws SQLException {
		return acc.listarNombreProducto();
	}
	/****
	 * Lo utilizo para la pantalla AbmProductos
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<voProducto> listarProductos() throws SQLException {
		return acc.listarProductos();
	}
	/******
	 * Lo utilizo en la ventana Modo1 traigo los productos dependiendo la familia
	 * @return
	 * @throws SQLException
	 */
	
	public ArrayList<voProducto> listarProductosXFamilia(int _idFamilia) throws SQLException {
		return acc.listarProductoXFamilia(_idFamilia);
	}
	
	/**
	 * @throws SQLException **
	 * 
	 */
	public Imagen ObtenerImagen(String _nombreProducto) throws SQLException{
		return acc.getImagen(_nombreProducto); 
	}
	
	
	/*******
	 * Devuelve un ArrayList de Familia, devolviendo id y nombre
	 * 
	 */
	public ArrayList<voFamilia> listarNombreFamilia() throws SQLException {
		return acc.listarFamilias();
	}
	
	/*******
	 * Devuelve un ArrayList de Proveedores, devolviendo id y nombre
	 * 
	 */
	public ArrayList<voProveedor> listarNombreProveedores() throws SQLException {
		return acc.listarProveedores();
	}
	
	/****
	 * Esta funcion verifica si existe la familia en la base 
	 * @param _nombreFamilia
	 * @return
	 * @throws SQLException 
	 */
	public boolean existeFamilia(String _nombreFamilia) throws SQLException{
		boolean existe = false;
		listFamilias = listarNombreFamilia();
		Iterator<voFamilia> it = listFamilias.iterator();
		while(it.hasNext() && !existe){
			voFamilia fam = it.next();
			if(fam.getNombreFamilia().equalsIgnoreCase(_nombreFamilia))
				existe= true;
		}
		return existe;
	}
	
	/****
	 * Esta funcion verifica si existe el porveedor en la base 
	 * @param _idProveedor
	 * @return
	 * @throws SQLException 
	 */
	public boolean existeProveedor(String _nombreProveedor) throws SQLException{
		boolean existe = false;
		listProveedores = listarNombreProveedor();
		Iterator<voProveedor> it = listProveedores.iterator();
		while(it.hasNext() && !existe){
			voProveedor prov = it.next();
			if(prov.getNombreProveedor().equalsIgnoreCase(_nombreProveedor))
				existe= true;
		}
		return existe;
	}
	
	/***
	 * Hay que probar esta función.
	 * Esta funcion es para verificar si existe el proveedor o no por la clave RUT, hay que trasladar esta funcion a la clase proveedor.
	 * @param _rutProveedor
	 * @return
	 * @throws SQLException
	 */
	public boolean existeProveedorRut (String _rutProveedor) throws SQLException {
		boolean existe = false;
		listProveedores = listarNombreProveedor();
		Iterator<voProveedor> it = listProveedores.iterator();
		while(it.hasNext() && !existe){
			voProveedor prov = it.next();
			if(prov.getIdProveedor()== _rutProveedor)
				existe= true;
		}
		return existe;
	}
	
	/****
	 * Esta funcion verifica si existe el repuesto en la base 
	 * @param _nombreFamilia
	 * @return
	 * @throws SQLException 
	 */
	public boolean existeProducto(String _nombreProducto) throws SQLException{
		boolean existe = false;
		listProducto = listarNombreProducto();
		Iterator<voProducto> it = listProducto.iterator();
		while(it.hasNext() && !existe){
			voProducto pro = it.next();
			if(pro.getNombreProducto().equalsIgnoreCase(_nombreProducto))
				existe= true;
		}
		return existe;
	}
	
	public void modificarFamilia (voFamilia _voFamilia1,voFamilia _voFamilia2) throws SQLException{
		if(existeFamilia(_voFamilia1.getNombreFamilia()) && (!existeFamilia(_voFamilia2.getNombreFamilia()))){
			acc.modificarFamilia(_voFamilia1, _voFamilia2);
		}
	}
	
	/*******
	 * Devuelve un ArrayList de Proveedores, devolviendo id y nombre
	 * 
	 */
	public ArrayList<voProveedor> listarNombreProveedor() throws SQLException {
		return acc.listarProveedores();
	}

	public ArrayList<voTipoProveedor> listarNombresTipoProveedor() throws SQLException {
		return acc.listarTipoProveedor();
	}

	/****
	 * Devuelve un proveedor
	 * @param _rut
	 * @return
	 * @throws SQLException
	 */
	public voProveedor getProveedorTotal(String _rut) throws SQLException {
		// TODO Auto-generated method stub
		voProveedor auxProv = acc.getProveedorRut(_rut);
		System.out.println("ControlCrearProv: "+auxProv.getIdProveedor());
		return auxProv;
	}
	
	/***
	 * Envio un voProveedor y modifico lo que se encuentre en la base para ese voData
	 * @param _voData
	 * @throws SQLException
	 */
	public void modificarProveedor(voProveedor _voData) throws SQLException {
		// TODO Auto-generated method stub
		acc.modificarProveedor(_voData);
	}

	/***
	 * Devuelve todo los proveedores
	 * @return
	 * @throws SQLException
	 */
	public ArrayList getProvTodos() throws SQLException {
		ArrayList<voTipoProveedor> arrProv = new ArrayList<voTipoProveedor>();
		arrProv= acc.getProvTodo();
		return arrProv;
	}
	
	
	
	//////CREACION DE REPORTES
	public void crearReporte(String _nomReporte) throws SQLException, FileNotFoundException, IOException {
	
		try {
			//Cabezal (nombre del reporte y todos los proveedores)
			GenerarExcel gx = new GenerarExcel();
			ArrayList<voProveedor> arrProv = new ArrayList<voProveedor>();
			arrProv = getProvTodos();
			gx.GenerarExcelReport(_nomReporte, arrProv);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	

	
}
