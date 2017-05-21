package logica.excepciones;

import java.sql.SQLException;

public class ExcepcionesGeneral extends SQLException {

	
	public static final int ERROR_AL_GUARDAR = 1;
	public static final int ERROR_AL_LISTAR = 2;
	public static final int ERROR_EXISTE = 3;
	public static final int ERROR_ESPACIOS_BLANCOS = 4;
	public static final int OK_GUARDO = 5;
	public static final int ERROR_NUMEROS = 6;
	public static final int ERROR_SELECCIONAR = 7;
	public static final int ERROR_RUT = 8;
	public static final int ERROR_CORREO = 9;
	public static final int MODIFICACIONES = 10;
	public static final int FECHA_FORMATO = 11;
	
	public String getMessage(int code){
		String msg = new String();
		switch(code){
			case ERROR_AL_GUARDAR: msg = "Error al guardar los datos del repuesto.";
				break;
			case ERROR_AL_LISTAR: msg = "Error al listar los datos del repuesto.";
				break;
			case ERROR_EXISTE: msg = "Ya existe un repuesto con ese nombre, eliga otro nombre.";
				break;
			case ERROR_ESPACIOS_BLANCOS: msg = "No se permiten espacios en blanco";
				break;
			case OK_GUARDO: msg = "Se registro con exito";
				break;	
			case ERROR_NUMEROS: msg = "Solo se pudee ingresar números";
				break;
			case ERROR_SELECCIONAR: msg = "Debe seleccionar una opción";
				break;
			case ERROR_RUT: msg = "No es un RUT Valido.";
				break;
			case ERROR_CORREO: msg = "No es un correo electronico valido.";
				break;
			case MODIFICACIONES: msg = "No hubieron modificaciones.";
				break;
			case FECHA_FORMATO: msg = "La fecha no puede ser menor al día de hoy o el formato no es el correcto (AAAA/MM/DD).";
				break;
			//Errores sql
			case 1060:
				msg = "Nombre de columna duplicado";
			break;
			case 1061:
				msg = "Clave duplicada";
			break;
			case 1062:
				msg = "Entrada duplicada";
			break;
			case 1022:
				msg = "Ya se ingreso ese registro";
			break;
			case 1105:
				msg = "Error desconocido de base de datos";
			break;
			case 1452:
				msg = "No se encuentra el dato";
			break;
			default:
				msg ="Error desconocido (" + (new Integer(code)).toString() + ")";
			break;	
		}
		return msg;
	}
	
}
