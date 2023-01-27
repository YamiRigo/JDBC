/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Entidades.Cliente;
import java.util.ArrayList;

/**
 *
 * @author yamila
 */

public class ClienteDAO extends DAO{
    
    public ArrayList<Cliente> listarClientes() throws Exception {
        
        try {
            String sql = "SELECT * FROM Clientes";    //armo la query
            consultarBase(sql);    //Consulto la base de datos!

            ArrayList<Cliente> casas = tablaClientes(sql);    //recorrer el resultado!
            
            return casas;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error listar usuarios! (DAO)");

        } finally {
            desconectarBase();
        }
    }
    
    public ArrayList<Cliente> tablaClientes(String sql) throws Exception {
        
        try {
            consultarBase(sql);    //Consulto la base de datos!

            Cliente cliente = null;
            ArrayList<Cliente> clientes = new ArrayList<>();    //recorrer el resultado!

            while (resultado.next()) {
                cliente = new Cliente();
                
                cliente.setIdCliente(resultado.getInt(1));
                cliente.setNombre(resultado.getString(2));
                cliente.setCalle(resultado.getString(3));
                cliente.setNumero(resultado.getInt(4));
                cliente.setCodigoPostal(resultado.getInt(5));
                cliente.setCiudad(resultado.getString(6));
                cliente.setPais(resultado.getString(7));
                cliente.setEmail(resultado.getString(8));

                clientes.add(cliente);
            }
            return clientes;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error listar usuarios! (DAO)");

        } finally {
            desconectarBase();
        }
    }
}
