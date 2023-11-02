package com.uma.example.springuma.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // para ignorar el serializador al devolver un objeto cuenta
public class Gato
{
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

    private long edad;

    public long getEdad() {
        return edad;
    }

    public void setEdad(long edad) {
        this.edad = edad;
    }

    @ManyToOne
    private Raza raza;
    public Raza getRaza() {
        return raza;
    }

    public void setRaza(Raza raza) {
        this.raza = raza;
    }
  
}
