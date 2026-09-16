package com.rafael.gerenciador_tarefas.controller;

import com.rafael.gerenciador_tarefas.domain.Status;
import com.rafael.gerenciador_tarefas.domain.Tarefa;
import com.rafael.gerenciador_tarefas.service.TarefaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @PostMapping
    public ResponseEntity<Tarefa> criar(@RequestBody Tarefa tarefa) {
        Tarefa salva = tarefaService.criar(tarefa);
        return ResponseEntity.created(URI.create("/tarefas/" + salva.getId())).body(salva);
    }

    @GetMapping
    public List<Tarefa> listar(@RequestParam(required = false) Status status,
                               @RequestParam(required = false) Long projetoId) {
        return tarefaService.listar(status, projetoId);
    }

    @GetMapping("/{id}")
    public Tarefa buscarPorId(@PathVariable Long id) {
        return tarefaService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Tarefa atualizar(@PathVariable Long id, @RequestBody Tarefa tarefa) {
        return tarefaService.atualizar(id, tarefa);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) {
        tarefaService.remover(id);
    }
}