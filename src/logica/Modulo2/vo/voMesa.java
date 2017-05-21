package logica.Modulo2.vo;

public class voMesa {

	private int idMesa;
	private int estado;

	public voMesa(int _idMesa,int  _estado) {
		this.idMesa = _idMesa;
		this.estado = _estado;
	}

	public int getIdMesa() {
		return idMesa;
	}
	
	public int getEstado(){
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	

	
}
