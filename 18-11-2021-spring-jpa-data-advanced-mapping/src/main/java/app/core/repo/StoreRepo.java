package app.core.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.core.entities.Store;

public interface StoreRepo extends JpaRepository<Store, Integer> {

		List<Store> findByNameStartsWith(String prefix);

}
