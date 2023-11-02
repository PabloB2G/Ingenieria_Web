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

import com.uma.example.springuma.model.Raza;
import com.uma.example.springuma.model.RazaService;

@RestController
public class RazaController {
    
    @Autowired
    private RazaService razaService;

    @GetMapping("/razas")
    public List<Raza> getRazas(){
        return razaService.getAllRazas();
    }

    @PostMapping(value = "/razas",     consumes = {MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<?> saveRaza(@RequestBody Raza raza) {
        try{
            razaService.addRaza(raza);
            return ResponseEntity.ok().body("Una nueva Raza se ha anyadido");
        }
        catch(Exception e){
            return ResponseEntity.internalServerError().body("La Raza ya existe");
        }
	}

    @GetMapping("/raza/{id}")
    public Raza getRaza(@PathVariable("id") Long id) {
        return razaService.getRaza(id);
    }

    @PutMapping(value =  "/raza/{id}",     consumes = {MediaType.APPLICATION_JSON_VALUE} )
    public ResponseEntity<?> updateRaza (@PathVariable("id") Long id, @RequestBody Raza raza) {
        try{
            razaService.updateRaza(id, raza);
            return ResponseEntity.ok().body("La Raza se ha actualizado");
        }
        catch(Exception e){
            return ResponseEntity.internalServerError().body("Error al actualizar la Raza");
        }
    }
    
    @DeleteMapping(value = "/raza/{id}")
    public ResponseEntity<?> deleteRaza(@PathVariable("id") Long id){
        try{
            razaService.removeRazaID(id);;
            return ResponseEntity.ok().body("La Raza se ha eliminado");
        }
        catch(Exception e){
            return ResponseEntity.internalServerError().body("Error al eliminar la Raza");
        }
    }
}
