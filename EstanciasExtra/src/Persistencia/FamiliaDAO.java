/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Entidades.Familia;
import java.util.ArrayList;

/**
 *
 * @author yamila
 */

public class FamiliaDAO extends DAO{
    
    public ArrayList<Familia> listarFamilias() throws Exception {
        
        try {
            String sql = "SELECT * FROM Familias";    //armo la query
            consultarBase(sql);    //conecto la base

            ArrayList<Familia> familias = tablaFamilias(sql);    //recorrer el resultado

            return familias;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error listar usuarios! (DAO)");
            
        } finally {
            desconectarBase();
        }
    }
    
    public ArrayList<Familia> tablaFamilias(String sql) throws Exception {
        
        try {
            consultarBase(sql);

            Familia familia = null;
            ArrayList<Familia> familias = new ArrayList<>();    //recorrer el resultado

            while (resultado.next()) {
                familia = new Familia();

                familia.setIdFamilia(resultado.getInt(1));
                familia.setNombre(resultado.getString(2));
                familia.setEdadMinima(resultado.getInt(3));
                familia.setEdadMaxima(resultado.getInt(4));
                familia.setNumHijos(resultado.getInt(5));
                familia.setEmail(resultado.getString(6));
                familia.setIdCasaFamilia(resultado.getInt(7));

                familias.add(familia);
            }

            return familias;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error en consulta! (DAO FAMILIAS)");

        } finally {
            desconectarBase();
        }
    }
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public ArrayList<Familia> aaaa() throws Exception {
        
        //a) Listar aquellas familias que tienen al menos 3 hijos, y con edad mÃ¡xima inferior a 10 aÃ±os.
        try {
            String sql = "SELECT * FROM Familia WHERE num_hijos <=3 AND edad_maxima <10;";    //armo la query
            consultarBase(sql);    //Consulto la base de datos!

            ArrayList<Familia> familias = tablaFamilias(sql);    //recorrer el resultado!

            return familias;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error aaaa (DAO)");

        } finally {
            desconectarBase();
        }
    }

    public ArrayList<Familia> cccc() throws Exception {
        
        try {
            String sql = "SELECT * FROM estancias_exterior.familias WHERE familias.nombre LIKE '%y';";    //armo la query
            consultarBase(sql);    //Consulto la base de datos!

            ArrayList<Familia> familias = tablaFamilias(sql);    //el metodo consultaFamilia me devuelve el resultado de la bÃºsqueda    //recorrer el resultado!

            return familias;
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error cccc (DAO)");

        } finally {
            desconectarBase();
        }
    }
    
    public ArrayList<Familia> dddd() throws Exception {
        
        try {
            String sql = "SELECT * FROM estancias_exterior.familias WHERE familias.email LIKE '%hotmail%';";    //armo la query
            consultarBase(sql);    //Consulto la base de datos!

            ArrayList<Familia> familias = tablaFamilias(sql);    //el metodo consultaFamilia me devuelve el resultado de la bÃºsqueda    //recorrer el resultado!

            return familias;
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error dddd (DAO)");

        } finally {
            desconectarBase();
        }
    }
}
