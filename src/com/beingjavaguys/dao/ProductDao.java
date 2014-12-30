package com.beingjavaguys.dao;

import java.util.List;

import com.beingjavaguys.domain.Product;

public interface ProductDao {
	
	public void saveProduct ( Product product );
	public List<Product> getProduct();
	public Product addProduct(int productID);
}
