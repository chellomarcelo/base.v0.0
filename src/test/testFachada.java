package test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import logica.fachada;
import logica.familia;
import logica.producto;
import logica.stock;
import logica.vo.voFamilia;
import logica.vo.voProducto;

public class testFachada {

	public static void main(String[] args) {
		
		fachada fach;
		try {
			fach = new fachada();
			
			//Familia
			int idFamilia = 1;
			String nombreFamilia = "FiltroPrueba3";
			String fechaCreacionFamilia = "2014/05/04"; 
			String fechaModificacionFamilia = "2014/05/06";	
			
			int idRepuesto = 1;
			String nombreRepuesto = "Filtro 487PHP";
			//String nombreProveedor = "Filtros Logan";
			String idProveedor = "1";
			String fechaCreacion = "09/04/2012";
			String fechaModificacion = "10/04/2013";
			String urlFoto = "";
			int cantidadRepuesto = 2;
			float precioIva = 100;
			float precioSIva = 122;
			
			
			
			familia _familia = new familia (idFamilia ,nombreFamilia);
			voFamilia _voFamilia = new voFamilia(idFamilia, nombreFamilia);
		//	Repuesto vo = null;
			producto _repuesto = 	new producto(idRepuesto, nombreRepuesto, idProveedor, 
									idFamilia, urlFoto, cantidadRepuesto, precioIva, precioSIva);
			
			voProducto _voRepuesto = new voProducto(idRepuesto, nombreRepuesto, idProveedor, idFamilia, urlFoto, cantidadRepuesto, precioIva, precioSIva);
		//	System.out.println("Borro Familia: "+_familia.getNombreFamilia());
		//	fach.borrarFamilia(_familia);
			
			System.out.println("Creo la familia: "+nombreFamilia);
			fach.crearFamilia (_voFamilia);
			
			System.out.println("Creo el repuesto "+_repuesto.getIdRepuesto() +"\nNombre Repuesto: "+_repuesto.getNombreRepuesto());
			System.out.println("Repuesto asociado con la familia: "+_repuesto.getidFamilia());
			fach.crearProducto(_voRepuesto);
			
			/*****
			 *HASTA ACA LLEGO 2014/05/04 
			 **********/
			
			/*
			System.out.println("Borra repuesto, ID: "+_repuesto.getIdRepuesto());
			fach.borrarRepuesto(_repuesto);
			
			System.out.println("Borra repuesto de la BD por familia: \nNombre Familia: "+ _repuesto.getNombreFamilia() +"\nIdentificación del repuesto: "+_repuesto.getIdRepuesto());
			fach.borrarRepuestoFamilia(_repuesto);
			
			System.out.println("Borro Familia: "+_familia.getNombreFamilia());
			fach.borrarFamilia(_familia);
			*/
			
			/*
			System.out.println("Listando los repuestos de la BD: "+ _repuesto.getIdRepuesto());
			vo = fach.getRepuesto(_repuesto.getIdRepuesto());
			
			/***
			 * private int idRepuesto;
				private String nombreRepuesto;
				private String nombreProveedor;
				private String nombreFamilia;
				private String fechaCreacion;
				private String fechaModificacion;
				private String urlFoto;
				private int cantidadRepuesto;
				private float precioIva;
				private float precioSIva;
			
			System.out.println(	 "Identificacion del repuesto: "+ vo.getIdRepuesto()
							  +"\nNombre Repuesto: "+ vo.getNombreRepuesto()
							  +"\nNombre Proveedor: "+ vo.getNombreProveedor()
							  +"\nNombre Familia: "+ vo.getNombreFamilia()
							  +"\nFecha Creacion: "+ vo.getFechaCreacion()
							  +"\nFecha Modificacion: "+ vo.getFechaModificacion()
							  +"\nUrl Foto: "+ vo.getUrlFoto()
							  +"\nPrecio Iva: "+ vo.getPrecioIva()
							  +"\nPrecio Sin Iva: "+ vo.getPrecioSIva());
			
			*/
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Salto");
			System.out.println(e.getErrorCode());
			e.printStackTrace();
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
	}
	
}
