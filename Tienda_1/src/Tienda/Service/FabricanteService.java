/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tienda.Service;

import Tienda.Entidad.Fabricante;
import Excepcion.MiExcepcion;
import java.util.List;
import Tienda.Persistencia.FabricanteDAO;

/**
 *
 * @author yamila
 */
public class FabricanteService {
    
    private FabricanteDAO f;

    public FabricanteService(){
        f = new FabricanteDAO();
    }
    
    //Crea Nuevo
    public void crearFab(Integer codigo, String nombre) throws MiExcepcion{
        try{
            //Validación
            if (codigo == null | codigo < 0){
                throw new MiExcepcion("DEBE INGRESAR UN CODIGO");
            }
            
            if(nombre == null | nombre.trim().isEmpty()){
                throw new MiExcepcion("DEBE INGRESAR UN NOMBRE");
            }
            
            Fabricante fabricante = new Fabricante();
            
            fabricante.setCodigo(codigo);
            fabricante.setNombre(nombre);
            f.guardarFab(fabricante);
            
        }catch(MiExcepcion e){
            //e.printStackTrace();
            throw e;
        }catch(Exception e){
            //e.printStackTrace();
            throw new MiExcepcion("ERROR DE SISTEMA");
        }
    }
    
    //Modifica
    public void modificarFab(Integer codigo, String nombre) throws MiExcepcion{
        try{
            //Validación
            if (codigo == null | codigo < 0){
                throw new MiExcepcion("DEBE INGRESAR UN CODIGO");
            }
            
            if(nombre == null | nombre.trim().isEmpty()){
                throw new MiExcepcion("DEBE INGRESAR UN NOMBRE");
            }
            
            Fabricante fabricante = f.buscarFabPorCod(codigo);
            
            if(fabricante == null){
                throw new MiExcepcion("EL CODIGO INGRESADO NO ESTÁ ASOCIADO A NINGÚN FABRICANTE");
            }
            
            fabricante.setNombre(nombre);
            
            f.modificarFab(fabricante);
        }catch(MiExcepcion e){
            //e.printStackTrace();
            throw e;
        }catch(Exception e){
            //e.printStackTrace();
            throw new MiExcepcion("ERROR DE SISTEMA");
        }
    }
    
    //Elimina
    public void eliminarFab(Integer cod) throws MiExcepcion{
        try{
            if(cod == null || cod < 0){
                throw new MiExcepcion("DEBE INGRESAR UN CORREO");
            }
            
            Fabricante fabricante = f.buscarFabPorCod(cod);
            
            if(fabricante == null){
                throw new MiExcepcion("EL CORREO INGRESADO NO ESTÁ ASOCIADO A NINGÚN USUARIO");
            }
            
            f.eliminarFab(cod);
        }catch(MiExcepcion e){
            //e.printStackTrace();
            throw e;
        }catch(Exception e){
            //e.printStackTrace();
            throw new MiExcepcion("ERROR DE SISTEMA");
        }
    }
    
    //Muestra
    public void muestraFab() throws MiExcepcion{
        try{
            List<Fabricante> fabricantes = f.obtenerFab();
            
            if(fabricantes.isEmpty()){
                throw new MiExcepcion("NO EXISTEN FABRICANTES");
            }else{
                System.out.println("*** LISTA DE FABRICANTES ***");
                System.out.printf("%-15s%-15s\n", "CODIGO", "NOMBRE"); //Formato de impresión
                for(Fabricante aux : fabricantes){
                    System.out.println(aux);
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
    
}
