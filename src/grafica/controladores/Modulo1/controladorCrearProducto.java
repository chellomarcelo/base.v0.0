package grafica.controladores.Modulo1;

import java.awt.Image;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import grafica.ventanas.Modulo1.ventanaCrearProducto;
import logica.excepciones.ExcProveedores;
import logica.excepciones.ExcProducto;
import logica.excepciones.ExcepcionesGeneral;
import logica.excepciones.MessageError;
import logica.Config;
import logica.fachada;
import logica.familia;
import logica.fecha;
import logica.excepciones.ExcFamilia;
import logica.vo.voFamilia;
import logica.vo.voProveedor;
import logica.vo.voProducto;

public class controladorCrearProducto {
	
	private fachada fac;
	private ventanaCrearProducto ventCrearProducto;
	private Config config = null;

	public controladorCrearProducto ( ventanaCrearProducto _ventCrearProducto ){
		this.ventCrearProducto = _ventCrearProducto;
	}
	
	public void crearProducto (voProducto _voProducto, int estado) throws SQLException {
		boolean chequeo = true;
		try {
			if (fac==null){
				fac = new fachada();
			}
			config = Config.getInstance();
			
			//Primero verifico los campos obligatorios
			// Nombre Producto, Familia, Proveedor, Fecha Ingreso
			
			if (_voProducto.getNombreProducto().isEmpty()){
				chequeo=false;
				JOptionPane.showMessageDialog(ventCrearProducto.getContentPane(), (new ExcProducto().getMessage(ExcProducto.ERROR_ESPACIOS_BLANCOS)), "Error al crear repuesto", JOptionPane.ERROR_MESSAGE);
			}else{
				if(_voProducto.getIdFamilia() == 0){
					chequeo=false;
					JOptionPane.showMessageDialog(null, (new ExcepcionesGeneral().getMessage(ExcepcionesGeneral.ERROR_SELECCIONAR)), "Error Campo Familia.", JOptionPane.ERROR_MESSAGE);
					//JOptionPane.showMessageDialog(null, (ExcFamilia.FAMILIA_NOT_EXISTS), "Error", JOptionPane.ERROR_MESSAGE);
				}else{
					if(_voProducto.getIdProveedor().isEmpty()){
						chequeo=false;
						JOptionPane.showMessageDialog(null, ((ExcProveedores.ERROR_SELECT_ITEM)), "Error Campo Proveedor", JOptionPane.ERROR_MESSAGE);
					}else{
						if(_voProducto.getFechaIngreso().isEmpty()){
							chequeo=false;
							JOptionPane.showMessageDialog(null, ((ExcepcionesGeneral.FECHA_FORMATO)), "Error al crear Producto", JOptionPane.ERROR_MESSAGE);									
						}else{
							_voProducto.setFechaIngreso(formatoFechaEnv(_voProducto.getFechaIngreso()));
						}
							
					}
				}
			}
			
			//Luego verifico el resto de los campos que su formato sea el correcto
			if(!_voProducto.getFechaVencimiento().isEmpty()){
				if(_voProducto.getFechaVencimiento().equals("AAAA/MM/DD")){
					_voProducto.setFechaVencimiento("");
				}else{
					if(!formatoFecha(_voProducto.getFechaVencimiento())){
						JOptionPane.showMessageDialog(null, ((new ExcepcionesGeneral().getMessage(ExcepcionesGeneral.FECHA_FORMATO))), "Error al crear Producto", JOptionPane.ERROR_MESSAGE);
						chequeo=false;
					}else{
						_voProducto.setFechaVencimiento(formatoFechaEnv(_voProducto.getFechaVencimiento()));
					}
				}	
			}
			
			if(!_voProducto.getLote().isEmpty()){
				_voProducto.setLote(_voProducto.getLote().trim());
				_voProducto.setLote(_voProducto.getLote().replaceAll("\\s", ""));
			}
			System.out.println("Precio" + _voProducto.getPrecioSIva());
			if(_voProducto.getPrecioSIva()==1){	//Si precio iva igual 1 quiere decir que lleva IVA
				_voProducto.setPrecioSIva((Float.parseFloat(config.getProperty(config.CONST_IVA))) * _voProducto.getPrecioIva());
			}
			
			if (chequeo){
				fac.crearProducto(_voProducto, estado);
				ventCrearProducto.cerrarVentana();
				ventCrearProducto = new ventanaCrearProducto();
				JOptionPane.showMessageDialog(null, (new ExcepcionesGeneral().getMessage(ExcepcionesGeneral.OK_GUARDO)), "OK", JOptionPane.INFORMATION_MESSAGE);
			}else{
				JOptionPane.showMessageDialog(ventCrearProducto.getContentPane(), (new ExcProducto().getMessage(ExcProducto.ERROR_AL_GUARDAR)), "Error al crear repuesto", JOptionPane.ERROR_MESSAGE);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e){
			System.out.println(e.getErrorCode());
			System.out.println(e.getStackTrace());
			JOptionPane.showMessageDialog(ventCrearProducto.getContentPane(), (new ExcProducto().getMessage(ExcProducto.ERROR_AL_GUARDAR)), (new ExcProducto().getMessage(e.getErrorCode())), JOptionPane.ERROR_MESSAGE);
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
	
	private String formatoFechaEnv(String _fecha) {
		String[] fecha = _fecha.split("/");
		System.out.println("d:"+fecha[0]+"m:"+fecha[1]+"a:"+fecha[2]);
		return new String(fecha[0]+fecha[1]+fecha[2]);
	}

	/***
	 * Verifico que el formato ingresado sea AAAA/MM/DD
	 */
	private boolean formatoFecha(String fechaVencimiento) {
		String[] fecha = fechaVencimiento.split("/");
		boolean formato = true;
		fecha f = new fecha();
	    
		if(fecha[0].matches("\\d*"))
			if(fecha[1].matches("\\d*"))
				if(fecha[2].matches("\\d*")){
		
					int anio1 = Integer.parseInt(f.getAno());
					int anio2 = Integer.parseInt(fecha[0]);
				    int mes1 = Integer.parseInt(f.getMes());
				    int mes2 = Integer.parseInt(fecha[1]);
				    int dia1 = Integer.parseInt(f.getDia());
				    int dia2 = Integer.parseInt(fecha[2]);
	    
				    if (anio2<anio1){
				    	formato=false;
				    }else{   
				    	if(anio2==anio1){
				    		if (mes2<mes1 || mes2>12){
				    			formato=false;
				    		}else{
				    			if ((anio2 % 4 == 0) && ((anio2 % 100 != 0) || (anio2 % 400 == 0))){
				    				if ((dia2<dia1 && mes2==2) || (mes2==2 && dia2>29))
				    					formato=false;
				    			}else{
				    				if ((dia2<dia1 && mes2==mes1) || (mes2==2 && dia2>28))
				    					formato=false;
				    			}
				    			if((dia2<dia1 && mes2==mes1)|| (mes2==1 && dia2>31) || (mes2==3 && dia2>31) || (mes2==5 && dia2>31) || (mes2==7 && dia2>31) || (mes2==8 && dia2>31) || (mes2==10 && dia2>31) || (mes2==12 && dia2>31) ){
				    				formato=false;
				    			}
				    		
				    			if((dia2<dia1 && mes2==mes1) || (mes2==4 && dia2>30) || (mes2==6 && dia2>30) || (mes2==9 && dia2>30) || (mes2==11 && dia2>30)){
				    				formato=false;
				    			}
				    		}
				    }else{
				    	if (mes2>12){
			    			formato=false;
			    		}else{
			    			if ((anio2 % 4 == 0) && ((anio2 % 100 != 0) || (anio2 % 400 == 0))){
			    				if (mes2==2 && dia2>29)
			    					formato=false;
			    			}else{
			    				if (mes2==2 && dia2>28)
			    					formato=false;
			    			}
			    			if((mes2==1 && dia2>31) || (mes2==3 && dia2>31) || (mes2==5 && dia2>31) || (mes2==7 && dia2>31) || (mes2==8 && dia2>31) || (mes2==10 && dia2>31) || (mes2==12 && dia2>31) ){
			    				formato=false;
			    			}
			    		
			    			if((mes2==4 && dia2>30) || (mes2==6 && dia2>30) || (mes2==9 && dia2>30) || (mes2==11 && dia2>30)){
			    				formato=false;
			    			}
			    		}
			    		}
				    }
				}else{
					
				}
	    return formato;
	    
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
			JOptionPane.showMessageDialog(ventCrearProducto.getContentPane(), (new ExcFamilia(ExcFamilia.ERROR_NO_HAY_FAMILIAS)), "Error al crear repuesto", JOptionPane.ERROR_MESSAGE);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//System.out.println(e.getCause());
			JOptionPane.showMessageDialog(ventCrearProducto.getContentPane(), (e.getMessage()), "Error al crear repuesto", JOptionPane.ERROR_MESSAGE);
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
			JOptionPane.showMessageDialog(ventCrearProducto.getContentPane(), (new ExcProveedores(ExcProveedores.ERROR_AL_LISTAR)), "Error al crear repuesto", JOptionPane.ERROR_MESSAGE);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//System.out.println(e.getCause());
			JOptionPane.showMessageDialog(ventCrearProducto.getContentPane(), (e.getMessage()), "Error al crear repuesto", JOptionPane.ERROR_MESSAGE);
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
	
	public voProducto getProdUni(String _nombreProducto){
		System.out.println("Controlador: "+_nombreProducto);
		voProducto auxVoProd = null;
		
		try{
		if (fac==null){
			fac = new fachada();
		}
		auxVoProd = fac.getProductoTotal(_nombreProducto);
		System.out.println("ControlCrearProv: "+auxVoProd.getNombreProducto());
	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return auxVoProd;
	}
	
	/***
	 * Genero esta función para la parte de Modificación y detalle que me traiga mediante el id el nombre de la familia
	 */
	public String buscarNombreProveedor(ArrayList<voProveedor> listaProv, String idProveedor){
		Iterator<voProveedor> it = listaProv.iterator();
		while(it.hasNext()){
			//System.out.println("entro");
			voProveedor prov = it.next();
			System.out.println("Entro al buscar " + idProveedor + "Nombre lista: "+prov.getNombreProveedor());
			if(prov.getIdProveedor().equals(idProveedor)){
				System.out.println(prov.getNombreProveedor());
				System.out.println("Nombre: "+idProveedor);
				return prov.getNombreProveedor();
			}
		}	
			
		return "Error";
	}
	
	/***
	 * Genero esta función para la parte de Modificación y detalle que me traiga mediante el id el nombre de la familia
	 */
	public String buscarNombreFamilia(ArrayList<voFamilia> listaFam, int idFamilia){
		Iterator<voFamilia> it = listaFam.iterator();
		while(it.hasNext()){
			//System.out.println("entro");
			voFamilia fam = it.next();
			if(fam.getIdFamilia()==idFamilia){
				return fam.getNombreFamilia();
			}
		}
		
		return "Error";
	}
	
	
	public ImageIcon createImage(String _nomProd, String _path,int ancho, int largo) {
		ImageIcon nuevo=null;
		System.out.println("Path ok");
		try {
			nuevo = new ImageIcon (fac.ObtenerImagen(_nomProd).getImagen().getScaledInstance(ancho,largo,Image.SCALE_DEFAULT));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nuevo;
	}
	
}
