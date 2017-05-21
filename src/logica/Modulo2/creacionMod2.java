package logica.Modulo2;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import logica.Config;
import persistencia.ConectorDB;

public class creacionMod2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection con = null;
		Statement s;
		int res;
		try {
			con = ConectorDB.conectar(null);
			
			s = con.createStatement();
			
			System.out.println(s. getConnection());
			
			String sql = "CREATE DATABASE IF NOT EXISTS " + Config.getInstance().getProperty(Config.BASE) + " DEFAULT CHARACTER SET UTF8 collate utf8_general_ci";
			System.out.println(sql);
			res = s.executeUpdate(sql);
			System.out.println("Filas afectadas: " + res);
		
			sql = "USE " + Config.getInstance().getProperty(Config.BASE);
			System.out.println(sql);
			s.executeUpdate(sql);
			
			/***
			 * Tabla Mesa - 17/04/2017
			 * int idMesa
			 * int estado
			 * varchar (10) fecha creación 
			 * varchar (10) fecha modificación
			 * varchar ( 8)	hora modificacion  
			 * 
			 */
		
			System.out.println("Creando tabla Mesa");
			res = s.executeUpdate(
					"create table IF NOT EXISTS Mesa (" 		+
					" idMesa int not null," 					+
					" estado int not null DEFAULT 0," 			+		
					" fechaCreacion varchar(10) not null," 		+
					" fechaModificacion varchar(10) not null,"	+
					" horaModificacion varchar(8) not null,"  	+
					" primary key(idMesa)" 					+ 
					") engine=innodb default character set utf8");
			
			System.out.println("Filas Mesa afectadas: " + res);

			/***
			 * Tabla TipoIngrediente - 23/04/2017
			 * int idTipoIngrediente
			 * varchar (50) descripcionTipoIngrediente
			 * varchar (10) fecha creación 
			 * varchar (10) fecha modificación
			 * varchar ( 8)	hora modificacion  
			 * 
			 */
			
			System.out.println("Creando tabla Tipo de Ingrediente");
			res = s.executeUpdate(
					"create table IF NOT EXISTS tipoIngrediente(" 					+
					" idTipoIngrediente int not null AUTO_INCREMENT," 	+
					" descripcionTipoIngr varchar(50) not null," 			+
					" fechaCreacion varchar(10) not null," 			+
					" fechaModificacion varchar(10) not null,"		+
					" horaModificacion varchar(8) not null,"  		+
					" primary key(idTipoIngrediente)" 							+ 
					") engine=innodb default character set utf8");
			
			System.out.println("Filas Tipo de Ingrediente afectadas: " + res);
			
			
			/***
			 * Tabla Ingrediente - 23/04/2017
			 * int 			idIngrediente
			 * int 			idTipoIngrediente
			 * varchar (50) descripcionIngrediente
			 * float 		costo
			 * varchar (10) fecha creación 
			 * varchar (10) fecha modificación
			 * varchar ( 8)	hora modificacion  
			 * 
			 */
		
			System.out.println("Creando tabla Ingrediente");
			res = s.executeUpdate(
					"create table IF NOT EXISTS ingrediente(" 					+
					" idIngrediente int not null AUTO_INCREMENT," 	+
					" idTipoIngrediente int not null,"				+	
					" descripcionIngrediente varchar(50) not null," +
					" costo float,"									+
					" fechaCreacion varchar(10) not null," 			+
					" fechaModificacion varchar(10) not null,"		+
					" horaModificacion varchar(8) not null,"  		+
					" primary key(idIngrediente, idTipoIngrediente)" 							+ 
					") engine=innodb default character set utf8");
			
			System.out.println("Filas Ingrediente afectadas: " + res);
			
			System.out.println("Creando tabla Relacion Producto Ingredientes");
			
			/*****
			 * Tabla relIngProd - 07/05/2017
			 * int 			idProducto
			 * int 			idIngrediente
			 * varchar (50) descripcionIngrediente
			 * varchar (10) fecha creación 
			 * varchar (10) fecha modificación
			 * varchar ( 8)	hora modificacion  
			 */
			res = s.executeUpdate(
					"create table IF NOT EXISTS relIngProd(" 					+
					" idproducto int not null,"				+	
					" idIngrediente int not null," 	+
					" descripcionIngrediente varchar(50) not null," +
					" fechaCreacion varchar(10) not null," 			+
					" fechaModificacion varchar(10) not null,"		+
					" horaModificacion varchar(8) not null,"  		+
					" primary key( idProducto,idIngrediente)" 							+ 
					") engine=innodb default character set utf8");
			
			System.out.println("Filas Ingrediente afectadas: " + res);
			
			
			
			System.out.println("Listo");
		
			s.close();
		} catch (SQLException e) {
			System.out.println("Error de base de datos: " + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Excepción: " + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Error de base de datos: " + e.getMessage());
				e.printStackTrace();
			}
		}
	}
}