/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estancia;

import Servicios.CasaService;
import Servicios.ComentarioService;
import Servicios.FamiliaService;

/**
 *
 * @author yamila
 */
public class Estancia {

    public static void main(String[] args) throws Exception{
        
        try {
            FamiliaService familiasservice = new FamiliaService();
            familiasservice.listarEImprimiraaaa();
            System.out.println("---------------------------------------------------------");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            //throw new Exception("Error MAIN aaaa");
        }
        /////////////////////////////////////////////////////////////////
        try {
            CasaService casasservice = new CasaService();
            casasservice.listarEImprimirbbbb();
            System.out.println("---------------------------------------------------------");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            //throw new Exception("Error MAIN bbbb");
        }
        /////////////////////////////////////////////////////////////////
        try {
            FamiliaService familiasservice = new FamiliaService();
            familiasservice.listarEImprimircccc();
            System.out.println("---------------------------------------------------------");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            //throw new Exception("Error MAIN cccc");
        }
        /////////////////////////////////////////////////////////////////
        try {
            FamiliaService familiasservice = new FamiliaService();
            familiasservice.listarEImprimirdddd();
            System.out.println("---------------------------------------------------------");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            //throw new Exception("Error MAIN dddd");
        }
        /////////////////////////////////////////////////////////////////
        try {
            CasaService casasservice = new CasaService();
            casasservice.listarEImprimireeee();
            System.out.println("---------------------------------------------------------");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error MAIN eeee");
        }
        /////////////////////////////////////////////////////////////////
        try {
            CasaService casasservice = new CasaService();
            casasservice.listarEImprimirffff();
            System.out.println("---------------------------------------------------------");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error MAIN ffff");
        }
        /////////////////////////////////////////////////////////////////
        try {
            CasaService casasservice = new CasaService();
            casasservice.listarEImprimirgggg();
            System.out.println("---------------------------------------------------------");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error MAIN gggg");
        }
        /////////////////////////////////////////////////////////////////
        try {
            ComentarioService comentariosservice = new ComentarioService();
            comentariosservice.listarEImprimirhhhh();
            System.out.println("---------------------------------------------------------");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error MAIN hhhh");
        }
        /////////////////////////////////////////////////////////////////
        try {
            ComentarioService comentariosservice = new ComentarioService();
            //comentariosservice.listarEImprimiriiii();
            System.out.println("---------------------------------------------------------");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error MAIN iiii");
        }
        
    }
    
}
