package org.example.proyecturitsexplor.Repositorios;

import org.example.proyecturitsexplor.Entidades.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface UserRepositorio extends JpaRepository<User, Long> {
    boolean existsByUserName(String UserName);
}
