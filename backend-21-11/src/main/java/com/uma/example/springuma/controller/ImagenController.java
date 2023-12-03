package com.uma.example.springuma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.uma.example.springuma.model.Imagen;
import com.uma.example.springuma.model.ImagenService;

@RestController
public class ImagenController {
    @Autowired
    private ImagenService imagenService;

    @GetMapping("/imagen")
    public List<Imagen> getAllImagenes(){
        return imagenService.getAllImagenes();
    }

    @GetMapping("/imagen/{id}")
    public Imagen getImagen(@PathVariable("id") Long id){
        return imagenService.getImagen(id);
    }

    @PostMapping(value = "/imagen",     consumes = {MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<?> saveImagen(@RequestBody Imagen imagen) {
        try{
            imagenService.addImagen(imagen);
            return ResponseEntity.noContent().build();
        }
        catch(Exception e){
            return ResponseEntity.internalServerError().body("La imagen ya existe");
        }
	}

    @PutMapping(value = "/imagen",     consumes = {MediaType.APPLICATION_JSON_VALUE} )
    public ResponseEntity<?> updateImagen (@RequestBody Imagen imagen) {
        try{
            imagenService.updateImagen(imagen);
            return ResponseEntity.noContent().build();
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Error al actualizar la imagen");
        }
    }

    @DeleteMapping("/imagen/{id}")
    public ResponseEntity<?> deleteImagen (@PathVariable("id") Long id) {
        try{
            imagenService.removeImagenByID(id);
            return ResponseEntity.noContent().build();
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Error al eliminar la imagen");
        }
    }

    @GetMapping("/imagen/paciente/{id}")
    public List<Imagen> getImagenes (@PathVariable("id") Long id) {
        return imagenService.getImagenesPaciente(id);
    }
}
