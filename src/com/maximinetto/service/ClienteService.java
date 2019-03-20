/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximinetto.service;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Administrador
 */
public class ClienteService {
    
    private IntegerProperty id = new SimpleIntegerProperty();
    
    private IntegerProperty dni = new SimpleIntegerProperty();
    
    private StringProperty nombre = new SimpleStringProperty();
    
    private StringProperty dir = new SimpleStringProperty();
    
    private StringProperty tel = new SimpleStringProperty();

    public ClienteService() {
    }

    public ClienteService(Integer id, Integer dni, String nombre, String dir, String tel){
        this.id.set(id);
        this.dni.set(dni);
        this.nombre.set(nombre);
        this.tel.set(tel);
        this.dir.set(dir);
    }
    public IntegerProperty getIdProperty() {
        return id;
    }
    
    public Integer getId() {
        return id.get();
    }

    public void setId(Integer id) {
        this.id.set(id);
    }

    public IntegerProperty getDniProperty() {
        return dni;
    }
    
    public Integer getDni() {
        return dni.get();
    }

    public void setDni(Integer dni) {
        this.dni.set(dni);
    }

    public StringProperty getNombreProperty() {
        return nombre;
    }

    public String getNombre() {
        return nombre.get();
    }
    
    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public StringProperty getDirProperty() {
        return dir;
    }
    
    public String getDir() {
        return dir.get();
    }

    public void setDir(String dir) {
        this.dir.set(dir);
    }

    public StringProperty getTelProperty() {
        return tel;
    }
    
    public String getTel() {
        return tel.get();
    }

    public void setTel(String tel) {
        this.tel.set(tel);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 53 * hash + (this.dni != null ? this.dni.hashCode() : 0);
        hash = 53 * hash + (this.nombre != null ? this.nombre.hashCode() : 0);
        hash = 53 * hash + (this.dir != null ? this.dir.hashCode() : 0);
        hash = 53 * hash + (this.tel != null ? this.tel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ClienteService other = (ClienteService) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if (this.dni != other.dni && (this.dni == null || !this.dni.equals(other.dni))) {
            return false;
        }
        if (this.nombre != other.nombre && (this.nombre == null || !this.nombre.equals(other.nombre))) {
            return false;
        }
        if (this.dir != other.dir && (this.dir == null || !this.dir.equals(other.dir))) {
            return false;
        }
        if (this.tel != other.tel && (this.tel == null || !this.tel.equals(other.tel))) {
            return false;
        }
        return true;
    }
    
    
    
    
}
