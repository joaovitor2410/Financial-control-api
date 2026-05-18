package Sistema.api.repositories;

import Sistema.api.entities.Pessoa;
import aj.org.objectweb.asm.commons.Remapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa,Long> {
    Page<Pessoa> findByAtivoTrue(Pageable paginacao);
}
