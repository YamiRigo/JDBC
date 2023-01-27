/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author yamila
 */
public class DAO {
    
    //OBJETO CONNECTION --> encargado de INICIAR-TENER-MANTENER la conexion
    protected Connection conexion = null;
    
    //OBJETO STATEMENT ---> "TIENE" las consultas.. es donde generamos las sentencias a ejecutar
    protected Statement sentencia = null;
    
    //OBJETO RESULSET ---> guarda todos los datos que llegan de la DB (las filas de la query)
    protected ResultSet resultado = null;
    
    private final String USUARIO = "root";
    private final String CLAVE = "root";
    private final String CONTROLADOR = "com.mysql.cj.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/estancias_exterior?useSSL=false";
    
    
    protected void conectarDB() throws Exception {
        try {
            Class.forName(CONTROLADOR);// CARGA EL CONTROLADOR
            conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);// ESTABLECE LA CONEXIÓN
        } catch (Exception e) {
            // e.printStackTrace(); //para ver la traza del error
            System.out.println(e.getMessage());
            throw new Exception("ERROR AL CONECTARSE");
        }
    }

    protected void desconectarBase() throws Exception {
        try {
            if (resultado != null) {
                resultado.close();
            }
            if (sentencia != null) {
                sentencia.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        } catch (Exception e) {
            // e.printStackTrace();
            System.out.println(e.getMessage());
            throw new Exception("ERROR AL DESCONECTARSE");
        }
    }

    protected void insertarModificarEliminar(String sql) throws Exception {
        try {
            conectarDB();
            sentencia = conexion.createStatement();
            sentencia.executeUpdate(sql);
        } catch (SQLException e) {
            try {
                conexion.rollback();
                System.out.println(e.getMessage());
                System.out.println("ERROR AL INTENTAR ACTUALIZAR LA BASE DE DATOS");
            } catch (SQLException ex) {
                // ex.printStackTrace();
                throw new Exception("ERROR AL REALIZAR ROLLBACK");
            }
            // e.printStackTrace();
            throw new Exception("ERROR AL EJECUTAR SENTENCIA");
        } finally {
            desconectarBase();
        }
    }

    protected void consultarBase(String sql) throws Exception {
        try {
            conectarDB();
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sql);
        } catch (Exception e) {
            // e.printStackTrace();
            throw new Exception("ERROR AL CONSULTAR");
        }
    }
    
}
