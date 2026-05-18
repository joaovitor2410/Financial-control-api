package Sistema.api.DTO;

import Sistema.api.entities.Pessoa;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosListagemPessoa(
        Long id,
        String nome,
        Boolean ativo,
        String telefone,
        DadosEndereco endereco
) {
    public DadosListagemPessoa(Pessoa pessoa){
        this(pessoa.getId(),pessoa.getNome(), pessoa.getAtivo(), pessoa.getTelefone(), new DadosEndereco(pessoa.getEndereco()));
    }
}
