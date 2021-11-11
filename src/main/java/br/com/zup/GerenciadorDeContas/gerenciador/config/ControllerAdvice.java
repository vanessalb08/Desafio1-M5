package br.com.zup.GerenciadorDeContas.gerenciador.config;

import br.com.zup.GerenciadorDeContas.gerenciador.excessoes.ContaNaoEncontradaException;
import br.com.zup.GerenciadorDeContas.gerenciador.excessoes.StatusInvalidoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public List<MensagemErro> tratarErrosDeValidacao(MethodArgumentNotValidException exception){
        List<MensagemErro> errosDeValidacao = new ArrayList<>();

        for (FieldError fieldError: exception.getFieldErrors()){
            MensagemErro mensagemErro = new MensagemErro(fieldError.getDefaultMessage());
            errosDeValidacao.add(mensagemErro);
        }

        return errosDeValidacao;
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MensagemErro tratarExcecaoDeEnumInvalido(HttpMessageNotReadableException exception){

        return new MensagemErro("Enum não reconhecido");
    }

    @ExceptionHandler(StatusInvalidoException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MensagemErro tratarStatusInvalidoException(StatusInvalidoException exception){
        return new MensagemErro(exception.getMessage());
    }

    @ExceptionHandler(ContaNaoEncontradaException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public MensagemErro tratarContaNaoEncontrada(ContaNaoEncontradaException exception){
        return new MensagemErro(exception.getMessage());
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MensagemErro tratarErroDeFiltro(MethodArgumentTypeMismatchException exception){
        return new MensagemErro("Filtro inválido!");
    }
}
