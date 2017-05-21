package logica.excepciones;

import java.sql.SQLException;

public class ExcFamilia extends SQLException {
	public static final String ERROR_AL_LISTAR = "Error al listar las Familias";
	public static final String ERROR_AL_BORRAR = "Error al borrar la Familia";
	public static final String FAMILIA_NOT_EXISTS = "La Familia no existe en el sistema";
	public static final String FAMILIA_EXISTS = "Una Familia con el mismo c�digo ya existe en el sistema";
	public static final String ERROR_AL_GUARDAR = "Error al guardar los datos del Familias";
	public static final String ERROR_NO_HAY_FAMILIAS = "No hay familias cargadas en el sistema";
	public static final String ERROR_SELECT_ITEM = "No ha seleccionado ninguna Familia";
	
	public ExcFamilia(String msg){
		super(msg);
	}
	
	
/*			//Errores sql
			case 1060:
				msg = "Nombre de columna duplicado";
			break;
			case 1061:
				msg = "Clave duplicada";
			break;
			case 1062:
				msg = "Entrada duplicada";
			break;
			case 1116:
				msg = "Erro al conectar con la base de datos(1116).";
			break;
			case 1022:
				msg = "Ya se ingresó ese registro";
			break;
			case 1105:
				msg = "Error desconocido de base de datos";
			break;
			case 1452:
				msg = "No se encuentra el dueño";
			break;
			default:
				msg ="Error desconocido (" + (new Integer(code)).toString() + ")";
			break;	
		}
		return msg;
	}
*/
}