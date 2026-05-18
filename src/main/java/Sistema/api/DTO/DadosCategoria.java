package Sistema.api.DTO;

import jakarta.validation.constraints.NotBlank;

public record DadosCategoria(
        @NotBlank
        String nome) {
}
