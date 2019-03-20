package com.maximinetto.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "reserva")
public class Reserva implements Serializable{
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @Column(name = "inicio", nullable = false)
    private LocalDate inicio;

//    @Column(name = "fin", nullable = false)
    private LocalDate fin;

//    @Column(name = "precio", nullable = false)
    private double precio;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    private Agencia agencia;

    @OneToMany(mappedBy = "reserva", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleReserva> detalleReserva;

    public Reserva() {
    }
    
    public Integer getId() {
            return id;
    }

    public void setId(Integer id) {
            this.id = id;
    }

    public LocalDate getInicio() {
            return inicio;
    }

    public void setInicio(LocalDate inicio) {
            this.inicio = inicio;
    }

    public LocalDate getFin() {
            return fin;
    }

    public void setFin(LocalDate fin) {
            this.fin = fin;
    }

    public double getPrecio() {
            return precio;
    }

    public void setPrecio(double precio) {
            this.precio = precio;
    }

    public Cliente getCliente() {
            return cliente;
    }

    public void setCliente(Cliente cliente) {
            this.cliente = cliente;
    }

    public Agencia getAgencia() {
            return agencia;
    }

    public void setAgencia(Agencia agencia) {
            this.agencia = agencia;
    }

    public List<DetalleReserva> getDetalleReserva() {
        return detalleReserva;
    }

    public void setDetalleReserva(List<DetalleReserva> detalleReserva) {
        this.detalleReserva = detalleReserva;
    }
	
	
	
}
