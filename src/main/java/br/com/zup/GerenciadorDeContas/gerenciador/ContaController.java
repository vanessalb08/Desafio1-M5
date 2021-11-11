package br.com.zup.GerenciadorDeContas.gerenciador;

import br.com.zup.GerenciadorDeContas.gerenciador.DTOS.AtualizarContaDTO;
import br.com.zup.GerenciadorDeContas.gerenciador.DTOS.ContaDTO;
import br.com.zup.GerenciadorDeContas.gerenciador.DTOS.ContaResumoDTO;
import br.com.zup.GerenciadorDeContas.gerenciador.DTOS.ContaSaidaDTO;
import br.com.zup.GerenciadorDeContas.gerenciador.enuns.Status;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/contas")
public class ContaController {

    @Autowired
    private ContaService contaService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ContaSaidaDTO cadastrarConta (@RequestBody ContaDTO ContaDTO){
        Conta conta = modelMapper.map(ContaDTO, Conta.class);
        ContaSaidaDTO contaSaidaDTO = modelMapper.map(contaService.salvarConta(conta), ContaSaidaDTO.class);

        return contaSaidaDTO;
    }

    @GetMapping
    public List<ContaResumoDTO> exibirContas(){
        List<ContaResumoDTO> contaResumoDTOS = new ArrayList<>();
        for(Conta contaReferencia : contaService.retornatTodasAsContas()){
            ContaResumoDTO contaResumoDTO = modelMapper.map(contaReferencia,ContaResumoDTO.class);
            contaResumoDTOS.add(contaResumoDTO);
        }
        return contaResumoDTOS;
    }

    @PutMapping("/{id}")
    public ContaSaidaDTO atualizarConta (@PathVariable int id, @RequestBody AtualizarContaDTO atualizarContaDTO){
        ContaSaidaDTO contaSaidaDTO;
        if (atualizarContaDTO.getStatus().equals(Status.PAGO)){
            contaSaidaDTO = modelMapper.map(contaService.atualizarConta(id), ContaSaidaDTO.class);
            return contaSaidaDTO;
        }
        else{
             return contaSaidaDTO = modelMapper.map(contaService.buscarConta(id), ContaSaidaDTO.class);
        }

    }

}
