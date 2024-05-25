package org.example.proyecturitsexplor.Entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "tipoAlojamiento")
public class TipoAlojamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "servicios", nullable = false)
    private String servicios;

    @Column(name = "precio_promedio", nullable = false)
    private double precioPromedio;

    // Constructores (Vacio y Cargado)
    public TipoAlojamiento() {
    }

    public TipoAlojamiento(String nombre, String descripcion, String servicios, double precioPromedio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.servicios = servicios;
        this.precioPromedio = precioPromedio;
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

    public String getServicios() {
        return servicios;
    }

    public void setServicios(String servicios) {
        this.servicios = servicios;
    }

    public Double getPrecioPromedio() {
        return precioPromedio;
    }

    public void setPrecioPromedio(double precioPromedio) {
        this.precioPromedio = precioPromedio;
    }

    // Método toString()
    @Override
    public String toString() {
        return "TipoAlojamientoServicio{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", servicios='" + servicios + '\'' +
                ", precioPromedio=" + precioPromedio +
                '}';
    }
}
