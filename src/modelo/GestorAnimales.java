package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultListModel;

/**
 * 
 * @author Endika Serrano Lomas
 * 
 */

public class GestorAnimales {
	
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
	 * @param pNombre
	 * @param pNacimiento
	 * @param pPeso
	 * @param pAltura
	 * @param pLongitud
	 * @param pGanaderia
	 */
	public void anadirToro(String pNombre, String pNacimiento, Float pPeso, Float pAltura, Float pLongitud, int pIdGanaderia){
		
		String strSQLFichaje;
				
				try {
					
					strSQLFichaje = "INSERT INTO Toro (nombre,nacimiento,peso,altura,longcorn,ganaderia) "
							+ "VALUES(\"" + pNombre + "\",\"" + pNacimiento + "\"," + pPeso + 
							"," + pAltura + "," + pLongitud + "," + pIdGanaderia + ");";
		
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
	 * @param pNacimiento
	 * @param pPeso
	 * @param pAltura
	 * @param pColor
	 * @param pGanaderia
	 */
	public void anadirCabestro(String pNacimiento, Float pPeso, Float pAltura, String pColor, int pIdGanaderia){
		
		String strSQLFichaje;
				
				try {
					
					strSQLFichaje = "INSERT INTO Cabestro (nacimiento,peso,altura,color,ganaderia)VALUES(\"" 
					+ pNacimiento + "\"," + pPeso + "," + pAltura + ",\"" + pColor + "\"," + pIdGanaderia + ");";
		
					int result = GestorBD.getInstance().insertar(strSQLFichaje);
					
					if(result != 1) {
						System.out.println("Error!!");
					}
					
				}
				catch (SQLException e){
					e.printStackTrace();
				}	
	}
	
	
	public DefaultListModel<Toro> obtenerToros(int pIdGanaderia){
		
		@SuppressWarnings("unused")
		int cont = 0;

		DefaultListModel<Toro> lista = new DefaultListModel<Toro>();
		
		try{
			
		String strSQL ="SELECT * FROM Toro " +
				"WHERE ganaderia = " + pIdGanaderia + ";";
		
		ResultSet resultado = GestorBD.getInstance().consulta(strSQL);
		
		if(resultado.last()) {
			
			resultado.first();
			do {
				
				int idToro = resultado.getInt("idToro");
				String nombre = resultado.getString("nombre");
				String nacimiento = resultado.getDate("nacimiento").toString();
				float peso = resultado.getFloat("peso");
				float altura = resultado.getFloat("altura");
				float longcorn = resultado.getFloat("longcorn");
				Toro pToro = new Toro(idToro,nombre,nacimiento,peso,altura,longcorn);
				
				lista.addElement(pToro);	
				cont++;
				
			}while(resultado.next());
		}
	}
	catch (SQLException e){
		e.printStackTrace();
	}

	return lista;
	}

	
	public DefaultListModel<Cabestro> obtenerCabestros(int pIdGanaderia){
		
		@SuppressWarnings("unused")
		int cont = 0;

		DefaultListModel<Cabestro> lista = new DefaultListModel<Cabestro>();
		
		try{
			
		String strSQL ="SELECT * FROM Cabestro " +
				"WHERE ganaderia = " + pIdGanaderia + ";";
		
		ResultSet resultado = GestorBD.getInstance().consulta(strSQL);
		
		if(resultado.last()) {
			
			resultado.first();
			do {
				
				int idCabestro = resultado.getInt("idCabestro");
				String nacimiento = resultado.getDate("nacimiento").toString();
				float peso = resultado.getFloat("peso");
				float altura = resultado.getFloat("altura");
				String color = resultado.getString("color");
				Cabestro pCabestro = new Cabestro(idCabestro,nacimiento,peso,altura,color);
				
				lista.addElement(pCabestro);
				cont++;
				
			}while(resultado.next());
		}
	}
	catch (SQLException e){
		e.printStackTrace();
	}

	return lista;
	}
}
