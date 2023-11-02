package com.uma.example.springuma.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RazaService {

    @Autowired
    RepositoryRaza repositoryRaza;

    public List<Raza> getAllRazas(){
        return repositoryRaza.findAll();
    }

    public Raza getRaza(Long id){
        return repositoryRaza.getReferenceById(id);
    }

    public Raza addRaza(Raza c){
        return repositoryRaza.saveAndFlush(c);
    }

    public void updateRaza(long id, Raza r){
        Raza raza = repositoryRaza.getReferenceById(id);
		raza.setAmabilidad(r.getAmabilidad());
		raza.setPelosidad(r.getPelosidad());
        raza.setNombre(r.getNombre());
        raza.setTamanyo(r.getTamanyo());
        repositoryRaza.save(raza);
    }

    public void removeRaza(Raza c){
        repositoryRaza.delete(c);
    }

    public void removeRazaID(Long id){
        repositoryRaza.deleteById(id);
    }
}
