package br.com.zup.GerenciadorDeContas.gerenciador.DTOS;

import br.com.zup.GerenciadorDeContas.gerenciador.enuns.Status;
import br.com.zup.GerenciadorDeContas.gerenciador.enuns.Tipo;

public class ContaResumoDTO {
    private int id;
    private Tipo tipo;
    private double valor;
    private Status status;

    public ContaResumoDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
