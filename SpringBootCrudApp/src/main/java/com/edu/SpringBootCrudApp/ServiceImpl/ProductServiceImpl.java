package com.edu.SpringBootCrudApp.ServiceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.edu.SpringBootCrudApp.Entity.Product;
import com.edu.SpringBootCrudApp.Exception.ProductNotFoundException;
import com.edu.SpringBootCrudApp.Repository.ProductRepository;
import com.edu.SpringBootCrudApp.Service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;
	
	public ProductServiceImpl(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

	@Override
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product getProductById(Long id) {
		return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with ID: " + id));
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product updateProduct(Long id, Product product) {
		Product pro = getProductById(id);
        pro.setName(product.getName());
        pro.setDescription(product.getDescription());
        pro.setPrice(product.getPrice());
        return productRepository.save(pro);
	}

	@Override
	public void deleteProduct(Long id) {
		if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException("Product not found with ID: " + id);
        }
        productRepository.deleteById(id);
	}
}
