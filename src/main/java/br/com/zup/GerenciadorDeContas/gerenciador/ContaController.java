package br.com.zup.GerenciadorDeContas.gerenciador;

import br.com.zup.GerenciadorDeContas.gerenciador.DTOS.EntradaContaDTO;
import br.com.zup.GerenciadorDeContas.gerenciador.DTOS.SaidaContaDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contas")
public class ContaController {

    @Autowired
    private ContaService contaService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SaidaContaDTO salvarConta (@RequestBody EntradaContaDTO entradaContaDTO){
        Conta conta = modelMapper.map(entradaContaDTO, Conta.class);
        SaidaContaDTO saidaContaDTO = modelMapper.map(contaService.salvarConta(conta),SaidaContaDTO.class);

        return saidaContaDTO;
    }

}
