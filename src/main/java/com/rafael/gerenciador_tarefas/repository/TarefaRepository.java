package com.rafael.gerenciador_tarefas.repository;

import com.rafael.gerenciador_tarefas.domain.Status;
import com.rafael.gerenciador_tarefas.domain.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    List<Tarefa> findByStatus(Status status);

    List<Tarefa> findByProjetoId(Long projetoId);

    List<Tarefa> findByStatusAndProjetoId(Status status, Long projetoId);
}
