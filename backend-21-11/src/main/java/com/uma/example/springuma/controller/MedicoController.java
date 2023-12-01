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

import com.uma.example.springuma.model.Medico;
import com.uma.example.springuma.model.MedicoService;

@RestController
public class MedicoController {
    
    @Autowired
    private MedicoService medicoService;

    @GetMapping("/medico")
    public List<Medico> getAllMedicos(){
        return medicoService.getAllMedicos();
    }

    @GetMapping("/medico/{id}")
    public Medico getMedico(@PathVariable("id") Long id){
        return medicoService.getMedico(id);
    }

    @PostMapping(value = "/medico",     consumes = {MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<?> saveMedico(@RequestBody Medico medico) {
        try{
            medicoService.addMedico(medico);
            return ResponseEntity.noContent().build();
        }
        catch(Exception e){
            return ResponseEntity.internalServerError().body("El medico ya existe");
        }
	}

    @PutMapping(value = "/medico",     consumes = {MediaType.APPLICATION_JSON_VALUE} )
    public ResponseEntity<?> updateMedico (@RequestBody Medico medico) {
        try{
            medicoService.updateMedico(medico);
            return ResponseEntity.noContent().build();
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Error al actualizar el medico");
        }
    }

    @DeleteMapping("/medico/{id}")
    public ResponseEntity<?> deleteMedico(@PathVariable("id") Long id) {
        try{
            medicoService.removeMedicoID(id);
            return ResponseEntity.noContent().build();
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Error al eliminar la cuenta");
        }
    }

}
