package com.uma.example.springuma.model;

import com.uma.example.springuma.model.Imagen;
import com.uma.example.springuma.model.RepositoryImagen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImagenService {

    @Autowired
    private RepositoryImagen repositoryImagen;

    public List<Imagen> getAllImagenes() {
        return repositoryImagen.findAll();
    }

    public Imagen getImagen(Long id) {
        return repositoryImagen.getReferenceById(id);
    }

    public Imagen addImagen(Imagen imagen) {
        return repositoryImagen.saveAndFlush(imagen);
    }

    public void updateImagen(Imagen imagen) {
        repositoryImagen.save(imagen);
    }

    public void removeImagen(Imagen imagen) {
        repositoryImagen.delete(imagen);
    }

    public void removeImagenByID(Long id) {
        repositoryImagen.deleteById(id);
    }
}
