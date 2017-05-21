package test.descontinuados;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


import grafica.ventanas.Modulo1.ventanaCrearProducto;
import logica.excepciones.ExcProveedores;
import logica.excepciones.ExcProducto;
import logica.excepciones.MessageError;
import logica.fachada;
import logica.familia;
import logica.excepciones.ExcFamilia;
import logica.vo.voFamilia;
import logica.vo.voProveedor;
import logica.vo.voProducto;

public class controladorCrearItem {
	
	private fachada fac;
	private ventanaCrearItems ventCrearItems;
	
	public controladorCrearItem ( ventanaCrearItems ventCrearItem ){
		this.ventCrearItems = ventCrearItem;
	}
	
	public void crearProducto (voProducto _voProducto) throws SQLException {
		boolean chequeo = true;
		try {
			if (fac==null){
				fac = new fachada();
			}
			
			//1_Verifico que el campo nombre tenga algun valor
			if (!(ingresarTextoVacio(_voProducto.getNombreRepuesto()))){
				chequeo=false;
				JOptionPane.showMessageDialog(ventCrearItems.getContentPane(), (new ExcProducto().getMessage(ExcProducto.ERROR_ESPACIOS_BLANCOS)), "Error al crear producto", JOptionPane.ERROR_MESSAGE);
			}
			//2_Verifico que haya selccionado una familia
			//Esto se controla en la ventana antes de invocar al procedimiento de crear el producto.
			//3_Verifico que haya seleccionado un proovedor (Se hara futuramente con combobox)
			
			//4_Verificar que el campo cantidad no sea vacio
			if (!(ingresarTextoVacio(Integer.toString(_voProducto.getCantidadRepuesto())))){
				chequeo=false;
				JOptionPane.showMessageDialog(ventCrearItems.getContentPane(), (new ExcProducto().getMessage(ExcProducto.ERROR_ESPACIOS_BLANCOS)), "Error al crear producto", JOptionPane.ERROR_MESSAGE);
			}
			//5_Verificar que el campo precio no sea vacio
			if (!(ingresarTextoVacio(Float.toString(_voProducto.getPrecioIva())))){
					chequeo=false;
					JOptionPane.showMessageDialog(ventCrearItems.getContentPane(), (new ExcProducto().getMessage(ExcProducto.ERROR_ESPACIOS_BLANCOS)), "Error al crear producto", JOptionPane.ERROR_MESSAGE);
			}else{
				if (!(ingresarTextoVacio(Float.toString(_voProducto.getPrecioSIva())))){
					chequeo=false;
					JOptionPane.showMessageDialog(ventCrearItems.getContentPane(), (new ExcProducto().getMessage(ExcProducto.ERROR_ESPACIOS_BLANCOS)), "Error al crear producto", JOptionPane.ERROR_MESSAGE);
				}
			}
			
			
			if (chequeo){
				fac.crearProducto(_voProducto);
				ventCrearItems.closeVent();
				ventCrearItems = new ventanaCrearItems();
			}else{
				JOptionPane.showMessageDialog(ventCrearItems.getContentPane(), (new ExcProducto().getMessage(ExcProducto.ERROR_AL_GUARDAR)), "Error al crear producto", JOptionPane.ERROR_MESSAGE);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e){
			JOptionPane.showMessageDialog(ventCrearItems.getContentPane(), (new ExcProducto().getMessage(ExcProducto.ERROR_AL_GUARDAR)), "Error al crear producto", JOptionPane.ERROR_MESSAGE);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	/***
	 * Listar familias, si fac no esta instanciada lo instancia y se comunica con la fachada para tomar un ArrayList de familia.
	 * @return
	 * @throws Exception 
	 */
	public ArrayList<voFamilia> listarFamilias() throws Exception{
		try {
			if (fac==null){
				fac = new fachada();
			}
			
			return fac.listarNombreFamilia();
		} catch (ExcFamilia e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(ventCrearItems.getContentPane(), (new ExcFamilia(ExcFamilia.ERROR_NO_HAY_FAMILIAS)), "Error al crear producto", JOptionPane.ERROR_MESSAGE);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//System.out.println(e.getCause());
			JOptionPane.showMessageDialog(ventCrearItems.getContentPane(), (e.getMessage()), "Error al crear producto", JOptionPane.ERROR_MESSAGE);
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

	///Seguridad de ingresos de datos
	public boolean ingresarTextoVacio(String texto) {
		boolean correcto = true;
		//Primero chequeo el nombre del producto que no este vacio
		if( texto.contentEquals(" ")) {
			System.out.println("No puede ser un campo vacio");
			correcto = false;
		}
		return correcto;
	}

	/****
	 * Hay que verificar dependiendo de la familia seleccionada se le tiene que asignar su id.
	 * @return
	 */
	public int darFamiliaId(String _nombreFamilia) {
		System.out.println("Controlador: "+_nombreFamilia);
		voFamilia voFam = new voFamilia(0, _nombreFamilia); //me quede aqui
		try {
			voFamilia aux = fac.getFamilia(voFam);
			if(aux != null){
				return aux.getIdFamilia();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	
	/***
	 * Listar Proveedores, si fac no esta instanciada lo instancia y se comunica con la fachada para tomar un ArrayList de Proveedores.
	 * @return
	 * @throws Exception 
	 */
	public ArrayList<voProveedor> listarProveedores()  throws Exception{
		try {
			if (fac==null){
				fac = new fachada();
			}
			
			return fac.listarNombreProveedor();
		} catch (ExcFamilia e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(ventCrearItems.getContentPane(), (new ExcProveedores(ExcProveedores.ERROR_AL_LISTAR)), "Error al crear producto", JOptionPane.ERROR_MESSAGE);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//System.out.println(e.getCause());
			JOptionPane.showMessageDialog(ventCrearItems.getContentPane(), (e.getMessage()), "Error al crear producto", JOptionPane.ERROR_MESSAGE);
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

	/****
	 * Hay que verificar dependiendo del proveedor seleccionado se le tiene que asignar su id.
	 * @return
	 */
	public String darProveedor(String _nombreProveedor) {
		System.out.println("Controlador: "+_nombreProveedor);
		voProveedor voPro = new voProveedor("", _nombreProveedor);
		try {
			voProveedor aux = fac.getProveedor(voPro);
			if(aux != null){
				return aux.getIdProveedor();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
}
