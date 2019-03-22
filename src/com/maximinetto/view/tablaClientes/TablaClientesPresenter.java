/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximinetto.view.tablaClientes;

import com.maximinetto.entities.Cliente;
import com.maximinetto.service.ClienteCRUDService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.ListProperty;
import javafx.beans.property.Property;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.inject.Inject;

/**
 *
 * @author Administrador
 */
public class TablaClientesPresenter implements Initializable {

    private ResourceBundle resources = null;
    
     @FXML
    private TableView<Cliente> tblClientes;

    @FXML
    private TableColumn<Cliente, Integer> dni;

    @FXML
    private TableColumn<Cliente, String> nombre;

    @FXML
    private TableColumn<Cliente, String> dir;

    @FXML
    private TableColumn<Cliente, String> tel;
    
    @Inject
    private ClienteCRUDService clienteCRUDService;
   
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.resources = resources;
        this.inicializarTabla();
    }
    
    private void inicializarTabla(){
        dni.setCellValueFactory(new PropertyValueFactory<>("dni"));
        nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        dir.setCellValueFactory(new PropertyValueFactory<>("dir"));
        tel.setCellValueFactory(new PropertyValueFactory<>("tel"));
        tblClientes.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if(newSelection != null){
                clienteCRUDService.setClienteSeleccionado(newSelection);
            }
        });
        Property<ObservableList<Cliente>> listCliente = clienteCRUDService
                                                             .listaClienteTablaProperty();
        tblClientes.itemsProperty().bindBidirectional(listCliente);
    }

    public TableView<Cliente> getTablaCliente(){
        return tblClientes;
    }
}
