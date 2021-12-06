package app.core.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.core.entities.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

	List<Product> findByPriceLessThanEqual(double maxPrice);
}
