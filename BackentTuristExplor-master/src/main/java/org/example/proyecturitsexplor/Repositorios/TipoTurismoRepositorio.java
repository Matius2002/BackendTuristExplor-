package org.example.proyecturitsexplor.Repositorios;

import org.example.proyecturitsexplor.Entidades.TipoTurismo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface TipoTurismoRepositorio extends JpaRepository<TipoTurismo, Long> {
    boolean existsByNombre(String nombre);
}
