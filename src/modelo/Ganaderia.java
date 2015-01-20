package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Ganaderia {
	
	private int idGanaderia;
	private String nombre;
	private ArrayList<Animal> ListaAnimales;
	
	public Ganaderia(int pIdGanaderia, String pNombre){
		this.idGanaderia = pIdGanaderia;
		this.nombre = pNombre;
	}
	
	public int getIdGanaderia() {
		return idGanaderia;
	}

	public void setIdGanaderia(int idGanaderia) {
		this.idGanaderia = idGanaderia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Animal> getListaAnimales() {
		return ListaAnimales;
	}

	public void setListaAnimales(ArrayList<Animal> listaAnimales) {
		ListaAnimales = listaAnimales;
	}

	public boolean haVotado(){
		boolean havotado = false;
		
		GestorBD g = GestorBD.getInstance();
		Calendar fecha = new GregorianCalendar();
		int año = fecha.get(Calendar.YEAR);
		ResultSet rs;
		try {
			rs = g.consulta("SELECT COUNT(*) FROM Voto where IDdequien="+this.getIdGanaderia()+" and fecha="+año+";");
			if(rs.next()){	
				if((rs.getInt(1))>0){
					havotado=true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return havotado;
	}
	
	public void votar(ArrayList<String> nominados){
		Voto auxv;
		Calendar fecha = new GregorianCalendar();
		int año = fecha.get(Calendar.YEAR);
		for(String s: nominados){
			int n = ListaGanaderias.getListaGanaderias().buscarPorNombre(s).getIdGanaderia();
			auxv = new Voto(this.getIdGanaderia(), n, año);
			auxv.registrarVotoEnBase();
		}
	}
	
	public String[] obtenerNominaciones(){
		String[] nominados = new String[3];
		int indice=0;
		
		GestorBD g = GestorBD.getInstance();
		Calendar fecha = new GregorianCalendar();
		int año = fecha.get(Calendar.YEAR);
		ResultSet rs;
		try {
			rs = g.consulta("SELECT IDaquien FROM Voto where IDdequien="+this.getIdGanaderia()+" and fecha="+año+";");
			while(rs.next()){	
				if(indice<=2){
					nombre = ListaGanaderias.getListaGanaderias().buscarPorId(Integer.parseInt(rs.getString("IDaquien"))).getNombre();
					nominados[indice] = nombre;
					indice++;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return nominados;
	}
	
}
