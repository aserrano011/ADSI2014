package modelo;

import java.sql.SQLException;

/**
 * 
 * @author Endika Serrano Lomas
 *
 */
public class Cabestro {
	
	private int idCabestro;
	private String nacimiento;
	private float peso;
	private float altura;
	private String color;
	
	public Cabestro(int pIdCabestro, String pNacimiento, Float pPeso, Float pAltura, String pColor){
		idCabestro = pIdCabestro;
		nacimiento = pNacimiento;
		peso = pPeso;
		altura = pAltura;
		color = pColor;
	}

	
	/**
	 * Modifica el cabestro en la base de datos
	 * @param pIdCabestro
	 * @param pNacimiento
	 * @param pPeso
	 * @param pAltura
	 * @param pColor
	 * @return
	 */
	public int modificarCabestro(){
		
		String strSQL ="UPDATE Cabestro SET nacimiento = " + this.nacimiento + 
				", peso = " + this.peso + ", altura = " + this.altura + ", color = " + this.color + " " +
						"WHERE idCabestro = " + this.idCabestro;
	
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
	 * Elimina el cabestro de la base de datos
	 * @param pIdCabestro
	 */
	public void eliminarCabestro(){
		
		String strSQL = "DELETE FROM Cabestro WHERE idCabestro = " + this.idCabestro + ";";
		
		try {
			
			GestorBD.getInstance().borrar(strSQL);
			
		}catch(SQLException e) {
			System.out.println(strSQL);
			e.printStackTrace();
		}
	}
	
	/**
	 * Se hace un override a toString() para que al cargar la lista devuelva el nombre
	 */
	@Override
	public String toString(){
		String nombre = "Cabestro " + idCabestro;
		return nombre;
	}
}
