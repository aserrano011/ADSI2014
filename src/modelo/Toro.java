package modelo;

import java.sql.SQLException;

/**
 * 
 * @author Endika Serrano Lomas
 *
 */

public class Toro extends Animal{

	private int idToro;
	private String nombre;
	private float longcorn;
	
	public Toro(int pIdToro, String pNombre, String pNacimiento, float pPeso, float pAltura, float pLongCorn){
		super(pNacimiento,pPeso,pAltura);
		idToro = pIdToro;
		nombre = pNombre;
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
	public int modificarAnimal(){
			
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
	public void eliminarAnimal(){
		
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
