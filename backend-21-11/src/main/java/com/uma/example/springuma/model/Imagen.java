package com.uma.example.springuma.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
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

    // Relación con Informe (una imagen puede tener muchos informes)
    @OneToMany(mappedBy = "imagen", cascade = CascadeType.ALL)
    private List<Informe> informes;

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

    public List<Informe> getInformes() {
        return informes;
    }

    public void setInformes(List<Informe> informes) {
        this.informes = informes;
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
                ", informes=" + informes +
                '}';
    }
}
