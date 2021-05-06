package int221luxcars.repositories;

import int221luxcars.models.Colors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorsRepository extends JpaRepository<Colors, Long> {
}
