package modelo;

public class Mes {
	private int mes;
	private int año;
	private int numApariciones;
	
	public Mes (int mes, int año, int numApariciones){
		this.año=año;
		this.mes=mes;
		this.numApariciones=numApariciones;
		}
	
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}


	public int getAño() {
		return año;
	}


	public void setAño(int año) {
		this.año = año;
	}


	public int getNumApariciones() {
		return numApariciones;
	}


	public void setNumApariciones(int numApariciones) {
		this.numApariciones = numApariciones;
	}	
}
