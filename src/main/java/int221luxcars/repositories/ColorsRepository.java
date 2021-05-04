package int221luxcars.repositories;

import int221luxcars.models.Colors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ColorsRepository extends JpaRepository <Colors,Long> {
    List<Colors> findByProductsId(Long productid);
    Optional<Colors> findByIdAndProductId(Long id,Long productId);
}
