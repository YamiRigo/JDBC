/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Estancia;
import Entidades.Cliente;
import Persistencia.EstanciaDAO;
import Persistencia.ClienteDAO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author yamila
 */

public class EstanciaService extends Entidades.Casa{
    
    private EstanciaDAO dao;
    
    public EstanciaService() {
        this.dao = new EstanciaDAO();
    }
    
    public void listarEImprimiriiii() throws Exception {
        
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 'T' HH:mm:ss.SSS");
                
        try {
            
            ArrayList<Estancia> estancias = dao.iiii();
            System.out.println("\033[36m"+"i) Insertar nuevos datos en la tabla estancias verificando la disponibilidad de las fechas.\n"+"\033[30m");
            
            int casa = sc.nextInt();
            System.out.print("Fecha DESDE (YYYY-MM-DD) -> ");
            String fechaInicio = sc.next();
            Date fech1 = sdf.parse(fechaInicio);
            
            System.out.print("Fecha HASTA (YYYY-MM-DD) -> ");
            String fechaFinal = sc.next();
            Date fech2 = sdf.parse(fechaFinal);
            
            System.out.print("ID del cliente que alquila -> ");
            List<Cliente> clientes = new ArrayList<>();
            ClienteDAO cliente = new ClienteDAO();
            clientes = cliente.listarClientes();
            int seleccionarCliente = sc.nextInt();
            
            //completar
            
            if (estancias.isEmpty()) {
                System.out.println("La lista está vacia");
            } else {
                for (Estancia i : estancias) {
                    System.out.println(i.getIdEstancia()+" | ");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error Service iiii");

        }
    }
    
}
