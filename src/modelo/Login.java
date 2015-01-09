package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.Popup;

public class Login
{
	public Login()
	{
		
	}
	
	public static void identificarse(String pUser, char[] pPass) throws SQLException
	{
		ResultSet rs1 = GestorBD.getInstance().consulta("Select * from ADSI.Ganaderia where ADSI.Ganaderia.Nombre = \"" + pUser + "\" and ADSI.Ganaderia.Password = \"" + String.valueOf(pPass) + "\"");
		rs1.first();
		int idGanaderia = rs1.getInt("idGanaderia");
		if (rs1!=null)
		{
			new vista.Principal(idGanaderia, pUser);
			//vista.Login.cerrar();
		}
		/*else
		{
			Popup pp = new Popup();
		}*/
	}
}