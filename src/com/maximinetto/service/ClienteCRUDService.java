/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximinetto.service;

import com.maximinetto.connection.Conexion;
import com.maximinetto.entities.Cliente;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;

/**
 *
 * @author Administrador
 */
public class ClienteCRUDService {
    
    private static Long totalClientes;
    
    public ObservableList<ClienteService> mostrarClientes(){
        List<Cliente> clientes = Conexion.getInstance().select("SELECT c FROM Cliente c", Cliente.class);
        List<ClienteService> clientesService = convertToClienteService(clientes);
        return FXCollections.observableArrayList(clientesService);
        
    }
    
    public ObservableList<ClienteService> mostrarPaginado(int sizePage, int fromIndex){
        Map<List<Cliente>, Long> clientesMap = Conexion.getInstance().pageable(Cliente.class, sizePage, fromIndex);
        List<Cliente> clientes = clientesMap.keySet().stream().findFirst().get();
        List<ClienteService> clientesService = convertToClienteService(clientes);   
        totalClientes = clientesMap.get(clientes);
        return FXCollections.observableArrayList(clientesService);
    }
    
    public Long getTotalClientes(){
        return totalClientes;
    }
    
    public ObservableList<ClienteService> find(String hql,Map<String, Object> valores){
        List<Cliente> clientes = Conexion.getInstance().find(hql, Cliente.class, valores);
        List<ClienteService> clientesService = convertToClienteService(clientes);
        return FXCollections.observableArrayList(clientesService);
    }
    
    private List<ClienteService> convertToClienteService(List<Cliente> clientes) {
        List<ClienteService> clientesService = clientes.stream()
                .map(c -> {
                    ClienteService clienteService = new ClienteService(c.getIdCliente(), c.getDni(), c.getNombre(), c.getDir(), c.getTel());
                    return clienteService;
                }).collect(Collectors.toList());
        return clientesService;
    }
}
