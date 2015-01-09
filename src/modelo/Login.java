package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;

public class Login
{
	public Login()
	{
		
	}
	
	public static void identificarse(String pUser, char[] pPass) throws SQLException
	{
		ResultSet rs1 = GestorBD.getInstance().consulta("select * from <tabla_usuarios> where <nombre_usuario>= " + pUser + " and <password>= " + pPass.toString());
		
	}
}