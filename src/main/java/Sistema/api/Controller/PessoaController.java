package Sistema.api.Controller;

import Sistema.api.DTO.*;
import Sistema.api.services.PessoaServices;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("pessoas")
public class PessoaController {
    @Autowired
    private PessoaServices services;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastro cadastro, UriComponentsBuilder uriBuilder) {
        var pessoa = services.cadastrarPessoa(cadastro);

        var uri = uriBuilder.path("/pessoas/{id}").
                buildAndExpand(pessoa.getId()).toUri();
        return ResponseEntity.created(uri)
                .body(new DadosDetalhamentoPessoa(pessoa));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemPessoa>>
    listarPessoa(@PageableDefault(size = 10, sort = {"nome"})Pageable paginacao){
        Page<DadosListagemPessoa> page =
                services.listarPessoa(paginacao);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoPessoa dados){
        var pessoa = services.atualizarPessoa(dados);
        return ResponseEntity.ok(new DadosDetalhamentoPessoa(pessoa));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable Long id){
        services.excluirPessoa(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var pessoa = services.detalharPessoa(id);
        return ResponseEntity.ok(new DadosDetalhamentoPessoa(pessoa));
    }

}
