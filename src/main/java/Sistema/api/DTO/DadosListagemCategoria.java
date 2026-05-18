package Sistema.api.DTO;

import Sistema.api.entities.Categoria;

public record DadosListagemCategoria(
        Long id,
        String nome
) {
    public DadosListagemCategoria(Categoria categoria){
        this(categoria.getId(),categoria.getNome());
    }
}
