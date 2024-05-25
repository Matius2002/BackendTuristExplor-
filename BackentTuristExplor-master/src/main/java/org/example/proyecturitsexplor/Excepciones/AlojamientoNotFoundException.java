package org.example.proyecturitsexplor.Excepciones;

import org.example.proyecturitsexplor.Entidades.Alojamiento;

public class AlojamientoNotFoundException extends RuntimeException{
    private Long id;

    public AlojamientoNotFoundException(Long id) {
        super("Alojamiento no encontrado: " + id);
        this.id = id;

    }
    public Long getId() {
        return id;
    }
}
