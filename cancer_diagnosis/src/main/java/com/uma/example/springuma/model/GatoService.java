package com.uma.example.springuma.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GatoService {

    @Autowired
    RepositoryGato repositoryGato;

    public List<Gato> getAllGatos(){
        return repositoryGato.findAll();
    }

    public Gato getGato(Long id){
        return repositoryGato.getReferenceById(id);
    }

    public Gato addGato(Gato c){
        return repositoryGato.saveAndFlush(c);
    }

    public void updateGato(Long id, Gato g){
        Gato gato = repositoryGato.getReferenceById(id);
		gato.setEdad(g.getEdad());
        gato.setNombre(g.getNombre());
        repositoryGato.save(gato);
    }


    public void removeGatoID(Long id){
        repositoryGato.deleteById(id);
    }

    public List<Gato> getAllGatosbyRazaId(long raza_id){
        return repositoryGato.findByRazaId(raza_id);
    }
}
