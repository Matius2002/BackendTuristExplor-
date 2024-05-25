package org.example.proyecturitsexplor.Entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "tipoTurismo")
public class TipoTurismo {
    // Variables
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "popularidad", nullable = false)
    private String popularidad;

    // Constructores (Vacio y Cargado)
    public TipoTurismo() {
    }

    public TipoTurismo(String nombre, String descripcion, String popularidad) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.popularidad = popularidad;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPopularidad() {
        return popularidad;
    }

    public void setPopularidad(String popularidad) {
        this.popularidad = popularidad;
    }

    // Método toString()
    @Override
    public String toString() {
        return "TipoTurismo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", popularidad=" + popularidad +
                '}';
    }
}
