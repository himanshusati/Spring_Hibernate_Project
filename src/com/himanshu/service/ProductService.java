package com.himanshu.service;

import java.util.List;

import com.himanshu.domain.Product;

public interface ProductService {

	public void addProduct(Product product);

	public List<Product> getProduct();
	
	public Product addcartProduct(int productID);
}
