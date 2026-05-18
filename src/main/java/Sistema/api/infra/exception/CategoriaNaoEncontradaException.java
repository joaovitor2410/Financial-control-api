package Sistema.api.infra.exception;

public class CategoriaNaoEncontradaException extends RuntimeException {
    public CategoriaNaoEncontradaException() {
        super("Categoria não encontrada");
    }
}