package com.rafael.gerenciador_tarefas.controller;

import com.rafael.gerenciador_tarefas.domain.Projeto;
import com.rafael.gerenciador_tarefas.service.ProjetoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {

    private final ProjetoService projetoService;

    public ProjetoController(ProjetoService projetoService) {
        this.projetoService = projetoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Projeto criar(@RequestBody Projeto projeto) {
        return projetoService.criar(projeto);
    }

    @GetMapping
    public List<Projeto> listar() {
        return projetoService.listarTodos();
    }
}