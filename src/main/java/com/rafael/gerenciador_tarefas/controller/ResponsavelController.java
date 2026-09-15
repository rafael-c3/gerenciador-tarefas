package com.rafael.gerenciador_tarefas.controller;

import com.rafael.gerenciador_tarefas.domain.Responsavel;
import com.rafael.gerenciador_tarefas.service.ResponsavelService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/responsaveis")
public class ResponsavelController {

    private final ResponsavelService responsavelService;

    public ResponsavelController(ResponsavelService responsavelService) {
        this.responsavelService = responsavelService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Responsavel criar(@RequestBody Responsavel responsavel) {
        return responsavelService.criar(responsavel);
    }

    @GetMapping
    public List<Responsavel> listar() {
        return responsavelService.listarTodos();
    }
}