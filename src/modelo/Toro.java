package modelo;

import java.sql.SQLException;

/**
 * 
 * @author Endika Serrano Lomas
 *
 */

public class Toro {

	private int idToro;
	private String nombre;
	private String nacimiento;
	private float peso;
	private float altura;
	private float longcorn;
	
	public Toro(int pIdToro, String pNombre, String pNacimiento, float pPeso, float pAltura, float pLongCorn){
		idToro = pIdToro;
		nombre = pNombre;
		nacimiento = pNacimiento;
		peso = pPeso;
		altura = pAltura;
		longcorn = pLongCorn;
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
	public int modificarToro(){
			
			String strSQL ="UPDATE Toro SET nombre = " + this.nombre + ", nacimiento = " + this.nacimiento + 
					", peso = " + this.peso + ", altura = " + this.altura + ", longcorn = " + this.longcorn + " " +
							"WHERE idToro = " + this.idToro;
		
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
	public void eliminarToro(){
		
		String strSQL = "DELETE FROM Toro WHERE idToro = " + this.idToro + ";";
		
		try {
			
			GestorBD.getInstance().borrar(strSQL);
			
		}catch(SQLException e) {
			System.out.println(strSQL);
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString(){
		
		return nombre;
	}
}
