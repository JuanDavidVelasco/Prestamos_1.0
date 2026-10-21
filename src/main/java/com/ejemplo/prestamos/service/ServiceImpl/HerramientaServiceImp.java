package com.ejemplo.prestamos.service.ServiceImpl;

import com.ejemplo.prestamos.model.Herramienta;
import com.ejemplo.prestamos.repository.HerramientaRepository;
import com.ejemplo.prestamos.service.HerramientaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HerramientaServiceImp implements HerramientaService {

    private final HerramientaRepository herramientaRepository;

    public HerramientaServiceImp(HerramientaRepository herramientaRepository) {
        this.herramientaRepository = herramientaRepository;
    }

    @Override
    @Transactional
    public Herramienta registrarHerramienta(Herramienta herramienta) {
        if (herramienta.getCantidad() == null || herramienta.getCantidad() < 0) {
            throw new IllegalArgumentException("No se permiten cantidades negativas al registrar una herramienta.");
        }
        return herramientaRepository.save(herramienta);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Herramienta> consultarHerramientas() {
        return herramientaRepository.findAll();
    }
}