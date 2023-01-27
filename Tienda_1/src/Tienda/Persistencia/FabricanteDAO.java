/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tienda.Persistencia;

import Tienda.Entidad.Fabricante;
import Excepcion.MiExcepcion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yamila
 */
public class FabricanteDAO extends DAO{ 
    
    //Guardar
    public void guardarFab(Fabricante f) throws MiExcepcion{
        try{
            if(f == null){
                throw new MiExcepcion("FABRICANTE INVÁLIDO");
            }
            //Sentencia SQL de inserción -- INSERT INTO `tienda`, `fabricante` (`codigo`, `nombre`) VALUES (`10`, `PHILLIPS`);
            String sql = "INSERT INTO fabricante (codigo, nombre)"
                    + "VALUES('" + f.getCodigo()
                    + "', '" + f.getNombre() + "');";
            insertarModificarEliminar(sql);
        }catch(MiExcepcion e){
            System.out.println(e.getMessage());
            throw new MiExcepcion("ERROR AL GUARDAR FABRICANTE");
        }
    }
    
    //Buscar
    public Fabricante buscarFabPorCod(int cod) throws MiExcepcion{
        try{
            //Sentencia SQL de consulta
            String sql = "SELECT * FROM fabricante WHERE codigo = '" + cod + ";";
            consultarBase(sql);
            Fabricante f = null;
            
            while(resultado.next()){
                f = new Fabricante();
                
                f.setCodigo(resultado.getInt(1));
                f.setNombre(resultado.getString(2));
            }
            return f;
        }catch(SQLException | MiExcepcion e){
            System.out.println(e.getMessage());
            throw new MiExcepcion("ERROR AL OBTENER FABRICANTE");
        }finally{
            desconectarBase();
        }
    }
    
    //Modificar
    public void modificarFab(Fabricante f) throws MiExcepcion{
        try{
            if(f == null){
                throw new MiExcepcion("FABRICANTE INVÁLIDO");
            }
            //Sentencia SQL de modificación -- UPDATE fabricante SET nombre = 'Generico' WHERE (codigo = '11');
            String sql = "UPDATE fabricante SET nombre = '" + f.getNombre() + "' "
                    + "WHERE codigo = '" + f.getCodigo() + "';";
            
            insertarModificarEliminar(sql);
        }catch(MiExcepcion e){
            System.out.println(e.getMessage());
            throw new MiExcepcion("ERROR AL MODIFICAR FABRICANTE");
        }
    }
    
    //Eliminar
    public void eliminarFab(Integer cod) throws MiExcepcion{
        try{
            //Sentencia SQL de eliminación
            String sql = "DELETE FROM fabricante WHERE codigo = '" + cod + "';";
            
            insertarModificarEliminar(sql);
        }catch(MiExcepcion e){
            System.out.println(e.getMessage());
            throw new MiExcepcion("ERROR AL ELIMINAR FABRICANTE");
        }       
    }
    
    //Obtener
    public List<Fabricante> obtenerFab()throws MiExcepcion{
        try{
            //Sentencia SQL de consulta
            String sql = "SELECT * FROM fabricante";
            consultarBase(sql);
            
            List<Fabricante> fabricantes = new ArrayList<>();
            Fabricante aux = null;
            
            while(resultado.next()){
                aux = new Fabricante();
                
                aux.setCodigo(resultado.getInt(1));
                aux.setNombre(resultado.getString(2));
                fabricantes.add(aux);
            }
            return fabricantes;
        }catch(SQLException | MiExcepcion e){
            System.out.println(e.getMessage());
            throw new MiExcepcion("ERROR AL OBTENER FABRICANTES");
        }finally{
            desconectarBase();
        }
    }
    
}
