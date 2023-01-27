/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tienda.Persistencia;

import Tienda.Entidad.Producto;
import Excepcion.MiExcepcion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yamila
 */
public class ProductoDAO extends DAO{
    
    //Guardar
    public void guardarProd(Producto p )throws MiExcepcion{
        try{
            if(p == null){
                throw new MiExcepcion("PRODUCTO INVÁLIDO");
            }
            //Sentencia SQL de inserción -- INSERT INTO `tienda`, `fabricante` (`codigo`, `nombre`) VALUES (`10`, `PHILLIPS`);
            String sql = "INSERT INTO producto (codigo, nombre, precio, codigo_fabricante) "
                    + "VALUES('" + p.getCodigo() 
                    + "', '" + p.getNombre() + "', '" + p.getPrecio() + "', '"
                    + p.getCodigoFabricante() + "');";
            
            insertarModificarEliminar(sql);
        }catch(MiExcepcion e){
            System.out.println(e.getMessage());
            throw new MiExcepcion("ERROR AL GUARDAR PRODUCTO");
        }
    }
    
    //Buscar
    public Producto buscarProdPorCod(int cod) throws MiExcepcion{
        try{
            //Sentencia SQL de consulta
            String sql = "SELECT * FROM producto WHERE codigo = '" + cod + "';";
            consultarBase(sql);
            Producto p = null;
            
            while(resultado.next()){
                p = new Producto();
                
                p.setCodigo(resultado.getInt(1));
                p.setNombre(resultado.getString(2));
                p.setPrecio(resultado.getDouble(3));
                p.setCodigoFabricante(resultado.getInt(4));
            }
            return p;
        }catch(SQLException | MiExcepcion e){
            System.out.println(e.getMessage());
            throw new MiExcepcion("ERROR AL OBTENER PRODUCTO");
        }finally{
            desconectarBase();
        }
    }
    
    //Verifica si existe fabricante
    public boolean verificarFab(int cod_fab) throws MiExcepcion{
        try{
            //Sentencia SQL de consulta
            String sql = "SELECT * FROM fabricante WHERE codigo = '" + cod_fab + "';";
            consultarBase(sql);
            return resultado.next();
        }catch(SQLException | MiExcepcion e){
            System.out.println(e.getMessage());
            throw new MiExcepcion("ERROR AL OBTENER PRODUCTO");
        }finally{
            desconectarBase();
        }
    }
    
    public List<Producto> buscarProdPorNomb(String nombre) throws MiExcepcion{
        try{
            //Sentencia SQL de consulta
            String sql = "SELECT * FROM producto WHERE nombre LIKE '" + nombre + "%';";
            consultarBase(sql);
            List<Producto> productos = new ArrayList<>();
            Producto p = null;
            
            while(resultado.next()){
                p = new Producto(); //instancio el obj de mi clase Producto
                
                p.setCodigo(resultado.getInt(1));
                p.setNombre(resultado.getString(2));
                p.setPrecio(resultado.getDouble(3));
                p.setCodigoFabricante(resultado.getInt(4));
                
                productos.add(p); //Agrego a la lista el obj instanciado y seteado
            }
            return productos;
        }catch(SQLException | MiExcepcion e){
            System.out.println(e.getMessage());
            throw new MiExcepcion("ERROR AL OBTENER PRODUCTO");
        }finally{
            desconectarBase();
        }
    }
    
    //Modificar
    public void modificarProd(Producto p) throws MiExcepcion{
        try{
            if(p == null){
                throw new MiExcepcion("PRODUCTO INVÁLIDO");
            }
            //Sentencia SQL de modificación
            /*UPDATE producto SET codigo = '51',
            nombre = 'algo',
            precio = '25.50',
            codigo_fabricante = '2'
            WHERE (codigo = '78');
            */
            
            String sql = "UPDATE producto SET nombre = '" + p.getNombre() + "', "
                    + "precio = '" + p.getPrecio() + "', "
                    + "codigo_fabricante = '" + p.getCodigoFabricante() + "' "
                    + "WHERE codigo = '" + p.getCodigo() + "';";
            
            insertarModificarEliminar(sql);
        }catch(MiExcepcion e){
            System.out.println(e.getMessage());
            throw new MiExcepcion("ERROR AL MODIFICAR PRODUCTO");
        }
    }
    
    //Eliminar
    public void eliminarProd(Integer cod) throws MiExcepcion{
        try{
            //Sentencia SQL de eliminación
            String sql = "DELETE FROM producto WHERE codigo = '" + cod + "';";
            
            insertarModificarEliminar(sql);
        }catch(MiExcepcion e){
            System.out.println(e.getMessage());
            throw new MiExcepcion("ERROR AL ELIMINAR PRODUCTO");
        }
    }
    
    //Obtener
    public List<Producto> obtenerProd() throws MiExcepcion{
        try{
            //Sentencia SQL de consulta
            String sql = "SELECT * FROM producto;";
            consultarBase(sql);
            
            List<Producto> productos = new ArrayList<>();
            Producto aux = null;
            
            while(resultado.next()){
                aux = new Producto();
                aux.setCodigo(resultado.getInt(1));
                aux.setNombre(resultado.getString(2));
                aux.setPrecio(resultado.getDouble(3));
                aux.setCodigoFabricante(resultado.getInt(4));
                
                productos.add(aux);
            }
            return productos;
        }catch(SQLException | MiExcepcion e){
            System.out.println(e.getMessage());
            throw new MiExcepcion("ERROR AL OBTENER PRODUCTOS");
        }finally{
            desconectarBase();
        }
    }
    
    public List<String> obtenerNombPrecio() throws MiExcepcion{
        try{
            //Sentencia SQL de consulta
            String sql = "SELECT nombre, precio FROM producto ORDER BY nombre;";
            consultarBase(sql);
            
            List<String> nomb_precio = new ArrayList<>();
            Producto aux = null;
            String variable = null;
            
            while(resultado.next()){
                aux = new Producto();
                variable = resultado.getString(1) + " - $" + resultado.getDouble(2);
                
                nomb_precio.add(variable);
            }
            return nomb_precio;
        }catch(SQLException | MiExcepcion e){
            System.out.println(e.getMessage());
            throw new MiExcepcion("ERROR AL OBTENER PRODUCTOS");
        }finally{
            desconectarBase();
        }
    }
    
    public Producto buscarBarato() throws MiExcepcion{
        try{
            /*Sentencia SQL de consulta
            SELECT * FROM producto ORDER BY precio 
            limit 1;
            */
            
            String sql = "SELECT * FROM producto ORDER BY precio LIMIT 1;";
            consultarBase(sql);
            Producto p = null;
            
            while(resultado.next()){
                p = new Producto();
                
                p.setCodigo(resultado.getInt(1));
                p.setNombre(resultado.getString(2));
                p.setPrecio(resultado.getDouble(3));
                p.setCodigoFabricante(resultado.getInt(4));
            }
            return p;
        }catch(SQLException | MiExcepcion e){
            System.out.println(e.getMessage());
            throw new MiExcepcion("ERROR AL OBTENER PRODUCTO");
        }finally{
            desconectarBase();
        }
    }
    
    public List<Producto> obtenerRangoPrec(double min, double max) throws MiExcepcion{
        try{
            //Sentencia SQL de consulta
            String sql = "SELECT * FROM producto p JOIN fabricante f ON f.codigo = p.codigo_fabricante "
                    + "WHERE p.precio BETWEEN " + min + " AND " + max + " ;";
            
            consultarBase(sql);
            
            List<Producto> productos = new ArrayList<>();
            Producto p = null;
            
            while(resultado.next()){
                p = new Producto();
                
                p.setCodigo(resultado.getInt(1));
                p.setNombre(resultado.getString(2));
                p.setPrecio(resultado.getDouble(3));
                p.setCodigoFabricante(resultado.getInt(4));
                
                productos.add(p);
            }
            return productos;
        }catch(SQLException | MiExcepcion e){
            System.out.println(e.getMessage());
            throw new MiExcepcion("ERROR AL OBTENER PRODUCTOS");
        }finally{
            desconectarBase();
        }
    }
    
}
