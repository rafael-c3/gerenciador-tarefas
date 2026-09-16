package com.rafael.gerenciador_tarefas.service;

import com.rafael.gerenciador_tarefas.domain.*;
import com.rafael.gerenciador_tarefas.repository.ProjetoRepository;
import com.rafael.gerenciador_tarefas.repository.ResponsavelRepository;
import com.rafael.gerenciador_tarefas.repository.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {

    private final TarefaRepository tarefaRepository;
    private final ProjetoRepository projetoRepository;
    private final ResponsavelRepository responsavelRepository;

    public TarefaService(TarefaRepository tarefaRepository,
                         ProjetoRepository projetoRepository,
                         ResponsavelRepository responsavelRepository) {
        this.tarefaRepository = tarefaRepository;
        this.projetoRepository = projetoRepository;
        this.responsavelRepository = responsavelRepository;
    }

    public Tarefa criar(Tarefa tarefa) {
        Long projetoId = tarefa.getProjeto().getId();
        Projeto projeto = projetoRepository.findById(projetoId)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Projeto nao encontrado: " + projetoId));
        tarefa.setProjeto(projeto);

        if (tarefa.getResponsavel() != null && tarefa.getResponsavel().getId() != null) {
            Long responsavelId = tarefa.getResponsavel().getId();
            Responsavel responsavel = responsavelRepository.findById(responsavelId)
                    .orElseThrow(() -> new RecursoNaoEncontradoException("Responsavel nao encontrado: " + responsavelId));
            tarefa.setResponsavel(responsavel);
        }

        return tarefaRepository.save(tarefa);
    }

    public List<Tarefa> listar(Status status, Long projetoId) {
        if (status != null && projetoId != null) {
            return tarefaRepository.findByStatusAndProjetoId(status, projetoId);
        }
        if (status != null) {
            return tarefaRepository.findByStatus(status);
        }
        if (projetoId != null) {
            return tarefaRepository.findByProjetoId(projetoId);
        }
        return tarefaRepository.findAll();
    }

    public Tarefa buscarPorId(Long id) {
        return tarefaRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Tarefa nao encontrada: " + id));
    }

    public Tarefa atualizar(Long id, Tarefa dadosAtualizados) {
        Tarefa tarefa = buscarPorId(id);

        tarefa.setTitulo(dadosAtualizados.getTitulo());
        tarefa.setDescricao(dadosAtualizados.getDescricao());
        tarefa.setPrioridade(dadosAtualizados.getPrioridade());
        tarefa.setPrazo(dadosAtualizados.getPrazo());

        if (dadosAtualizados.getResponsavel() != null && dadosAtualizados.getResponsavel().getId() != null) {
            Long responsavelId = dadosAtualizados.getResponsavel().getId();
            Responsavel responsavel = responsavelRepository.findById(responsavelId)
                    .orElseThrow(() -> new RecursoNaoEncontradoException("Responsavel nao encontrado: " + responsavelId));
            tarefa.setResponsavel(responsavel);
        }

        boolean estaConcluindo = dadosAtualizados.getStatus() == Status.CONCLUIDA
                && tarefa.getStatus() != Status.CONCLUIDA;

        tarefa.setStatus(dadosAtualizados.getStatus());

        if (estaConcluindo) {
            tarefa.setConcluidaEm(java.time.LocalDateTime.now());
        }

        return tarefaRepository.save(tarefa);
    }

    public void remover(Long id) {
        Tarefa tarefa = buscarPorId(id);
        tarefaRepository.delete(tarefa);
    }
}