package com.rafael.gerenciador_tarefas.domain;

import java.time.Instant;

public class ErroResposta {

    private String erro;
    private Instant momento;

    public ErroResposta(String erro) {
        this.erro = erro;
        this.momento = Instant.now();
    }

    public String getErro() {
        return erro;
    }

    public Instant getMomento() {
        return momento;
    }
}