package com.uma.example.springuma.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Informe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "prediccion")
    private String prediccion;

    @Column(name = "contenido", columnDefinition = "TEXT")
    private String contenido;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPrediccion() {
        return prediccion;
    }

    public void setPrediccion(String prediccion) {
        this.prediccion = prediccion;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Informe() {
        // Constructor vacío necesario para JPA
    }

    public Informe(String prediccion, String contenido) {
        this.prediccion = prediccion;
        this.contenido = contenido;
    }

    public boolean equals(Object obj)
    {
	    return (obj instanceof Informe) && ((Informe) obj).getContenido()==this.contenido;
    }

    public int hashCode()
    {
	    return this.contenido.hashCode();
    }
    
    public String toString()
    {
	    return "Predicción = " + this.prediccion + "; " + "Contenido = " + this.contenido;    
    }
}
