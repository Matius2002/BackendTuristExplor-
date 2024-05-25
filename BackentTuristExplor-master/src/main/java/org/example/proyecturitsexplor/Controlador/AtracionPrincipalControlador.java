package org.example.proyecturitsexplor.Controlador;

import org.example.proyecturitsexplor.Entidades.AtracionPrincipal;
import org.example.proyecturitsexplor.Repositorios.AtracionPrincipalRepositorio;
import org.example.proyecturitsexplor.Repositorios.DestinosRepositorio;
import org.example.proyecturitsexplor.Servicios.AtracionPrincipalServicio;
import org.example.proyecturitsexplor.Servicios.DestinosServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080")
public class AtracionPrincipalControlador {
    @Autowired
    private AtracionPrincipalRepositorio atracionPrincipalRepositorio;
    @Autowired
    private AtracionPrincipalServicio atracionPrincipalServicio;

    //CRUD
    @PostMapping("/atracionPrincipals/guardarAtracionPrincipal")
    public ResponseEntity<AtracionPrincipal> guardarDestino(@RequestBody AtracionPrincipal atracionPrincipal) {
        if (atracionPrincipal.getNombre()==null || atracionPrincipal.getHorario()==null || atracionPrincipal.getDescripcion()==null || atracionPrincipal.getHorarioFuncionamiento()==null){
            return  ResponseEntity.badRequest().build();
        }
        AtracionPrincipal atracionPrincipalGuardado = atracionPrincipalServicio.guardarAtracionPrincipal(atracionPrincipal);
        return ResponseEntity.status(HttpStatus.CREATED).body(atracionPrincipalGuardado);
    }
    //recuperar todos las atraciones principales
    @GetMapping("/atracion/obtenerTodosLasAtracionesPrincipales ")
    public ResponseEntity<List<AtracionPrincipal>>obtenerTodosLosDestinos(){
        List<AtracionPrincipal> atracionPrincipal = atracionPrincipalServicio.obtenerTodosLosDestinos();
        return ResponseEntity.ok(atracionPrincipal);
    }
    //recuperar destinos por id
    @GetMapping("/destinos/recuperarPorId/{id}")
    public ResponseEntity<AtracionPrincipal>obtenerDestinosPorId(@PathVariable Long id){
        AtracionPrincipal destinos = destinosServicio.obtenerDestinosPorId(id);
        return ResponseEntity.ok(destinos);
    }
    //actulizar destino
    @PutMapping("destinos/{id}")
    public ResponseEntity<?> actualizarDestinos(@PathVariable("id") Long id, @RequestBody Destinos destinosActualizada) {
        try {
            // Verificar si el ID proporcionado en la ruta coincide con el ID del destino actualizada
            if (!id.equals(destinosActualizada.getId())) {
                throw new IllegalArgumentException("El ID de la Destino del cuerpo no coincide con el ID proporcionado en la ruta.");
            }
            AtracionPrincipal destinosActual = destinosServicio.obtenerDestinosPorId(id);
            if (destinosActual == null) {
                return new ResponseEntity<>("No se encontró ningun Destino con el ID proporcionado.", HttpStatus.NOT_FOUND);
            }
            Destinos destinosActualizadaGuardada = destinosServicio.actulizarDestinos(destinosActualizada);
            return new ResponseEntity<>(destinosActualizadaGuardada, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    //Eliminar destino
    @DeleteMapping("/destinos/{id}")
    public ResponseEntity<String> eliminarDestinoPorId(@PathVariable Long id) {
        destinosServicio.eliminarDestino(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Destino con ID " + id + " eliminada correctamente.");
    }
    // verificar si un destino existe en la base de datos
    @GetMapping("/atracion/existe/{destinoName}")
    public ResponseEntity<?> verificarDestinosExistente(@PathVariable String destinoName) {
        try {
            boolean existe = destinosServicio.verificarDestinoExistente(destinoName);
            return ResponseEntity.ok(existe);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al verificar si el destino existe por Nombre: " + e.getMessage());
        }
    }
}
