package br.com.zup.GerenciadorDeContas.gerenciador.DTOS;

import br.com.zup.GerenciadorDeContas.gerenciador.enuns.Status;

public class AtualizarContaDTO {
    private Status status;

    public AtualizarContaDTO() {
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
