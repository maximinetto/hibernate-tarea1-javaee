/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximinetto.view.camposCliente;

import com.maximinetto.connection.Conexion;
import com.maximinetto.service.ClienteCRUDService;
import com.maximinetto.entities.Cliente;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ObjectProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
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
    
    @FXML
    private Button btnGuardar;
    
    @Inject
    private ClienteCRUDService clienteCRUDService;
    
    private String dni;
    private String nombre;
    private String dir;
    private String tel;
    
    private Cliente cliente;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
         ObjectProperty<Cliente> clienteProperty = clienteCRUDService.getClienteSeleccionado();        
         cliente = clienteProperty.get();
         if(cliente != null){
            setTextField();
         }
         
         btnGuardar.disableProperty().bind(
                 Bindings.isEmpty(txtDNI.textProperty())
        .or(Bindings.isEmpty(txtDir.textProperty()))
        .or(Bindings.isEmpty(txtNombre.textProperty()))
        .or(Bindings.isEmpty(txtTel.textProperty()))
        );
                
    }   

     @FXML
    void guardar(ActionEvent event) {
        if(esValidoFormulario()){
            
        }
        else{
            mensajeError();
        }
    }
    
    private boolean esValidoFormulario(){
        String dni = txtDNI.getText();
        String tel = txtTel.getText();
        
        try{
            Long.parseLong(dni);
            Long.parseLong(tel);
        }
        catch(NumberFormatException e)
        {
            return false;
        }
        
        return true;
    }

    @FXML
    void volver(ActionEvent event) {

    }
    
    private void mensajeError(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Campos incorrectos");
        alert.setContentText("El dni y el teléfono debe ser numéricos");
        alert.showAndWait();
    }
    
    private void guardarCambios(){
        if(clienteCRUDService.getClienteSeleccionado().get() == null)
        {
            insertar();
        }
        else
        {
            editar();
        }
    }

    private void insertar() {
        obtenerCampos();
        cliente = new Cliente();
        setCliente(cliente);
        Conexion.getInstance().persist(cliente);
        clienteCRUDService.getListaClienteTabla().add(cliente);
        
    }

    private void editar() {
        obtenerCampos();
        setCliente(cliente);
        Conexion.getInstance().merge(cliente);
        ObservableList<Cliente> clientes = clienteCRUDService.getListaClienteTabla();
        int indexCliente = clientes.indexOf(clientes);
        clientes.set(indexCliente, cliente);
    }
    
    
    
    private void obtenerCampos() {
       dni = txtDNI.getText();
       nombre = txtNombre.getText();
       dir = txtDir.getText();
       tel = txtTel.getText();
    }
    
    private void setTextField() {
        txtDNI.setText(cliente.getDni());
        txtNombre.setText(cliente.getNombre());
        txtDir.setText(cliente.getDir());
        txtTel.setText(cliente.getTel());
    }
    
    private void setCliente(Cliente cliente){
        cliente.setDni(dni);
        cliente.setNombre(nombre);
        cliente.setDir(dir);
        cliente.setTel(tel);
    }
}
