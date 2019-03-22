/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximinetto.view.clientemostrar;

import com.maximinetto.entities.Cliente;
import com.maximinetto.service.ClienteCRUDService;
import com.maximinetto.view.camposCliente.CamposClienteView;
import com.maximinetto.view.paginationCliente.PaginationClienteView;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
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
    
    private TableView<Cliente> tblClientes;
    
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
        
        ObservableList<Cliente> cliente = clienteCRUDService.find(busqueda);
        tblClientes.setItems(cliente);
    }
    
    @FXML
    void editarRegistro(ActionEvent event) {
        crearVistaFormulario();
    }

    @FXML
    void eliminarRegistro(ActionEvent event) {

    }

    @FXML
    void nuevoRegistro(ActionEvent event) {
        crearVistaFormulario();
        clienteCRUDService.setClienteSeleccionado(null);
    }

    private void crearVistaFormulario(){
        Stage primaryStage = (Stage) txtBuscar.getScene().getWindow();
        CamposClienteView camposClienteView = new CamposClienteView();
        Parent parent = camposClienteView.getView();
        Scene scene = new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
    }
}
