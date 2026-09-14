package com.rafael.gerenciador_tarefas.repository;

import com.rafael.gerenciador_tarefas.domain.Responsavel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResponsavelRepository extends JpaRepository<Responsavel, Long> {
}