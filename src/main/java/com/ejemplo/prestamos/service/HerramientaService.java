package com.ejemplo.prestamos.service;

import com.ejemplo.prestamos.model.Herramienta;
import java.util.List;

public interface HerramientaService {

    Herramienta registrarHerramienta(Herramienta herramienta);

    List<Herramienta> consultarHerramientas();

}