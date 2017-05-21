package logica.excepciones;

import java.sql.SQLException;

public class ExcTipoProveedor extends SQLException {
		
	public static final String ERROR_AL_LISTAR_TPROVEEDOR = "Error al listar los tipo de proveedor";
	public static final String ERROR_AL_BORRAR_TPROVEEDOR = "Error al borrar el tipo de proveedor";
	public static final String TPROVEEDOR_NOT_EXISTS = "El tipo de proveedor no existe en el sistema";
	public static final String TPROVEEDOR_EXISTS = "Ya existe el tipo de proveedor en el sistema";
	public static final String ERROR_AL_GUARDAR = "Error al guardar los datos del tipo de proveedor";
	public static final String ERROR_NO_HAY_TPROVEEDOR = "No hay ningun tipo de proveedor cargados en el sistema";
	public static final String ERROR_SELECT_ITEM_TPROVEEDOR = "No ha seleccionado ningún Tipo de proveedor";
	
	public ExcTipoProveedor (String msg){
		super(msg);
	}

	
}
