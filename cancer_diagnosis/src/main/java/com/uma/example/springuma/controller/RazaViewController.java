package com.uma.example.springuma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.uma.example.springuma.model.GatoService;
import com.uma.example.springuma.model.RazaService;

@Controller
public class RazaViewController {

    @Autowired
    private GatoService gatoService;

    @Autowired
    private RazaService razaService;

    @GetMapping("viewRaza/{id}")
    public String viewRaza(@PathVariable("id") long id, Model model){
        model.addAttribute("raza", razaService.getRaza(id));
        model.addAttribute("gatos", gatoService.getAllGatosbyRazaId(id));
        return "viewRaza";
    }
    
}
