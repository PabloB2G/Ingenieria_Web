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

import com.uma.example.springuma.model.Cuenta;
import com.uma.example.springuma.model.CuentaService;

@RestController
public class CuentaController {
    
    @Autowired
    private CuentaService cuentaService;

    @GetMapping("/cuenta")
    public List<Cuenta> getCuentas(){
        return cuentaService.getAllCuentas();
    }
    
    @GetMapping("/cuenta/{id}")
    public Cuenta getCuenta(@PathVariable("id") Long id) {
        return cuentaService.getCuenta(id);
    }

    @PostMapping(value = "/cuenta",     consumes = {MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<?> saveCuenta(@RequestBody Cuenta cuenta) {
        try{
            cuentaService.addCuenta(cuenta);
            return ResponseEntity.noContent().build();
        }
        catch(Exception e){
            return ResponseEntity.internalServerError().body("La cuenta ya existe");
        }
	}

    @PutMapping(value = "/cuenta",     consumes = {MediaType.APPLICATION_JSON_VALUE} )
    public ResponseEntity<?> updateCuenta (@RequestBody Cuenta cuenta) {
        try{
            cuentaService.updateCuenta(cuenta);
            return ResponseEntity.noContent().build();
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Error al actualizar la cuenta");
        }
    }

    @DeleteMapping("/cuenta/{id}")
    public ResponseEntity<?> deleteCuenta(@PathVariable("id") Long id) {
        try{
            cuentaService.removeCuentaID(id);
            return ResponseEntity.noContent().build();
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Error al eliminar la cuenta");
        }
    }
}
