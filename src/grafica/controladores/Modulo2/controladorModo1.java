package grafica.controladores.Modulo2;

import java.awt.Image;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import grafica.ventanas.Modulo2.ventanaPedido;
import logica.Config;
import logica.fachada;
import logica.Modulo2.fachadaModulo2;
import logica.Modulo2.vo.voMesa;
import logica.vo.voProducto;

public class controladorModo1 {

	
	private ventanaPedido vent;
	private fachada fac;
	private fachadaModulo2 fac2;
	
	public controladorModo1 (ventanaPedido ventanaPedido){
		this.vent = ventanaPedido;
	}
	
	public ArrayList<voProducto> ListarProductos (int _idFamilia){
		if (fac==null){
			try {
				fac = new fachada();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
		
			return fac.listarProductosXFamilia(_idFamilia);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<voMesa> ListarMesas(){
		if(fac2==null){
			try {
				fac2 = new fachadaModulo2();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			return fac2.listarMesas();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
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
		
		public ImageIcon createImageMesa(int _estado) {
			if (fac2== null){
				try {
					fac2 = new fachadaModulo2();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			ImageIcon nuevo=null;
			try {
				nuevo = fac2.ObtenerImagenMesa(_estado);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return nuevo;
			
			
		}
		
		  public static double redondearDecimales(double valorInicial) {
		       double parteEntera, resultado;
		       resultado = valorInicial;
		       parteEntera = Math.floor(resultado);
		       resultado=(resultado-parteEntera)*Math.pow(10, Config.DECIMALES);
		       resultado=Math.round(resultado);
		       resultado=(resultado/Math.pow(10, Config.DECIMALES))+parteEntera;
		       return resultado;
		   }

}
