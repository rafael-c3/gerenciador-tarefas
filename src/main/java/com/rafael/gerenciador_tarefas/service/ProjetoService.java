package com.rafael.gerenciador_tarefas.service;

import com.rafael.gerenciador_tarefas.domain.Projeto;
import com.rafael.gerenciador_tarefas.repository.ProjetoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetoService {

    private final ProjetoRepository projetoRepository;

    public ProjetoService(ProjetoRepository projetoRepository) {
        this.projetoRepository = projetoRepository;
    }

    public Projeto criar(Projeto projeto) {
        return projetoRepository.save(projeto);
    }

    public List<Projeto> listarTodos() {
        return projetoRepository.findAll();
    }
}