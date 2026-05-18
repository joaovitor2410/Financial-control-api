package Sistema.api.DTO;

import Sistema.api.entities.Endereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastro(
        @NotBlank
        String nome,
        Boolean ativo,
        String telefone,
        @NotNull
        @Valid
        DadosEndereco endereco) {
}
