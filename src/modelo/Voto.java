package modelo;

import java.sql.SQLException;

public class Voto {
	
	private int iddequien;
	private int idaquien;
	private int fecha;
	
	public Voto(int pIDDequien, int pIDAquien, int pFecha){
		if(pIDDequien==pIDAquien){
			System.out.println("La ID del votante no puede ser la misma que la del votado");
		}else{
			this.iddequien = pIDDequien;
			this.idaquien = pIDAquien;
			this.fecha = pFecha;
		}
	}
	
	private int getIDDequien(){
		return this.iddequien;
	}
	
	private int getIDAquien(){
		return this.idaquien;
	}
	
	private int getFecha(){
		return this.fecha;
	}
	
	public void registrarVotoEnBase(){
	  GestorBD g = GestorBD.getInstance();
	  try {
		  	g.insertar("INSERT INTO Voto(IDdequien, IDaquien, fecha) VALUES("+this.getIDDequien()+", "+this.getIDAquien()+", "+this.getFecha()+");");
	  }catch (SQLException e) {
			System.out.println("Error al insertar.");
	  }
	}
}