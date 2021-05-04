package int221luxcars.repositories;

import int221luxcars.models.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsJpaRepository
 extends JpaRepository<Products, String> {

}
