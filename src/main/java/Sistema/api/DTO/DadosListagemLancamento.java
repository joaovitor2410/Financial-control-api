package Sistema.api.DTO;

import Sistema.api.entities.Lancamento;
import Sistema.api.entities.TipoLancamento;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosListagemLancamento(
        Long codigo,
        String descricao,
        LocalDate dataVencimento,
        LocalDate dataPagamento,
        BigDecimal valor,
        String observacao,
        TipoLancamento tipo) {

    public DadosListagemLancamento(Lancamento lancamento){
        this(lancamento.getCodigo(),lancamento.getDescricao(), lancamento.getDataVencimento(), lancamento.getDataPagamento(),
                lancamento.getValor(), lancamento.getObservacao(), lancamento.getTipo());
    }
}
