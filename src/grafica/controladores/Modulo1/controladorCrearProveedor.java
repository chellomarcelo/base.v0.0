package grafica.controladores.Modulo1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import test.descontinuados.ventanaListarProveedor;

import grafica.ventanas.Modulo1.ventanaAbmProveedor;
import grafica.ventanas.Modulo1.ventanaCrearProveedor2;
import logica.fachada;
import logica.excepciones.ExcProveedores;
import logica.excepciones.ExcTipoProveedor;
import logica.excepciones.ExcepcionesGeneral;
import logica.vo.voProveedor;
import logica.vo.voTipoProveedor;

public class controladorCrearProveedor {
	
	private fachada fac;
	private ventanaCrearProveedor2 ventCrearProveedor;
	
	public controladorCrearProveedor ( ventanaCrearProveedor2  _ventCrearProveedor ){
		this.ventCrearProveedor = _ventCrearProveedor;
	}
	
	public void crearProveedor ( voProveedor _voProveedor) throws SQLException{
		try {
			if (fac==null){
				fac = new fachada();
			}
			//Si el chequeo da true se crea el proveedor
			if (chequeoDatos(_voProveedor)){
				fac.crearProveedor(_voProveedor);
				//Lo dejo aca abajo porque si salta algun error no deberia de llegar a salir el OK
				JOptionPane.showMessageDialog(null, (new ExcepcionesGeneral().getMessage(ExcepcionesGeneral.OK_GUARDO)), "Se creo con exito el Proveedor", JOptionPane.INFORMATION_MESSAGE);
				ventCrearProveedor.cerrarVentana();
				//Abrir ventana del menu
				ventanaAbmProveedor vent = new ventanaAbmProveedor();
			}	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, ((ExcProveedores.PROVEEDOR_RUT_EXISTS)), "Error Campo Rut", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public ArrayList<voTipoProveedor> listarTipoProveedor() {
		try {
			if (fac==null){
				fac = new fachada();
			}
			return fac.listarNombresTipoProveedor();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//System.out.println(e.getCause());
			JOptionPane.showMessageDialog(null, (new ExcTipoProveedor(ExcTipoProveedor.ERROR_AL_LISTAR_TPROVEEDOR)), "Error al listar Tipo de Proveedor.", JOptionPane.ERROR_MESSAGE);
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
	
	/**
	 * Lista los proveedores
	 * @return
	 * @throws Exception
	 */
	public ArrayList<voProveedor> listarProveedores() throws Exception{
		try {
			if (fac==null){
				fac = new fachada();
			}
			return fac.listarNombreProveedores();
		//	JOptionPane.showMessageDialog(ventCrearRepuesto.getContentPane(), (new ExcFamilia(ExcFamilia.ERROR_NO_HAY_FAMILIAS)), "Error al crear repuesto", JOptionPane.ERROR_MESSAGE);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//System.out.println(e.getCause());
			JOptionPane.showMessageDialog(null, (new ExcProveedores(ExcProveedores.ERROR_AL_LISTAR)), "Error al listar Proveedor.", JOptionPane.ERROR_MESSAGE);
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
		//Primero chequeo el nombre del repuesto que no este vacio
		if( texto.contentEquals("")) {
			System.out.println("No puede ser un campo vacio");
			correcto = false;
		}
		if( texto.contentEquals(" ")) {
			System.out.println("No puede ser un espacio en blanco el nombre.");
			correcto = false;
		}
		return correcto;
	}
	
	//Finalizo Seguridad de ingreso de datos

	public boolean chequeoDatos(voProveedor _voProveedor){
		boolean aux=true;
		//Verificación de rut valido.
		if(RutValido(_voProveedor.getIdProveedor())){
			_voProveedor.setIdProveedor(_voProveedor.getIdProveedor().trim());
			_voProveedor.setIdProveedor(_voProveedor.getIdProveedor().replaceAll("\\s", ""));
		//Logica para validar los campos con numeros.
		//Valido que no este vacio, en caso de que no, quito todos los espacios a los costados, y quito los espacios.
		//Luego verifico que solo tenga numeros cargados, sino despleigo un mensaje de error.
		
		if (_voProveedor.getTel2().isEmpty()){
			_voProveedor.setTel2("0");
		}else{
			_voProveedor.setTel2(_voProveedor.getTel2().trim());
			_voProveedor.setTel2(_voProveedor.getTel2().replaceAll("\\s", ""));
			if(!_voProveedor.getTel2().matches("\\d*")){
				System.out.println("Antes tel2: " + _voProveedor.getTel2());
				aux=false;
				JOptionPane.showMessageDialog(null, (new ExcepcionesGeneral().getMessage(ExcepcionesGeneral.ERROR_NUMEROS)), "Error Campo Telefono 2.", JOptionPane.ERROR_MESSAGE);
			}
		}	
		if (_voProveedor.getTel3().isEmpty()){
			_voProveedor.setTel3("0");
		}else{
			_voProveedor.setTel3(_voProveedor.getTel3().trim());
			_voProveedor.setTel3(_voProveedor.getTel3().replaceAll("\\s", ""));
			if(!_voProveedor.getTel3().matches("\\d*")){
				aux=false;
				JOptionPane.showMessageDialog(null, (new ExcepcionesGeneral().getMessage(ExcepcionesGeneral.ERROR_NUMEROS)), "Error Campo Telefono 3.", JOptionPane.ERROR_MESSAGE);
			}
		}	
		
		if (_voProveedor.getCel2().isEmpty()){
			_voProveedor.setCel2("0");
		}else{
			_voProveedor.setCel2(_voProveedor.getCel2().trim());
			_voProveedor.setCel2(_voProveedor.getCel2().replaceAll("\\s", ""));
			if(!_voProveedor.getCel2().matches("\\d*")){
				aux=false;
				JOptionPane.showMessageDialog(null, (new ExcepcionesGeneral().getMessage(ExcepcionesGeneral.ERROR_NUMEROS)), "Error Campo Celular 2.", JOptionPane.ERROR_MESSAGE);
			}
		}
			
		if (_voProveedor.getCel3().isEmpty()){
			_voProveedor.setCel3("0");
		}else{
			_voProveedor.setCel3(_voProveedor.getCel3().trim());
			_voProveedor.setCel3(_voProveedor.getCel3().replaceAll("\\s", ""));
			if(!_voProveedor.getCel3().matches("\\d*")){
				aux=false;
				JOptionPane.showMessageDialog(null, (new ExcepcionesGeneral().getMessage(ExcepcionesGeneral.ERROR_NUMEROS)), "Error Campo Celular 3.", JOptionPane.ERROR_MESSAGE);
			}
		}
	}else{
		aux=false;
	}
		//Valido los campos obligatorios en cadena, si falla uno se despliega un mensaje de error. 
		
		if(_voProveedor.getNombreProveedor().isEmpty()){
			aux=false;
			JOptionPane.showMessageDialog(null, (new ExcepcionesGeneral().getMessage(ExcepcionesGeneral.ERROR_ESPACIOS_BLANCOS)), "Error Campo Nombre Proveedor.", JOptionPane.ERROR_MESSAGE);
		}else{
			if(_voProveedor.getTipoProveedor().isEmpty()){
					aux=false;
					JOptionPane.showMessageDialog(null, (new ExcepcionesGeneral().getMessage(ExcepcionesGeneral.ERROR_SELECCIONAR)), "Error Campo Tipo Proveedor.", JOptionPane.ERROR_MESSAGE);
				}else{
					if(_voProveedor.getDir1().isEmpty()){
						aux=false;
						JOptionPane.showMessageDialog(null, (new ExcepcionesGeneral().getMessage(ExcepcionesGeneral.ERROR_ESPACIOS_BLANCOS)), "Error Campo Dirección 1.", JOptionPane.ERROR_MESSAGE);
					}else{
						if (_voProveedor.getTel1().isEmpty()){
							aux=false;
							JOptionPane.showMessageDialog(null, (new ExcepcionesGeneral().getMessage(ExcepcionesGeneral.ERROR_ESPACIOS_BLANCOS)), "Error Campo Telefono 1.", JOptionPane.ERROR_MESSAGE);
						}else{
							System.out.println("Antes del trim: "+_voProveedor.getTel1());
							_voProveedor.setTel1(_voProveedor.getTel1().trim());
							_voProveedor.setTel1(_voProveedor.getTel1().replaceAll("\\s", ""));
							if(!_voProveedor.getTel1().matches("\\d*")){
								aux=false;
								JOptionPane.showMessageDialog(null, (new ExcepcionesGeneral().getMessage(ExcepcionesGeneral.ERROR_NUMEROS)), "Error Campo Telefonó 1.", JOptionPane.ERROR_MESSAGE);
							}else{
							if (_voProveedor.getCel1().isEmpty()){
								aux=false;
								JOptionPane.showMessageDialog(null, (new ExcepcionesGeneral().getMessage(ExcepcionesGeneral.ERROR_ESPACIOS_BLANCOS)), "Error Campo Celular 1.", JOptionPane.ERROR_MESSAGE);
								}else{
									_voProveedor.setCel1(_voProveedor.getCel1().trim());
									_voProveedor.setCel1(_voProveedor.getCel1().replaceAll("\\s", ""));
									if(!_voProveedor.getCel1().matches("\\d*")){
										aux=false;
										JOptionPane.showMessageDialog(null, (new ExcepcionesGeneral().getMessage(ExcepcionesGeneral.ERROR_NUMEROS)), "Error Campo Celular 1.", JOptionPane.ERROR_MESSAGE);	
									}else{
										if (_voProveedor.getContacto1().isEmpty()){
											aux=false;
											JOptionPane.showMessageDialog(null, (new ExcepcionesGeneral().getMessage(ExcepcionesGeneral.ERROR_ESPACIOS_BLANCOS)), "Error Campo Contacto 1.", JOptionPane.ERROR_MESSAGE);
										}
									}
								}
							}
						}
					}
				}	
			}
		
		//Control de Correos Electronicos.
		if(!_voProveedor.getCorreo1().isEmpty())
			if(!validoCorreo(_voProveedor.getCorreo1())){
				aux=false;
				JOptionPane.showMessageDialog(null, (new ExcepcionesGeneral().getMessage(ExcepcionesGeneral.ERROR_CORREO)), "Error Campo Correo 1.", JOptionPane.ERROR_MESSAGE);
			}
		if(!_voProveedor.getCorreo2().isEmpty())
			if(!validoCorreo(_voProveedor.getCorreo2())){
				aux=false;
				JOptionPane.showMessageDialog(null, (new ExcepcionesGeneral().getMessage(ExcepcionesGeneral.ERROR_CORREO)), "Error Campo Correo 2.", JOptionPane.ERROR_MESSAGE);
			}
		
		if(!_voProveedor.getCorreo3().isEmpty())
			if(!validoCorreo(_voProveedor.getCorreo3())){
				aux=false;
				JOptionPane.showMessageDialog(null, (new ExcepcionesGeneral().getMessage(ExcepcionesGeneral.ERROR_CORREO)), "Error Campo Correo 3.", JOptionPane.ERROR_MESSAGE);
			}
		
		return aux;
	}
	
	
	public boolean validoCorreo(String _correo1) {
		// TODO Auto-generated method stub
		return _correo1.matches("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	}

	/****
	 * Verifico si es correcto el rut
	 * Tipo si es 1 tiene 12 caracteres, si es 2 ti 11 y su digito verificador se desecha.
	 * @param _rut
	 * @return
	 */
	public boolean RutValido(String _rut){
		boolean valido=true;
		if (_rut.isEmpty()){
			valido=false;
			JOptionPane.showMessageDialog(null, (new ExcepcionesGeneral().getMessage(ExcepcionesGeneral.ERROR_ESPACIOS_BLANCOS)), "Error Campo Rut.", JOptionPane.ERROR_MESSAGE);
			}else{
				_rut = _rut.trim();
				_rut=_rut.replaceAll("\\s", "");
				System.out.println("Rut "+_rut);
				if(!_rut.matches("\\d*")){
					valido=false;
					JOptionPane.showMessageDialog(null, (new ExcepcionesGeneral().getMessage(ExcepcionesGeneral.ERROR_NUMEROS)), "Error Campo RUT.", JOptionPane.ERROR_MESSAGE);	
				}else{
					if(_rut.length() > 12 || _rut.length() < 11 ){
							valido=false;
							JOptionPane.showMessageDialog(null, (new ExcepcionesGeneral().getMessage(ExcepcionesGeneral.ERROR_RUT)), "Error Campo RUT.", JOptionPane.ERROR_MESSAGE);
					}else{
					//Paso el String a un array
					ArrayList<Integer> digits = new ArrayList<Integer>();
					int[]  rutFijo = new int[]{4,3,2,9,8,7,6,5,4,3,2};
					int resultado = 0;
					
					//Primera Validación 
					//System.out.println("rut 0: "+_rut.charAt(0));
					if(Integer.parseInt(""+_rut.charAt(0))<3){
						if((Integer.parseInt(""+_rut.charAt(0))== 0 && Integer.parseInt(""+_rut.charAt(1))<= 2 ) || (Integer.parseInt(""+_rut.charAt(0))==1 && Integer.parseInt(""+_rut.charAt(1))<=2 ) || (Integer.parseInt(""+_rut.charAt(0))== 2 && Integer.parseInt(""+_rut.charAt(1))<=1 ) ){	
							//System.out.println("Pos 9: "+_rut.charAt(8));
							//System.out.println("Suma: "+((Integer.parseInt(""+_rut.charAt(2))+Integer.parseInt(""+_rut.charAt(3))+Integer.parseInt(""+_rut.charAt(4))+Integer.parseInt(""+_rut.charAt(5))+Integer.parseInt(""+_rut.charAt(6))+Integer.parseInt(""+_rut.charAt(7)))));
							if((Integer.parseInt(""+_rut.charAt(2))+Integer.parseInt(""+_rut.charAt(3))+Integer.parseInt(""+_rut.charAt(4))+Integer.parseInt(""+_rut.charAt(5))+Integer.parseInt(""+_rut.charAt(6))+Integer.parseInt(""+_rut.charAt(7)))!=0){
								//System.out.println("Rut 8 "+_rut.charAt(8));
								//System.out.println("Rut 9 "+_rut.charAt(9));
								if (Integer.parseInt(""+_rut.charAt(8))== 0){
									//System.out.println("pos10: "+_rut.charAt(9));
									if (Integer.parseInt(""+_rut.charAt(9))==0){
										resultado=0;
										for (int i=0; i<_rut.length()-1; i++){
											digits.add(Integer.parseInt(""+_rut.charAt(i)));
											resultado = resultado + (digits.get(i) * rutFijo[i]);
										}	  
											//De la suma los divido entre 11 obteniendo el cociente y el resto
											int coci = resultado /11;
											int rest = resultado % 11;
											int digi =0;
											// Al resto le restamos 11, esto nos da un posible digito verificador.
											//Condiciones: 	1_si el resultado es menor a 10 es ese el digito verificador.
											//				2_Si es 11, entonces el digito verificador es cero
											//				3_Si es 10, entonces no tiene digito verificador.		
											digi = 11-rest;
											System.out.println("suma: "+resultado+" cociente: "+coci+" resto: "+rest+ " digi:"+digi);
											
											if(_rut.length() == 11){
													if(digi==10 ){
														System.out.println("digi==10 no tiene digit verificador");
													}else{
														valido=false;
														JOptionPane.showMessageDialog(null, (new ExcepcionesGeneral().getMessage(ExcepcionesGeneral.ERROR_RUT)), "Error Campo RUT.", JOptionPane.ERROR_MESSAGE);	
													}
											}else{		
												if(digi<10  && digi==Integer.parseInt(""+_rut.charAt(11))){
													System.out.println("Digi < 10 " +_rut.charAt(11)+ "  correcto");
												}else{
													if(digi==11 && Integer.parseInt(""+_rut.charAt(11)) == 0){
														System.out.println("Digi == 11 poner 0" +_rut.charAt(11)+ "  correcto");
													}else{
														valido=false;
														JOptionPane.showMessageDialog(null, (new ExcepcionesGeneral().getMessage(ExcepcionesGeneral.ERROR_RUT)), "Error Campo RUT.", JOptionPane.ERROR_MESSAGE);
													}
												}
											}	
										}
									}		
								}
						}	
					}
				}
			}
		}
	
		return valido;
	}

	//Envio un voProveedor solo con el rut y me devuelve otro con toda la info.
	public voProveedor getProvUni( String _rut) {
		voProveedor auxProv = null;
				
			try {
				if (fac==null){
					fac = new fachada();
				}
				auxProv = fac.getProveedorTotal(_rut);
				System.out.println("ControlCrearProv: "+auxProv.getIdProveedor());
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
		return auxProv;
	}

	public void modProveedor(voProveedor voData1, voProveedor voData2) {
		// TODO Auto-generated method stub
		//Primero comparo si hubo cambios.
		boolean cambio=false;
				//Compara si hubieron algunas modificaciones
				//Original 	voProv	
				//Nuevo		voData
		if (voData1.getNombreProveedor().equals(voData2.getNombreProveedor())){
			if(voData1.getNombreFantasia().equals(voData2.getNombreFantasia())){
				if(voData1.getNombreAuxiliar().equals(voData2.getNombreAuxiliar())){
					if(voData1.getTipoProveedor().equals(voData2.getTipoProveedor())){
						if(voData1.getDir1().equals(voData2.getDir1())){
							if(voData1.getDir2().equals(voData2.getDir2())){
								if(voData1.getDir3().equals(voData2.getDir3())){
									if(voData1.getTel1().equals(voData2.getTel1())){
										if(voData1.getTel2().equals(voData2.getTel2())){
											if(voData1.getTel3().equals(voData2.getTel3())){
												if(voData1.getCel1().equals(voData2.getCel1())){
													if(voData1.getCel2().equals(voData2.getCel2())){
														if(voData1.getCel3().equals(voData2.getCel3())){
															if(voData1.getCorreo1().equals(voData2.getCorreo1())){
																if(voData1.getCorreo2().equals(voData2.getCorreo2())){
																	if(voData1.getCorreo3().equals(voData2.getCorreo3())){
																		if(voData1.getContacto1().equals(voData2.getContacto1())){
																			if(voData1.getContacto2().equals(voData2.getContacto2())){
																				if(voData1.getContacto3().equals(voData2.getContacto3())){
																					if(voData1.getComentarios().equals(voData2.getComentarios())){
																						if(voData1.getHorarioAtentcion().equals(voData2.getHorarioAtentcion())){
																							JOptionPane.showMessageDialog(null, (new ExcepcionesGeneral().getMessage(ExcepcionesGeneral.MODIFICACIONES)), "Modificación Proveedor", JOptionPane.INFORMATION_MESSAGE);
																						}else
																							cambio=true;
																					}else
																						cambio=true;	
																				}else
																					cambio=true;
																			}else
																				cambio=true;
																		}else
																			cambio=true;
																	}else
																		cambio=true;
																}else
																	cambio=true;
															}else
																cambio=true;
														}else
															cambio=true;
													}else
														cambio=true;
												}else
													cambio=true;
											}else
												cambio=true;
										}else
											cambio=true;
									}else
										cambio=true;
								}else
									cambio=true;
							}else
								cambio=true;
						}else
							cambio=true;
					}else
						cambio=true;
				}else
					cambio=true;
			}else{
				cambio=true;
			}
		}else{
			cambio=true;
		}
		//Si hubo cambios verifico que los datos sean consistentes y si lo son mandoa a la fachada
		if(cambio){
			if(chequeoDatos(voData2)){
				try {
					fac.modificarProveedor(voData2);
					JOptionPane.showMessageDialog(null, (new ExcepcionesGeneral().getMessage(ExcepcionesGeneral.OK_GUARDO)), "Modificación Proveedor", JOptionPane.INFORMATION_MESSAGE);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
			
		
	}
}				


/*
 1) SE TOMA EL NRO. DE RUC HASTA LA PENULTIMA POSICION, O SEA LOS
PRIMEROS 11 DIGITOS.
EJEMPLO: 	21076507001
			212247340018
2) SE MULTIPLICA CADA DIGITO POR UN FACTOR DIFERENTE.
COMENZANDO DE DERECHA A IZQUIERA LOS FACTORES SON :
 2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4.
Ejemplo: 2 1 0 7 6 5 0 7 0 0 1
 x4 x3 x2 x9 x8 x7 x6 x5 x4 x3 x2
 -----------------------------------------------------------------
 8 3 0 63 48 35 0 35 0 0 2
3) Se suman los productos obtenidos:
 Ejemplo: 8+3+0+63+48+35+0+35+0+0+2 = 194
4) El probable digito verificador es lo que falta para llegar de la suma obtenida (194) en
el ejemplo, al próximo múltiplo de 11. Para obtenerlo se procede de la siguiente
manera:
- Se divide el resultado de la suma entre 11, obteniéndose un cociente entero y un resto.
En el ejemplo Cociente = 17 y Resto = 7.
- Se resta 11 menos el resto obteniéndose un probable check digit.
Desarrollo de Software para DINAE e INEFOP
Modelo de Datos y Servicios Externos – Versión 1.4
En el ejemplo 11 - 7 = 4.
- Si el probable check digit es menor que 10, entonces es verdaderamente el digito
verificador
y ocupará la posición 12 del número de ruc.
- Si el probable check digit es 11 entonces el digito verificador es 0.
- Si el probable check digit es 10 entonces el número se desecha y no se adjudica.
Ejemplo: 21040762001x
5) Además debe controlarse que:
 - Las dos primeras posiciones estén en el rango 01 a 21.
 - De la 3a. a la 8va. posición debe ser distinto de 000000
 - Las posiciones 9a. y 10a. deben ser 00
 */
