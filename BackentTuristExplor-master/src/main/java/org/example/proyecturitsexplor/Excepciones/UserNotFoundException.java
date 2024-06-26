package org.example.proyecturitsexplor.Excepciones;

public class UserNotFoundException extends RuntimeException{
    private Long id;

    public UserNotFoundException(Long id) {
        super("User no encontrado: " + id);
        this.id = id;
    }
    public Long getId() {
        return id;
    }
}
