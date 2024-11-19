package com.example.kanban.repository;

import com.example.kanban.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface RepositorioUsuario extends JpaRepository<User, String>{
    UserDetails findByLogin(String login);
}
