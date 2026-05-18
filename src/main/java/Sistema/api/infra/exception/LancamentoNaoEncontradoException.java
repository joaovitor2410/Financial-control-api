package Sistema.api.infra.exception;

public class LancamentoNaoEncontradoException extends RuntimeException {
    public LancamentoNaoEncontradoException() {
        super("Lançamento não encontrado");
    }
}