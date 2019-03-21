/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximinetto.view.clientemostrar;

import com.maximinetto.service.ClienteCRUDService;
import com.maximinetto.service.ClienteService;
import com.maximinetto.view.paginationCliente.PaginationClienteView;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javax.inject.Inject;

/**
 *
 * @author Administrador
 */
public class ClienteMostrarPresenter implements Initializable {

    private ResourceBundle resources = null;
    
    @FXML
    private HBox norte;

    @FXML
    private HBox sur;
    
    @FXML
    private TextField txtBuscar;
    
    @Inject
    private ClienteCRUDService clienteCRUDService;
    
    private TableView<ClienteService> tblClientes;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.resources = resources;
        
        PaginationClienteView paginationClienteView = new PaginationClienteView();
        norte.getChildren().add(paginationClienteView.getView());
        
        tblClientes = paginationClienteView.getRealPresenter().getTblClientes();
        eventoBuscar();
    }
    
    private void eventoBuscar() {
        txtBuscar.textProperty().addListener((obs, oldText, newText) -> {
            find();
        });
    }
       
    private void find(){
        
        String busqueda = txtBuscar.getText();
        busqueda = busqueda.trim();
        Map<String, Object> valores = new HashMap<>();
        String hql;
        try{
            hql = buscarPorDni(busqueda, valores);        
        }
        catch(NumberFormatException e)
        {
            hql = buscarPorNombreDireccionTelefono(busqueda, valores); 
        }
        
        ObservableList<ClienteService> cliente = clienteCRUDService.find(hql, valores);
        tblClientes.setItems(cliente);
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
        String hql = "SELECT c FROM Cliente c WHERE str(c.dni) like :dni";
        return hql;
    }
}
