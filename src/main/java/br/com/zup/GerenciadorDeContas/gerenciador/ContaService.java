package br.com.zup.GerenciadorDeContas.gerenciador;

import br.com.zup.GerenciadorDeContas.gerenciador.DTOS.EntradaContaDTO;
import br.com.zup.GerenciadorDeContas.gerenciador.DTOS.SaidaContaDTO;
import br.com.zup.GerenciadorDeContas.gerenciador.enuns.Status;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Conta salvarConta(Conta conta){
        verificarData(conta);
        return contaRepository.save(conta);
    }

    public void verificarData (Conta conta){
        if (conta.getDataDeVencimento().isBefore(LocalDate.now())){
            conta.setStatus(Status.VENCIDA);
        }
        else{
            conta.setStatus(Status.AGUARDANDO);
        }

    }
}
