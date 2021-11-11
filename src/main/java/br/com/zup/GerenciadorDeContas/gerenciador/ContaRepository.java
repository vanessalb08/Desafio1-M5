package br.com.zup.GerenciadorDeContas.gerenciador;

import br.com.zup.GerenciadorDeContas.gerenciador.enuns.Status;
import br.com.zup.GerenciadorDeContas.gerenciador.enuns.Tipo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContaRepository extends CrudRepository <Conta, Integer>{
    List<Conta> findAllByStatus (Status status);

    List<Conta> findAllByTipo(Tipo tipo);
}
