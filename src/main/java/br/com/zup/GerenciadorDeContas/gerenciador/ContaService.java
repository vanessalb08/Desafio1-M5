package br.com.zup.GerenciadorDeContas.gerenciador;

import br.com.zup.GerenciadorDeContas.gerenciador.enuns.Status;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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

    public Conta buscarConta(int id){
        for (Conta contaReferencia : contaRepository.findAll()){
            if (contaReferencia.getId() == id){
                return contaReferencia;
            }
        }
        throw new RuntimeException("Conta não encontrada");
    }

    public Conta atualizarConta(int id){
        Conta contaParaAtualizar = buscarConta(id);
        contaParaAtualizar.setStatus(Status.PAGO);
        contaParaAtualizar.setDataDePagamento(LocalDateTime.now());

        contaRepository.save(contaParaAtualizar);

        return contaParaAtualizar;
    }

    public List<Conta> retornatTodasAsContas(){
        Iterable<Conta> contas = contaRepository.findAll();
        return (List<Conta>) contas;
    }
}
