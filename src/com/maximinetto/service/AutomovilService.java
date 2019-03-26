/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximinetto.service;

import com.maximinetto.connection.Conexion;
import com.maximinetto.entities.Automovil;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Administrador
 */
public class AutomovilService {
    
    public ObservableList<Automovil>obtenerTodos(){
        List<Automovil> listaAutomovil = Conexion.getInstance().select("FROM Automovil", Automovil.class);
        return FXCollections.observableArrayList(listaAutomovil);
    }
}
