package logica;

public class Proveedor {
	
	private int idProveedor;
	private String nombreProveedor;
	private String nombreFantasia;
	private String nombreAuxiliar;
	private String tipoProveedor;
	private int rut;
	private String dir1;
	private String dir2;
	private String dir3;
	private int tel1;
	private int tel2;
	private int tel3;
	private int cel1;
	private int cel2;
	private int cel3;
	private String correo1;
	private String correo2;
	private String correo3;
	private String contacto1;
	private String contacto2;
	private String contacto3;
	private String comentarios;
	private String horarioAtentcion;
	private String fechaCreacion;
	private String fechaModificacion;
	private fecha f;
	
	public Proveedor(	int idProveedor, 
						String nombreProveedor, 
						String nombreFantasia, 
						String nombreAuxiliar, 
						String tipoProveedor, 
						int rut, 
						String dir1, String dir2, String dir3, 
						int tel1, int tel2, int tel3, 
						int cel1, int cel2, int cel3, 
						String correo1, String correo2, String correo3, 
						String contacto1, String contacto2, String contacto3, 
						String comentarios, 
						String horarioAtentcion
		) {
		super();
		if(f==null){
			 f=new fecha();
		}
		this.idProveedor = idProveedor;
		this.nombreProveedor = nombreProveedor;
		this.nombreFantasia = nombreFantasia;
		this.nombreAuxiliar = nombreAuxiliar;
		this.tipoProveedor = tipoProveedor;
		this.rut = rut;
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
		this.fechaCreacion = f.getFecha();
		this.fechaModificacion = f.getFecha();
	}


	public int getidProveedor() {
		return idProveedor;
	}


	public void setidProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}


	public String getNombreProveedor() {
		return nombreProveedor;
	}


	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}


	public String getNombreFantasia() {
		return nombreFantasia;
	}


	public void setNombreFantasia(String nombreFantasia) {
		this.nombreFantasia = nombreFantasia;
	}


	public String getNombreAuxiliar() {
		return nombreAuxiliar;
	}


	public void setNombreAuxiliar(String nombreAuxiliar) {
		this.nombreAuxiliar = nombreAuxiliar;
	}


	public String getTipoProveedor() {
		return tipoProveedor;
	}


	public void setTipoProveedor(String tipoProveedor) {
		this.tipoProveedor = tipoProveedor;
	}


	public int getRut() {
		return rut;
	}


	public void setRut(int rut) {
		this.rut = rut;
	}


	public String getDir1() {
		return dir1;
	}


	public void setDir1(String dir1) {
		this.dir1 = dir1;
	}


	public String getDir2() {
		return dir2;
	}


	public void setDir2(String dir2) {
		this.dir2 = dir2;
	}


	public String getDir3() {
		return dir3;
	}


	public void setDir3(String dir3) {
		this.dir3 = dir3;
	}


	public int getTel1() {
		return tel1;
	}


	public void setTel1(int tel1) {
		this.tel1 = tel1;
	}


	public int getTel2() {
		return tel2;
	}


	public void setTel2(int tel2) {
		this.tel2 = tel2;
	}


	public int getTel3() {
		return tel3;
	}


	public void setTel3(int tel3) {
		this.tel3 = tel3;
	}


	public int getCel1() {
		return cel1;
	}


	public void setCel1(int cel1) {
		this.cel1 = cel1;
	}


	public int getCel2() {
		return cel2;
	}


	public void setCel2(int cel2) {
		this.cel2 = cel2;
	}


	public int getCel3() {
		return cel3;
	}


	public void setCel3(int cel3) {
		this.cel3 = cel3;
	}


	public String getCorreo1() {
		return correo1;
	}


	public void setCorreo1(String correo1) {
		this.correo1 = correo1;
	}


	public String getCorreo2() {
		return correo2;
	}


	public void setCorreo2(String correo2) {
		this.correo2 = correo2;
	}


	public String getCorreo3() {
		return correo3;
	}


	public void setCorreo3(String correo3) {
		this.correo3 = correo3;
	}


	public String getContacto1() {
		return contacto1;
	}


	public void setContacto1(String contacto1) {
		this.contacto1 = contacto1;
	}


	public String getContacto2() {
		return contacto2;
	}


	public void setContacto2(String contacto2) {
		this.contacto2 = contacto2;
	}


	public String getContacto3() {
		return contacto3;
	}


	public void setContacto3(String contacto3) {
		this.contacto3 = contacto3;
	}


	public String getComentarios() {
		return comentarios;
	}


	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}


	public String getHorarioAtentcion() {
		return horarioAtentcion;
	}


	public void setHorarioAtentcion(String horarioAtentcion) {
		this.horarioAtentcion = horarioAtentcion;
	}
	
	public String getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(String fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	
	
	
}