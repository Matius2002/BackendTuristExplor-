package org.example.proyecturitsexplor.Entidades;
import jakarta.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "noticia")
public class Noticia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "contenido", nullable = false)
    private String contenido;

    @Column(name = "fecha_publicacion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaPublicacion;

    @Column(name = "fuente", nullable = false)
    private String fuente;

    @Column(name = "fecha_creacion", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    // Relación con destinos
    @ManyToOne
    @JoinColumn(name = "destino_id", nullable = false)
    private Destinos destino;

    @Column(name = "fecha_actualizacion", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacion;

    // Relación con imágenes
    @ManyToMany
    @JoinTable(
            name = "noticia_images",
            joinColumns = @JoinColumn(name = "noticia_id"),
            inverseJoinColumns = @JoinColumn(name = "image_id")
    )
    private Set<Images> images = new HashSet<>();

    // Constructores
    public Noticia() {}

    public Noticia(String titulo, String contenido, Date fechaPublicacion, String fuente, Date fechaCreacion, Date fechaActualizacion) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.fechaPublicacion = fechaPublicacion;
        this.fuente = fuente;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getFuente() {
        return fuente;
    }

    public void setFuente(String fuente) {
        this.fuente = fuente;
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

    public Set<Images> getImages() {
        return images;
    }

    public void setImages(Set<Images> images) {
        this.images = images;
    }

    public Destinos getDestino() {
        return destino;
    }

    public void setDestino(Destinos destino) {
        this.destino = destino;
    }

    // Método toString()
    @Override
    public String toString() {
        return "Noticia{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", contenido='" + contenido + '\'' +
                ", fechaPublicacion=" + fechaPublicacion +
                ", fuente='" + fuente + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", fechaActualizacion=" + fechaActualizacion +
                ", images=" + images +
                ", destinos=" + destino +
                '}';
    }
}
