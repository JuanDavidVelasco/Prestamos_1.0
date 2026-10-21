package com.ejemplo.prestamos.controller;

import com.ejemplo.prestamos.dto.PrestamoRequest;
import com.ejemplo.prestamos.exception.ResourceNotFoundException;
import com.ejemplo.prestamos.model.Prestamo;
import com.ejemplo.prestamos.service.PrestamoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/prestamos")
@CrossOrigin(origins = "*")
public class PrestamoController {

    private final PrestamoService prestamoService;

    public PrestamoController(PrestamoService prestamoService) {
        this.prestamoService = prestamoService;
    }

    // POST /api/prestamos -> Registrar préstamo
    @PostMapping
    public ResponseEntity<?> registrarPrestamo(@Valid @RequestBody PrestamoRequest request) {
        try {
            Prestamo creado = prestamoService.registrarPrestamo(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(creado);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("mensaje", e.getMessage()));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("mensaje", e.getMessage()));
        }
    }


    @GetMapping
    public ResponseEntity<List<Prestamo>> consultarPrestamos() {
        return ResponseEntity.ok(prestamoService.consultarPrestamos());
    }

    @GetMapping("/herramienta/{id}")
    public ResponseEntity<?> consultarPrestamosPorHerramienta(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(prestamoService.consultarPrestamosPorHerramienta(id));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("mensaje", e.getMessage()));
        }
    }
}