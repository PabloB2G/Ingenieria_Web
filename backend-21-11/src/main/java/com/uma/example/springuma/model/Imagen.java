package com.uma.example.springuma.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // para ignorar el serializador al devolver un objeto cuenta
public class Imagen {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "path")
    private String path;

    // Relación con Paciente (muchas imágenes pueden pertenecer a un paciente)
    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    // @Column(name = "file_conent")
    // private byte[] file_conent;

    // public byte[] getFile_content(){
    //     return file_conent;
    // }

    // public void setFile_content(byte[] file_conent){
    //     this.file_conent
    // }

    // Constructor vacío
    public Imagen() {
    }

    // Getters y Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Imagen)) return false;
        return id != 0 && id == (((Imagen) o).getId());
    }
    @Override
    public int hashCode() {
        return this.path.hashCode();
    }
    @Override
    public String toString() {
        return "Imagen{" +
                "id=" + id +
                ", path='" + path + '\'' +
                ", paciente=" + paciente +
                '}';
    }
    public Imagen(String path, Paciente paciente)
    {
        this.path = path;
        this.paciente = paciente;
    }

}
