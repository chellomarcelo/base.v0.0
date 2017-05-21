package logica.excepciones;

import java.sql.SQLException;

public class ExcProveedores extends SQLException {

	public static final String ERROR_AL_LISTAR = "Error al listar los Proveedores";
	public static final String ERROR_AL_BORRAR = "Error al borrar el Proveedor";
	public static final String PROVEEDOR_NOT_EXISTS = "El Proveedor no existe en el sistema";
	public static final String PROVEEDOR_NOM_EXISTS = "Un Proveedor con el mismo nombre ya existe en el sistema";
	public static final String PROVEEDOR_RUT_EXISTS = "EL RUT ingresado existe en base";
	public static final String ERROR_AL_GUARDAR = "Error al guardar los datos del Proveedor";
	public static final String ERROR_NO_HAY_PROVEEDORES = "No hay proveedores cargados en el sistema";
	public static final String ERROR_SELECT_ITEM = "No ha seleccionado ningún Proveedor";

	public ExcProveedores(String msg){
		super();
	}
	
}
