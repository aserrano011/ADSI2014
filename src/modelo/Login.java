package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import vista.Principal;

public class Login
{
	public Login()
	{
		
	}
	
	public static void identificarse(String pUser, String pPass) throws SQLException
	{
		ResultSet rs1 = GestorBD.getInstance().consulta("Select * from ADSI.Ganaderia where ADSI.Ganaderia.Nombre = \"" + pUser + "\" and ADSI.Ganaderia.Password = \"" + pPass + "\"");
		if (rs1.first())
		{
			int idGanaderia = rs1.getInt("idGanaderia");
			new Principal(idGanaderia, pUser);
		}
		else
		{
			JOptionPane.showMessageDialog(new JFrame(), "Usuario o contraseña incorrectos.", "Login erroneo", JOptionPane.ERROR_MESSAGE);
			vista.Login dialog = new vista.Login();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
	}
}