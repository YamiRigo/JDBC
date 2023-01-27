/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Comentario;
import Persistencia.ComentarioDAO;
import java.util.ArrayList;

/**
 *
 * @author yamila
 */

public class ComentarioService {
    
    private ComentarioDAO dao;
    
    public ComentarioService() {
        this.dao = new ComentarioDAO();
    }
    
    public void listarEImprimirhhhh() throws Exception {
        try {
            
            ArrayList<Comentario> comentarios = dao.hhhh();
            System.out.println("\033[36m"+"h) Busca y listar aquellas casas del Reino Unido de las que se ha dicho de ellas (comentarios) que están 'limpias'.\n"+"\033[30m");

            if (comentarios.isEmpty()) {
                System.out.println("La lista estÃ¡ vacia");
            } else {
                for (Comentario i : comentarios) {
                    System.out.println(i.toString());
                }
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error Service hhhh");

        }
    }
    
}
