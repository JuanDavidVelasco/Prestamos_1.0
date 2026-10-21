package com.ejemplo.prestamos.controller;

import com.ejemplo.prestamos.model.Herramienta;
import com.ejemplo.prestamos.service.HerramientaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/herramientas")
@CrossOrigin(origins = "*")
public class HerramientaController {

    private final HerramientaService herramientaService;

    public HerramientaController(HerramientaService herramientaService) {
        this.herramientaService = herramientaService;
    }


    @PostMapping
    public ResponseEntity<Herramienta> registrarHerramienta(@Valid @RequestBody Herramienta herramienta) {
        Herramienta creada = herramientaService.registrarHerramienta(herramienta);
        return ResponseEntity.status(HttpStatus.CREATED).body(creada);
    }

    @GetMapping
    public ResponseEntity<List<Herramienta>> consultarHerramientas() {
        return ResponseEntity.ok(herramientaService.consultarHerramientas());
    }
}