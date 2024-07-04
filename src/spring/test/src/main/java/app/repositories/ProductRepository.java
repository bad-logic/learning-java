package app.repositories;

import app.domain.product.Product;
import app.domain.product.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findProductByPriceGreaterThan(double price);
    List<Product> findProductByCategoryName(ProductCategory category);
}
