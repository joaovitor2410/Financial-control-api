package Sistema.api.infra;

import Sistema.api.DTO.DadosErroCategoria;
import Sistema.api.DTO.DadosErroLancamento;
import Sistema.api.DTO.DadosErroPessoa;
import Sistema.api.DTO.DadosErroValidacao;
import Sistema.api.infra.exception.CategoriaNaoEncontradaException;
import Sistema.api.infra.exception.LancamentoNaoEncontradoException;
import Sistema.api.infra.exception.PessoaNaoEncontradaException;
import jakarta.persistence.EntityNotFoundException;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler(PessoaNaoEncontradaException.class)
    public ResponseEntity tratarErro404pessoa(){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new DadosErroPessoa("Pessoa não encontrada"));

    }

    @ExceptionHandler(LancamentoNaoEncontradoException.class)
    public ResponseEntity tratarErro404lancamento(){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new DadosErroLancamento("Lancamento não encontrado"));

    }

    @ExceptionHandler(CategoriaNaoEncontradaException.class)
    public ResponseEntity tratarErro404categoria(){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new DadosErroCategoria("Categoria não encontrada"));

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarErro400(MethodArgumentNotValidException ex){
        var erros = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(erros.stream().map(DadosErroValidacao::new).toList());
    }
}
