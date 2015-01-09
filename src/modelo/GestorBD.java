/*
 * Bajar driver desde http://dev.mysql.com/downloads/connector/j/
 */

package modelo;

import java.sql.*;

public class GestorBD {
	
	private String usuario;
    private String clave;
    private String url;
    private String driverClassName;
    private Connection conn = null;
    private Statement sentencia;
    private static GestorBD miGestor;

    /** Constructor **/
    private GestorBD() {

            this.usuario = "ADSI";
            this.clave = "adsi2014";
            this.url = "jdbc:mysql://estres.duckdns.org:3306/ADSI";
            this.driverClassName = "com.mysql.jdbc.Driver";

            try {
                    AbrirConexion();
            } catch (SQLException ex) {
                    System.out.println("SQLException: " + ex.getMessage());
                    System.out.println("SQLState: " + ex.getSQLState());
                    System.out.println("VendorError: " + ex.getErrorCode());
            }
    }

    /**
     * @author Andoni
     * @return
     */
    public static GestorBD getInstance() {
            if(miGestor == null) {

                    miGestor = new GestorBD();
            }
            return miGestor;
    }

    /** 
     * @author Andoni
     *      Abre la conexión a la base de datos
     * @throws SQLException
     */
    private void AbrirConexion() throws SQLException {

            try {
                    Class.forName(this.driverClassName).newInstance();
                    this.conn = DriverManager.getConnection(this.url, this.usuario, this.clave);
                    sentencia = this.conn.createStatement();

            } catch (Exception err) {
                    System.out.println("Error " + err.getMessage());
            }
    }

    /**
     * @author Andoni 
     *
     *  Comprueba si la conexion existe o está abierta, la abre en caso contrario
     * @throws SQLException
     */
    private void comprobarConexion() throws SQLException{

            if (conn == null)
                    AbrirConexion();

            if (conn.isClosed())
                    AbrirConexion();
            

    }

    /**
     * @author Andoni
     * Ejecuta una consulta de base de datos y devuelve el resultset
     * @param consulta
     * @return
     * @throws SQLException
     */
    public ResultSet consulta(String strSQL) throws SQLException
    {
            comprobarConexion();
            return this.sentencia.executeQuery(strSQL);
    }

    /**
     * @author Andoni
     * Ejecuta una sentencia de actualización
     * @param actualiza
     * @throws SQLException
     */
    public int actualizar(String strSQL) throws SQLException {
            comprobarConexion();
            return sentencia.executeUpdate(strSQL);
    }

    /**
     * @author Andoni
     * Ejecuta una sentencia de borrado
     * @param borra
     * @return
     * @throws SQLException
     */
    public int borrar(String strSQL) throws SQLException {
            comprobarConexion();
            return sentencia.executeUpdate(strSQL);
    }

    /**
     * @author Andoni
     * Ejecuta una sentencia de insercion 
     * @param inserta
     * @return
     * @throws SQLException
     */
    public int insertar(String strSQL) throws SQLException {
            comprobarConexion();
            return sentencia.executeUpdate(strSQL);
    }

    /**
     * @author Andoni
     * Devuelve el ID GENERADO al hacer un insert
     * Devolvera -1 si ha fallado
     * @param strSQL Sentencia que queremos ejecutar
     * @return
     * @throws SQLException 
     */
    public int ultimoID(String strSQL) throws SQLException{
            int ret = -1;
            
            sentencia.executeUpdate(strSQL, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = sentencia.getGeneratedKeys();
            if (rs.first()) 
                    ret = rs.getInt(1);
            
            return ret;
    }

    /**
     * @author Andoni
     * Guarda las sentencias que queramos agregar hasta que se ejecuten
     * @param strSQL Sentencia que queremos agregar
     * @throws SQLException 
     */
    public void agregarSentencia(String strSQL) throws SQLException{
            sentencia.addBatch(strSQL);
    }

    /**
     * @author Andoni
     * 
     * Ejecutar las sentencias agregadas
     * @throws SQLException 
     */
    public void ejecutarSentencias() throws SQLException{

            sentencia.executeBatch();
            sentencia.clearBatch();

    }
	
}
