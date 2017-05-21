package logica.excepciones;

public class MessageError {
	public static final int E_CEDULA_INVALIDA = 12;
	public static final int E_FILE_NOT_FOUND = 13;
	public static final int E_IO = 14;
	public static final int E_CLASS_NOT_FOUND = 15;
	public static final int E_DUENO_NOT_SELECTED = 16;
	public static final int M_DELETE_OK = 18;
	public static final int M_OK = 19;
	public static final int M_NO_DUENOS_FOUND = 20;
	public static final int M_NO_MASCOTAS_FOUND = 21;
	public static final int E_APODO = 22;
	public static final int E_RAZA = 23;
	public static final int E_NOMBRE = 24;
	public static final int E_APELLIDO = 25;
	
	public String getMessage(int code){
		String msg = new String();
		switch(code){
			case M_OK:
				msg = "Guardado OK";
			break;
			case M_DELETE_OK:
				msg = "Borrado OK";
			break;
			case M_NO_DUENOS_FOUND:
				msg = "No se encuentran dueños para listar";
			break;
			case M_NO_MASCOTAS_FOUND:
				msg = "No se encuentran mascotas para listar";
			break;
			case E_CEDULA_INVALIDA:
				msg = "La cédula no es válida. Ej: 1234567";
			break;
			case E_FILE_NOT_FOUND:
				msg = "No se encuentra el archivo de configuracion";
			break;
			case E_IO:
				msg = "Error de entrada/salida";
			break;
			case E_CLASS_NOT_FOUND:
				msg = "No se encuentra la clase";
			break;
			case E_DUENO_NOT_SELECTED:
				msg = "No se selecciono un dueño";
			break;
			case E_APODO:
				msg = "No se ingreso apodo";
			break;
			case E_RAZA:
				msg = "No se ingreso raza";
			break;
			case E_NOMBRE:
				msg = "No se ingreso el nombre";
			break;
			case E_APELLIDO:
				msg = "No se ingreso el apellido";
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
}