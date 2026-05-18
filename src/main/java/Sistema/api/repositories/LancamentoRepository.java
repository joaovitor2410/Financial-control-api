package Sistema.api.repositories;

import Sistema.api.entities.Lancamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LancamentoRepository extends JpaRepository<Lancamento,Long> {
}
