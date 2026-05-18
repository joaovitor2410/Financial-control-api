package Sistema.api.entities;

import Sistema.api.DTO.DadosAtualizacaoCategoria;
import Sistema.api.DTO.DadosCategoria;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "categoria")
@Entity(name = "Categoria")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Long id;

    @Column(name = "nome")
    private String nome;

    public Categoria(DadosCategoria dados) {
        this.nome = dados.nome();
    }

    public Categoria(Long id){
        this.id = id;
    }

    @OneToMany(mappedBy = "categoria")
    private List<Lancamento> lancamentos;

    public void atualizarInformacoesCategoria(DadosAtualizacaoCategoria dados){
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
    }
}
