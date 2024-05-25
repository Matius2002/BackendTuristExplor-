package org.example.proyecturitsexplor.Entidades;

import jakarta.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "alojamiento")
public class Alojamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "tipo_id")
    private TipoAlojamiento tipoAlojamiento;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "celular")
    private String celular;

    @Column(name = "email")
    private String email;

    @Column(name = "web_url")
    private String webUrl;

    @Column(name = "precio_general")
    private Double precioGeneral;

    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    @Column(name = "fecha_actualizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacion;

    @ManyToMany
    @JoinTable(
            name = "alojamiento_destino",
            joinColumns = @JoinColumn(name = "alojamiento_id"),
            inverseJoinColumns = @JoinColumn(name = "destino_id")
    )
    private Set<Destinos> destinos = new HashSet<>();

    // Constructores (Vacio y Cargado)
    public Alojamiento() {
    }

    public Alojamiento(String nombre, TipoAlojamiento tipoAlojamiento, String direccion, String celular, String email, String webUrl, double precioGeneral, Date fechaCreacion, Date fechaActualizacion) {
        this.nombre = nombre;
        this.tipoAlojamiento = tipoAlojamiento;
        this.direccion = direccion;
        this.celular = celular;
        this.email = email;
        this.webUrl = webUrl;
        this.precioGeneral = precioGeneral;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
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

    public TipoAlojamiento getTipoAlojamiento() {
        return tipoAlojamiento;
    }

    public void setTipoAlojamiento(TipoAlojamiento tipoAlojamiento) {
        this.tipoAlojamiento = tipoAlojamiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public Double getPrecioGeneral() {
        return precioGeneral;
    }

    public void setPrecioGeneral(Double precioGeneral) {
        this.precioGeneral = precioGeneral;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public Set<Destinos> getDestinos() {
        return destinos;
    }

    public void setDestinos(Set<Destinos> destinos) {
        this.destinos = destinos;
    }

    // Método toString()
    @Override
    public String toString() {
        return "Alojamiento{" +
                "id=" + id +
                ", destinos=" + destinos +
                ", nombre='" + nombre + '\'' +
                ", tipoAlojamiento=" + tipoAlojamiento +
                ", direccion='" + direccion + '\'' +
                ", celular='" + celular + '\'' +
                ", email='" + email + '\'' +
                ", webUrl='" + webUrl + '\'' +
                ", precioGeneral=" + precioGeneral +
                ", fechaCreacion=" + fechaCreacion +
                ", fechaActualizacion=" + fechaActualizacion +
                '}';
    }
}
