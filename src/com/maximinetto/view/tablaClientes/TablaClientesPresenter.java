/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximinetto.view.tablaClientes;

import com.maximinetto.entities.Cliente;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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
    }

    public TableView<Cliente> getTablaCliente(){
        return tblClientes;
    }
}
