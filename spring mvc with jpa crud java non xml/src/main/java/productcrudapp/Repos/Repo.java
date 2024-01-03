package productcrudapp.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import productcrudapp.model.Product;

public interface Repo extends JpaRepository<Product,Long> {
}
