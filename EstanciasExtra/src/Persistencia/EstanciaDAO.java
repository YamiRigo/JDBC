/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Entidades.Estancia;
//import Entidades.Comentario;
import java.util.ArrayList;

/**
 *
 * @author yamila
 */
public class EstanciaDAO extends DAO{
    
    public ArrayList<Estancia> listarEstancias() throws Exception {
        
        try {
            String sql = "SELECT * FROM Estancias";    //armo la query
            consultarBase(sql);    //Consulto la base de datos!

            ArrayList<Estancia> estancias = tablaEstancias(sql);    //recorrer el resultado!
            
            return estancias;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error listar usuarios! (DAO)");

        } finally {
            desconectarBase();
        }
    }
    
    public ArrayList<Estancia> tablaEstancias(String sql) throws Exception {
        
        try {
            consultarBase(sql);    //Consulto la base de datos!

            Estancia estancia = null;
            ArrayList<Estancia> estancias = new ArrayList<>();    //recorrer el resultado!

            while (resultado.next()) {
                estancia = new Estancia();
                
                estancia.setIdEstancia(resultado.getInt(1));
                estancia.setIdCliente(resultado.getInt(2));
                estancia.setIdCasa(resultado.getInt(3));
                estancia.setNombreHuesped(resultado.getString(4));
                estancia.setFechaDesde(resultado.getDate(5));
                estancia.setFechaHasta(resultado.getDate(6));

                estancias.add(estancia);
            }
            return estancias;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error listar usuarios! (DAO)");

        } finally {
            desconectarBase();
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public ArrayList<Estancia> iiii() throws Exception {
        
        //i) Insertar nuevos datos en la tabla estancias verificando la disponibilidad de las fechas.
        try {
            String sql = "SELECT *"
                    + " FROM estancias_exterior.casas"
                    + " WHERE casas.fecha_desde = date '2020/08/1'"
                    + " AND casas.fecha_hasta = date '2020/08/31'"
                    + " AND casas.pais = 'reino unido'";    //armo la query
            consultarBase(sql);    //Consulto la base de datos!

            ArrayList<Estancia> estancias = tablaEstancias(sql);    //recorrer el resultado!
            
            return estancias;
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error iiii (DAO)");

        } finally {
            desconectarBase();
        }
    }
    
}
