/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author zebas
 */
public class Conexion { 
    
    private static Connection conexion;
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String USERDB = "root";
    private static final String PASSWORDDB = "";
    private static final String JDBC = "jdbc:mysql://localhost:3306/medicos_pa?zeroDateTimeBehavior=convertToNull";

    private Conexion() throws InstantiationException, IllegalAccessException {        
        try {
            Class.forName(DRIVER).newInstance();
            conexion = DriverManager.getConnection(JDBC, USERDB, PASSWORDDB);            
        } catch (ClassNotFoundException ex) {
            System.out.println("Exeption: " + ex.getMessage());
        }   catch (SQLException ex) {
            System.out.println("Exeption: " + ex.getMessage());
        }
    }
    
    public static Connection getConexion() throws InstantiationException, IllegalAccessException{
        if(conexion == null){
            Conexion con = new Conexion();
        }
        return conexion;
    }
    
    public static void desconectar(){
        try {
            if(conexion != null){
                conexion.close();
            }
        } catch (SQLException ex) {
            System.out.println("Exeption: " + ex.getMessage());
        }
    }
   
}
