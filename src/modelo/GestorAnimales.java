package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GestorAnimales {
	/**
	 * @author Endika Serrano Lomas
	 */
	
	private static GestorAnimales miGestorAnimales;
	
	private GestorAnimales(){
		
	}
	
	public static GestorAnimales getInstance(){
		if (miGestorAnimales == null){
			miGestorAnimales = new GestorAnimales();	
		}
		
		return miGestorAnimales;
	}
	
	/**
	 * Añade el toro a la base de datos
	 * @param pIdToro
	 * @param pNombre
	 * @param pNacimiento
	 * @param pPeso
	 * @param pAltura
	 * @param pLongitud
	 * @param pGanaderia
	 */
	public void anadirToro(int pIdToro, String pNombre, String pNacimiento, Float pPeso, Float pAltura, Float pLongitud, String pGanaderia){
		
		String strSQLFichaje;
				
				try {
					
					strSQLFichaje = "INSERT INTO Toro VALUES(" + pNombre + "," + pNacimiento + 
							"," + pPeso + "," + pAltura + "," + pLongitud + "," + pGanaderia + ");";
		
					int result = GestorBD.getInstance().insertar(strSQLFichaje);
					
					if(result != 1) {
						System.out.println("Error!!");
					}
					
				}
				catch (SQLException e){
					e.printStackTrace();
				}
	}
	
	/**
	 * Añade el cabestro a la base de datos
	 * @param pIdCabestro
	 * @param pNombre
	 * @param pNacimiento
	 * @param pPeso
	 * @param pAltura
	 * @param pColor
	 * @param pGanaderia
	 */
	public void anadirCabestro(int pIdCabestro, String pNombre, String pNacimiento, Float pPeso, Float pAltura, String pColor, String pGanaderia){
		
		String strSQLFichaje;
				
				try {
					
					strSQLFichaje = "INSERT INTO Cabestro VALUES(" + pNombre + "," + pNacimiento + 
							"," + pPeso + "," + pAltura + "," + pColor + "," + pGanaderia + ");";
		
					int result = GestorBD.getInstance().insertar(strSQLFichaje);
					
					if(result != 1) {
						System.out.println("Error!!");
					}
					
				}
				catch (SQLException e){
					e.printStackTrace();
				}	
	}
	
	/**
	 * Modifica el toro en la base de datos
	 * @param pIdToro
	 * @param pNombre
	 * @param pNacimiento
	 * @param pPeso
	 * @param pAltura
	 * @param pLongitud
	 * @return
	 */
	public int modificarToro(int pIdToro, String pNombre, String pNacimiento, Float pPeso, Float pAltura, Float pLongitud  ){
			
			String strSQL ="UPDATE Toro SET nombre = " + pNombre + ", nacimiento = " + pNacimiento + 
					", peso = " + pPeso + ", altura = " + pAltura + ", longcorn = " + pLongitud + " " +
							"WHERE idToro = " + pIdToro;
		
			int rs = 0;
			try{
				rs = GestorBD.getInstance().actualizar(strSQL);
			}catch(SQLException e) {
				System.out.println(strSQL);
				e.printStackTrace();
			}
			return rs;
	}
	
	/**
	 * Modifica el cabestro en la base de datos
	 * @param pIdCabestro
	 * @param pNombre
	 * @param pNacimiento
	 * @param pPeso
	 * @param pAltura
	 * @param pColor
	 * @return
	 */
	public int modificarCabestro(int pIdCabestro, String pNombre, String pNacimiento, Float pPeso, Float pAltura, String pColor  ){
		
		String strSQL ="UPDATE Cabestro SET nombre = " + pNombre + ", nacimiento = " + pNacimiento + 
				", peso = " + pPeso + ", altura = " + pAltura + ", color = " + pColor + " " +
						"WHERE idCabestro = " + pIdCabestro;
	
		int rs = 0;
		try{
			rs = GestorBD.getInstance().actualizar(strSQL);
		}catch(SQLException e) {
			System.out.println(strSQL);
			e.printStackTrace();
		}
		return rs;
	}	
	/**
	 * Elimina el toro de la base de datos
	 * @param pIdToro
	 */
	public void eliminarToro(int pIdToro){
		
		String strSQL = "DELETE FROM Toro WHERE idToro = " + pIdToro + ";";
		
		try {
			
			GestorBD.getInstance().borrar(strSQL);
			
		}catch(SQLException e) {
			System.out.println(strSQL);
			e.printStackTrace();
		}
	}
	
	/**
	 * Elimina el cabestro de la base de datos
	 * @param pIdCabestro
	 */
	public void eliminarCabestro(int pIdCabestro){
		
		String strSQL = "DELETE FROM Cabestro WHERE idCabestro = " + pIdCabestro + ";";
		
		try {
			
			GestorBD.getInstance().borrar(strSQL);
			
		}catch(SQLException e) {
			System.out.println(strSQL);
			e.printStackTrace();
		}
	}
	
	public Integer[] obtenerToros(int pIdGanaderia){
		
		Integer[] toros = null;
		int cont = 0;

		try{
			
		String strSQL ="SELECT idToro FROM Toro " +
				"WHERE idGanaderia = "+ pIdGanaderia + ");";
		
		ResultSet resultado = GestorBD.getInstance().consulta(strSQL);
		
		if(resultado.last()) {
			
			toros = new Integer[resultado.getRow()];
			resultado.first();
			do {
				int idToro = resultado.getInt("idToro");
				toros [cont] = new Integer(idToro);
				
				//toros[cont].setID(idToro);
				cont++;
			}while(resultado.next());
		}
	}
	catch (SQLException e){
		e.printStackTrace();
	}
	//copiarArray(arbitros);
	return toros;
	}

	
	public Integer[] obtenerCabestros(int pIdGanaderia){
		
		Integer[] cabestros = null;
		int cont = 0;

		try{
			
		String strSQL ="SELECT idCabestro FROM Cabestro " +
				"WHERE idGanaderia = "+ pIdGanaderia + ");";
		
		ResultSet resultado = GestorBD.getInstance().consulta(strSQL);
		
		if(resultado.last()) {
			
			cabestros = new Integer[resultado.getRow()];
			resultado.first();
			do {
				int idCabestros = resultado.getInt("idCabestros");
				cabestros [cont] = new Integer(idCabestros);
				
				//toros[cont].setID(idToro);
				cont++;
			}while(resultado.next());
		}
	}
	catch (SQLException e){
		e.printStackTrace();
	}
	//copiarArray(arbitros);
	return cabestros;
	}
}
