package Sistema.api.entities;

import Sistema.api.DTO.DadosAtualizacaoLancamento;
import Sistema.api.DTO.DadosAtualizacaoPessoa;
import Sistema.api.DTO.DadosLancamento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Table(name = "lancamento")
@Entity(name = "Lancamento")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "codigo")
public class Lancamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String descricao;

    @Column(name = "data_vencimento")
    private LocalDate dataVencimento;

    @Column(name = "data_pagamento")
    private LocalDate dataPagamento;

    private BigDecimal valor;

    private String observacao;

    @Enumerated(EnumType.STRING)
    private TipoLancamento tipo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigo_categoria")
    private Categoria categoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigo_pessoa")
    private Pessoa pessoa;

    public Lancamento(DadosLancamento dados) {
        this.descricao = dados.descricao();
        this.dataVencimento = dados.dataVencimento();
        this.dataPagamento = dados.dataPagamento();
        this.valor = dados.valor();
        this.observacao = dados.observacao();
        this.tipo = dados.tipo();
        this.categoria = new Categoria(dados.codigoCategoria());
        this.pessoa = new Pessoa(dados.codigoPessoa());
    }

    public void atualizarInformacoesLancamento(DadosAtualizacaoLancamento dados) {
        if(dados.descricao() != null){
            this.descricao = dados.descricao();
        }
        if(dados.dataVencimento() != null){
            this.dataVencimento = dados.dataVencimento();
        }
        if(dados.dataPagamento() != null){
            this.dataPagamento = dados.dataPagamento();
        }
        if(dados.valor() != null){
            this.valor = dados.valor();
        }
        if(dados.observacao() != null){
            this.observacao = dados.observacao();
        }
        if(dados.tipo() != null){
            this.tipo = dados.tipo();
        }
    }
}