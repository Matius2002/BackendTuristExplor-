package org.example.proyecturitsexplor.Servicios;

import org.example.proyecturitsexplor.Entidades.Images;
import org.example.proyecturitsexplor.Excepciones.ImagesNotFoundException;
import org.example.proyecturitsexplor.Repositorios.ImagesRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImagesServicio {
    @Autowired
    private ImagesRepositorio ImagesRepositorio;

    public ImagesServicio(ImagesRepositorio ImagesRepositorio) {
        this.ImagesRepositorio = ImagesRepositorio;
    }
    //CRUD

    //Obtener todos los Images turisticos
    public List<Images> obtenerTodosLosImages () {
        return ImagesRepositorio.findAll();
    }
    //guardar Image turistico
    public Images guardarImages(Images Images) {
        return ImagesRepositorio.save(Images);
    }
    //Obtener Images por id
    public Images obtenerImagesPorId(Long id) {
        return ImagesRepositorio.findById(id).orElseThrow(()-> new ImagesNotFoundException(id));
    }
    //actulizar Image turistico
    public Images actulizarImages(Images Images) {
        return ImagesRepositorio.save(Images);
    }
    //Eliminar Image
    public void eliminarImage(Long id) {
        ImagesRepositorio.deleteById(id);
    }
    //Verificar si existe en la base. por nombre
    public boolean verificarImageExistente(String Nombre) {
        return ImagesRepositorio.existsByNombre(Nombre);
    }
}
