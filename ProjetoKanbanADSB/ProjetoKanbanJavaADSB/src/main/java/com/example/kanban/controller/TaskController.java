package com.example.kanban.controller;

import com.example.kanban.model.Tarefas;
import com.example.kanban.service.ServicoDeTarefas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private ServicoDeTarefas taskService;

    @PostMapping
    public Tarefas CriarTarefa(@RequestBody Tarefas task) {
        return taskService.CriarTarefa(task);
    }

    @GetMapping
    public List<Tarefas> getAllTasks() {
        return taskService.getAllTasks();
    }

    @PutMapping("/{id}")
    public Tarefas updateTask(@PathVariable Long id, @RequestBody Tarefas updatedTask) {
        return taskService.updateTask(id, updatedTask);
    }

    @PutMapping("/{id}/move")
    public Tarefas moveTask(@PathVariable Long id) {
        return taskService.moveTask(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
