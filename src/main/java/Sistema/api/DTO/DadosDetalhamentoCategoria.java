package Sistema.api.DTO;

import Sistema.api.entities.Categoria;

public record DadosDetalhamentoCategoria(
        Long id,
        String nome
) {
    public DadosDetalhamentoCategoria(Categoria categoria){
        this(categoria.getId(), categoria.getNome());
    }
}
