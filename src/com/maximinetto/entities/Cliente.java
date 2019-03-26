package com.maximinetto.entities;

import java.io.Serializable;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javax.persistence.Access;
import javax.persistence.AccessType;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "cliente")
@Access(AccessType.FIELD)
public class Cliente implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;

   
    @Column(unique = true, nullable = false)
    @Transient
    private final StringProperty dni = new SimpleStringProperty();
    
    @Transient
    private final StringProperty nombre = new SimpleStringProperty();
    
    @Transient
    private final StringProperty dir = new SimpleStringProperty();
    
    @Transient
    private final StringProperty tel = new SimpleStringProperty();

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reserva> reservas;

    public Cliente() {
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }
   
    @Access(AccessType.PROPERTY)
    public String getDni() {
            return dni.get();
    }

    public void setDni(String dni) {
            this.dni.set(dni);
    }
    
    public StringProperty dniProperty(){
        return dni;
    }

    @Access(AccessType.PROPERTY)
    public String getNombre() {
            return nombre.get();
    }

    public void setNombre(String nombre) {
            this.nombre.set(nombre);
    }
    
    public StringProperty nombreProperty(){
        return nombre;
    }

    @Access(AccessType.PROPERTY)
    public String getDir() {
            return dir.get();
    }

    public void setDir(String dir) {
            this.dir.set(dir);
    }
    
    public StringProperty dirProperty(){
        return dir;
    }

    @Access(AccessType.PROPERTY)
    public String getTel() {
            return tel.get();
    }

    public void setTel(String tel) {
            this.tel.set(tel);
    }
    
    public StringProperty telProperty(){
        return this.tel;
    }

    public List<Reserva> getReservas() {
            return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
            this.reservas = reservas;
    }

    @Override
    public String toString() {
        return getDni() + " " + getNombre();
    }
    
    
	
}
