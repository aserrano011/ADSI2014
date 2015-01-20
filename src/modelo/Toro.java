package modelo;

import java.sql.SQLException;

import javax.swing.JOptionPane;

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
	 * @return rs
	 */
	public int modificarToro(String pNombre, String pNacimiento, float pPeso, float pAltura, float pLongCorn){
			
			String strSQL ="UPDATE Toro SET nombre = \"" + pNombre + "\", nacimiento = \"" + pNacimiento + 
					"\", peso = " + pPeso + ", altura = " + pAltura + ", longcorn = " + pLongCorn + " " +
							"WHERE idToro = " + this.idToro + ";";
		
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
	 */
	public void eliminarAnimal(){
		
		String strSQL = "DELETE FROM Toro WHERE idToro = " + this.idToro + ";";
		
		try {
			
			GestorBD.getInstance().borrar(strSQL);
			
		}catch(SQLException e) {
			System.out.println(strSQL);
			JOptionPane.showMessageDialog(null,"Ese animal está inscrito en algún encierro, si desea eliminarlo antes debe retirarlo.");
		}
	}
	
	@Override
	public String toString(){
		return nombre;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public float getLongCorn(){
		return longcorn;
	}

}
