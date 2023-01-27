/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Persistencia.ClienteDAO;

/**
 *
 * @author yamila
 */

public class ClienteService {
    
    private ClienteDAO dao;
    
    public ClienteService() {
        this.dao = new ClienteDAO();
    }
    
}
