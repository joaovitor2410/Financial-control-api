package Sistema.api.services;

import Sistema.api.DTO.DadosAtualizacaoPessoa;
import Sistema.api.DTO.DadosCadastro;
import Sistema.api.DTO.DadosListagemLancamento;
import Sistema.api.DTO.DadosListagemPessoa;
import Sistema.api.entities.Pessoa;
import Sistema.api.infra.exception.PessoaNaoEncontradaException;
import Sistema.api.repositories.PessoaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaServices {

        @Autowired
        private PessoaRepository repository;

        @Transactional
        public Pessoa cadastrarPessoa(DadosCadastro dados){
            var pessoa = repository.save(new Pessoa(dados));
            return pessoa;
        }

        public Page<DadosListagemPessoa> listarPessoa(Pageable paginacao){
                return repository.findByAtivoTrue(paginacao).map(DadosListagemPessoa::new);
        }

        @Transactional
        public Pessoa atualizarPessoa(DadosAtualizacaoPessoa dados){
                var pessoa = repository.getReferenceById(dados.id());
                pessoa.atualizarInformacoesPessoa(dados);
                return pessoa;
        }

        @Transactional
        public void excluirPessoa(Long id) {
                var pessoa = repository.getReferenceById(id);
                pessoa.excluir();
        }

        @Transactional
        public Pessoa detalharPessoa(Long id) {
                return repository.findById(id)
                        .orElseThrow(PessoaNaoEncontradaException::new);
        }
}

