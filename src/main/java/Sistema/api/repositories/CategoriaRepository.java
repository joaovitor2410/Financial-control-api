package Sistema.api.repositories;

import Sistema.api.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria,Long> {
}
