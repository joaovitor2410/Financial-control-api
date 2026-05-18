package Sistema.api.Controller;

import Sistema.api.DTO.*;
import Sistema.api.services.CategoriaServices;
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
@RequestMapping("categorias")
public class CategoriaController {
    @Autowired
    private CategoriaServices services;

    @PostMapping
    public ResponseEntity cadastrarCategoria(@RequestBody @Valid DadosCategoria dados, UriComponentsBuilder uriBuilder){
        var categoria = services.cadastrarCategoria(dados);

        var uri = uriBuilder.path("/categorias/{id}").
                buildAndExpand(categoria.getId()).toUri();
        return ResponseEntity.created(uri)
                .body(new DadosDetalhamentoCategoria(categoria));
    }
    @GetMapping
    public ResponseEntity<Page<DadosListagemCategoria>>
    listarCategoria(@PageableDefault(size = 10, sort = {"nome"})Pageable paginacao){
        Page<DadosListagemCategoria> page =
            services.listarCategoria(paginacao);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoCategoria dados){
        var categoria = services.atualizarCategoria(dados);
        return ResponseEntity.ok(new DadosDetalhamentoCategoria(categoria));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluir(@PathVariable Long id){
        services.excluirCategoria(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var categoria = services.detalharCategoria(id);
        return ResponseEntity.ok(new DadosDetalhamentoCategoria(categoria));
    }
}
