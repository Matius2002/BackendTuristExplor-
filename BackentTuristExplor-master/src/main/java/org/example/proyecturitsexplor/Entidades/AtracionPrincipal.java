package org.example.proyecturitsexplor.Entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "atracionesPrincipales")
public class AtracionPrincipal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "horario", nullable = false)
    private String horario;

    @Column(name = "horario_funcionamiento", nullable = false)
    private String horarioFuncionamiento;

    // Constructores (Vacio y Cargado)
    public AtracionPrincipal() {
    }

    public AtracionPrincipal(String nombre, String descripcion, String horario, String horarioFuncionamiento) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.horario = horario;
        this.horarioFuncionamiento = horarioFuncionamiento;
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

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getHorarioFuncionamiento() {
        return horarioFuncionamiento;
    }

    public void setHorarioFuncionamiento(String horarioFuncionamiento) {
        this.horarioFuncionamiento = horarioFuncionamiento;
    }

    // Método toString()
    @Override
    public String toString() {
        return "AtraccionPrincipalServicio{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", horario='" + horario + '\'' +
                ", horarioFuncionamiento='" + horarioFuncionamiento + '\'' +
                '}';
    }
}
