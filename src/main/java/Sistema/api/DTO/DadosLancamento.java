package Sistema.api.DTO;

import Sistema.api.entities.TipoLancamento;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosLancamento(
        @NotBlank
        String descricao,
        LocalDate dataVencimento,
        LocalDate dataPagamento,
        @NotNull
        BigDecimal valor,
        String observacao,
        @NotNull
        TipoLancamento tipo,
        @NotNull
        Long codigoCategoria,
        @NotNull
        Long codigoPessoa
){
}
