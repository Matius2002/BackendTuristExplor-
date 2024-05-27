package org.example.proyecturitsexplor.Servicios;

import org.example.proyecturitsexplor.Entidades.User;
import org.example.proyecturitsexplor.Excepciones.UserNotFoundException;
import org.example.proyecturitsexplor.Repositorios.UserRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServicio {
    @Autowired
    private UserRepositorio userRepositorio;

    public UserServicio(UserRepositorio userRepositorio) {
        this.userRepositorio = userRepositorio;
    }
    //CRUD

    //Obtener todos los user turisticos
    public List<User> obtenerTodosLosUser () {
        return userRepositorio.findAll();
    }
    //guardar user turistico
    public User guardarUser(User user) {
        return userRepositorio.save(user);
    }
    //Obtener user por id
    public User obtenerUserPorId(Long id) {
        return userRepositorio.findById(id).orElseThrow(()-> new UserNotFoundException(id));
    }
    //actulizar user turistico
    public User actulizarUser(User user) {
        return userRepositorio.save(user);
    }
    //Eliminar user
    public void eliminarUser(Long id) {
        userRepositorio.deleteById(id);
    }
    //Verificar si existe en la base. por nombre
    public boolean verificarUserExistente(String userName) {
        return userRepositorio.existsByUserName(userName);
    }
}
