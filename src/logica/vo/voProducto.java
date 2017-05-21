package logica.vo;

import java.awt.image.BufferedImage;

public class voProducto {
	
	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	private int idProducto;
	private String nombreProducto;
	private String idProveedor;
	private int idFamilia;
	private String urlFoto;
	private int cantidadProducto;
	private float precioIva;
	private float precioSIva;
	private String fechaIngreso;
	private String fechaVencimiento;
	private String Lote;
	private String codBar;
	private String descripcion;
	
	
	
	public voProducto(	int _idProducto, 		String _nombreProducto, 
						String _idProveedor, 	int _idFamilia, 
						String _urlFoto,		int _cantidadProducto, 
						float _precioIva, 		float _precioSIva) 		{

		this.idProducto = _idProducto;
		this.nombreProducto = _nombreProducto;
		this.idProveedor = _idProveedor;
		this.idFamilia = _idFamilia;
		this.urlFoto = _urlFoto;
		this.cantidadProducto = _cantidadProducto;
		this.precioIva = _precioIva;
		this.precioSIva = _precioSIva;
	}

	public voProducto(	int    _idProducto,		String  _nombreProducto, 
						String _idProveedor, 	int 	_idFamilia, 
						String _urlFoto,		int 	_cantidadProducto, 
						float  _precioIva, 		float 	_precioSIva, 
						String _fechIngreso, 	String 	_fechVencimiento, 
						String _lote,			String 	_codBar, 
						String _descripcion) {
	
		this.idProducto = _idProducto;
		this.nombreProducto = _nombreProducto;
		this.idProveedor = _idProveedor;
		this.idFamilia = _idFamilia;
		this.urlFoto = _urlFoto;
		this.cantidadProducto = _cantidadProducto;
		this.precioIva = _precioIva;
		this.precioSIva = _precioSIva;
		this.fechaIngreso = _fechIngreso;
		this.fechaVencimiento = _fechVencimiento;
		this.Lote = _lote;
		this.codBar = _codBar;
		this.descripcion = _descripcion;
		
	}
	
	public voProducto(int _idProducto, String _nombreProducto, float _precioSIva, String _urlFoto) {
		// TODO Auto-generated constructor stub
		this.idProducto= _idProducto;
		this.nombreProducto = _nombreProducto;
		this.precioSIva = _precioSIva;
		this.urlFoto = _urlFoto;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public int getCantidadProducto() {
		return cantidadProducto;
	}

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public String getFechaVencimiento() {
		return fechaVencimiento;
	}

	public String getLote() {
		return Lote;
	}
	
	public void setLote(String lote) {
		Lote = lote;
	}

	public String getCodBar() {
		return codBar;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getIdProveedor() {
		return idProveedor;
	}

	public int getIdFamilia() {
		return idFamilia;
	}

	public String getUrlFoto() {
		return urlFoto;
	}
	
	public void setUrlFoto (String _urlFoto){
		urlFoto = _urlFoto;
	}

	public int getCantidadRepuesto() {
		return cantidadProducto;
	}

	public float getPrecioIva() {
		return precioIva;
	}

	public float getPrecioSIva() {
		return precioSIva;
	}

	public void setPrecioIva(float precioIva) {
		this.precioIva = precioIva;
	}

	public void setPrecioSIva(float precioSIva) {
		this.precioSIva = precioSIva;
	}
	
	
	
}
