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

import com.uma.example.springuma.model.Gato;
import com.uma.example.springuma.model.GatoService;

@RestController
public class GatoController {
    
    @Autowired
    private GatoService gatoService;

    @GetMapping("/gatos")
    public List<Gato> getGatos(){
        return gatoService.getAllGatos();
    }

    @PostMapping(value = "/gatos",     consumes = {MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<?> saveGato(@RequestBody Gato gato) {
        try{
            gatoService.addGato(gato);
            return ResponseEntity.ok().body("Un nuevo gato se ha anyadido");
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("El gato ya existe");
        }
	}

    @GetMapping("/gato/{id}")
    public Gato getGato(@PathVariable("id") Long id) {
        return gatoService.getGato(id);
    }

    @PutMapping(value = "/gato/{id}",     consumes = {MediaType.APPLICATION_JSON_VALUE} )
    public ResponseEntity<?> updateGato (@PathVariable("id") Long id, @RequestBody Gato gato) {
        try{
            gatoService.updateGato(id, gato);
            return ResponseEntity.ok().body("El gato se ha actualizado");
        }
        catch(Exception e){
            return ResponseEntity.internalServerError().body("Error al actualizar el gato");
        }
    }

    @DeleteMapping(value = "/gato/{id}")
    public ResponseEntity<?> deleteGato(@PathVariable("id") Long id){
        try{
            gatoService.removeGatoID(id);
            return ResponseEntity.ok().body("El gato se ha eliminado");
        }
        catch(Exception e){
            return ResponseEntity.internalServerError().body("Error al eliminar el gato");
        }
    }
}
