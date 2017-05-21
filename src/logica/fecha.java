package logica;

import java.util.Calendar;

public class fecha {

	private String dia;
	private String mes;
	private String ano;
	private String hora; //hh:mm:ss
	
	public fecha() {
		String aux[];
		java.util.Date utilDate = new java.util.Date(); //fecha actual
		long lnMilisegundos = utilDate.getTime();
		java.sql.Date sqlDate = new java.sql.Date(lnMilisegundos);
		java.sql.Time sqlTime = new java.sql.Time(lnMilisegundos);
		  
		aux = sqlDate.toString().split("-");
		this.dia = aux[2];
		this.mes = aux[1];
		this.ano = aux[0];
		this.hora = sqlTime.toString();
		
	}

	public String getFecha(){
		return (ano+mes+dia);		
	}
	
	public String getHora(){
		return this.hora;
	}
	
	public String listarFecha(){
		return (ano+"/"+mes+"/"+dia);
	}
	
	public String getDia() {
		return dia;
	}
	
	public void setDia(String dia) {
		this.dia = dia;
	}
	
	public String getMes() {
		return mes;
	}
	
	public void setMes(String mes) {
		this.mes = mes;
	}
	
	public String getAno() {
		return ano;
	}
	
	public void setAno(String ano) {
		this.ano = ano;
	}
	
	/***
	 * Me dan una fecha de la base y la devuevlo con las "/"
	 * @param fecha
	 * @return
	 */
	public String retornoFecha (String fecha){
		String ano = fecha.substring(0,4);
		String mes = fecha.substring(4,6);
		String dia = fecha.substring(6,8);
		System.out.println(ano);
		System.out.println(mes);
		System.out.println(dia);
		
		return ano+"/"+mes+"/"+dia;
	}
}
