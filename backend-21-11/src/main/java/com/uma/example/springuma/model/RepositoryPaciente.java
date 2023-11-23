package com.uma.example.springuma.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryPaciente extends JpaRepository<Paciente, Long> {



    Paciente findByDni(String dni);

}
