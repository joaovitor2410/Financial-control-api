package Sistema.api.services;

import Sistema.api.DTO.DadosAtualizacaoLancamento;
import Sistema.api.DTO.DadosAtualizacaoPessoa;
import Sistema.api.DTO.DadosLancamento;
import Sistema.api.DTO.DadosListagemLancamento;
import Sistema.api.entities.Lancamento;
import Sistema.api.infra.exception.LancamentoNaoEncontradoException;
import Sistema.api.repositories.LancamentoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LancamentoServices {
    @Autowired
    private LancamentoRepository repository;

    @Transactional
    public Lancamento cadastrarLancamento(DadosLancamento dados){
        var lancamento = repository.save(new Lancamento(dados));
        return lancamento;
    }

    public Page<DadosListagemLancamento> listarLancamento(Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemLancamento::new);
    }

    @Transactional
    public Lancamento atualizarLancamento(DadosAtualizacaoLancamento dados){
        var lancamento = repository.getReferenceById(dados.codigo());
        lancamento.atualizarInformacoesLancamento(dados);
        return lancamento;
    }

    public void excluirLancamento(Long codigo) {
        repository.deleteById(codigo);
    }

    @Transactional
    public Lancamento detalharLancamento(Long codigo) {
        return repository.findById(codigo)
                .orElseThrow(LancamentoNaoEncontradoException::new);
    }
}
