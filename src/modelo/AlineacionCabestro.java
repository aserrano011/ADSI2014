package modelo;


public class AlineacionCabestro {
	
	private int idCabestro;
	private int idEncierro;
	
	
	public AlineacionCabestro(int pIdCabestro, int pIdEncierro){
		this.idCabestro=pIdCabestro;
		this.idEncierro=pIdEncierro;
	}
	
	public Integer getIdCabestro() {
		return idCabestro;
	}

	public int getIdEncierro() {
		return idEncierro;
	}

}
