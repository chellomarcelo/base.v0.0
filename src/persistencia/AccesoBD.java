package persistencia;


import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

import logica.Config;
import logica.familia;
import logica.fecha;
import logica.producto;
import logica.vo.voFamilia;
import logica.vo.voProveedor;
import logica.vo.voProducto;
import logica.vo.voTipoProveedor;
import logica.Imagen;

public class AccesoBD {
	
	private Consultas consultas;
	private Connection con;
	private fecha f;
	
	public AccesoBD() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		con = ConectorDB.conectar(Config.getInstance().getProperty("base"));
		consultas = new Consultas();
	}
	
	/***
	 *   Crea un producto y automaticamente lo relaciona al stockPrincipal
	 * 	 int idProducto;
		 String nombreProducto;
		 int 	idProveedor;
		 String nombreFamilia;
		 String fechaCreacion;
		 String fechaModificacion;
		 String urlFoto;
		 int cantidadRepuesto
		 float precioIva;
		 float precioSIva;
	
	 * @param producto
	 * @throws SQLException
	 * @throws FileNotFoundException 
	 */
	public void crearProducto (voProducto _voProducto) throws SQLException, FileNotFoundException {
		
		if (f==null){
			f = new fecha();
		}
		FileInputStream fis = null;
		if (_voProducto.getUrlFoto().equals("")){
			System.out.println("vino vacia la url");
		}
		File file = new File(_voProducto.getUrlFoto());
		fis = new FileInputStream(file);
		try{
			PreparedStatement ps = con.prepareStatement(consultas.crearProducto());
			//ps.setInt(1, getMaxIdRepuesto()+1);
			ps.setString(1, _voProducto.getNombreProducto());
			ps.setString(2, _voProducto.getIdProveedor());
			ps.setInt(3, _voProducto.getIdFamilia());
			ps.setInt(4, _voProducto.getCantidadProducto());
			ps.setFloat(5, _voProducto.getPrecioIva());
			ps.setFloat(6, _voProducto.getPrecioSIva());
			ps.setBinaryStream(7, fis, (int) file.length()); //setString(7, _voProducto.getUrlFoto());
			ps.setString(8, _voProducto.getFechaIngreso());
			ps.setString(9, _voProducto.getFechaVencimiento());
			ps.setString(10, _voProducto.getLote());
			ps.setString(11, _voProducto.getCodBar());
			ps.setString(12, _voProducto.getDescripcion());
			ps.setString(13, f.getFecha());
			ps.setString(14, f.getFecha());
			ps.setString(15, f.getHora());
		System.out.println(_voProducto.getNombreProducto());
		System.out.println(_voProducto.getIdProveedor());
		System.out.println(_voProducto.getIdFamilia());
		System.out.println(_voProducto.getCantidadProducto());
		System.out.println(_voProducto.getPrecioIva());
		System.out.println(_voProducto.getPrecioSIva());
		System.out.println("Largo: "+_voProducto.getUrlFoto().length()+" "+_voProducto.getUrlFoto());
		
		System.out.println(_voProducto.getFechaIngreso());
		System.out.println(_voProducto.getFechaVencimiento());
		System.out.println(_voProducto.getLote());
		System.out.println(_voProducto.getCodBar());
		System.out.println(_voProducto.getDescripcion());
		System.out.println(f.getFecha());
		System.out.println(f.getHora());
		
		ps.executeUpdate();
		System.out.println("Grabo Producto");
		
		//PARA STOCK
/*		ps = con.prepareStatement(consultas.insertarStock());
		ps.setString(1, "stockPrincipal");
		ps.setInt(2, _Producto.getIdProducto());
		ps.setInt(3, _Producto.getCantidadProducto());
		ps.executeUpdate();
*/		
		ps.close();
		} catch (Exception ex) {
			ex.getStackTrace();
			Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null,ex);
		}
	}

	/***
	 * 	Crea una nueva familia, se le pasa un voFamilia
	 * @throws SQLException 
	 *  Tabla Familia
	 * int idFamilia
	 * varchar (45) nombreFamilia
	 * varchar (10) fecha creación 
	 * varchar (10) fecha modificación
	 */
	public void crearFamilia ( voFamilia _voFamilia ) throws SQLException {
		if (f==null){
			f = new fecha();
		}
		
		PreparedStatement ps = con.prepareStatement(consultas.crearFamilia());
		ps.setInt(1, _voFamilia.getIdFamilia()); 
		ps.setString(2, _voFamilia.getNombreFamilia());
		ps.setString(3, f.getFecha());
		ps.setString(4, f.getFecha());
		ps.setString(5, f.getHora());
		ps.executeUpdate();
		ps.close();
	}
	
	public void crearTipoProveedor(voTipoProveedor _voTipoProveedor) throws SQLException {
		if (f==null){
			f = new fecha();
		}
		
		PreparedStatement ps = con.prepareStatement(consultas.crearTipoProveedor());
		//ps.setInt(1, _voTipoProveedor.getIdTipoProveedor()); 
		ps.setString(1, _voTipoProveedor.getNombreTipoProveedor());
		ps.setString(2, f.getFecha());
		ps.setString(3, f.getFecha());
		ps.setString(4, f.getHora());
		ps.executeUpdate();
		ps.close();	
		
	}
	
	/****
	 * 	private int idProveedor;
		private String nombreProveedor;
		private String nombreFantasia;
		private String nombreAuxiliar;
		private String tipoProveedor;
		private int rut;
		private String dir1;
		private String dir2;
		private String dir3;
		private int tel1;
		private int tel2;
		private int tel3;
		private int cel1;
		private int cel2;
		private int cel3;
		private String correo1;
		private String correo2;
		private String correo3;
		private String contacto1;
		private String contacto2;
		private String contacto3;
		private String comentarios;
		private String horarioAtentcion;
	 * @param _voProveedor
	 * @throws SQLException
	 */
	///Ver bien la creación del proveedor muchos campos para rellenar
	public void crearProveedor ( voProveedor _voProveedor ) throws SQLException {
		if (f==null){
			f = new fecha();
		}
		
		PreparedStatement ps = con.prepareStatement(consultas.crearProveedor());
		ps.setString(1, _voProveedor.getIdProveedor()); 
		ps.setString(2, _voProveedor.getNombreProveedor());
		ps.setString(3, _voProveedor.getNombreFantasia());
		ps.setString(4, _voProveedor.getNombreAuxiliar());
		ps.setString(5, _voProveedor.getTipoProveedor());
		ps.setString(6, _voProveedor.getDir1());
		ps.setString(7, _voProveedor.getDir2());
		ps.setString(8, _voProveedor.getDir3());
		ps.setString(9, _voProveedor.getTel1());
		ps.setString(10, _voProveedor.getTel2());
		ps.setString(11, _voProveedor.getTel3());		
		ps.setString(12, _voProveedor.getCel1());
		ps.setString(13, _voProveedor.getCel2());
		ps.setString(14, _voProveedor.getCel3());
		ps.setString(15, _voProveedor.getCorreo1());
		ps.setString(16, _voProveedor.getCorreo2());
		ps.setString(17, _voProveedor.getCorreo3());
		ps.setString(18, _voProveedor.getContacto1());
		ps.setString(19, _voProveedor.getContacto2());
		ps.setString(20, _voProveedor.getContacto3());
		ps.setString(21, _voProveedor.getComentarios());
		ps.setString(22, _voProveedor.getHorarioAtentcion()); 
		ps.setString(23, f.getFecha());
		ps.setString(24, f.getFecha());
		ps.setString(25, f.getHora());
					
		System.out.println("RUT "+_voProveedor.getIdProveedor());
		System.out.println("Nombre "+_voProveedor.getNombreProveedor());
		System.out.println("Hora2: "+f.getHora() );
		 
		ps.executeUpdate();
		ps.close();
	}
	
	/***
	 * Borra el Producto de una familia y la BD
	 * @param _nombreFamilia
	 * @param _idProducto
	 * @throws SQLException
	 */
	public void borrarProductoFamilia(int _idFamilia, int _idProducto) throws SQLException {
		PreparedStatement ps = con.prepareStatement(consultas.borrarProductoFamilia());
		ps.setInt(1, _idFamilia);
		ps.setInt(2, _idProducto);
		ps.executeUpdate();
		ps.close();
	}
	
	/***
	 * Borra la familia de la BD
	 * @param _nombreFamilia
	 * @throws SQLException
	 */
	public void borrarFamilia( String _nombreFamilia ) throws SQLException {
		PreparedStatement ps = con.prepareStatement(consultas.borrarFamilia());
		ps.setString(1, _nombreFamilia);
		ps.executeUpdate();
		ps.close();
	}
	
	/*** Tener en cuenta para futuro - 2017/02/12 para agregar la parte del stock
	 * Borra el Producto de la BD, pasandole el ID y tambien borra el Producto relacionado con el stock
	 * @param _idProducto
	 * @throws SQLException
	 
	public void borrarProducto(int _idProducto) throws SQLException {
		PreparedStatement ps = con.prepareStatement(consultas.borrarProducto());
		ps.setInt(1, _idProducto);
		ps.executeUpdate();
		ps = con.prepareStatement(consultas.borrarProductoStockRelacion());
		ps.setInt(2, _idProducto);
		ps.executeUpdate();
		ps.close();
	}
	*/
	
	/*** 2017/02/12
	 * Borra el Producto de la BD, pasandole el ID 
	 * @param _idProducto
	 * @throws SQLException
	*/ 
	public void borrarProducto(int _idProducto) throws SQLException {
		PreparedStatement ps = con.prepareStatement(consultas.borrarProducto());
		ps.setInt(1, _idProducto);
		ps.executeUpdate();
		ps.close();
	}
	
	/***
	 * Borra Proveedor de la BD
	 * @param _idProveedor
	 * @throws SQLException
	 */
	public void borrarProveedor( String _idProveedor ) throws SQLException {
		PreparedStatement ps = con.prepareStatement(consultas.borrarProveedor());
		ps.setString(1, _idProveedor);
		ps.executeUpdate();
		ps.close();
	}
	
	/***
	 * Insertar en un stock, se le pasa una idStock, que por lo general va a ser un idMatricula,
	 * un idProducto que se quiere ingresar y la cantidad a ingresar
	 * @param _idMatricula
	 * @param _idProducto
	 * @throws SQLException
	 */
	public void insertarStock( String _idStock, int _idProducto, int cantidad) throws SQLException {
		PreparedStatement ps = con.prepareStatement(consultas.insertarStock());
		ps.setString(1, _idStock);
		ps.setInt(2, _idProducto);
		ps.setInt(3, cantidad);
		ps.executeUpdate();
		ps.close();
	}
	
	/*****
	 * Quita un articulo del stock relacionado
	 * @param _idProducto
	 * @throws SQLException
	 */
	public void quitarProductoStock(String _idStock, int _idProducto) throws SQLException {
		PreparedStatement ps = con.prepareStatement(consultas.quitarProductoStockRelacion());
		ps.setString(1, _idStock);
		ps.setInt(2, _idProducto);
		ps.executeUpdate();
		ps.close();
	}
	
	public boolean FamiliaExists(String _nombreFamilia) throws SQLException {
		boolean flag = false;
		PreparedStatement pstmt = con.prepareStatement(consultas.familiaExists());
		pstmt.setString(1, _nombreFamilia);
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()){
			flag = true;
		}	
		rs.close();
		pstmt.close();
		return flag;
	}
	
	/**
	 *  Devuelve un Producto dado, las cantidades van a ser 0 porque eso te lo da el stock
	 * @param _idProducto
	 * @throws SQLException 
	 */
	public producto getProducto(int _idProducto) throws SQLException{
		producto rep = null;
		PreparedStatement ps = con.prepareStatement(consultas.darProducto());
		ps.setInt(1, _idProducto);
		ResultSet rs = ps.executeQuery();	
		
		while (rs.next()){
		rep = new producto(rs.getInt("idRepuesto"), rs.getString("nombreRepuesto"), 
				rs.getString("idProvedor"), rs.getInt("idFamilia"), 
				rs.getString("urlFoto") ,0, 
				rs.getFloat("precioIva"), rs.getFloat("precioSIva"));
		}
		return rep;
	}
	
	/**
	 * 2016/11/28
	 * Le paso el nombre y me devuelve un Producto
	 * @param _idProducto
	 * @throws SQLException 
	 */
	public voProducto getProducto(String _nombreProducto) throws SQLException{
		voProducto auxProd = null;
		PreparedStatement ps = con.prepareStatement(consultas.darProductoNomProd());
		ps.setString(1, _nombreProducto);
		ResultSet rs = ps.executeQuery();	
		
		while (rs.next()){
		auxProd = new voProducto(	rs.getInt("idProducto"), 
									rs.getString("nombreProducto"), 
									rs.getString("idProveedor"), 
									rs.getInt("idFamilia"), 
									rs.getString("urlFoto"), 
									rs.getInt("cantidad"), 
									rs.getFloat("precioIva"), 
									rs.getFloat("precioSIva"), 
									rs.getString("fechaIngreso"), 
									rs.getString("fechaVencimiento"), 
									rs.getString("lote"), 
									rs.getString("codBar"), 
									rs.getString("descripcion"));
		}
		return auxProd;
	}
	
	
	public int getMaxIdProducto() throws SQLException{
		int aux = 0;
		PreparedStatement ps = con.prepareStatement(consultas.getMaxIdProducto());
		ResultSet rs = ps.executeQuery();	
		while (rs.next()){
			aux= rs.getInt(1);
			System.out.println(aux);
		}
		return aux;
	}
	
	public voFamilia getFamilia(String _nombreFamilia) throws SQLException{
		voFamilia voFam = null;
		PreparedStatement ps = con.prepareStatement(consultas.darFamilia());
		ps.setString(1, _nombreFamilia);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			voFam= new voFamilia (rs.getInt("idFamilia"), rs.getString("nombreFamilia"));
		}
		
		return voFam;
	}
	
	
	public voProveedor getProveedor(String _nombreProveedor) throws SQLException{
		voProveedor voPro = null;
		PreparedStatement ps = con.prepareStatement(consultas.darProveedor());
		ps.setString(1, _nombreProveedor);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			voPro= new voProveedor(rs.getString("idProveedor"), rs.getString("nombreProveedor"));
		}
		
		return voPro;
	}
	
	/******
	 * Devuelve un proveedor
	 * @param _rutProveedor
	 * @return
	 * @throws SQLException
	 */
	public voProveedor getProveedorRut(String _rutProveedor) throws SQLException{
		voProveedor voPro = null;
		PreparedStatement ps = con.prepareStatement(consultas.darProveedorRut());
		ps.setString(1, _rutProveedor);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			voPro= new voProveedor(	rs.getString("idProveedor"), 
									rs.getString("nombreProveedor"),
									rs.getString("nombreFantasia"),
									rs.getString("nombreAuxiliar"),
									rs.getString("tipoProveedor"),
									rs.getString("dir1"),
									rs.getString("dir2"),
									rs.getString("dir3"),
									rs.getString("tel1"),
									rs.getString("tel2"),
									rs.getString("tel3"),
									rs.getString("cel1"),
									rs.getString("cel2"),
									rs.getString("cel3"),
									rs.getString("correo1"),
									rs.getString("correo2"),
									rs.getString("correo3"),
									rs.getString("contacto1"),
									rs.getString("contacto2"),
									rs.getString("contacto3"),
									rs.getString("comentarios"),
									rs.getString("horarioAtencion")
									);
		}
		
		return voPro;
	}
	
	public ArrayList getProvTodo() throws SQLException{
		ArrayList<voProveedor> arreProv = new ArrayList<voProveedor>();
		voProveedor voPro = null;
		PreparedStatement ps = con.prepareStatement(consultas.darProvTodos());
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			voPro= new voProveedor(	rs.getString("idProveedor"), 
									rs.getString("nombreProveedor"),
									rs.getString("nombreFantasia"),
									rs.getString("nombreAuxiliar"),
									rs.getString("tipoProveedor"),
									rs.getString("dir1"),
									rs.getString("dir2"),
									rs.getString("dir3"),
									rs.getString("tel1"),
									rs.getString("tel2"),
									rs.getString("tel3"),
									rs.getString("cel1"),
									rs.getString("cel2"),
									rs.getString("cel3"),
									rs.getString("correo1"),
									rs.getString("correo2"),
									rs.getString("correo3"),
									rs.getString("contacto1"),
									rs.getString("contacto2"),
									rs.getString("contacto3"),
									rs.getString("comentarios"),
									rs.getString("horarioAtencion")
									);
			arreProv.add(voPro);
		}
		
		return arreProv;
	}
	
	
	/***
	 *  Lista los Producto por familia
	 * 
	 * 	int idProducto;
		String nombreProducto;
		String nombreProveedor;
		String nombreFamilia;
		String fechaCreacion;
		String fechaModificacion;
		String urlFoto;
		int cantidadProducto;
		float precioIva;
		float precioSIva;
	 * @param ci
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<voProducto> listarProductoXFamilia (int _idFamilia) throws SQLException {
		ArrayList<voProducto> voProd = new ArrayList<voProducto>();
		PreparedStatement ps = con.prepareStatement(consultas.listarProductoXFamilia());
		ps.setInt(1, _idFamilia);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) { 
			voProd.add(new voProducto(	rs.getInt("idProducto"), 
										rs.getString("nombreProducto"), 
										rs.getFloat("precioSIva"), 
										rs.getString("urlFoto") ));
		}
		rs.close();
		ps.close();
		return voProd;
	}
	
	
	public ArrayList<voProducto> listarNombreProducto () throws SQLException {
		ArrayList<voProducto> _repuesto = new ArrayList<voProducto>();
		voProducto aux;
		PreparedStatement ps = con.prepareStatement(consultas.listarIdNombreProducto());
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
				aux = new voProducto(	rs.getInt("idProducto"), 
										rs.getString("nombreProducto"),
										"",
										0,
										"",
										0,
										0,
										0
									); //, rs.getString("nombreProvedor"), rs.getInt("idFamilia"), rs.getString("urlFoto"), rs.getInt("cantidad"), rs.getFloat("precioIva"), rs.getFloat("precioSIva"));
				if(aux!=null)
					_repuesto.add(aux);
		}
		return _repuesto;
	}
	
	public ArrayList<voProducto> listarProductos () throws SQLException {
		ArrayList<voProducto> _repuesto = new ArrayList<voProducto>();
		voProducto aux;
		PreparedStatement ps = con.prepareStatement(consultas.listarProductos());
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
				aux = new voProducto(	rs.getInt("idProducto"), 
										rs.getString("nombreProducto"),
										rs.getString("idProveedor"), 
										rs.getInt("idFamilia"), 
										rs.getString("urlFoto"), 
										rs.getInt("cantidad"), 
										rs.getFloat("precioIva"), 
										rs.getFloat("precioSIva"),
										rs.getString("fechaIngreso"),
										rs.getString("fechaVencimiento"),
										rs.getString("lote"),
										rs.getString("codBar"),
										rs.getString("descripcion")
										);
				if(aux!=null)
					_repuesto.add(aux);
		}
		
		return _repuesto;
	}
	
	/**
	 * Lista las familias
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<voFamilia> listarFamilias () throws SQLException {
		ArrayList<voFamilia> familias = new ArrayList<voFamilia>();
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery(consultas.listarFamilias());

		while (rs.next()) {
				familias.add(new voFamilia(rs.getInt("idFamilia"), rs.getString("nombreFamilia")));
		}
		rs.close();
		s.close();
		
		return familias;
	}

	public void modificarFamilia(voFamilia _voFamilia1, voFamilia _voFamilia2) throws SQLException {
		// TODO Auto-generated method stub
		if (f==null){
			f = new fecha();
		}
		
		PreparedStatement ps = con.prepareStatement(consultas.modificarFamiliar());
		ps.setString(1, _voFamilia2.getNombreFamilia()); //Nombre nuevo
		System.out.println("NomvoFam2 " +_voFamilia2.getNombreFamilia());
		ps.setString(2, f.getFecha());
		ps.setString(3, f.getHora());
		ps.setString(4, _voFamilia1.getNombreFamilia()); //Nombre antiguo
		System.out.println("NomvoFam1 " +_voFamilia1.getNombreFamilia());
		int row = ps.executeUpdate();
		System.out.println("row "+row);
		ps.close();
	}
	
	/**
	 * Lista los proveedores
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<voProveedor> listarProveedores () throws SQLException {
		ArrayList<voProveedor> proveedores = new ArrayList<voProveedor>();
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery(consultas.listarProveedores());

		while (rs.next()) {
				proveedores.add(new voProveedor(rs.getString("idProveedor"), rs.getString("nombreProveedor"), rs.getString("tipoProveedor")));
		}
		rs.close();
		s.close();
		
		return proveedores;
	}
	/**
	 * Lista los tipos de Proveedores
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<voTipoProveedor> listarTipoProveedor() throws SQLException {
		ArrayList<voTipoProveedor> tipoProveedor = new ArrayList<voTipoProveedor>();
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery(consultas.listarTipoProveedores());

		while (rs.next()) {
				tipoProveedor.add(new voTipoProveedor(rs.getString("nombreTipoProveedor")));
		}
		rs.close();
		s.close();
		return tipoProveedor;
	}

	public void modificarProveedor(voProveedor _voData) throws SQLException {
		if (f==null){
			f = new fecha();
		}
		PreparedStatement ps = con.prepareStatement(consultas.modificarProveedor());
		ps.setString(1, _voData.getNombreProveedor()); 
		ps.setString(2, _voData.getNombreFantasia());
		ps.setString(3, _voData.getNombreAuxiliar());
		ps.setString(4, _voData.getTipoProveedor());
		ps.setString(5, _voData.getDir1());
		ps.setString(6, _voData.getDir2());
		ps.setString(7, _voData.getDir3());
		ps.setString(8, _voData.getTel1());
		ps.setString(9, _voData.getTel2());
		ps.setString(10, _voData.getTel3());
		ps.setString(11, _voData.getCel1());
		ps.setString(12, _voData.getCel2());
		ps.setString(13, _voData.getCel3());
		ps.setString(14, _voData.getCorreo1());
		ps.setString(15, _voData.getCorreo2());
		ps.setString(16, _voData.getCorreo3());
		ps.setString(17, _voData.getContacto1());
		ps.setString(18, _voData.getContacto2());
		ps.setString(19, _voData.getContacto3());
		ps.setString(20, _voData.getComentarios());
		ps.setString(21, _voData.getHorarioAtentcion());			
		ps.setString(22, f.getFecha());
		ps.setString(23, f.getHora());
		ps.setString(24, _voData.getIdProveedor()); //Rut
		int row = ps.executeUpdate();
		System.out.println("row "+row);
		ps.close();
	}

	public void modificarProducto(voProducto _voData) throws SQLException, FileNotFoundException {
		if (f==null){
			f = new fecha();
		}
		FileInputStream fis = null;
		File file = new File(_voData.getUrlFoto());
		fis = new FileInputStream(file);
		PreparedStatement ps = con.prepareStatement(consultas.modificarProducto());
		ps.setString(1, _voData.getIdProveedor());
		ps.setInt(2, _voData.getIdFamilia());
		ps.setInt(3, _voData.getCantidadProducto());
		ps.setFloat(4, _voData.getPrecioIva());
		ps.setFloat(5, _voData.getPrecioSIva());
		ps.setBinaryStream(6, fis, (int) file.length()); //ps.setString(6, _voData.getUrlFoto());
		ps.setString(7, _voData.getFechaIngreso());
		ps.setString(8, _voData.getFechaVencimiento());
		ps.setString(9, _voData.getLote());
		ps.setString(10, _voData.getCodBar());
		ps.setString(11, _voData.getDescripcion());
		ps.setString(12, f.getFecha());
		ps.setString(13, f.getHora());
		ps.setInt(14, _voData.getIdProducto()); //busqueda where
		int row = ps.executeUpdate();
		System.out.println("row "+row);
		ps.close();
	}
	
	//REPORTES EXCEL
	
	public int getFilReporteProv() throws SQLException {
		// TODO Auto-generated method stub
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery(consultas.cantFilasProv());
		System.out.println(rs.getInt(1));
		
		int aux = rs.getInt(1);
		rs.close();
		s.close();
		return aux;
	}

	/****
	 * 
	 * @return
	 * @throws SQLException 
	 */
	public Imagen getImagen( String nombreProducto) throws SQLException{
		//Statement st = con.createStatement();
		BufferedImage img=null;
		Imagen imag = null;
		PreparedStatement ps = con.prepareStatement(consultas.getImagenProducto());
		ps.setString(1, nombreProducto); //Nombre nuevo
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			imag = new Imagen();
			Blob blob = rs.getBlob("urlFoto");
			String nombre = rs.getObject("nombreProducto").toString();
			byte[] data = blob.getBytes(1, (int) blob.length());
			img = null;
			
			try {
				img = ImageIO.read(new ByteArrayInputStream(data));
			} catch (IOException ex) {
			//	Logger.getLogger(AccesoBD.class.getName()).log(
				//		Level.SEVERE, null, ex);
			}

			imag.setImagen(img);
		}
		rs.close();
		
		return imag;
		
	}
	
	//Trae todas las imagenes
	ArrayList<Imagen> getImagenes() throws SQLException {
		ArrayList<Imagen> lista = new ArrayList();
		Statement st = con.createStatement();
		try {
			ResultSet rs = st.executeQuery("SELECT imagen,nombre FROM Imagenes");
			while (rs.next()) {
				Imagen imagen = new Imagen();
				Blob blob = rs.getBlob("imagen");
				String nombre = rs.getObject("nombre").toString();
				byte[] data = blob.getBytes(1, (int) blob.length());
				BufferedImage img = null;
				try {
					img = ImageIO.read(new ByteArrayInputStream(data));
				} catch (IOException ex) {
				//	Logger.getLogger(AccesoBD.class.getName()).log(
					//		Level.SEVERE, null, ex);
				}

				imagen.setImagen(img);
				lista.add(imagen);
			}
			rs.close();
		} catch (SQLException ex) {
			//Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null,
			//		ex);
		}
		return lista;
	}
	
}


