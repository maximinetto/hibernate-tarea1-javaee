package com.maximinetto.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "agencia")
public class Agencia implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAgencia;

    private String nombre;

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

    public String getNombre() {
            return nombre;
    }

    public void setNombre(String nombre) {
            this.nombre = nombre;
    }

    public List<Reserva> getReservas() {
            return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
            this.reservas = reservas;
    }
	
	
}
