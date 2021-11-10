package br.com.zup.GerenciadorDeContas.gerenciador.DTOS;

import br.com.zup.GerenciadorDeContas.gerenciador.enuns.Tipo;
import java.time.LocalDate;

public class RequisicaoDTO {
    private String nome;
    private double valor;
    private Tipo tipo;
    private LocalDate dataDeVencimento;

    public RequisicaoDTO() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public LocalDate getDataDeVencimento() {
        return dataDeVencimento;
    }

    public void setDataDeVencimento(LocalDate dataDeVencimento) {
        this.dataDeVencimento = dataDeVencimento;
    }
}
