package Sistema.api.DTO;

import Sistema.api.entities.Endereco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosEndereco(
        @NotBlank
        String logradouro,
        @NotBlank
        String numero,
        String complemento,
        @NotBlank
        String bairro,
        @NotBlank
        String cep,
        @NotBlank
        String cidade,
        @NotBlank
        String estado) {
        public DadosEndereco(Endereco endereco) {
                this(
                        endereco.getLogradouro(),
                        endereco.getNumero(),
                        endereco.getComplemento(),
                        endereco.getBairro(),
                        endereco.getCep(),
                        endereco.getCidade(),
                        endereco.getEstado()
                );
}
}
