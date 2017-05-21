package grafica.controladores.Modulo1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import test.descontinuados.ventanaListarProveedor;

import grafica.ventanas.Modulo1.ventanaAbmFamilia;
import grafica.ventanas.Modulo1.ventanaAbmProveedor;
import grafica.ventanas.Modulo1.ventanaCrearFamilia;
import grafica.ventanas.Modulo1.ventanaCrearProveedor2;
import grafica.ventanas.Modulo1.ventanaModFamilia;
import logica.fachada;
import logica.excepciones.ExcFamilia;
import logica.excepciones.ExcProveedores;
import logica.vo.voFamilia;
import logica.vo.voProveedor;

public class controladorAbmProveedor {
	
	public static final int ESTADO_A = 1;
	public static final int ESTADO_B = 2;
	public static final int ESTADO_M = 3;
	
	
	private fachada fac;
	private ventanaAbmProveedor ventListProv;
	
	public controladorAbmProveedor ( ventanaAbmProveedor  _ventanaListarProveedor ){	
		this.ventListProv = _ventanaListarProveedor;
	}
	
	public void ventCrearProveedor(){
		try {
			ventanaCrearProveedor2 ventana = new ventanaCrearProveedor2();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void ventCrearProveedorDet(int _estado, String _rut){
		try {
			ventanaCrearProveedor2 ventana = new ventanaCrearProveedor2(_estado, _rut);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/******
	 * Función que devuelve la lista de los proveedores que hay en base
	 * @return
	 * @throws Exception
	 */
	public ArrayList<voProveedor> listarProveedores() throws Exception{
		try {
			System.out.println("oho");
			if (fac==null){
				fac = new fachada();
			}
			return fac.listarNombreProveedores();
		} catch (ExcProveedores e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, ((ExcProveedores.ERROR_NO_HAY_PROVEEDORES)), "Error al crear Proveedor", JOptionPane.ERROR_MESSAGE);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//System.out.println(e.getCause());
			JOptionPane.showMessageDialog(null, (e.getMessage()), "Error al crear proveedor", JOptionPane.ERROR_MESSAGE);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/*****
	 * BORRAR PROVEEDOR
	 * @param _voProveedor
	 */
	public void borrarProveedor(voProveedor _voProveedor){
		try {
			fac.borrarProveedor(_voProveedor);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e1){
			e1.getMessage();
		}
	}
	/*****
	 * Modificar Proveedor
	 * @param _nombreActual
	 */
	public void ventModProveedor(String _rut) {
		// TODO Auto-generated method stub
		try {
			ventanaCrearProveedor2 _ventModProv = new ventanaCrearProveedor2(ESTADO_M, _rut);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public DefaultTableModel CargarModelo(){
		DefaultTableModel dtm = new DefaultTableModel();
		try {
			ArrayList<voProveedor> _voProveedor = listarProveedores();
			Object [] data = new Object[3];
			
			// insertamos el contenido de las columnas
			dtm.addColumn("RUT");
			dtm.addColumn("Nombre");
			dtm.addColumn("Tipo Proveedor");
			// insertamos el contenido de las columnas
			for(int row = 0; row < _voProveedor.size(); row++) {
						data[0] = _voProveedor.get(row).getIdProveedor();//"Celda " + row + "," + column;
						data[1] = _voProveedor.get(row).getNombreProveedor();
						data[2] = _voProveedor.get(row).getTipoProveedor();
						dtm.addRow(data);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dtm;
		
	}
}
