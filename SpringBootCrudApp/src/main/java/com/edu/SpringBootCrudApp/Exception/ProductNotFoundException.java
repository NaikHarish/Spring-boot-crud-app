package com.edu.SpringBootCrudApp.Exception;

public class ProductNotFoundException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductNotFoundException(String string) {
        super(string);
    }
}
