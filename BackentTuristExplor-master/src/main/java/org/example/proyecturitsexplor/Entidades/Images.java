package org.example.proyecturitsexplor.Entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "images")

public class Images {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Lob
    @Column(name = "imageData", nullable = false)
    private byte[] imageData;

    // Constructores (Vacio y Cargado)
    public Images() {
    }

    public Images(String nombre, byte[] imageData) {
        this.nombre = nombre;
        this.imageData = imageData;
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

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    // Método toString()
    @Override
    public String toString() {
        return "Images{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
