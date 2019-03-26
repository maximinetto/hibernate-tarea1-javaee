/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximinetto.view.reserva;

import com.maximinetto.entities.Agencia;
import com.maximinetto.entities.Cliente;
import com.maximinetto.service.AgenciaService;
import com.maximinetto.service.ClienteCRUDService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.util.StringConverter;
import javax.inject.Inject;

/**
 *
 * @author Administrador
 */
public class ReservaPresenter implements Initializable {

     @FXML
    private VBox contenedor;

    @FXML
    private DatePicker dateInicio;

    @FXML
    private DatePicker dateFin;

    @FXML
    private TextField txtPrecio;

    @FXML
    private ComboBox<Cliente> cmbCliente;

    @FXML
    private ComboBox<Agencia> cmbAgencia;
    
    @Inject
    private ClienteCRUDService clienteCRUDService;
    
    @Inject
    private AgenciaService agenciaService;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cmbCliente.setItems(clienteCRUDService.mostrarClientes());
        cmbAgencia.setItems(agenciaService.mostrarTodos());

        cmbAgencia.setConverter(new StringConverter<Agencia>(){
            @Override
            public String toString(Agencia object) {
                 return object.getNombre();
            }

            @Override
            public Agencia fromString(String string) {
                return cmbAgencia.getItems().stream().filter(a -> a.getNombre().equals(string)).findFirst().orElse(null);
            }
            
        });
    }
    
}
