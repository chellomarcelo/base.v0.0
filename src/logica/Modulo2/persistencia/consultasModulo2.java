package logica.Modulo2.persistencia;

public class consultasModulo2 {
	
	
	public consultasModulo2 () {
		
	}

	
	/*************************************************************************************************************************************************************************/
	/***Crear Objetos //INSERT																																				**/
	/***Crear Objetos //INSERT																																				**/
	/*************************************************************************************************************************************************************************/

	/***
	 * Funcionalidad: Crea una mesa
	 * Testeado:			?
	 * Fecha Creacion:		17/04/2017
	 * Fecha Modificacion:	17/04/2017
	 * @return
	 */
	public String crearMesa () {
		return new String("INSERT INTO mesa ( idmesa, estado, fechaCreacion, fechaModificacion, horaModificacion ) VALUES ( ?, ?, ?, ?, ? )");
	}
	
	
	/****
	 * Funcionalidad: Crea un Ingrediente
	 * Testeado:			?
	 * Fecha Creacion:		23/04/2017
	 * Fecha Modificacion:	23/04/2017
	 *  
	 * @return
	 */
	public String ingresarIngrediente(){
		return new String ("INSERT INTO ingrediente (idIngrediente, idTipoIngrediente, descripcionIngrediente, costo, fechaCreacion, fechaModificacion, horaModificacion) VALUES (?,?,?,?,?,?,?)");
		
	}
	
	/*****
	 * Funcionalidad: Guardo la lista de los ingredientes del producto
	 * Testeado:			?
	 * Fecha Creacion:		07/05/2017
	 * Fecha Modificacion:	07/05/2017 
	 * @return
	 */
	
	public String guardarListaIngProd(){
		return new String ("INSERT INTO relingprod (idProducto, idIngrediente, descripcionIngrediente, fechaCreacion, fechaModificacion, horaModificacion) VALUES (?,?,?,?,?,?)");
	}
	
	/*
	 * Quito porque no parece necesario lo suplanto con el producto mismo.
	public String ingresarTipoIngrediente(){
		return new String ("INSERT INTO tipoIngrediente ");
	}
	*/
	
	/*************************************************************************************************************************************************************************/
	/***Modificar Objetos //UPDATE																																			**/
	/***Modificar Objetos //UPDATE																																			**/
	/*************************************************************************************************************************************************************************/

	/****
	 * Funcionalidad: Modificar una mesa
	 * Testeado:			?
	 * Fecha Creacion:		17/04/2017
	 * Fecha Modificacion:	17/04/2017
	 * @return
	 */
	public String modificarMesa(){
		return new String ("UPDATE mesa SET idMesa= ? , fechaModificacion= ?, horaModifiacion= ?  WHERE idMesa = ?");
	}
	
	
	
	/*************************************************************************************************************************************************************************/
	/***Borrar Objetos //DELETE																																				**/
	/***Borrar Objetos //DELETE																																				**/
	/*************************************************************************************************************************************************************************/
	
	/*****
	 * Funcionalidad: Borrar una mesa
	 * Testeado:			?
	 * Fecha Creacion:		17/04/2017
	 * Fecha Modificacion:	17/04/2017
	 * @return
	 */
	public String borrarMesa () {
		return new String("DELETE FROM mesa WHERE idMesa = ?");
	}
	
	
	/*******
	 * Funcionalidad: Borrar toda la lista de ingredientes de un producto
	 * Testeado:			?
	 * Fecha Creacion:		13/05/2017
	 * Fecha Modificacion:	13/05/2017
	 * 
	 * @return
	 */
	public String borrarLisProdIng () {
		return new String("DELETE FROM relingprod WHERE idproducto = ?");
	}
	
	
	/*************************************************************************************************************************************************************************/
	/***Listar Objetos //SELECT																																				**/
	/***Listar Objetos //SELECT																																				**/
	/*************************************************************************************************************************************************************************/
	
	/***
	 * Funcionalidad: Trae todas las Mesas
	 * Testeado:			?
	 * Fecha Creacion:		17/04/2017
	 * Fecha Modificacion:	17/04/2017
	 * 
	 * @return
	 */
	public String listarMesas () {
		return new String("SELECT * FROM mesa");
	}
	
	/*****
	 * Funcionalidad: Trae todos los Ingredientes
	 * Testeado:			?
	 * Fecha Creacion:		23/04/2017
	 * Fecha Modificacion:	23/04/2017
	 * @return
	 */
	public String listarIngredientes(){
		return new String("SELECT * FROM ingrediente");
	}
	
	/***
	 * Funcionalidad: Trae todos los Tipos de Ingredientes
	 * Testeado:			?
	 * Fecha Creacion:		01/05/2017
	 * Fecha Modificacion:	01/05/2017 
	 * @return
	 */
	/*
	public String listarTipoIngrediente(){
		return new String ("SELECT * FROM tipoIngrediente");
	}
	*/
	
	/****
	 * Funcionalidad: Trae los ingredientes de un prdocuto
	 * Testeado:			?
	 * Fecha Creacion:		13/05/2017
	 * Fecha Modificacion:	13/05/2017
 	 *
	 * @return
	 */
	public String listarRelIngProd(){
		return new String ("SELECT * FROM relingprod where idproducto=?");
	}
	
	/******
	 * Funcionalidad: Trae 1 Mesa
	 * Testeado:			?
	 * Fecha Creacion:		17/04/2017
	 * Fecha Modificacion:	17/04/2017
	 *
	 * @return
	 */
	public String darMesa() {
		return new String ("SELECT * FROM mesa where idmesa= ?");
	}
	
	
	/****
	 * Funcionalidad: 		Trae una mesa sola
	 * Testeado:			?
	 * Fecha Creacion:		17/04/2017
	 * Fecha Modificacion:	17/04/2017
	 * 
	 * @return
	 */
	public String mesaExiste() {
		return new String("SELECT * FROM mesa WHERE idMesa = ?");
	}
	
	
}
