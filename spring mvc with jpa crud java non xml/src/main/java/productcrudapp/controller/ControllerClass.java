// ControllerClass.java
package productcrudapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import productcrudapp.Service.ServiceClass;
import productcrudapp.model.Product;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ControllerClass {

    private final ServiceClass serviceClass;

    @Autowired
    public ControllerClass(ServiceClass serviceClass) {
        this.serviceClass = serviceClass;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) {
        return serviceClass.getProduct(id);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return serviceClass.getProducts();
    }

    @PostMapping
    public ResponseEntity<String> insertProduct(@RequestBody Product product) {
        serviceClass.createProduct(product);
        return new ResponseEntity<>("Product inserted", HttpStatus.CREATED);
    }
}
