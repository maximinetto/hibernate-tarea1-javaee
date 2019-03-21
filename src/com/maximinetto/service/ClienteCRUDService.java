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
    
    private Cliente clienteSeleccionado;
    
    public ObservableList<Cliente> mostrarClientes(){
        List<Cliente> clientes = Conexion.getInstance().select("SELECT c FROM Cliente c", Cliente.class);
        return FXCollections.observableArrayList(clientes);
        
    }
    
    public ObservableList<Cliente> mostrarPaginado(int sizePage, int fromIndex){
        Map<List<Cliente>, Long> clientesMap = Conexion.getInstance().pageable(Cliente.class, sizePage, fromIndex);
        List<Cliente> clientes = clientesMap.keySet().stream().findFirst().get();
        totalClientes = clientesMap.get(clientes);
        return FXCollections.observableArrayList(clientes);
    }
    
    public Long getTotalClientes(){
        return totalClientes;
    }
    
    public ObservableList<Cliente> find(String busqueda){
        Map<String, Object> valores = new HashMap<>();
        String hql;
        try{
            hql = buscarPorDni(busqueda, valores);        
        }
        catch(NumberFormatException e)
        {
            hql = buscarPorNombreDireccionTelefono(busqueda, valores); 
        }
        List<Cliente> clientes = Conexion.getInstance().find(hql, Cliente.class, valores);
      
        return FXCollections.observableArrayList(clientes);
    }
    
    private String buscarPorNombreDireccionTelefono(String busqueda, Map<String, Object> valores) {
        
        busqueda = busqueda + "%";
        valores.put("dir", busqueda);
        valores.put("nombre", busqueda);
        valores.put("tel", busqueda);
        String hql = "SELECT c FROM Cliente c WHERE UPPER(c.nombre) like UPPER(:nombre) or UPPER(c.dir) like UPPER(:dir) or UPPER(c.tel) like UPPER(:tel)";
        return hql;
    }

    private String buscarPorDni(String busqueda, Map<String, Object> valores) throws NumberFormatException {
        Integer.parseInt(busqueda);
        valores.put("dni", busqueda + "%");
        String hql = "SELECT c FROM Cliente c WHERE c.dni like :dni";
        return hql;
    }
    
    public Cliente getClienteSeleccionado(){
        return clienteSeleccionado;
    }
    
    public void setClienteSeleccionado(Cliente clienteSeleccionado){
        this.clienteSeleccionado = clienteSeleccionado;
    }
}
