/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tienda.Service;

import Tienda.Entidad.Producto;
import Excepcion.MiExcepcion;
import java.util.List;
import Tienda.Persistencia.ProductoDAO;

/**
 *
 * @author yamila
 */
public class ProductoService {
    
    private ProductoDAO pDAO;
    
    public ProductoService(){
        this.pDAO = new ProductoDAO();
    }
    
    //Crea Nuevo
    public void crearProd(Integer codigo, String nombre, Double precio, Integer cod_fab) throws MiExcepcion{
        try{
            //Validación
            if(codigo == null | codigo < 0){
                throw new MiExcepcion("DEBE INGRESAR UN CODIGO");
            }
            
            if(nombre == null | nombre.trim().isEmpty()){
                throw new MiExcepcion("DEBE INGRESAR UN NOMBRE");
            }
            
            if(precio == null | precio < 0){
                throw new MiExcepcion("DEBE INGRESAR UN PRECIO");
            }
            
            if(cod_fab == null | cod_fab < 0){
                throw new MiExcepcion("DEBE INGRESAR UN CODIGO DE FABRICANTE");
            }
            
            if(!pDAO.verificarFab(cod_fab)){
                throw new MiExcepcion("NO EXISTE EL FABRICANTE");
            }
            
            Producto p = new Producto();
            
            p.setCodigo(codigo);
            p.setNombre(nombre);
            p.setPrecio(precio);
            p.setCodigoFabricante(cod_fab);
            pDAO.guardarProd(p);
            
        }catch(MiExcepcion e){
            //e.printStackTrace();
            throw e;
        }catch(Exception e){
            //e.printStackTrace();
            throw new MiExcepcion("ERROR DE SISTEMA");
        }
    }
    
    //Modifica
    public void modificarProd(Integer codigo, String nombre, Double precio, Integer cod_fab) throws MiExcepcion{
        try{
            //Validación
            if(codigo == null | codigo < 0){
                throw new MiExcepcion("DEBE INGRESAR UN CODIGO");
            }
            
            if(nombre == null | nombre.trim().isEmpty()){
                throw new MiExcepcion("DEBE INGRESAR UN NOMBRE");
            }
            
            if(precio == null | precio < 0){
                throw new MiExcepcion("DEBE INGRESAR UN PRECIO");
            }
            
            if(cod_fab == null | cod_fab < 0){
                throw new MiExcepcion("DEBE INGRESAR UN CODIGO DE FABRICANTE");
            }
            
            Producto p = pDAO.buscarProdPorCod(codigo);
            
            if(p == null){
                throw new MiExcepcion("EL CODIGO INGRESADO NO ESTÁ ASOCIADO A NINGÚN PRODUCTO");
            }
            p.setNombre(nombre);
            p.setPrecio(precio);
            p.setCodigoFabricante(cod_fab);
            
            pDAO.modificarProd(p);
        }catch(MiExcepcion e){
            //e.printStackTrace();
            throw e;
        }catch(Exception e){
            //e.printStackTrace();
            throw new MiExcepcion("ERROR DE SISTEMA");
        }
    }
    
    //Elimina
    public void eliminarProd(Integer cod) throws MiExcepcion{
        try{
            if(cod == null || cod < 0){
                throw new MiExcepcion("DEBE INGRESAR UN CODIGO");
            }
            
            Producto p = pDAO.buscarProdPorCod(cod);
            
            if(p == null){
                throw new MiExcepcion("EL CODIGO INGRESADO NO ESTÁ ASOCIADO A NINGÚN USUARIO");
            }
            
            pDAO.eliminarProd(cod);
        }catch(MiExcepcion e){
            //e.printStackTrace();
            throw e;
        }catch(Exception e){
            //e.printStackTrace();
            throw new MiExcepcion("ERROR DE SISTEMA");
        }
    }
    
    //Muestra
    public void muestraProd() throws MiExcepcion{
        try{
            List<Producto> productos = pDAO.obtenerProd();
            
            if(productos.isEmpty()){
                throw new MiExcepcion("NO EXISTEN PRODUCTOS");
            }else{
                System.out.println("\n*** LISTA DE PRODUCTOS ***");
                System.out.printf("%-8s%-10s%-15s%-5s\n", "CODIGO", "COD.FABR", "PRECIO $", "NOMBRE"); //Formato de impresión
                productos.forEach(aux -> {
                    System.out.println(aux);
                });
                System.out.println();
            }
        }catch(MiExcepcion e){
            //e.printStackTrace();
            throw e;
        }catch(Exception e){
            //e.printStackTrace();
            throw new MiExcepcion("ERROR DE SISTEMA");
        }
    }
    
    public void muestraPorNombre(String nomb) throws MiExcepcion{
        try{
            List<Producto> productos = pDAO.obtenerProd();
            
            if(productos.isEmpty()){
                throw new MiExcepcion("NO EXISTEN PRODUCTOS");
            }else{
                System.out.println("*** LISTA DE PRODUCTOS ***");
                System.out.printf("%-15s\n", "NOMBRE"); //Formato de impresión
                productos.forEach(aux -> {
                    System.out.println(aux.getNombre());
                });
                System.out.println();
            }
        }catch(MiExcepcion e){
            //e.printStackTrace();
            throw e;
        }catch(Exception e){
            //e.printStackTrace();
            throw new MiExcepcion("ERROR DE SISTEMA");
        }
    }
    
    //Buscar por nombre
    public void buscaPorNombre(String nomb) throws MiExcepcion{
        try{
            List<Producto> productos = pDAO.buscarProdPorNomb(nomb);
            
            if(productos.isEmpty()){
                throw new MiExcepcion("NO EXISTEN PRODUCTOS");
            }else{
                System.out.println("*** LISTA DE PRODUCTOS ***");
                System.out.printf("%-8s%-10s%-15s%-5s\n", "CODIGO", "COD.FABR", "PRECIO $", "NOMBRE"); //Formato de impresión
                productos.forEach(aux -> {
                    System.out.println(aux);
                });
                System.out.println();
            }
        }catch(MiExcepcion e){
            //e.printStackTrace();
            throw e;
        }catch(Exception e){
            //e.printStackTrace();
            throw new MiExcepcion("ERROR DE SISTEMA");
        }
    }
    
    public void listarPorNombre() throws MiExcepcion{
        try{
            List<Producto> productos = pDAO.obtenerProd();
            
            if(productos.isEmpty()){
                throw new MiExcepcion("NO EXISTEN PRODUCTOS");
            }else{
                System.out.println("*** LISTA DE PRODUCTOS ***");
                System.out.printf("%-15s\n", "NOMBRE"); //Formato de impresión
                for(Producto aux : productos){
                    System.out.println(aux.getNombre());
                }
                System.out.println();
            }
        }catch(MiExcepcion e){
            //e.printStackTrace();
            throw e;
        }catch(Exception e){
            //e.printStackTrace();
            throw new MiExcepcion("ERROR DE SISTEMA");
        }
    }
    
    public void buscaMasBarato() throws MiExcepcion{
        try{
            Producto p = pDAO.buscarBarato();
            
            if(p == null){
                throw new MiExcepcion("NO HAY PRODUCTO");
            }
            
            System.out.println("\n*** PRODUCTO MÁS ECONOMICO ***");
            System.out.printf("%-15s%-35s%-15s%-25s\n", "CODIGO", "NOMBRE", "PRECIO", "FABRICANTE"); //Formato de impresión
            
            System.out.printf("%-15s%-35s%-15s%-25s\n", p.getCodigo(), p.getNombre(), p.getPrecio(), p.getCodigoFabricante());
            
            System.out.println();
        }catch(MiExcepcion e){
            //e.printStackTrace();
            throw e;
        }catch(Exception e){
            //e.printStackTrace();
            throw new MiExcepcion("ERROR DE SISTEMA");
        }
    }
    
    public void muestraRangoPre(double min, double max) throws MiExcepcion{
        try{
            List<Producto> productos = pDAO.obtenerRangoPrec(min, max);
            
            if(productos.isEmpty()){
                throw new MiExcepcion("NO EXISTEN PRODUCTOS");
            }else{
                System.out.println("*** LISTA DE PRODUCTOS ***");
                System.out.printf("%-15s%-35s%-15s%-25s\n", "CODIGO", "NOMBRE", "PRECIO", "FABRICANTE"); //Formato de impresión
                productos.forEach(aux -> {
                    System.out.printf("%-15s%-35s%-15s%-25s\n", aux.getCodigo(), aux.getNombre(), "$" + aux.getPrecio(), aux.getCodigoFabricante());
                });
                System.out.println();
            }
        }catch(MiExcepcion e){
            //e.printStackTrace();
            throw e;
        }catch(Exception e){
            //e.printStackTrace();
            throw new MiExcepcion("ERROR DE SISTEMA");
        }
    }
    
}
