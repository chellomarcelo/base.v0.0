package logica.Modulo2.vo;

public class voRelIngProd {

	
	private int idProducto;
	private int idIngrediente;
	private String descripcionIngrediente;
	
	
	public voRelIngProd(int idProducto, int idIngrediente, String descripcionIngrediente) {
		this.idProducto = idProducto;
		this.idIngrediente = idIngrediente;
		this.descripcionIngrediente = descripcionIngrediente;
	}


	public int getIdProducto() {
		return idProducto;
	}


	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}


	public int getIdIngrediente() {
		return idIngrediente;
	}


	public void setIdIngrediente(int idIngrediente) {
		this.idIngrediente = idIngrediente;
	}


	public String getDescripcionIngrediente() {
		return descripcionIngrediente;
	}


	public void setDescripcionIngrediente(String descripcionIngrediente) {
		this.descripcionIngrediente = descripcionIngrediente;
	}
	
	
	
	
}
