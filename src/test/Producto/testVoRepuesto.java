package test.Producto;

import logica.producto;

public class testVoRepuesto {

	public static void main(String[] args) {
	
		int idRepuesto = 001;
		String nombreRepuesto = "Filtro 487PHP";
		//String nombreProveedor = "Filtros Logan";
		//String nombreFamilia = "Filtros";
		String idProveedor = "1";
		int idFamilia = 1;
		String urlFoto = "";
		int cantidadRepuesto = 1;
		float precioIva = 100;
		float precioSIva = 122;
		
		producto voRepuesto = new producto(idRepuesto, nombreRepuesto, idProveedor, 
								idFamilia, urlFoto, cantidadRepuesto, precioIva, precioSIva);
		
		System.out.println("Imprimiendo creacion: Test voRepuesto");
		System.out.println("Id. Repuesto: "+ voRepuesto.getIdRepuesto());
		System.out.println("Nombre Repuesto: "+ voRepuesto.getNombreRepuesto());
		System.out.println("Nombre Proveedor: "+voRepuesto.getIdProveedor());
		System.out.println("Identificador Familia: "+voRepuesto.getidFamilia());
		System.out.println("Fecha Creación: "+voRepuesto.getFechaCreacion());
		System.out.println("Fecha Modificación: "+voRepuesto.getFechaModificacion());
		System.out.println("Url Foto: "+voRepuesto.getUrlFoto());
		System.out.println("Cantidad Repuesto: "+voRepuesto.getCantidadRepuesto());
		System.out.println("Precio con Iva: "+voRepuesto.getPrecioIva());
		System.out.println("Precio sin Iva: "+voRepuesto.getPrecioSIva());
		
	}
}
