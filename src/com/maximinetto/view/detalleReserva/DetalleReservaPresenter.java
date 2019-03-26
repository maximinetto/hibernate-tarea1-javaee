/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximinetto.view.detalleReserva;

import com.maximinetto.entities.Automovil;
import com.maximinetto.entities.DetalleReserva;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 *
 * @author Administrador
 */
public class DetalleReservaPresenter implements Initializable {

     @FXML
    private TextField txtPrecio;

    @FXML
    private TextField txtLitros;

    @FXML
    private ComboBox<Automovil> cmbAutomovil;

    @FXML
    private CheckBox chkEntregado;

    @FXML
    private TableView<DetalleReserva> tablaDetalle;

    @FXML
    private TableColumn<DetalleReserva, Double> columnPrecio;

    @FXML
    private TableColumn<DetalleReserva, Automovil> columnAutomovil;

    @FXML
    private TableColumn<DetalleReserva, Integer> columnLitros;

    @FXML
    private TableColumn<DetalleReserva, Boolean> columnEntregado;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
}
