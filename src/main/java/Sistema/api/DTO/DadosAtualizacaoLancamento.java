package Sistema.api.DTO;

import Sistema.api.entities.TipoLancamento;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosAtualizacaoLancamento(
        Long codigo,
        String descricao,
        LocalDate dataVencimento,
        LocalDate dataPagamento,
        BigDecimal valor,
        String observacao,
        TipoLancamento tipo
) {
}
