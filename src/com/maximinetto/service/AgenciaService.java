/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximinetto.service;

import com.maximinetto.connection.Conexion;
import com.maximinetto.entities.Agencia;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Administrador
 */
public class AgenciaService {
    
       public ObservableList<Agencia> mostrarTodos(){
           List<Agencia> listaAgencia = Conexion.getInstance().select("FROM Agencia", Agencia.class);
           listaAgencia.forEach(a -> System.out.println(a.getNombre()));
           return FXCollections.observableArrayList(listaAgencia);
       }
    
}
