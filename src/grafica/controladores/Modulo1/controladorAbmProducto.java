package grafica.controladores.Modulo1;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import test.descontinuados.ventanaListarProveedor;

import grafica.ventanas.Modulo1.ventanaAbmFamilia;
import grafica.ventanas.Modulo1.ventanaAbmProducto;
import grafica.ventanas.Modulo1.ventanaAbmProveedor;
import grafica.ventanas.Modulo1.ventanaCrearFamilia;
import grafica.ventanas.Modulo1.ventanaCrearProducto;
import grafica.ventanas.Modulo1.ventanaCrearProveedor2;
import grafica.ventanas.Modulo1.ventanaModFamilia;
import logica.Config;
import logica.fachada;
import logica.excepciones.ExcFamilia;
import logica.excepciones.ExcProveedores;
import logica.vo.voFamilia;
import logica.vo.voProducto;
import logica.vo.voProveedor;

public class controladorAbmProducto {
	
	public static final int ESTADO_A = 1;
	public static final int ESTADO_B = 2;
	public static final int ESTADO_M = 3;
	
	
	private fachada fac;
	private ventanaAbmProducto ventListProd;
	
	public controladorAbmProducto ( ventanaAbmProducto  _ventanaListarProducto ){	
		this.ventListProd = _ventanaListarProducto;
	}
	
	public void ventCrearProducto(){
		try {
			ventanaCrearProducto ventana = new ventanaCrearProducto();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	// Procedimiento para invocar a la pantalla con detalles.
	public void ventCrearProductoDet(int _estado, String _nombreProducto){
		try {
			//cambiar
			ventanaCrearProducto ventana = new ventanaCrearProducto(_estado, _nombreProducto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	/******
	 * Función que devuelve la lista de los productos que hay en base
	 * @return
	 * @throws Exception
	 */
	public ArrayList<voProducto> listarProductos() throws Exception{
		try {
			System.out.println("oho");
			if (fac==null){
				fac = new fachada();
			}
			//System.out.println("Listar Nombre Productos");
			return fac.listarProductos();
			//cambiar
		} catch (ExcProveedores e) {
			e.printStackTrace();
			//Cambiar
			JOptionPane.showMessageDialog(null, ((ExcProveedores.ERROR_NO_HAY_PROVEEDORES)), "Error al crear Proveedor", JOptionPane.ERROR_MESSAGE);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//System.out.println(e.getCause());
			//Cambiar
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
	 * BORRAR PRODCUTO
	 * @param _voProducto
	 */
	public void borrarProducto(voProducto _voProducto){
		try {
			System.out.println("Borrar producto");
			fac.borrarProducto(_voProducto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e1){
			e1.getMessage();
		}
	}
	/*****
	 * Modificar Producto
	 * @param _nombreActual
	 */
	public void ventModProducto(String _nombreProducto) {
		// TODO Auto-generated method stub
		try {
			System.out.println("Ventana crear prudcto modificación");
			ventanaCrearProducto _ventModProd = new ventanaCrearProducto(ESTADO_M, _nombreProducto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//cambiar
	public DefaultTableModel CargarModelo(){
		DefaultTableModel dtm = new DefaultTableModel(){
			public Class getColumnClass (int indiceColumna){
				Object algo = getValueAt(0, indiceColumna);
				if (algo == null){
					return Object.class;
				}else{
					return algo.getClass();
				}
			}
		};
		try {
			ArrayList<voProducto> _voProdcuto = listarProductos();
			ArrayList<voFamilia> _voFamilia = listarFamilias();
			Object [] data = new Object[7];
			
			// insertamos el contenido de las columnas
			dtm.addColumn("Nombre Prodcuto");
			dtm.addColumn("Familia");
			dtm.addColumn("Proveedor");
			dtm.addColumn("Cantidad");
			dtm.addColumn("Fecha Ingreso");
			dtm.addColumn("Fecha Vencimiento");
			dtm.addColumn("Imagen");
			
			// insertamos el contenido de las columnas
			for(int row = 0; row < _voProdcuto.size(); row++) {
						data[0] = _voProdcuto.get(row).getNombreProducto();
						data[1] = _voFamilia.get(_voProdcuto.get(row).getIdFamilia()-1).getNombreFamilia();
						data[2] = _voProdcuto.get(row).getIdProveedor();
						data[3] = _voProdcuto.get(row).getCantidadProducto();
						data[4] = _voProdcuto.get(row).getFechaIngreso();
						data[5] = _voProdcuto.get(row).getFechaVencimiento();
						data[6] = createImage(_voProdcuto.get(row).getNombreProducto(), _voProdcuto.get(row).getUrlFoto());	
						dtm.addRow(data);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dtm;
		
	}
	
	//Anexos
	public ImageIcon createImage(String _nomProd, String _path) {
		ImageIcon nuevo=null;
		System.out.println("Path ok");
		try {
			nuevo = new ImageIcon (fac.ObtenerImagen(_nomProd).getImagen().getScaledInstance(85,85,Image.SCALE_DEFAULT));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nuevo;
		
		
	}
	
	private class MyTableModel extends DefaultTableModel {
		 
	     public MyTableModel(Object[][] data, Object[] columnNames) {
	         super(data, columnNames);
	     }
	 
	  @Override
	  public Class<?> getColumnClass(int columnIndex) {
	   Class<?> clazz = Object.class;
	   Object aux = getValueAt(0, columnIndex);
	   if (aux != null) {
	    clazz = aux.getClass();
	   }
	 
	   return clazz;
	  }
	 
	 }
		     
	public ArrayList<voFamilia> listarFamilias() throws Exception{
		try {
			if (fac==null){
				fac = new fachada();
			}
			return fac.listarNombreFamilia();
		} catch (ExcFamilia e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, (new ExcFamilia(ExcFamilia.ERROR_NO_HAY_FAMILIAS)), "Error al crear repuesto", JOptionPane.ERROR_MESSAGE);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//System.out.println(e.getCause());
			JOptionPane.showMessageDialog(null, (e.getMessage()), "Error al crear repuesto", JOptionPane.ERROR_MESSAGE);
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
}
