package logica;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import logica.Config;
import persistencia.ConectorDB;

public class creacion {

	public static void main(String[] args) {
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
			 * Tabla Familia
			 * int idFamilia
			 * varchar (45) nombreFamilia
			 * varchar (10) fecha creación 
			 * varchar (10) fecha modificación
			 * varchar ( 8)	fecha modificacion  --Modificacion 03/04/2017
			 * 
			 */
		
			System.out.println("Creando tabla de Familia Producto");
			res = s.executeUpdate(
					"create table familia(" +
					" idFamilia int not null AUTO_INCREMENT," 	+
					" nombreFamilia varchar(45) not null," 		+
					" fechaCreacion varchar(10) not null," 		+
					" fechaModificacion varchar(10) not null,"	+
					" horaModificacion varchar(8) not null,"  	+
					" primary key(idFamilia)" 					+ 
					") engine=innodb default character set utf8");
			
			System.out.println("Filas Familia afectadas: " + res);
			
			/***
			 * 	 Ultimo cambio 03/04/2017 --corrijo algunos detalles
			 * 	 Tabla Producto	
			 * 	 int 	idProducto;
				 String nombreProducto;
				 int 	idProveedor;		 --Modificación 18/05/2015
				 int 	nombreFamilia;
				 int 	cantidad
				 float 	precioIva;
				 float 	precioSIva;
				 String urlFoto;	
				 String fechaIngreso		--Modificación 27/03/2016
				 String fechaVencimiento	--Modificación 27/03/2016
				 String	Lote				--Modificación 27/03/2016
				 String codBar				--Modificación 27/03/2016
				 String descripcion			--Modificación 27/03/2016
				 String fechaCreacion;
				 String fechaModificacion;
				 String horaModificacion;	--Modificacion 03/04/2017
			 */
		
			System.out.println("Creando tabla de Producto");
			res = s.executeUpdate(
					"create table producto ( "+
					" idProducto int not null AUTO_INCREMENT, "+
					" nombreProducto varchar(45) not null, " +
					" idProveedor int, "+
					" idFamilia int not null, " +	
					" cantidad int, "+
					" precioIva float, "+
					" precioSIva float, "+
					" urlFoto longblob, " +				//varchar(100)
					" fechaIngreso varchar(8), " +
					" fechaVencimiento varchar(8), " +
					" lote varchar(25), " +
					" codBar varchar(50), " +
					" descripcion varchar (200), " +
					" fechaCreacion varchar(8) not null, " +
					" fechaModificacion varchar(8) not null, " +
					" horaModificacion varchar(8) not null,"   +
					" constraint ca20 foreign key (idFamilia) references familia(idFamilia), "+
					" primary key(idProducto)"+
					") engine=innodb default character set utf8");
			System.out.println("Filas Producto afectadas: " + res);
			
			/***
			 *  Cambios 04/05/2014
			 *  Tabla Relacion Producto - Familia
			 *  int idFamilia
			 *  int idProducto
			 *  varchar (10) fecha creación 
			 *  varchar (10) fecha modificación
			*/
			
/*			Desuso por le momento
 			System.out.println("Creando tabla de Relación Producto - Familia");
 
			res = s.executeUpdate(
					" create table famProd ( "+
					" idFamilia int not null, "+
					" idProducto int  not null, " +
					" fechaCreacion varchar(10) not null, " +
					" fechaModificacion varchar(10) not null, " +
					" constraint ca2 foreign key (idFamilia) references familia(idFamilia), "+
					" constraint ca3 foreign key (idProducto) references producto(idProducto), "+
					" primary key(idProducto ,idFamilia)"+
					") engine=innodb default character set utf8");
			System.out.println("Filas famProd afectadas: " + res);
*/			
			/***
			 *  Cambios 04/01/2016
			 *  Tabla Proveedores
			 *  	
			*/
			
			System.out.println("Creando tabla de Proveedores");
			res = s.executeUpdate(
					"create table proveedor ( "+
					"idProveedor varchar(12) not null, "+
					"nombreProveedor varchar(50) not null, "+
					"nombreFantasia varchar(50), "+
					"nombreAuxiliar varchar(50), "+
					"tipoProveedor varchar(50), "+
					"dir1 varchar(50), "+
					"dir2 varchar(50), "+
					"dir3 varchar(50), "+
					"tel1 varchar(20), "+
					"tel2 varchar(20), "+
					"tel3 varchar(20), "+
					"cel1 varchar(20), "+
					"cel2 varchar(20), "+
					"cel3 varchar(20), "+
					"correo1 varchar(50), "+
					"correo2 varchar(50), "+
					"correo3 varchar(50), "+
					"contacto1 varchar(50), "+
					"contacto2 varchar(50), "+
					"contacto3 varchar(50), "+
					"comentarios varchar(100), "+
					"horarioAtencion varchar(50), "+
					"fechaCreacion varchar(10) not null, "+
					"fechaModificacion varchar(10) not null, "+
					"horaModificacion varchar(8) not null,"  	+
					"primary key(idProveedor)"+
					") engine=innodb default character set utf8");
			System.out.println("Filas Proveedores afectadas: " + res);

// En caso de agrandar el sistema a futuro hacer una talba para direcciones y telefonos a parte mas correo.			
			
			/***
			 * Creado 04/01/2016
			 * Tipo de proveedor - similar al familia.
			 */
			System.out.println("Creando tabla de Tipo de Proveedor");
			
			res = s.executeUpdate(
					"create table tipoProveedor(" +
					" nombreTipoProveedor varchar(45) not null," +
					" fechaCreacion varchar(10) not null," +
					" fechaModificacion varchar(10) not null," +
					" horaModificacion varchar(8) not null,"  	+
					" primary key(nombreTipoProveedor)" + 
					") engine=innodb default character set utf8");
			
			System.out.println("Filas Tipo de Proveedor afectadas: " + res);
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
