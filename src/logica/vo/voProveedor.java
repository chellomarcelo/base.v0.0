package logica.vo;

public class voProveedor {
	
	//Cantidad de variables 22
	private String idProveedor;
	private String nombreProveedor;
	private String nombreFantasia;
	private String nombreAuxiliar;
	private String tipoProveedor;
	private String dir1;
	private String dir2;
	private String dir3;
	private String tel1;
	private String tel2;
	private String tel3;
	private String cel1;
	private String cel2;
	private String cel3;
	private String correo1;
	private String correo2;
	private String correo3;
	private String contacto1;
	private String contacto2;
	private String contacto3;
	private String comentarios;
	private String horarioAtentcion;
	
	public voProveedor (String idProveedor, String nombreProveedor){
		this.idProveedor = idProveedor;
		this.nombreProveedor = nombreProveedor;
	}
	
	public voProveedor (String idProveedor, String nombreProveedor, String tipoProveedor){
		this.idProveedor = idProveedor;
		this.nombreProveedor = nombreProveedor;
		this.tipoProveedor = tipoProveedor;
	}
	
	
	
	/***
	 * 
	 * @param idProveedor			Idem ruta, cambiar esto despues a unica clave rut
	 * @param nombreProveedor
	 * @param nombreFantasia
	 * @param nombreAuxiliar
	 * @param tipoProveedor
	 * @param dir1
	 * @param dir2
	 * @param dir3
	 * @param tel1
	 * @param tel2
	 * @param tel3
	 * @param cel1
	 * @param cel2
	 * @param cel3
	 * @param correo1
	 * @param correo2
	 * @param correo3
	 * @param contacto1
	 * @param contacto2
	 * @param contacto3
	 * @param comentarios
	 * @param horarioAtentcion
	 */
	public voProveedor(	String idProveedor, 	String nombreProveedor, String nombreFantasia, 
						String nombreAuxiliar, 	String tipoProveedor,	
						String dir1, 			String dir2, 			String dir3, 
						String tel1, 			String tel2,			String tel3, 				
						String  cel1,			String cel2, 			String cel3, 				
						String correo1,			String correo2, 		String correo3, 
						String contacto1, 		String contacto2,		String contacto3, 
						String comentarios, 	String horarioAtentcion) {
		super();
		this.idProveedor = idProveedor;
		this.nombreProveedor = nombreProveedor;
		this.nombreFantasia = nombreFantasia;
		this.nombreAuxiliar = nombreAuxiliar;
		this.tipoProveedor = tipoProveedor;
		this.dir1 = dir1;
		this.dir2 = dir2;
		this.dir3 = dir3;
		this.tel1 = tel1;
		this.tel2 = tel2;
		this.tel3 = tel3;
		this.cel1 = cel1;
		this.cel2 = cel2;
		this.cel3 = cel3;
		this.correo1 = correo1;
		this.correo2 = correo2;
		this.correo3 = correo3;
		this.contacto1 = contacto1;
		this.contacto2 = contacto2;
		this.contacto3 = contacto3;
		this.comentarios = comentarios;
		this.horarioAtentcion = horarioAtentcion;
	}
	
	public String getIdProveedor() {
		return idProveedor;
	}
	
	public String getNombreProveedor() {
		return nombreProveedor;
	}
	public String getNombreFantasia() {
		return nombreFantasia;
	}
	public String getNombreAuxiliar() {
		return nombreAuxiliar;
	}
	public String getTipoProveedor() {
		return tipoProveedor;
	}
	
	public String getDir1() {
		return dir1;
	}
	public String getDir2() {
		return dir2;
	}
	public String getDir3() {
		return dir3;
	}
	public String getTel1() {
		return tel1;
	}
	public String getTel2() {
		return tel2;
	}
	public String getTel3() {
		return tel3;
	}
	public String getCel1() {
		return cel1;
	}
	public String getCel2() {
		return cel2;
	}
	public String getCel3() {
		return cel3;
	}
	
	public void setIdProveedor (String idProveedor){
		this.idProveedor = idProveedor;
	}
	public void setNombreFantasia(String nombreFantasia) {
		this.nombreFantasia = nombreFantasia;
	}

	public void setNombreAuxiliar(String nombreAuxiliar) {
		this.nombreAuxiliar = nombreAuxiliar;
	}

	public void setTipoProveedor(String tipoProveedor) {
		this.tipoProveedor = tipoProveedor;
	}

	public void setDir1(String dir1) {
		this.dir1 = dir1;
	}

	public void setDir2(String dir2) {
		this.dir2 = dir2;
	}

	public void setDir3(String dir3) {
		this.dir3 = dir3;
	}

	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}

	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}

	public void setTel3(String tel3) {
		this.tel3 = tel3;
	}

	public void setCel1(String cel1) {
		this.cel1 = cel1;
	}

	public void setCel2(String cel2) {
		this.cel2 = cel2;
	}

	public void setCel3(String cel3) {
		this.cel3 = cel3;
	}

	public void setCorreo1(String correo1) {
		this.correo1 = correo1;
	}

	public void setCorreo2(String correo2) {
		this.correo2 = correo2;
	}

	public void setCorreo3(String correo3) {
		this.correo3 = correo3;
	}

	public void setContacto1(String contacto1) {
		this.contacto1 = contacto1;
	}

	public void setContacto2(String contacto2) {
		this.contacto2 = contacto2;
	}

	public void setContacto3(String contacto3) {
		this.contacto3 = contacto3;
	}

	public void setHorarioAtentcion(String horarioAtentcion) {
		this.horarioAtentcion = horarioAtentcion;
	}

	public String getCorreo1() {
		return correo1;
	}
	public String getCorreo2() {
		return correo2;
	}
	public String getCorreo3() {
		return correo3;
	}
	public String getContacto1() {
		return contacto1;
	}
	public String getContacto2() {
		return contacto2;
	}
	public String getContacto3() {
		return contacto3;
	}
	public String getComentarios() {
		return comentarios;
	}
	public String getHorarioAtentcion() {
		return horarioAtentcion;
	}
	
}
