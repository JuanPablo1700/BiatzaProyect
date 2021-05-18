package Proyecto;

import java.sql.*;

public class ConeccionBD {
    
    public Connection conexion;
    public Statement sentencia;
    
    //Datos para la conexion de la BD
    private final String servidor = "localhost";
    private final String puerto = "3306";
    private final String BD = "BiatzaBD";
    private final String usuario = "root";
    private final String clave = "9632174123";
    private final String URL = "jdbc:mysql://"+
            servidor + ":" + puerto + "/" + BD;
    
    /**
     * Metodo constructor, que inicialixa los atributos
     * internos del conector de BD
     */
    public ConeccionBD(){
    }
    
    /**
     * Metodo para crear la comunicacion con la BD
     * @return true cuando la conexion se crea correctamente
     * y false cuando no es posible
     */
    public Connection conectar(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
                //Establecer la conexion con la BD
                conexion = DriverManager.getConnection(URL, usuario, clave);
                //System.out.println("Conexion exitosa");
            } catch (Exception e) {
                System.err.println("ERROR: ConectorBD.conectar()");
                System.err.println("Al intentar la conexion con la BD");
                System.err.println(e.getMessage());
            }
        return conexion;
    }
    
    /**
     * Para ejecutar sentencias SQL: SELECT
     * @param sql texto con el script sql para seleccionar registros
     * @return ResulSet con la informacion selecionada o null en caso de no
     */
    /**
     * Para ejecutar sentencias SQL: INSERT, UPDATE, DELETE
     * @param sql texto con el script sql para ejecutar sobre la BD
     * @return true si la sentencia tiene exito y
     * false en caso de no
     */
    public boolean ejecutar(String sql){
        boolean estado = false;
        try {
            sentencia = conexion.createStatement();
            sentencia.execute(sql);
            sentencia.close();
            estado = true;
        } catch (SQLException sqle) {
            System.err.println("ERROR: ConectorBD.seleccionar(sql)");
            System.err.println(sqle.getMessage());
        }
        return estado;
    }
    
    /**
     * Para cerrar la conexion de forma correcta con la base de datos,
     * verifica que exista la conexion
     */
    public void desconectar(){
        try {
            if(conexion != null){
                conexion.close();
                conexion = null;
            }
        } catch (SQLException sqle) {
            System.err.println("ERROR: ConectorBD.seleccionar(sql)");
            System.err.println(sqle.getMessage());
        }
    }
    
    /**
     * Retorna la conexion actual que este establecida
     * @return conexion
     */
    public Connection getConection(){
        return conexion;
    }
}
