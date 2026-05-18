package Sistema.api.infra.exception;

public class PessoaNaoEncontradaException extends RuntimeException {
    public PessoaNaoEncontradaException() {
        super("Pessoa não encontrada");
    }
}