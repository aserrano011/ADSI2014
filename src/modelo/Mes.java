package modelo;

public class Mes {
	private int mes;
	private int a�o;
	private int numApariciones;
	
	public Mes (int mes, int a�o, int numApariciones){
		this.a�o=a�o;
		this.mes=mes;
		this.numApariciones=numApariciones;
		}
	
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}


	public int getA�o() {
		return a�o;
	}


	public void setA�o(int a�o) {
		this.a�o = a�o;
	}


	public int getNumApariciones() {
		return numApariciones;
	}


	public void setNumApariciones(int numApariciones) {
		this.numApariciones = numApariciones;
	}	
}
