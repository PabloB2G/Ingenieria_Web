package com.uma.example.springuma.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // para ignorar el serializador al devolver un objeto
public class Raza {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    private String nombre;
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private String tamanyo;
    public String getTamanyo() {
        return tamanyo;
    }
    public void setTamanyo(String tamanyo) {
        this.tamanyo = tamanyo;
    }
    private int amabilidad;

    public int getAmabilidad() {
        return amabilidad;
    }
    public void setAmabilidad(int amabilidad) {
        this.amabilidad = amabilidad;
    }
    private int pelosidad;
    public int getPelosidad() {
        return pelosidad;
    }
    public void setPelosidad(int pelosidad) {
        this.pelosidad = pelosidad;
    }
}
