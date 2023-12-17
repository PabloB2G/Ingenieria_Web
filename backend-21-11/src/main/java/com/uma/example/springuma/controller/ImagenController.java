package com.uma.example.springuma.controller;

import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uma.example.springuma.model.Imagen;
import com.uma.example.springuma.model.ImagenService;
import com.uma.example.springuma.model.Paciente;

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

 

    @PostMapping("/imagen")
public ResponseEntity<?> saveImagen(@RequestParam("file") MultipartFile file,
                                    @RequestParam("paciente") String pacienteJson) {
    try {
        // Define the directory where you want to save the file
        String directory_static = "backend-21-11/src/main/resources/static/";
        Path staticDirectory = Paths.get(directory_static);
        if (!Files.exists(staticDirectory)) {
            Files.createDirectories(staticDirectory); // Create directory if it doesn't exist
        }
        String directory_images = "backend-21-11/src/main/resources/static/images/";
        Path storageDirectory = Paths.get(directory_images);
        if (!Files.exists(storageDirectory)) {
            Files.createDirectories(storageDirectory); // Create directory if it doesn't exist
        }

        // Create a path where the file will be stored
        Path destinationPath = storageDirectory.resolve(file.getOriginalFilename());

        // Copy the file to the destination path
        Files.copy(file.getInputStream(), destinationPath, StandardCopyOption.REPLACE_EXISTING);

        // Save the file path or URL in the Imagen entity
        Imagen imagen = new Imagen();
        imagen.setPath(file.getOriginalFilename());
        Paciente paciente = new ObjectMapper().readValue(pacienteJson, Paciente.class);
        imagen.setPaciente(paciente);
        Imagen saved = imagenService.addImagen(imagen);

        return ResponseEntity.ok(saved); // Return the saved imagen object
    } catch (Exception e) {
        e.printStackTrace();
        return ResponseEntity.internalServerError().body("Error saving image: " + e.getMessage());
    }
}
    @GetMapping("/imagen/paciente/{id}")
    public List<Imagen> getImagenes (@PathVariable("id") Long id) {
        return imagenService.getImagenesPaciente(id);
    }
}
