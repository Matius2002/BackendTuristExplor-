package org.example.proyecturitsexplor.Repositorios;

import org.example.proyecturitsexplor.Entidades.Images;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImagesRepositorio extends JpaRepository<Images, Long> {
    boolean existsByNombre(String nombre);
}
