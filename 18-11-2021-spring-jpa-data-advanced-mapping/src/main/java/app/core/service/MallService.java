package app.core.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.core.entities.Product;
import app.core.entities.Store;
import app.core.exception.MallException;
import app.core.repo.ProductRepo;
import app.core.repo.StoreRepo;

@Service
@Transactional

public class MallService {
//	@Autowired
	private ProductRepo productRepo;
//	@Autowired
	private StoreRepo storeRepo;

	public MallService(ProductRepo productRepo, StoreRepo storeRepo) {
		super();
		this.productRepo = productRepo;
		this.storeRepo = storeRepo;
	}

	public int addStore(Store store) {
		store = this.storeRepo.save(store);
		return store.getId();
	}

	public Store getStore(int storeId) {
//		Optional<Store> opt = this.storeRepo.findById(storeId);
//		if(opt.isPresent()) {
//			return opt.get();
//		}else {
//			throw new MallException("getStore failed - store" + storeId + " not found");
//		}

		return this.storeRepo.findById(storeId)
				.orElseThrow(() -> new MallException("getStore failed - store" + storeId + " not found"));
	}

	public List<Store> getAllStoreInMall() {
		return this.storeRepo.findAll();
	}
	
	public List<Store> getAllStoresInMall(String prefix) {
		return this.storeRepo.findByNameStartsWith(prefix);
	}
	public void updateStore(Store store) {
		Store storeFromDb = getStore(store.getId());
		storeFromDb.setName(store.getName());
	}

	public void deleteStore(int storeId) {
		this.storeRepo.deleteById(storeId);
	}

	public void addProductToStore(int storeId, Product product) {
		Store store = getStore(storeId);
		store.getProducts().add(product);

	}
	
	public Product getProduct(int productId) {
		Optional<Product> opt = this.productRepo.findById(productId);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new MallException("getProduct failed - product " + productId + " not found");
		}
	}

	public List<Product> getAllProductsInMall() {
		return this.productRepo.findAll();
	}

	public List<Product> getAllProductsInMall(double maxPrice) {
		return this.productRepo.findByPriceLessThanEqual(maxPrice);
	}
}
