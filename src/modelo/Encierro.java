package modelo;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Encierro {
	
	private double longitud; //En metros.
	private double velocidadMedia;
	private ArrayList<AlineacionToro> alineacion;
	private ArrayList<AlineacionCabestro> alineacionCab;
	private Date fecha;
	private int idEncierro;
	private int idGanaderia;
	


	public Encierro(Date fecha, int idEncierro, double longit, int idGanaderia) {
		this.fecha = fecha;
		this.idEncierro = idEncierro;
		this.idGanaderia = idGanaderia;
		this.longitud = longit;
		alineacion = new ArrayList<AlineacionToro>();
		alineacionCab = new ArrayList<AlineacionCabestro>();
	}



	public double getLongitud() {
		return longitud;
	}



	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}



	public double getVelocidadMedia() {
		return velocidadMedia;
	}
	
	public int getIdGanaderia() {
		return this.idGanaderia;
	}
	
	public void setIdGanaderia(int idGanaderia){
		this.idGanaderia= idGanaderia;
	}



	public void setVelocidadMedia(double velocidadMedia) {
		this.velocidadMedia = velocidadMedia;
	}



	public ArrayList<AlineacionToro> getAlineacion() {
		return alineacion;
	}



	public void setAlineacion(ArrayList<AlineacionToro> alineacion) {
		this.alineacion = alineacion;
	}



	public ArrayList<AlineacionCabestro> getAlineacionCab() {
		return alineacionCab;
	}



	public void setAlineacionCab(ArrayList<AlineacionCabestro> alineacionCab) {
		this.alineacionCab = alineacionCab;
	}



	public Date getFecha() {
		return fecha;
	}



	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}



	public int getIdEncierro() {
		return idEncierro;
	}



	public void setIdEncierro(int idEncierro) {
		this.idEncierro = idEncierro;
	}



	public void obtenerVelocidadMedia(){
		double tiempomedio, vm, sumatoriotiempos = 0;
		
		for(AlineacionToro t : alineacion){
			sumatoriotiempos += t.getMinutos()*60;
			sumatoriotiempos += t.getSegundos();
		}
		
		tiempomedio = sumatoriotiempos/alineacion.size();
		vm = this.getLongitud() / tiempomedio;
		this.setVelocidadMedia(vm);
	}
	



	
	public ArrayList<Integer> generarListaIDToro(){
		ArrayList<Integer> lista = new ArrayList<Integer>();
		Iterator<AlineacionToro> itr = this.alineacion.iterator();
		while (itr.hasNext()){
			lista.add(itr.next().getIdToro());
		}
		return lista;
	}
	
	public ArrayList<Integer> generarListaIDCabestro(){
		ArrayList<Integer> lista = new ArrayList<Integer>();
		Iterator<AlineacionCabestro> itr = this.alineacionCab.iterator();
		while (itr.hasNext()){
			lista.add(itr.next().getIdCabestro());
		}
		return lista;
	}
	
	public ArrayList<Integer> obtenerTorosSustitutos(){
		ArrayList<Integer> lista = new ArrayList<Integer>();
		ArrayList<Integer> listaPart = new ArrayList<Integer>();
		ArrayList<Integer> listaInscr = new ArrayList<Integer>();
		listaPart = generarListaIDToro();
		listaInscr = obtenerTorosInscripcion();
		lista = sacarSustitutos(listaInscr, listaPart);
		return lista;
	}
	
	public ArrayList<Integer> obtenerCabestrosSustitutos(){
		ArrayList<Integer> lista = new ArrayList<Integer>();
		ArrayList<Integer> listaPart = new ArrayList<Integer>();
		ArrayList<Integer> listaInscr = new ArrayList<Integer>();
		listaPart = generarListaIDCabestro();
		listaInscr = obtenerCabestrosInscripcion();
		lista = sacarSustitutos(listaInscr, listaPart);
		return lista;
	}
	
	public ArrayList<Integer> sacarSustitutos(ArrayList<Integer> l1, ArrayList<Integer> l2){
		ArrayList<Integer> lista = new ArrayList<Integer>();
		boolean encontrado = false;
		//Algoritmo con mucho coste... Pero los ArrayList van a ser siempre pequeños.
		Iterator<Integer> itr1 = l1.iterator();
		Iterator<Integer> itr2 = l2.iterator();
		while (itr1.hasNext()){
			while (itr2.hasNext()||encontrado){
				if (itr1.next().equals(itr2.next().intValue())){
					encontrado = true;
				}
			if (!encontrado){
				lista.add(itr1.next());
			}
			else {encontrado = false;}
			}
			itr2 = l2.iterator();
		}
		return lista;
	}
	
	public void obtenerCabestrosAlineacionSQL(){
		
		try{
			
			String strSQL ="SELECT idCabestro FROM AlineacionCabestro " +
					"WHERE idEncierro = "+ this.idEncierro + ");";
			
			ResultSet resultado = GestorBD.getInstance().consulta(strSQL);
			alineacionCab.clear();
			if(resultado.last()) {
				
				
				alineacionCab.add(new AlineacionCabestro( resultado.getInt("idCabestro"), this.idEncierro));
				resultado.first();
				do {
					alineacionCab.add(new AlineacionCabestro( resultado.getInt("idCabestro"), this.idEncierro));
				}while(resultado.next());
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
	
	}
	
	public void obtenerTorosAlineacionSQL(){
		

		try{
			
		String strSQL ="SELECT idToro FROM AlineacionToro " +
				"WHERE idEncierro = "+ this.idEncierro + ");";
		
		ResultSet resultado = GestorBD.getInstance().consulta(strSQL);
		alineacion.clear();
		if(resultado.last()) {
			
			alineacion.add(new AlineacionToro( resultado.getInt("idToro"), this.idEncierro));
			do {
				alineacionCab.add(new AlineacionCabestro( resultado.getInt("idCabestro"), this.idEncierro));
			}while(resultado.next());
		}
	}
	catch (SQLException e){
		e.printStackTrace();
	}
		
		System.out.println("parada");
	}
	
	
	public ArrayList<Integer> obtenerCabestrosInscripcion(){
		
		ArrayList<Integer> cabestros = new ArrayList<Integer>();

		try{
			
			String strSQL ="SELECT idCabestro FROM InscripcionCabestro WHERE idEncierro = "+ this.getIdEncierro() + ";";
			
			ResultSet resultado = GestorBD.getInstance().consulta(strSQL);
			
			if(resultado.last()) {
				resultado.first();
				do {
					int idCabestros = resultado.getInt("idCabestro");
					cabestros.add(idCabestros);
				}while(resultado.next());
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		
		//copiarArray(arbitros);
		return cabestros;
	}
	
	public ArrayList<Integer> obtenerTorosInscripcion(){
		
		ArrayList<Integer> toros = new ArrayList<Integer>();

		try{
			String strSQL ="SELECT idToro FROM InscripcionToro WHERE idEncierro = "+ this.getIdEncierro() + ";";
			
			ResultSet resultado = GestorBD.getInstance().consulta(strSQL);
			
			if(resultado.last()) {
				
				resultado.first();
				do {
					int idToro = resultado.getInt("idToro");
					toros.add(idToro);
				}while(resultado.next());
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		
		return toros;
	}
	
	public void anadirSustitucionToroSQL(int pIdToroAlineacion,int pIdToroInscripcion){
		
		String strSQLFichaje;
				
		try {
			
			strSQLFichaje = "INSERT INTO SustitucionToro VALUES(" + this.idEncierro + "," + pIdToroAlineacion + 
					","  + pIdToroInscripcion + ");";

			int result = GestorBD.getInstance().insertar(strSQLFichaje);
			
			if(result != 1) {
				System.out.println("Error!!");
			}
			
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public void anadirSustitucionCabestroSQL(int pIdCabAlineacion,int pIdCabInscripcion){
		
		String strSQLFichaje;
				
		try {
			
			strSQLFichaje = "INSERT INTO SustitucionCabestro VALUES(" + this.idEncierro + "," + pIdCabAlineacion + 
					","  + pIdCabInscripcion + ");";

			int result = GestorBD.getInstance().insertar(strSQLFichaje);
			
			if(result != 1) {
				System.out.println("Error!!");
			}
			
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	}
	
public static void añadirIDGanaderiaBD(Encierro enci){
		
		String strSQLFichaje;
				
		try {
			
			strSQLFichaje = "INSERT INTO Encierro VALUES(" + enci.idEncierro + "," + enci.longitud + enci.velocidadMedia + enci.idGanaderia + ");";

			int result = GestorBD.getInstance().insertar(strSQLFichaje);
			
			if(result != 1) {
				System.out.println("Error!!");
			}
			
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	}



	public static ArrayList<Encierro> obtenerListaEncierrosDeBase(){
		int idEncierro;
		double longitud; //En metros.
		double velocidadmedia;
		int idGanaderia;
		Date fecha;
		ArrayList<Encierro> ListaEncierros = new ArrayList<Encierro>();
		GestorBD g = GestorBD.getInstance();
		ResultSet rs;
		try {
			rs = g.consulta("SELECT * FROM Encierro;");
			Encierro aux;
			while(rs.next()) {
				longitud = Integer.parseInt(rs.getString("longitud"));
				idEncierro= Integer.parseInt(rs.getString("idEncierro"));
				fecha=rs.getDate("fecha");
				idGanaderia = Integer.parseInt(rs.getString("idGanaderia"));
				aux = new Encierro(fecha,idEncierro,longitud,idGanaderia);
				ListaEncierros.add(aux);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ListaEncierros;
	}
	
	public int ObtenerEncierroUnico( int pIdGanaderia){
		int result =0;
		try{
			String strSQL ="SELECT idEncierro FROM Encierro " +
					"WHERE idEncierro = "+ pIdGanaderia + ");";
			
			ResultSet resultado = GestorBD.getInstance().consulta(strSQL);
			if(resultado.last()) {
				result = resultado.getRow();
				
		}}catch (SQLException e){
			e.printStackTrace();
		}
		
		return result;
	}
	
	public void registrarAlineacionesEnBase(){
		boolean excepcion = false;
		GestorBD g = GestorBD.getInstance();
		for(AlineacionToro at: this.getAlineacion()){
			try {
			  	g.insertar("INSERT INTO AlineacionToro(idToro, idEncierro, minutos, segundos) VALUES("+at.getIdToro()+", "+this.getIdEncierro()+", 0, 0);");
		  }catch (SQLException e) {
			  JOptionPane.showMessageDialog(new JFrame(), "Error al insertar.", "Alineación incorrecta", JOptionPane.ERROR_MESSAGE);
			  excepcion=true;
		  }
		}
		
		for(AlineacionCabestro ac:this.getAlineacionCab()){
			try {
			  	g.insertar("INSERT INTO AlineacionCabestro(idCabestro, idEncierro, minutos, segundos) VALUES("+ac.getIdCabestro()+", "+this.getIdEncierro()+", 0, 0);");
		    }catch (SQLException e) {
			  JOptionPane.showMessageDialog(new JFrame(), "Error al insertar.", "Alineación Incorrecta", JOptionPane.ERROR_MESSAGE);
			  excepcion=true;
		  }
		}
		
		if(!excepcion){
			JOptionPane.showMessageDialog(new JFrame(), "Se ha insertado la alineación correctamente.", "Alineación enviada", JOptionPane.INFORMATION_MESSAGE);
		}
	}

}