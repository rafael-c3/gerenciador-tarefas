package com.rafael.gerenciador_tarefas.repository;

import com.rafael.gerenciador_tarefas.domain.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
}