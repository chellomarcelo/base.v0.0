package persistencia;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import logica.Config;

public class ConectorDB {
	public static Connection conectar(String dbName) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		Config config = Config.getInstance();
		Class.forName(config.getProperty(Config.DRIVER));
		
		String url = config.getProperty(Config.CONNECTION_STRING);
		if(dbName != null) url += "/" + dbName;
		Connection con = DriverManager.getConnection(url, config.getProperty(Config.USER), config.getProperty(Config.PASS));
		System.out.println(con);
		System.out.println(url);
		return con;
	}
}
