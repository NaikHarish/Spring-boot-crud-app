package com.edu.SpringBootCrudApp.Service;

import java.util.List;

import com.edu.SpringBootCrudApp.Entity.Product;

public interface ProductService {
	
    public Product saveProduct(Product product);
	
	public Product getProductById(Long id);
	
	public List<Product> getAllProducts();
	
	public Product updateProduct(Long id, Product product);
	
	public void deleteProduct(Long id);
}
