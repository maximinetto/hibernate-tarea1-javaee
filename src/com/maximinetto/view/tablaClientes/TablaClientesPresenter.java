/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximinetto.view.tablaClientes;

import com.maximinetto.service.ClienteCRUDService;
import com.maximinetto.service.ClienteService;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javax.inject.Inject;

/**
 *
 * @author Administrador
 */
public class TablaClientesPresenter implements Initializable {

    private ResourceBundle resources = null;
    
     @FXML
    private TableView<ClienteService> tblClientes;

    @FXML
    private TableColumn<ClienteService, Integer> id;

    @FXML
    private TableColumn<ClienteService, Integer> dni;

    @FXML
    private TableColumn<ClienteService, String> nombre;

    @FXML
    private TableColumn<ClienteService, String> dir;

    @FXML
    private TableColumn<ClienteService, String> tel;
    
    
   
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.resources = resources;
        this.inicializarTabla();
    }
    
    private void inicializarTabla(){
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        dni.setCellValueFactory(new PropertyValueFactory<>("dni"));
        nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        dir.setCellValueFactory(new PropertyValueFactory<>("dir"));
        tel.setCellValueFactory(new PropertyValueFactory<>("tel"));
    }

    public TableView<ClienteService> getTablaCliente(){
        return tblClientes;
    }
}
