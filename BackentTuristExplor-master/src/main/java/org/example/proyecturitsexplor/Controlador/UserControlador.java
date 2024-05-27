package org.example.proyecturitsexplor.Controlador;

import org.example.proyecturitsexplor.Entidades.User;
import org.example.proyecturitsexplor.Repositorios.UserRepositorio;
import org.example.proyecturitsexplor.Servicios.UserServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080")

public class UserControlador {
    @Autowired
    private UserRepositorio userRepositorio;
    @Autowired
    private UserServicio userServicio;

    //CRUD
    @PostMapping("/users/guardarUser")
    public ResponseEntity<User> guardarUser(@RequestBody User user) {
        if (user.getUserName()==null || user.getEmail()==null || user.getPassword()==null || user.getFechaRegistro()==null){
            return  ResponseEntity.badRequest().build();
        }
        User userGuardado = userServicio.guardarUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userGuardado);
    }

    //Recuperar todos los users
    @GetMapping("/users/obtenerTodosLosUser")
    public ResponseEntity<List<User>>obtenerTodosLosUser(){
        List<User> user = userServicio.obtenerTodosLosUser();
        return ResponseEntity.ok(user);
    }
    //recuperar users por id
    @GetMapping("/users/recuperarPorId/{id}")
    public ResponseEntity<User>obtenerUserPorId(@PathVariable Long id){
        User user = userServicio.obtenerUserPorId(id);
        return ResponseEntity.ok(user);
    }

    //Actulizar user
    @PutMapping("users/{id}")
    public ResponseEntity<?> actualizarUser(@PathVariable("id") Long id, @RequestBody User userActualizada) {
        try {
            // Verificar si el ID proporcionado en la ruta coincide con el ID del user actualizada
            if (!id.equals(userActualizada.getId())) {
                throw new IllegalArgumentException("El ID de la user del cuerpo no coincide con el ID proporcionado en la ruta.");
            }
            User userActual = userServicio.obtenerUserPorId(id);
            if (userActual == null) {
                return new ResponseEntity<>("No se encontró ningun user con el ID proporcionado.", HttpStatus.NOT_FOUND);
            }
            User userActualizadaGuardada = userServicio.actulizarUser(userActualizada);
            return new ResponseEntity<>(userActualizadaGuardada, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    //Eliminar user
    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> eliminarUserPorId(@PathVariable Long id) {
        userServicio.eliminarUser(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("User con ID " + id + " eliminada correctamente.");
    }

    //Verificar si un user existe en la base de datos
    @GetMapping("/users/existe/{userName}")
    public ResponseEntity<?> verificarUserExistente(@PathVariable String userName) {
        try {
            boolean existe = userServicio.verificarUserExistente(userName);
            return ResponseEntity.ok(existe);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al verificar si el user existe por Nombre: " + e.getMessage());
        }
    }
}
