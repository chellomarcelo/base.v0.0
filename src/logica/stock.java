package logica;

public class stock {

	private String idStock;
	private int idRepuesto;
	private int cantidad;

	public stock(String idStock, int idRepuesto, int cantidad) {
		this.idStock = idStock;
		this.idRepuesto = idRepuesto;
		this.cantidad = cantidad;
	}
	
	public stock(String idStock, int idRepuesto) {
		super();
		this.idStock = idStock;
		this.idRepuesto = idRepuesto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getIdStock() {
		return idStock;
	}

	public int getIdRepuesto() {
		return idRepuesto;
	}
	
}
