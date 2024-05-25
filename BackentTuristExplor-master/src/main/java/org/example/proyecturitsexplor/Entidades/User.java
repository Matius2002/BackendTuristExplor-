package org.example.proyecturitsexplor.Entidades;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "userName")
    private String userName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "fechaRegistro")
    private Date fechaRegistro;

    // Constructores
    public User() {}

    public User(String userName, String email, String password, Date fechaRegistro) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.fechaRegistro = fechaRegistro;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {this.userName = userName; }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {this.email = email; }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {this.password = password; }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {this.fechaRegistro = fechaRegistro; }

    // Método toString()
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", fechaRegistro='" + fechaRegistro + '\'' +
                '}';
    }
}
