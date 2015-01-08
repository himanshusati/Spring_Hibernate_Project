package com.himanshu.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.himanshu.domain.Product;
import com.himanshu.domain.User;

@Repository("productDao")
public class ProductDaoImpl implements ProductDao{

	@Autowired
	private SessionFactory sessionfactory;
	
	@Override
	public void saveProduct(Product product) {
		// TODO Auto-generated method stub
		sessionfactory.getCurrentSession().saveOrUpdate(product);
	}

	@Override
	public List<Product> getProduct() {
		@SuppressWarnings("unchecked")
		List<Product> productlist = sessionfactory.getCurrentSession()
				.createCriteria(Product.class).list();
		return productlist;
	}
	
	@Override
	public Product addProduct(int productID) {
		// TODO Auto-generated method stub
		Query createQuery = sessionfactory.getCurrentSession().createQuery("FROM Product WHERE id = :id");
		createQuery.setParameter("id", productID);
		Object uniqueResult = createQuery.uniqueResult();
		return (Product) uniqueResult;
	}

}
