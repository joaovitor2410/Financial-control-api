package Sistema.api.services;

import Sistema.api.DTO.DadosAtualizacaoCategoria;
import Sistema.api.DTO.DadosAtualizacaoPessoa;
import Sistema.api.DTO.DadosCategoria;
import Sistema.api.DTO.DadosListagemCategoria;
import Sistema.api.entities.Categoria;
import Sistema.api.infra.exception.CategoriaNaoEncontradaException;
import Sistema.api.repositories.CategoriaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServices {
    @Autowired
    private CategoriaRepository repository;

    @Transactional
    public Categoria cadastrarCategoria(DadosCategoria dados){
        var categoria = repository.save(new Categoria(dados));
        return categoria;
    }

    public Page<DadosListagemCategoria> listarCategoria(Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemCategoria::new);
    }

    @Transactional
    public Categoria atualizarCategoria(DadosAtualizacaoCategoria dados){
        var categoria = repository.getReferenceById(dados.id());
        categoria.atualizarInformacoesCategoria(dados);
        return categoria;
    }

    public void excluirCategoria(Long id) {
        repository.deleteById(id);
    }

    @Transactional
    public Categoria detalharCategoria(Long id) {
        return repository.findById(id)
                .orElseThrow(CategoriaNaoEncontradaException::new);
    }
}

