package Sistema.api.DTO;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPessoa(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
