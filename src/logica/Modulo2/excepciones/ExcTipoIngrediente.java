package logica.Modulo2.excepciones;

import java.sql.SQLException;


public class ExcTipoIngrediente extends SQLException {

public static final String ERROR_EXISTE_TIP_ING = "No existe el Tipo de Ingrediente";
	

	public ExcTipoIngrediente(String msg){
		super(msg);
	}
	
}
