package com.maximinetto.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;

//    @Column(unique = true, nullable = false)
    private Integer dni;

//    @Column(name = "nombre", nullable = false)
    private String nombre; 

//    @Column(name = "dir", nullable = false)
    private String dir;

//    @Column(name = "tel", nullable = false)
    private String tel;

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
    
    public Integer getDni() {
            return dni;
    }

    public void setDni(Integer dni) {
            this.dni = dni;
    }

    public String getNombre() {
            return nombre;
    }

    public void setNombre(String nombre) {
            this.nombre = nombre;
    }

    public String getDir() {
            return dir;
    }

    public void setDir(String dir) {
            this.dir = dir;
    }

    public String getTel() {
            return tel;
    }

    public void setTel(String tel) {
            this.tel = tel;
    }

    public List<Reserva> getReservas() {
            return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
            this.reservas = reservas;
    }
	
}
