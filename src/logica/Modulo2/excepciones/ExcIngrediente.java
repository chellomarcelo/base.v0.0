package logica.Modulo2.excepciones;

import java.sql.SQLException;

public class ExcIngrediente  extends SQLException {
	
	public static final String ERROR_AL_LISTAR_INGREDIENTE = "Error al listar los ingredientes";
	public static final String ERROR_AL_BORRAR_INGREDIENTE = "Error al borrar el ingrediente";
	public static final String NO_EXISTE_INGREDIENTE = "El ingrediente no existe en el sistema";
	public static final String EXISTE_INGREDIENTE = "Ya existe ese ingrediente";
	public static final String ERROR_AL_GUARDAR_INGREDIENTE = "Error al guardar los datos del ingrediente";
	public static final String ERROR_NO_HAY_INGREDIENTE = "No hay ingredientes cargadoss en el sistema";
	public static final String ERROR_SELECT_ITEM_INGREDIENTE = "No ha seleccionado ningun ingrediente";
	
	public ExcIngrediente(String msg){
		super();
	}

}
