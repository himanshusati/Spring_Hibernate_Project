package com.himanshu.dao;

import java.util.Set;

import com.himanshu.domain.Cart;
import com.himanshu.domain.Product;

public interface CartDao {
	
	public void saveCart ( Cart cart );
	public Set<Product> updatecart(long cart_id,long cart_cost,Product cartProd);

}
