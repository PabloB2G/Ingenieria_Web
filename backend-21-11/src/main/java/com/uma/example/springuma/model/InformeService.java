package com.uma.example.springuma.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InformeService {

    @Autowired
    private RepositoryInforme repositoryInforme;

    public List<Informe> getAllInformes() {
        return repositoryInforme.findAll();
    }

    public Informe getInforme(Long id) {
        return repositoryInforme.findById(id).orElse(null);
    }

    public Informe addInforme(Informe informe) {
        return repositoryInforme.saveAndFlush(informe);
    }

    public void updateInforme(Informe informe) {
        // Puedes implementar la lógica de actualización según tus necesidades
        // Aquí se muestra un ejemplo básico:
        Informe existingInforme = repositoryInforme.findById(informe.getId()).orElse(null);
        if (existingInforme != null) {
            existingInforme.setPrediccion(informe.getPrediccion());
            existingInforme.setContenido(informe.getContenido());
            repositoryInforme.save(existingInforme);
        }
    }

    public void removeInforme(Informe informe) {
        repositoryInforme.delete(informe);
    }

    public void removeInformeByID(Long id) {
        repositoryInforme.deleteById(id);
    }

    public List<Informe> getInformesImagen(Long id) {
        return repositoryInforme.findByImagenId(id);
    }
}
