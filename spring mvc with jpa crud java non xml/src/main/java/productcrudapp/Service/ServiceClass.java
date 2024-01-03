// ServiceClass.java
package productcrudapp.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import productcrudapp.Repos.Repo;
import productcrudapp.model.Product;

@Service
public class ServiceClass {

	@Autowired
	private Repo repo;

	// Create
	public void createProduct(Product product) {
		repo.save(product);
	}

	// Get all products
	public List<Product> getProducts() {
		return repo.findAll();
	}

	// Get a single product
	public ResponseEntity<Product> getProduct(Long id) {
		Optional<Product> product = repo.findById(id);
		return product.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
}
