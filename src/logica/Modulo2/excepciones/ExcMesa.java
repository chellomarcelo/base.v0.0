package logica.Modulo2.excepciones;

import java.sql.SQLException;

public class ExcMesa extends SQLException {
	public static final String ERROR_AL_LISTAR_MESA = "Error al listar las Mesas";
	public static final String ERROR_AL_BORRAR_MESA = "Error al borrar la Mesa";
	public static final String NO_EXISTE_MESA = "La Mesa no existe en el sistema";
	public static final String EXISTE_MESA = "Una Mesa con el mismo c�digo ya existe en el sistema";
	public static final String ERROR_AL_GUARDAR_MESA = "Error al guardar los datos de la Mesa";
	public static final String ERROR_NO_HAY_MESA = "No hay Mesas cargadas en el sistema";
	public static final String ERROR_SELECT_ITEM_MESA = "No ha seleccionado ninguna Mesaa";
	
	public ExcMesa(String msg){
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