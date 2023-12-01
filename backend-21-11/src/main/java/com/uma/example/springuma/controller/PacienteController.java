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

import com.uma.example.springuma.model.Paciente;
import com.uma.example.springuma.model.PacienteService;

@RestController
public class PacienteController {
    
    @Autowired
    private PacienteService pacienteService;

    @GetMapping("/paciente")
    public List<Paciente> getPacientes(){
        return pacienteService.getAllPacientes();
    }
    
    @GetMapping("/paciente/{id}")
    public Paciente getPaciente(@PathVariable("id") Long id) {
        return pacienteService.getPaciente(id);
    }

    // Get all paciente of medico 1
    @GetMapping("/paciente/medico/{id}")
    public List<Paciente> getPacientes(@PathVariable("id") Long id) {
        return pacienteService.getPacientesMedico(id);
    }

    @PostMapping(value = "/paciente",     consumes = {MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<?> savePaciente(@RequestBody Paciente paciente) {
        try{
            pacienteService.addPaciente(paciente);
            return ResponseEntity.noContent().build();
        }
        catch(Exception e){
            return ResponseEntity.internalServerError().body("El paciente ya existe");
        }
	}

    @PutMapping(value = "/paciente",     consumes = {MediaType.APPLICATION_JSON_VALUE} )
    public ResponseEntity<?> updateCuenta (@RequestBody Paciente paciente) {
        try{
            pacienteService.updatePaciente(paciente);
            return ResponseEntity.noContent().build();
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Error al actualizar el paciente ");
        }
    }

    @DeleteMapping("/paciente/{id}")
    public ResponseEntity<?> deleteCuenta(@PathVariable("id") Long id) {
        try{
            pacienteService.removePacienteID(id);
            return ResponseEntity.noContent().build();
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Error al eliminar el paciente");
        }
    }
}
