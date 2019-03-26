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
@Table(name = "agencia")
@Access(AccessType.FIELD)
public class Agencia implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAgencia;

    @Transient
    private StringProperty nombre = new SimpleStringProperty();

    @OneToMany(mappedBy = "agencia", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reserva> reservas;

    public Agencia() {
    }

    public Integer getIdAgencia() {
            return idAgencia;
    }

    public void setIdAgencia(Integer idAgencia) {
            this.idAgencia = idAgencia;
    }

    public StringProperty nombre(){
        return nombre;
    }
   
    @Column(name = "nombre", unique = true)
    @Access(AccessType.PROPERTY)
    public String getNombre() {
            return nombre.get();
    }

    public void setNombre(String nombre) {
            this.nombre.set(nombre);
    }

    public List<Reserva> getReservas() {
            return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
            this.reservas = reservas;
    }
	
	
}
