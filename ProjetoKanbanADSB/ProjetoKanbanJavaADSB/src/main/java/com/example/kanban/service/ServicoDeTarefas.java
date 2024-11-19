package com.example.kanban.service;

import com.example.kanban.model.Tarefas;
import com.example.kanban.model.TaskStatus;
import com.example.kanban.repository.RepositorioDeTarefas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.kanban.model.TaskStatus.DONE;
import static com.example.kanban.model.TaskStatus.IN_PROGRESS;

@Service
public class ServicoDeTarefas {

    @Autowired
    private RepositorioDeTarefas taskRepository;

    public Tarefas CriarTarefa(Tarefas task) {
        task.setStatus(TaskStatus.TO_DO);
        return taskRepository.save(task);
    }

    public List<Tarefas> getAllTasks() {
        return taskRepository.findAll();
    }

    public Tarefas updateTask(Long id, Tarefas updatedTask) {
        return taskRepository.findById(id).map(task -> {
            task.setTitle(updatedTask.getTitle());
            task.setDescription(updatedTask.getDescription());
            task.setPriority(updatedTask.getPriority());
            return taskRepository.save(task);
        }).orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public Tarefas moveTask(Long id) {
        Tarefas task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        switch (task.getStatus()) {
            case TO_DO -> task.setStatus(IN_PROGRESS);
            case IN_PROGRESS -> task.setStatus(DONE);
            case DONE -> throw new IllegalStateException("Task already completed");
        }
        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
