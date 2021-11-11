package br.com.zup.GerenciadorDeContas.gerenciador.excessoes;

public class ContaNaoEncontradaException extends RuntimeException{
    public ContaNaoEncontradaException (String message){
        super(message);
    }
}
