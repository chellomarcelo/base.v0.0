package logica;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Config {
	static final String CONFIG_FILE = "config/config.properties";
	public static final String 	SERVIDOR = "servidor";
	public static final String 	PUERTO = "puerto";
	public static final String 	BASE = "base";
	public static final String 	CONNECTION_STRING = "connectionString";
	public static final String 	DRIVER = "driver";
	public static final String 	USER = "user";
	public static final String 	PASS = "pass";
	public static final String 	APP_NAME = "appName";
	public static final String 	CONST_IVA = "const_iva";
	public static final int		DECIMALES=2;
	public static final String  SIN_IMAGEN= "rutaImagenes";
	
	//Reportes Rutas
	public static final String REPORTE_PROVEEDOR = "provReportExcel";
	
 	
	static private Config me = null;
	Properties config;
	
	private Config() throws FileNotFoundException, IOException {
		config = new Properties();
		config.load(new FileInputStream(CONFIG_FILE));
	}
	
	public static Config getInstance() throws FileNotFoundException, IOException {
		if (me == null) {
			me = new Config();
		}
		return me;
	}
	
	public String getProperty (String propertyName) {
		return config.getProperty(propertyName);
	}
}
