package Sistema.api.Controller;

import Sistema.api.DTO.DadosAtualizacaoLancamento;
import Sistema.api.DTO.DadosDetalhamentoLancamento;
import Sistema.api.DTO.DadosLancamento;
import Sistema.api.DTO.DadosListagemLancamento;
import Sistema.api.entities.Pessoa;
import Sistema.api.services.LancamentoServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("lancamentos")
public class LancamentoController {
    @Autowired
    private LancamentoServices services;

    @PostMapping
    public ResponseEntity lancar(@RequestBody @Valid DadosLancamento dados, UriComponentsBuilder uriBuilder){
        var lancamento = services.cadastrarLancamento(dados);

        var uri = uriBuilder.path("/lancamentos/{id}").
                buildAndExpand(lancamento.getCodigo()).toUri();
        return ResponseEntity.created(uri)
                .body(new DadosDetalhamentoLancamento(lancamento));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemLancamento>>
    listarLancamento(@PageableDefault(size = 10, sort = {"descricao"})Pageable paginacao){
        Page<DadosListagemLancamento> page =
            services.listarLancamento(paginacao);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoLancamento dados){
        var lancamento = services.atualizarLancamento(dados);
        return ResponseEntity.ok(new DadosDetalhamentoLancamento(lancamento));
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity excluir(@PathVariable Long codigo){
        services.excluirLancamento(codigo);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity detalhar(@PathVariable Long codigo){
        var lancamento = services.detalharLancamento(codigo);
        return ResponseEntity.ok(new DadosDetalhamentoLancamento(lancamento));
    }
}
