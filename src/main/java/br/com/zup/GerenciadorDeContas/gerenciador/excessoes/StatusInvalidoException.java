package br.com.zup.GerenciadorDeContas.gerenciador.excessoes;

public class StatusInvalidoException extends RuntimeException{
    public StatusInvalidoException (String message){
        super(message);
    }
}
