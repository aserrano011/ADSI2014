package modelo;

public class AlineacionToro {
	
	private int idToro;
	private int idEncierro;
	private int minutos;
	private int segundos;
	
	public AlineacionToro(int pIdToro, int pIdEncierro){
		this.idToro=pIdToro;
		this.idEncierro=pIdEncierro;
	}
	
	public Integer getIdToro() {
		return idToro;
	}

	public int getIdEncierro() {
		return idEncierro;
	}

	public int getMinutos() {
		return minutos;
	}

	public int getSegundos() {
		return segundos;
	}

	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}

	public void setSegundos(int segundos) {
		this.segundos = segundos;
	}
}
