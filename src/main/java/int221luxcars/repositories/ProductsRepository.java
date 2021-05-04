package int221luxcars.repositories;

import int221luxcars.models.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository
 extends JpaRepository<Products, Long> {

}
