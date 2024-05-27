package org.example.proyecturitsexplor.Controlador;

import org.example.proyecturitsexplor.Entidades.Noticia;
import org.example.proyecturitsexplor.Repositorios.NoticiasRepositorio;
import org.example.proyecturitsexplor.Servicios.NoticiasServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080")

public class NoticiasControlador {
    @Autowired
    private NoticiasRepositorio noticiasRepositorio;
    @Autowired
    private NoticiasServicio noticiasServicio;

    //CRUD
    @PostMapping("/noticias/guardarNoticias")
    public ResponseEntity<Noticia> guardarNoticias(@RequestBody Noticia noticias) {
        if (noticias.getTitulo()==null || noticias.getContenido()==null || noticias.getFechaPublicacion()==null || noticias.getFuente()==null || noticias.getFechaCreacion()==null || noticias.getFechaActualizacion()==null || noticias.getDestino()==null){
            return  ResponseEntity.badRequest().build();
        }
        Noticia noticiasGuardado = noticiasServicio.guardarNoticias(noticias);
        return ResponseEntity.status(HttpStatus.CREATED).body(noticiasGuardado);
    }

    //Recuperar todos los Noticias
    @GetMapping("/noticias/obtenerTodosLosNoticias")
    public ResponseEntity<List<Noticia>>obtenerTodosLosNoticias(){
        List<Noticia> noticias = noticiasServicio.obtenerTodosLosNoticias();
        return ResponseEntity.ok(noticias);
    }
    //recuperar Noticias por id
    @GetMapping("/noticias/recuperarPorId/{id}")
    public ResponseEntity<Noticia>obtenerNoticiasPorId(@PathVariable Long id){
        Noticia noticias = noticiasServicio.obtenerNoticiasPorId(id);
        return ResponseEntity.ok(noticias);
    }

    //Actulizar Noticias
    @PutMapping("noticias/{id}")
    public ResponseEntity<?> actualizarNoticias(@PathVariable("id") Long id, @RequestBody Noticia noticiasActualizada) {
        try {
            // Verificar si el ID proporcionado en la ruta coincide con el ID del Noticias actualizada
            if (!id.equals(noticiasActualizada.getId())) {
                throw new IllegalArgumentException("El ID de la Noticias del cuerpo no coincide con el ID proporcionado en la ruta.");
            }
            Noticia noticiasActual = noticiasServicio.obtenerNoticiasPorId(id);
            if (noticiasActual == null) {
                return new ResponseEntity<>("No se encontró ningun Noticias con el ID proporcionado.", HttpStatus.NOT_FOUND);
            }
            Noticia noticiasActualizadaGuardada = noticiasServicio.actulizarNoticias(noticiasActualizada);
            return new ResponseEntity<>(noticiasActualizadaGuardada, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    //Eliminar Noticias
    @DeleteMapping("/noticias/{id}")
    public ResponseEntity<String> eliminarNoticiasPorId(@PathVariable Long id) {
        noticiasServicio.eliminarNoticias(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Noticias con ID " + id + " eliminada correctamente.");
    }

    //Verificar si un Noticias existe en la base de datos
    @GetMapping("/noticias/existe/{titulo}")
    public ResponseEntity<?> verificarNoticiasExistente(@PathVariable String titulo) {
        try {
            boolean existe = noticiasServicio.verificarNoticiasExistente(titulo);
            return ResponseEntity.ok(existe);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al verificar si el Noticias existe por Nombre: " + e.getMessage());
        }
    }
}
