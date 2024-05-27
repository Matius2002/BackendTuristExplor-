package org.example.proyecturitsexplor.Servicios;

import org.example.proyecturitsexplor.Entidades.Experiencia;
import org.example.proyecturitsexplor.Excepciones.ExperienciaNotFoundException;
import org.example.proyecturitsexplor.Repositorios.ExperienciaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienciaServicio {
    @Autowired
    private ExperienciaRepositorio experienciaRepositorio;

    public ExperienciaServicio(ExperienciaRepositorio experienciaRepositorio) {
        this.experienciaRepositorio = experienciaRepositorio;
    }
    //CRUD

    //Obtener todos los experiencia turisticos
    public List<Experiencia> obtenerTodosLosExperiencia () {
        return experienciaRepositorio.findAll();
    }
    //guardar experiencia turistico
    public Experiencia guardarExperiencia(Experiencia experiencia) {
        return experienciaRepositorio.save(experiencia);
    }
    //Obtener experiencia por id
    public Experiencia obtenerExperienciaPorId(Long id) {
        return experienciaRepositorio.findById(id).orElseThrow(()-> new ExperienciaNotFoundException(id));
    }
    //actulizar experiencia turistico
    public Experiencia actulizarExperiencia(Experiencia experiencia) {
        return experienciaRepositorio.save(experiencia);
    }
    //Eliminar experiencia
    public void eliminarExperiencia(Long id) {
        experienciaRepositorio.deleteById(id);
    }
    //Verificar si existe en la base. por nombre
    public boolean verificarExperienciaExistente(String nombre) {
        return experienciaRepositorio.existsByNombre(nombre);
    }
}
