package com.rafael.gerenciador_tarefas.service;

import com.rafael.gerenciador_tarefas.domain.Responsavel;
import com.rafael.gerenciador_tarefas.repository.ResponsavelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponsavelService {

    private final ResponsavelRepository responsavelRepository;

    public ResponsavelService(ResponsavelRepository responsavelRepository) {
        this.responsavelRepository = responsavelRepository;
    }

    public Responsavel criar(Responsavel responsavel) {
        return responsavelRepository.save(responsavel);
    }

    public List<Responsavel> listarTodos() {
        return responsavelRepository.findAll();
    }
}