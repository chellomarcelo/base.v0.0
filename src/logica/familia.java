package logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;
import persistencia.Consultas;

public class familia {

	public static final int PIZZERIA = 1;
	public static final int COCINA = 2;
	public static final int BRBIDA = 3;
	private int idFamilia;
	private String nombreFamilia;
	private String fechaCreacion;
	private String fechaModificacion;
	private fecha f;
	
	/**
	 * Crea voFamilia, dentro se obtienen ArrayList de los repuestos relacionados con la familia. 
	 * @param nombreFamilia
	 */
	public familia( int idFamilia, String nombreFamilia) {
		if(f==null){
			 f=new fecha();
		}
		this.idFamilia = idFamilia;
		this.nombreFamilia = nombreFamilia;
		this.fechaCreacion = f.getDia();
		this.fechaModificacion = f.getDia();
	}
	
	
	/**
	 * Devuelve la Lista de todas las familias
	 * @return
	 * @throws SQLException 
	 */
	public ArrayList getFamilia(Connection _con) throws SQLException {
		Consultas _consultas = null;
		ArrayList<familia> familias = new ArrayList<familia>();
		Statement s = _con.createStatement();
		ResultSet rs = s.executeQuery( _consultas.listarFamilias());

		while (rs.next()) {
				familias.add(new familia( rs.getInt("idFamilia"), rs.getString("nombre")) );
		}
		rs.close();
		s.close();
		
		return familias;
	}
	
	/***
	 * Devuelve la familia
	 * @param _con
	 * @param _nombreFamilia
	 * @return
	 * @throws SQLException
	 */
	public familia getFamiliaXNombre (Connection _con, String _nombreFamilia ) throws SQLException {
		familia datoFamilia = null;
		Consultas _consulta = null;
		PreparedStatement ps = _con.prepareStatement(_consulta.darFamilia());
		ps.setString(1, _nombreFamilia);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) { 
			datoFamilia.setNombreFamilia(rs.getString("nombreFamilia"));
		}
		rs.close();
		ps.close();
		return datoFamilia;
	}


	public int getIdFamilia (){
		return idFamilia;		
	}
	
	public String getNombreFamilia() {
		return nombreFamilia;
	}

	public void setNombreFamilia(String nombreFamilia) {
		this.nombreFamilia = nombreFamilia;
	}


	public String getFechaCreacion() {
		return fechaCreacion;
	}


	public String getFechaModificacion() {
		return fechaModificacion;
	}
	
	
	
}
