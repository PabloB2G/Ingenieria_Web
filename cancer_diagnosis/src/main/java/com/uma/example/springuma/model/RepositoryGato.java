package com.uma.example.springuma.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryGato extends JpaRepository<Gato, Long>{

    public List<Gato> findByRazaId(long id_raza);
}
