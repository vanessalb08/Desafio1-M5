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
        return contaRepository.save(conta);
    }

    public SaidaContaDTO retornarSaida (EntradaContaDTO entradaContaDTO){
        SaidaContaDTO saidaContaDTO = modelMapper.map(entradaContaDTO, SaidaContaDTO.class);
        if (entradaContaDTO.getDataDeVencimento().isBefore(LocalDate.now())){
            saidaContaDTO.setStatus(Status.VENCIDA);
        }
        else{
            saidaContaDTO.setStatus(Status.AGUARDANDO);
        }

        return saidaContaDTO;
    }
}
