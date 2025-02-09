package com.edu.SpringBootCrudApp.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.SpringBootCrudApp.Entity.Product;
//import com.edu.SpringBootCrudApp.Service.ProductService;
import com.edu.SpringBootCrudApp.ServiceImpl.ProductServiceImpl;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	private final ProductServiceImpl productService;

    public ProductController(ProductServiceImpl productService) {
		super();
		this.productService = productService;
	}
    
    
    @GetMapping("/welcome")
    public String showWelcomePage() {
		return "Welcome to the Project";
    	
    }
	@PostMapping("/saveProduct")
    public ResponseEntity<Product> saveProduct(@Validated @RequestBody Product product) {
    	return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.CREATED);
    }

    @GetMapping("/getProductById/{id}")
    
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    @GetMapping("/getAllProducts")
    public ResponseEntity<List<Product>> getAllProducts() {
    	return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    	
    }

    @PutMapping("/updateProductById/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @Validated @RequestBody Product product) {
        return new ResponseEntity<>(productService.updateProduct(id, product), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteProductById/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
