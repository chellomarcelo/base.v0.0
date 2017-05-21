package logica;

public class producto {

	private int idProducto;
	private String nombreProducto;
	private String idProveedor;
	private int idFamilia;
	private String fechaCreacion;
	private String fechaModificacion;
	private String urlFoto;
	private int cantidadRepuesto;
	private float precioIva;
	private float precioSIva;
	private fecha f;
	
	public producto(	int idRepuesto, String nombreRepuesto, String idProveedor, int idFamilia, 
						String urlFoto, int cantidadRepuesto,
						float precioIva, float precioSIva) {
		
		super();
		if(f==null){
			 f=new fecha();
		}
		this.idProducto = idRepuesto;
		this.nombreProducto = nombreRepuesto;
		this.idProveedor = idProveedor;
		this.idFamilia = idFamilia;
		this.fechaCreacion = f.getFecha();
		this.fechaModificacion = f.getFecha();
		this.urlFoto = urlFoto;
		this.cantidadRepuesto = cantidadRepuesto;
		this.precioIva = precioIva;
		this.precioSIva = precioSIva;
	}

	public producto(int idRepuesto, String nombreRepuesto) {
		this.idProducto = idRepuesto;
		this.nombreProducto = nombreRepuesto;
	}

	public int getIdRepuesto() {
		return idProducto;
	}

	public void setIdRepuesto(int idRepuesto) {
		this.idProducto = idRepuesto;
	}

	public String getNombreRepuesto() {
		return nombreProducto;
	}

	public void setNombreRepuesto(String nombreRepuesto) {
		this.nombreProducto = nombreRepuesto;
	}

	public String getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(String idProveedor) {
		this.idProveedor = idProveedor;
	}

	public int getidFamilia() {
		return idFamilia;
	}

/*No deberia d estar este procedimiento
	public void setNombreFamilia(String idFamilia) {
		this.idFamilia = idFamilia;
	}
*/
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

	public String getUrlFoto() {
		return urlFoto;
	}

	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}

	public int getCantidadRepuesto() {
		return cantidadRepuesto;
	}

	public void setCantidadRepuesto(int cantidadRepuesto) {
		this.cantidadRepuesto = cantidadRepuesto;
	}

	public float getPrecioIva() {
		return precioIva;
	}

	public void setPrecioIva(float precioIva) {
		this.precioIva = precioIva;
	}

	public float getPrecioSIva() {
		return precioSIva;
	}

	public void setPrecioSIva(float precioSIva) {
		this.precioSIva = precioSIva;
	}
		
}
