/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tienda.Persistencia;

import Excepcion.MiExcepcion;
import java.sql.*;

/**
 *
 * @author yamila
 */
public class DAO {
    
    protected Connection conexion = null;
    protected Statement sentencia = null;
    protected ResultSet resultado = null;
    private final String USER = "root";
    private final String PASSWORD = "root";
    private final String DATABASE = "jdbc:mysql://localhost:3306/tienda?useSSL=false";
    private final String DRIVER = "com.mysql.jdbc.Driver";
    
    protected void conectarDB() throws MiExcepcion{
        try{
            Class.forName(DRIVER); //Carga del driver
            conexion = DriverManager.getConnection(DATABASE, USER, PASSWORD); //Esteblece la conexion
        }catch(ClassNotFoundException | SQLException e){
            //e.printStackTrace(); //Para ver la traza del error
            throw new MiExcepcion("ERROR AL CONECTARSE");
        }
    }
    
    protected void desconectarBase() throws MiExcepcion{
        try{
            if(resultado != null){
                resultado.close();
            }
            if(sentencia != null){
                sentencia.close();
            }
            if(conexion != null){
                conexion.close();
            }
        }catch(SQLException e){
            //e.printStackTrace();
            throw new MiExcepcion("ERROR AL DESCONECTARSE");
        }
    }
    
    protected void insertarModificarEliminar(String sql) throws MiExcepcion {
        try {
            conectarDB();
            sentencia = conexion.createStatement();
            sentencia.executeUpdate(sql);
        } catch (SQLException ex) {
            // conexion.rollback();
            try {
                conexion.rollback();
            }catch(SQLException e){
                ex.printStackTrace();
                throw new MiExcepcion("ERROR AL REALIZAR ROLLBACK");
            }
            ex.printStackTrace();
            throw new MiExcepcion("ERROR AL EJECUTAR SENTENCIA");
        }catch(MiExcepcion e){
            e.printStackTrace();
            throw e;
            /*
                Descomentar la linea anterior si desean tener en cuenta el rollback.
                Correr el siguiente script en Workbench
            
                SET autocommit=1;
                COMMIT;
            
                **Sin rollback igual anda
             */
        } finally {
            desconectarBase();
        }
    }

    protected void consultarBase(String sql) throws MiExcepcion {
        try {
            conectarDB();
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new MiExcepcion("ERROR AL CONSULTAR");
        }catch(MiExcepcion e){
            e.printStackTrace();
            throw e;
        }
    }
    
}
