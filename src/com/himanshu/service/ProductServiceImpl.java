package com.himanshu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.himanshu.dao.ProductDao;
import com.himanshu.domain.Product;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductDao productDao;
	
	@Override
	public void addProduct(Product product) {
		productDao.saveProduct(product);
		
	}

	@Override
	public List<Product> getProduct() {
		return productDao.getProduct();
	}

	@Override
	public Product addcartProduct(int productID) {
		// TODO Auto-generated method stub
		return productDao.addProduct(productID);
	}

}
