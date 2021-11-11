package br.com.zup.GerenciadorDeContas.gerenciador.DTOS;

import br.com.zup.GerenciadorDeContas.gerenciador.enuns.Tipo;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class ContaDTO {
    @Size(min = 2, message = "Nome menor que o permitido")
    private String nome;
    @DecimalMin(value = "0.01", message = "Valor menor que o permitido")
    private double valor;
    private Tipo tipo;
    @NotNull(message = "Essa campo não pode ser vazio")
    private LocalDate dataDeVencimento;

    public ContaDTO() {
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
