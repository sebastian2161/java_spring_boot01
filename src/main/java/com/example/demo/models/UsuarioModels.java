package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;


@Entity
@Table(name = "usuario")
public class UsuarioModels {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    public Long id;
    
    public String nombre;
    public String email;
    public Integer prioridad;

    public UsuarioModels(){}

    public void setPrioridad(Integer prioridad){
        this.prioridad = prioridad;
    }

    public Integer getPrioridad(){
        return prioridad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString(){
        return "usuario{"+
        " nombre='" + nombre + '\'' +
        ", prioridad='" + prioridad + '\'' +
        '}';

    }
    
}
