/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import Excepcion.MiExcepcion;
import java.util.InputMismatchException;
import java.util.Scanner;
import Tienda.Service.*;

/**
 *
 * @author yamila
 */
public class Menu {
    
    private Scanner leer;
    private FabricanteService fabServ;
    private ProductoService prodServ;
    
    public Menu(){
        leer = new Scanner(System.in);
        fabServ = new FabricanteService();
        prodServ = new ProductoService();
    }
    
    public void menuPrincipal(){
        int opc = 0;
        
        do{
            try{
                System.out.println("\n********** MENU PRINCIPAL **********");
                System.out.println("**  1. Mostrar Fabricantes          **");
                System.out.println("**  2. Admin. de Fabricantes        **");
                System.out.println("**  3. Mostrar Productos            **");
                System.out.println("**  4. Admin. de Productos          **");
                System.out.println("**  5. Salir                        **");
                System.out.println("**************************************");
                
                opc = leer.nextInt();
                
                switch(opc){
                    case 1:
                        fabServ.muestraFab();
                        break;
                    case 2:
                        menuFabr();
                        break;
                    case 3:
                        prodServ.muestraProd();
                        break;
                    case 4:
                        menuProd();
                        break;
                    case 5:
                        System.out.println("ADIOS!!");
                        break;
                }
            }catch(InputMismatchException e){
                System.out.println("NO SE ADMITEN CARACTERES");
                leer.nextInt();
            }catch(MiExcepcion e){
                System.out.println(e.getMessage());
            }
        }while(opc != 5);
    }
    
    public void menuFabr(){
        int op = 0;
        
        do{
            try{
                System.out.println("\n***** MENU FABRICANTE *****");
                System.out.println("*  1. Nuevo Fabricante      *");
                System.out.println("*  2. Modificar Fabricante  *");
                System.out.println("*  3. Borrar Fabricante     *");
                System.out.println("*  4. Volver                *");
                System.out.println("*****************************");
                
                op = leer.nextInt();
                
                switch(op){
                    case 1:
                        crearFabricante();
                        break;
                    case 2:
                        modificarFabr();
                        break;
                    case 3:
                        eliminarFabr();
                        break;
                    case 4:
                        System.out.println("- VOLVER AL MENU PRINCIPAL -");
                }
            }catch(InputMismatchException e){
                System.out.println("NO SE ADMITEN CARACTERES");
                leer.nextInt();
            }
        }while(op != 4);
    }
    
    public void menuProd() throws MiExcepcion{
        int op = 0;
        
        do{
            try{
                System.out.println("\n***** MENU PRODUCTOS *****");
                System.out.println("*  1. Nuevo Producto       *");
                System.out.println("*  2. Modificar Producto   *");
                System.out.println("*  3. Borrar Producto      *");
                System.out.println("*  4. Buscar por Nombre    *");
                System.out.println("*  5. Mostrar más Barato   *");
                System.out.println("*  6. Listar por Nombre/$  *");
                System.out.println("*  7. Entre $120/202       *");
                System.out.println("*  8. Volver               *");
                System.out.println("****************************");
                
                op = leer.nextInt();
                
                switch(op){
                    case 1:
                        crearProd();
                        break;
                    case 2:
                        modificarProd();
                        break;
                    case 3:
                        eliminarProd();
                        break;
                    case 4:
                        buscaPorNomb();
                        break;
                    case 5:
                        prodServ.buscaMasBarato();
                        break;
                    case 6:
                        listarNombPrecio();
                        break;
                    case 7:
                        prodServ.muestraRangoPre(120d, 202d);
                        break;
                    case 8:
                        System.out.println("- VOLVER AL MENU PRINCIPAL -");
                }
            }catch(InputMismatchException e){
                System.out.println("NO SE ADMITEN CARACTERES");
                leer.nextInt();
            }
        }while(op != 8);
    }
    
    //Crud Fabricante
    public void crearFabricante(){
        try{
            System.out.println("INGRESE CODIGO: ");
            int codigo = leer.nextInt();
            
            System.out.println("INGRESE NOMBRE: ");
            String nombre = leer.next();
            
            fabServ.crearFab(codigo, nombre);
        }catch(MiExcepcion e){
            System.out.println(e.getMessage());
        }
    }
    
    public void modificarFabr(){
        try{
            System.out.println("INGRESE CODIGO: ");
            int codigo = leer.nextInt();
            
            System.out.println("INGRESE NOMBRE: ");
            String nombre = leer.next();
            
            fabServ.modificarFab(codigo, nombre);
        }catch(MiExcepcion e){
            System.out.println(e.getMessage());
        }
    }
    
    public void eliminarFabr(){
        try{
            System.out.println("INGRESE CODIGO DE FABRICANTE: ");
            int codigo = leer.nextInt();
            
            fabServ.eliminarFab(codigo);
        }catch(MiExcepcion e){
            System.out.println(e.getMessage());
        }
    }
    
    //Crud Producto
    public void crearProd(){
         try {
            System.out.println("INGRESE CODIGO: ");
            int codigo = leer.nextInt();
                                    
            System.out.println("INGRESE NOMBRE: ");
            String nombre = leer.next();

            System.out.println("INGRESE PRECIO: ");
            double precio = leer.nextDouble();

            System.out.println("INGRESE CODIGO DE FABRICANTE: ");
            int cod_fab = leer.nextInt();

            prodServ.crearProd(codigo, nombre, precio, cod_fab);
        } catch (MiExcepcion e) {
            System.out.println(e.getMessage());
        }
    }
    
     public void modificarProd() {
        try {
            System.out.println("INGRESE CODIGO: ");
            int codigo = leer.nextInt();

            System.out.println("INGRESE NOMBRE: ");
            String nombre = leer.next();

            System.out.println("INGRESE PRECIO: ");
            double precio = leer.nextDouble();

            System.out.println("INGRESE CODIGO DE FABRICANTE: ");
            int cod_fab = leer.nextInt();

            prodServ.modificarProd(codigo, nombre, precio, cod_fab);
        } catch (MiExcepcion e) {
            System.out.println(e.getMessage());
        }
    }

    public void eliminarProd() {
        try {
            System.out.println("INGRESE CODIGO DE PRODUCTO: ");
            int codigo = leer.nextInt();
            prodServ.eliminarProd(codigo);
        } catch (MiExcepcion e) {
            System.out.println(e.getMessage());
        }
    }

    //Consultas especiales
    
    public void buscaPorNomb(){
        try {
            System.out.println("INGRESE EL NOMBRE DEL PRODUCTO A BUSCAR: ");
            String variable = leer.next();
            prodServ.buscaPorNombre(variable);
        } catch (MiExcepcion e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    public void listarNombPrecio() {
        try
        {
            prodServ.listarPorNombre();
        } catch (MiExcepcion ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    
}
