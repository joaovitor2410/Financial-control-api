package Sistema.api.entities;

import Sistema.api.DTO.DadosAtualizacaoPessoa;
import Sistema.api.DTO.DadosCadastro;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "pessoa")
@Entity(name = "Pessoa")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "ativo")
    private Boolean ativo;

    @Column(name = "telefone")
    private String telefone;

    @Embedded
    private Endereco endereco;

    public Pessoa(DadosCadastro dados) {
        this.nome = dados.nome();
        this.ativo = true;
        this.telefone = dados.telefone();
        this.endereco = new Endereco(dados.endereco());
    }

    public Pessoa(Long id){
        this.id = id;
    }

    public void excluir(){
        this.ativo = false;
    }

    @OneToMany(mappedBy = "pessoa")
    private List<Lancamento> lancamentos;

    public void atualizarInformacoesPessoa(DadosAtualizacaoPessoa dados) {
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if(dados.telefone() != null){
            this.telefone = dados.telefone();
        }
        if(dados.endereco() != null){
            this.endereco.atualizarInformacoesEndereco(dados.endereco());
        }
    }
}
