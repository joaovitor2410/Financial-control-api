package Sistema.api.DTO;

import Sistema.api.entities.Pessoa;

public record DadosDetalhamentoPessoa(
        Long id,
        String nome,
        Boolean ativo,
        String telefone,
        DadosEndereco endereco
) {
    public DadosDetalhamentoPessoa (Pessoa pessoa){
        this(pessoa.getId(), pessoa.getNome(), pessoa.getAtivo(), pessoa.getTelefone(), new DadosEndereco(pessoa.getEndereco()));
    }
}
