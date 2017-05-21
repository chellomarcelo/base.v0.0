package logica.Modulo2.vo;

public class voIngrediente {

	private int idIngrediente;
	private int idProducto;
	private String nombreIngrediente;
	float costo;
	
	
	
	public voIngrediente(int _idIngrediente,  int _idProducto, String _nombreIngrediente, float _costo) {
		super();
		this.idIngrediente = _idIngrediente;
		this.nombreIngrediente = _nombreIngrediente;
		this.idProducto = _idProducto;
		this.costo = _costo;
	}



	public int getIdIngrediente() {
		return idIngrediente;
	}



	public void setIdIngrediente(int idIngrediente) {
		this.idIngrediente = idIngrediente;
	}



	public String getNombreIngrediente() {
		return nombreIngrediente;
	}



	public void setNombreIngrediente(String nombreIngrediente) {
		this.nombreIngrediente = nombreIngrediente;
	}



	public int getIdProducto() {
		return idProducto;
	}



	public void setIdProducto(int _idProducto) {
		this.idProducto = _idProducto;
	}



	public float getCosto() {
		return costo;
	}



	public void setCosto(float costo) {
		this.costo = costo;
	}
	
	
	
	
}
