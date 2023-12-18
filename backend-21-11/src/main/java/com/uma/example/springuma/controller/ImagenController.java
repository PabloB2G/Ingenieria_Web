package com.uma.example.springuma.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
	public ResponseEntity<?> downloadImage(@PathVariable long id){
		byte[] imageData=imagenService.downloadImage(id);
		return ResponseEntity.ok()
        .contentType(MediaType.valueOf(
            "image/png"
        ))
        .body(imageData);
	}

    @GetMapping("/imagen/info/{id}")
    public Imagen getImagen(@PathVariable("id") Long id){
        return imagenService.getImagen(id);
    }
 

	@PostMapping("/imagen")
	public ResponseEntity<?> uploadImage(@RequestParam("image")MultipartFile file,
            @RequestParam("paciente") Paciente paciente) throws IOException {
		String uploadImage = imagenService.uploadImage(file, paciente);
		return ResponseEntity.ok(uploadImage);
	}
    @GetMapping("/imagen/paciente/{id}")
    public List<Imagen> getImagenes (@PathVariable("id") Long id) {
        return imagenService.getImagenesPaciente(id);
    }
}
