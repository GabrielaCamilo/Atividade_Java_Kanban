package com.example.kanban.repository;

import com.example.kanban.model.Tarefas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioDeTarefas extends JpaRepository<Tarefas, Long> {
}
