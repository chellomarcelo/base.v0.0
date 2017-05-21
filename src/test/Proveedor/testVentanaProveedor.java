package test.Proveedor;

import grafica.controladores.Modulo1.controladorCrearProveedor;
import grafica.ventanas.Modulo1.ventanaCrearProveedor2;

public class testVentanaProveedor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
				try {
					ventanaCrearProveedor2 vent1= new ventanaCrearProveedor2();
					//controladorCrearProveedor con = new controladorCrearProveedor(vent1);
					/*Control de Correo
					 * if(con.validoCorreo("3200@uy.ibm")){
					 
						System.out.println("OK");
					}else{
						System.out.println("False");
					}
					*/
					//Largp 10
					//con.RutValido("21040762001111");
					//Largo 11
//					con.RutValido("21040762001"); 
					//Largo 12
					//con.RutValido("210765070014");
					//Largo 12 digito verificador cero
					//con.RutValido("212660950010");
					//Otro cualquier pero valido
					//con.RutValido("211723160013");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

}
