/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Familia;
import Persistencia.FamiliaDAO;
import java.util.ArrayList;

/**
 *
 * @author yamila
 */

public class FamiliaService {
    
    private FamiliaDAO dao;

    public FamiliaService() {
        this.dao = new FamiliaDAO();
    }
    
    public void listarEImprimiraaaa() throws Exception {
        
        try {
            ArrayList<Familia> familias = dao.aaaa();
            System.out.println("\033[36m"+"a) Listar aquellas familias que tienen al menos 3 hijos, y con edad máxima inferior a 10 años.\n"+"\033[30m");
            
            if (familias.isEmpty()) {
                throw new Exception("La lista esta vacia!");
            } else {
                for (Familia i : familias) {
                    System.out.println(i.getIdFamilia()+" | "+i.getNombre()+i.getEdadMaxima()+" | "+i.getNumHijos());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error Service aaaa");
        }
    }
    
    public void listarEImprimircccc() throws Exception {
        
        try {
            ArrayList<Familia> familias = dao.cccc();
            System.out.println("\033[36m"+"c) Como cliente, estás interesado en mandar a tu hijo a una familia, de la que únicamente recuerdas que su nombre familiar terminaba en 'y'.\n"+"\033[30m");
            
            if (familias.isEmpty()) {
                throw new Exception("La lista esta vacia!");
            } else {
                for (Familia i : familias) {
                    System.out.println(i.getIdFamilia()+" | "+i.getNombre());
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error Service cccc");
        }
    }
    
    public void listarEImprimirdddd() throws Exception {
        
        try {
            ArrayList<Familia> familias = dao.dddd();
            System.out.println("\033[36m"+"d) Encuentra todas aquellas familias cuya dirección de mail sea de Hotmail.\n"+"\033[30m");
            
            if (familias.isEmpty()) {
                throw new Exception("La lista esta vacia!");
            } else {
                for (Familia i : familias) {
                    System.out.println(i.getIdFamilia()+" | "+i.getNombre()+" | "+i.getEmail());
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error Service dddd");
        }
    }
    
}
