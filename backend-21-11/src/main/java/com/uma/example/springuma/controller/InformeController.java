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

import com.uma.example.springuma.model.Informe;
import com.uma.example.springuma.model.InformeService;

@RestController
public class InformeController {
    
    @Autowired
    private InformeService informeService;

    @GetMapping("/informe")
    public List<Informe> getInformes(){
        return informeService.getAllInformes();
    }
    
    @GetMapping("/informe/{id}")
    public Informe getInforme(@PathVariable("id") Long id) {
        return informeService.getInforme(id);
    }

    @GetMapping("informe/imagen/{id}")
    public List<Informe> getInformes(@PathVariable("id") Long id) {
        return informeService.getInformesImagen(id);
    }

    @PostMapping(value = "/informe",     consumes = {MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<?> saveInforme(@RequestBody Informe informe) {
        try{
            System.out.println(informe);
            informeService.addInforme(informe);
            return ResponseEntity.noContent().build();
        }
        catch(Exception e){
            return ResponseEntity.internalServerError().body("El informe ya existe");
        }
	}

    @PutMapping(value = "/informe",     consumes = {MediaType.APPLICATION_JSON_VALUE} )
    public ResponseEntity<?> updateCuenta (@RequestBody Informe informe) {
        try{
            informeService.updateInforme(informe);
            return ResponseEntity.noContent().build();
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Error al actualizar el informe ");
        }
    }

    @DeleteMapping("/informe/{id}")
    public ResponseEntity<?> deleteInforme(@PathVariable("id") Long id) {
        try{
            informeService.removeInformeByID(id);
            return ResponseEntity.noContent().build();
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Error al eliminar el informe");
        }
    }
}
