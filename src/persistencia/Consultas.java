package persistencia;

public class Consultas {
	public Consultas() {
		
	}
	
	///////////////////////////////CREAR o INSERT////////////////////////////////////////////////////////////////
	
	/***
	 * 	int idProducto;
		String nombreProducto;
		String nombreProveedor; -- 2015-09-27 cambio
		int idProveedor;
		int idFamilia;
		int cantidadProducto;
		float precioIva;
		float precioSIva;
		String urlFoto;
		String fechaIngreso;
		String fechaVencimiento;
		String lote;
		String codBar;
		String descripcion;
		String fechaCreacion;
		String fechaModificacion;
		String horaModificacion
	 * @return
	 */
	/*public String crearProducto () {
		return new String ( "insert into Producto (nombreProducto, nombreProvedor, idFamilia, " +
							"cantidad, precioIva, precioSIva, urlFoto, fechaCreacion,  fechaModificacion ) values ( ?, ?, ?, ?, ?, ?, ?, ?, ?)");
	}*/
	public String crearProducto () {
		return new String ( "insert into producto (nombreProducto, idProveedor, idFamilia, " +
							"cantidad, precioIva, precioSIva, urlFoto, fechaIngreso, fechaVencimiento, " +
							"lote, codBar, descripcion, fechaCreacion,  fechaModificacion, horaModificacion ) " +
							"values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)");
	}
	
	/***
	 * 	String nombreFamilia
	 * @return
	 */
	public String crearFamilia () {
		return new String("INSERT INTO familia ( idFamilia, nombreFamilia, fechaCreacion, fechaModificacion, horaModificacion ) VALUES ( ?, ?, ?, ?, ? )");
	}
	
	public String crearTipoProveedor() {
		return new String("INSERT INTO tipoProveedor ( nombreTipoProveedor, fechaCreacion, fechaModificacion, horaModificacion ) VALUES ( ?, ?, ?, ? )");
	}
	
	/*****
	 * 	private int idProveedor;
		private String nombreProveedor;
		private String nombreFantasia;
		private String nombreAuxiliar;
		private String tipoProveedor;
		private String dir1;
		private String dir2;
		private String dir3;
		private String tel1;
		private String tel2;
		private String tel3;
		private String cel1;
		private String cel2;
		private String cel3;
		private String correo1;
		private String correo2;
		private String correo3;
		private String contacto1;
		private String contacto2;
		private String contacto3;
		private String comentarios;
		private String horarioAtentcion;
		
		A parte: fechaCreacion, fechaModificacion, horaModiifacion
	 * @return
	 */
	public String crearProveedor () {
		return new String ("INSERT INTO Proveedor (idProveedor, nombreProveedor, nombreFantasia, nombreAuxiliar, tipoProveedor, " +
				"dir1, dir2, dir3, tel1, tel2, tel3, cel1, cel2, cel3, correo1, correo2, correo3, contacto1, contacto2, contacto3, " +
				"comentarios, horarioAtencion, fechaCreacion, fechaModificacion, horaModificacion) " +
				"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
	}
		
	/***
	 *  Se modifica el valor de la BD stockRelacion ( 	Cada vez que se crea un repuesto nuevo
	 *  												cae en StockPrincipal )
	 * @return
	 */
	public String insertarStock() {
		return new String ( "INSERT INTO stockRelacion (idStock, idProducto, cantidad) values ( ?, ?, ?)");
	}
	
	//////////////////////////LISTAS////////////////////////////////////////////////////////////////	
	/***
	 * 	
	 * @return
	 */
	public String listarFamilias () {
		return new String("SELECT * FROM familia");
	}
	
	/***
	 * 	Lista los repuesto de una familia dado
	 * 	String nombreFamilia
	 */
	public String listarProductoXFamilia () {
		return new String("SELECT * FROM producto WHERE idFamilia = ?");
	}
	
	/***
	 * Devuelve solo idProducto y nombreProducto
	 * @return
	 */
	public String listarIdNombreProducto() {
		return new String ( "Select idProducto, nombreProducto FROM producto");
	}
	
	public String listarProductos() {
		return new String ( "Select * FROM producto");
	}
	
	/***
	 * Devuelve solo idProveedor y nombreProveedor
	 * @return
	 */
	public String listarProveedores() {
		return new String ("Select idProveedor, nombreProveedor, tipoProveedor from proveedor");		
	}
	
	public String listarTipoProveedores() {
		return new String ("Select nombreTipoProveedor from tipoproveedor");
	}
	
	//////////////////////////Borrar////////////////////////////////////////////////////////////////
	
	/***
	 * 	Borra una familia dada
	 * 	String nombreFamilia
	 * @return
	 */
	public String borrarFamilia () {
		return new String("DELETE FROM familia WHERE nombrefamilia = ?");
	}
	
	
	/*** No se utiliza 
	 * 	String nombreFamilia
	 * 	int idProducto
	 * 	Borrar Producto pasandole datos del abmProducto
	 * @return
	 */
	public String borrarProductoFamilia () {
		return new String("DELETE FROM producto WHERE nombreFamilia = ? and idProducto = ?");
	}
	
	/***  2017/02/12
	 * 	String IdProducto
	 * 	Borra Producto de la BD
	 */
	public String borrarProducto () {
		return new String("DELETE FROM producto WHERE idProducto = ? ");
	}
	
	/***
	 * int idProducto
	 * Borra todo Producto relacionado con cierto idStock. Esto se utiliza solo para cuando se borra un 
	 * Producto de la BD
	 */
	public String borrarProductoStockRelacion () {
		return new String ("DELETE FROM stockRelacion WHERE idProducto = ?");
	}
	
	/***
	 * 	Borra un Proveedor dado
	 * 	String idProveedor
	 * @return
	 */
	public String borrarProveedor() {
		return new String("DELETE FROM proveedor WHERE idProveedor = ?");
	}
	
	/****
	 * Quita Producto relacionado con cierto stock
	 * @return
	 */
	public String quitarProductoStockRelacion () {
		return new String ("DELETE FROM stockRelacion WHERE idStock = ? and idProducto = ?");
	}
	
	/***
	 * String idStock
	 * Borra todos los stock de stockRelacion.
	 */
	public String borrarStockRelacion () {
		return new String ("DELETE FROM stockRelacion WHERE idStock = ?");
	}
	
	/***
	 * Borra una camioneta, pasandole la idMatricula
	 * @return
	 */
	public String borrarCamioneta () {
		return new String ("DELETE FROM camioneta WHERE idMatricula = ?");
	}
	
	//////////////////////////Existe////////////////////////////////////////////////////////////////
	
	/***
	 * 	Cheque si existe una familia dada
	 * @return
	 */
	public String familiaExists() {
		return new String("SELECT * FROM familia WHERE nombrefamilia = ?");
	}
	
	/***
	 * 	String nombreFamilia
	 * 	int idProducto
	 * 	Cheque si existe un Producto en una familia dada
	 * @return
	 */
	public String ProductoExists() {
		return new String("SELECT * FROM Producto WHERE nombrefamilia = ? AND nombreProducto = ?");
	}

	//////////////////////////Modificar////////////////////////////////////////////////////////////////
	
	public String modificarFamiliar(){
		return new String ("UPDATE FAMILIA SET nombreFamilia= ? , fechaModificacion= ?, horaModifiacion= ?  WHERE nombreFamilia like ?");
				//ejemplo: update familia set nombreFamilia='Prueba117', fechaModificacion='2014712'  where nombreFamilia='Prueba17'
	}
		
	//	UPDATE PROVEEDOR
	public String modificarProveedor(){
		
		String ss = new String ("UPDATE PROVEEDOR SET nombreProveedor= ?, " +
												"nombreFantasia= ?, "+  
												"nombreAuxiliar= ?, "+ 
												"tipoProveedor= ?, " +
												"dir1= ?, " +
												"dir2= ?," +
												"dir3= ?," +
												"tel1= ?, " +
												"tel2= ?, " +
												"tel3= ?, " +
												"cel1= ?, " +
												"cel2= ?, " +
												"cel3= ?, " +
												"correo1= ?, " +
												"correo2= ?, " +
												"correo3= ?, " +
												"contacto1= ?, " +
												"contacto2= ?, " +
												"contacto3= ?," +
												"comentarios= ?, " +
												"horarioAtencion= ?, " +
												"fechaModificacion= ?, " +
												"horaModificacion= ? " +	
												"WHERE idproveedor= ?");
		System.out.println(ss);
		return ss;
				//ejemplo: update familia set nombreFamilia='Prueba117', fechaModificacion='2014712'  where nombreFamilia='Prueba17'
	}
	
	//Update Producto
public String modificarProducto(){
		String ss = new String ("UPDATE PRODUCTO SET 	idProveedor= ?, "+  
														"idFamilia= ?, "+ 
														"cantidad= ?, " +
														"precioIva= ?, " +
														"precioSIva= ?," +
														"urlFoto= ?," +
														"fechaIngreso= ?, " +
														"fechaVencimiento= ?, " +
														"lote= ?, " +
														"codBar= ?, " +
														"descripcion= ?, " +
														"fechaModificacion= ?, " +
														"horaModificacion= ? " +	
														"WHERE idproducto= ?"
								);
		System.out.println(ss);
		return ss;
	}
	//////////////////////////Consultas////////////////////////////////////////////////////////////////
	/***
	 * 	String nombreFamilia
	 * @return
	 */
	public String darFamilia () {
		return new String("SELECT * FROM familia WHERE nombreFamilia = ?");
	}
	
	/******
	 * Int idProducto
	 * @return
	 */
	public String darProducto () {
		return new String ("Select * from producto where idProducto = ?");
	}
	
	/******
	 * 2016/11/28
	 * String nombreProducto
	 * @return
	 */
	public String darProductoNomProd () {
		return new String ("Select * from producto where nombreProducto = ?");
	}
	
	/****
	 * 2017/02/12
	 * Voy a buscar el blob mediante el producto.
	 * @return
	 */
	public String getImagenProducto (){
		return new String ("SELECT nombreProducto,urlFoto FROM Producto where nombreProducto=?");
	}

	
	/***
	 * Otorga el ultimo producto ingresado
	 * @return
	 */
	public String getMaxIdProducto(){
		return new String ("SELECT MAX(idProducto ) from Producto");
	}
	
	/***
	 * 	String nombreProveedor
	 * @return
	 */
	public String darProveedor() {
		return new String("SELECT * FROM proveedor WHERE nombreProveedor like ?");
	}

	/***
	 * 	String idProveedor
	 * @return
	 */
	public String darProveedorRut() {
		return new String("SELECT * FROM proveedor WHERE idProveedor = ?");
	}
	
	/***
	 * Devuelvo todos los proveedores
	 * @return
	 */
	public String darProvTodos(){
		return new String ("SELECT * FROM proveedor");
	}
	
	/****
	 * Devuelve la cantidad de datos en proveedores.
	 * @return
	 */
	public String cantFilasProv() {
		return new String ("SELECT COUNT(*) FROM proveedor");
	}
	

	
}
