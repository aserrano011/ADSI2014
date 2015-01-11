package modelo;

import java.sql.SQLException;

/**
 * 
 * @author Endika Serrano Lomas
 *
 */
public class Cabestro extends Animal{
	
	private int idCabestro;
	private String color;
	
	public Cabestro(int pIdCabestro, String pNacimiento, Float pPeso, Float pAltura, String pColor){
		super(pNacimiento,pPeso,pAltura);
		idCabestro = pIdCabestro;
		color = pColor;
	}

	
	/**
	 * Modifica el cabestro en la base de datos
	 * @return rs
	 */
	public int modificarCabestro(String pNacimiento, Float pPeso, Float pAltura, String pColor){
		
		String strSQL ="UPDATE Cabestro SET nacimiento = \"" + pNacimiento + 
				"\", peso = " + pPeso + ", altura = " + pAltura + ", color = \"" + pColor + "\" " +
						"WHERE idCabestro = " + this.idCabestro + ";";
	
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
	 */
	public void eliminarAnimal(){
		
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
	
	public String getColor(){
		return color;
	}
}
