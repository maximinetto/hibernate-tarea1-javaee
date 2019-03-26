package com.maximinetto.entities;

import java.io.Serializable;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detalle_reserva")
public class DetalleReserva implements Serializable{
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDetalleReserva;
    
    @ManyToOne()
    private Reserva reserva;

    private double precio;
    
    @ManyToOne()
    private Automovil automovil; 

    private Integer litrosGasolina;

    private boolean entregado;

    public DetalleReserva() {
    }

    public Integer getIdDetalleReserva() {
        return idDetalleReserva;
    }

    public void setIdDetalleReserva(Integer idDetalleReserva) {
        this.idDetalleReserva = idDetalleReserva;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Integer getLitrosGasolina() {
        return litrosGasolina;
    }

    public void setLitrosGasolina(Integer litrosGasolina) {
        this.litrosGasolina = litrosGasolina;
    }

    public boolean isEntregado() {
        return entregado;
    }

    public void setEntregado(boolean entregado) {
        this.entregado = entregado;
    }

    public Automovil getAutomovil() {
        return automovil;
    }

    public void setAutomovil(Automovil automovil) {
        this.automovil = automovil;
    }
        
}
