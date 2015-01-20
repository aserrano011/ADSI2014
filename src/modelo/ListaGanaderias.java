package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ListaGanaderias {
	
	private static ListaGanaderias mListaGanaderias = new ListaGanaderias();
	private ArrayList<Ganaderia> lista;
	
	private ListaGanaderias(){
		this.lista = new ArrayList<Ganaderia>();
	}
	
	public static ListaGanaderias getListaGanaderias(){
		return mListaGanaderias;
	}
	
	public ArrayList<Ganaderia> getLista(){
		return this.lista;
	}
	
	public Ganaderia buscarPorId(int pId){
		Ganaderia gan = null;
		
		for(Ganaderia aux:this.getLista()){
			if(aux.getIdGanaderia()==pId){
				gan=aux;
			}
		}
		
		return gan;
	}
	
	public Ganaderia buscarPorNombre(String pNombre){
		Ganaderia gan = null;
		
		for(Ganaderia aux:this.getLista()){
			if(aux.getNombre().equals(pNombre)){
				gan=aux;
			}
		}
		
		return gan;
	}
	
	public void obtenerGanaderiasDeBase(){
		String nombre;
		int id;
		GestorBD g = GestorBD.getInstance();
		ResultSet rs;
		try {
			rs = g.consulta("SELECT * FROM Ganaderia;");
			Ganaderia aux;
			while(rs.next()) {
				id = Integer.parseInt(rs.getString("idGanaderia"));
				nombre = rs.getString("nombre");
				aux = new Ganaderia(id, nombre);
				this.anadirGanaderia(aux);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void anadirGanaderia(Ganaderia pG){
		this.getLista().add(pG);
	}
}