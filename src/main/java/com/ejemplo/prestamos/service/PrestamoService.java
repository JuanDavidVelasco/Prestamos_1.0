package com.ejemplo.prestamos.service;

import com.ejemplo.prestamos.dto.PrestamoRequest;
import com.ejemplo.prestamos.model.Prestamo;
import java.util.List;

public interface PrestamoService {

    Prestamo registrarPrestamo(PrestamoRequest request);

    List<Prestamo> consultarPrestamos();

    List<Prestamo> consultarPrestamosPorHerramienta(Long herramientaId);

}