/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximinetto.view.camposCliente;

import com.maximinetto.service.ClienteCRUDService;
import com.maximinetto.entities.Cliente;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.util.converter.NumberStringConverter;
import javax.inject.Inject;

/**
 *
 * @author Administrador
 */
public class CamposClientePresenter implements Initializable {

     @FXML
    private GridPane gridCampos;

    @FXML
    private TextField txtDNI;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtTel;

    @FXML
    private TextField txtDir;
    
    @Inject
    private ClienteCRUDService clienteCRUDService;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Cliente cliente = clienteCRUDService.getClienteSeleccionado();
        if(cliente != null){
            txtDNI.textProperty().bindBidirectional(cliente.dniProperty());
            txtDir.textProperty().bindBidirectional(cliente.dirProperty());
            txtNombre.textProperty().bindBidirectional(cliente.nombreProperty());
            txtTel.textProperty().bindBidirectional(cliente.telProperty());
        }
        eventoTxtDNI();
        eventoTxtNombre();
        eventoTxtTel();
        eventoTxtDir();
    }

    private void eventoTxtDNI() {
        
    }

    private void eventoTxtNombre() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void eventoTxtTel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void eventoTxtDir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
