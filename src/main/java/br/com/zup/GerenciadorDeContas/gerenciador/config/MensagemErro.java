package br.com.zup.GerenciadorDeContas.gerenciador.config;

public class MensagemErro {
    private String messagem;

    public MensagemErro(String messagem) {
        this.messagem = messagem;
    }

    public String getMessagem() {
        return messagem;
    }

    public void setMessagem(String messagem) {
        this.messagem = messagem;
    }
}
