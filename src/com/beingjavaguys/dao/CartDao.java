package com.beingjavaguys.dao;

import java.util.Set;

import com.beingjavaguys.domain.Cart;
import com.beingjavaguys.domain.Product;

public interface CartDao {
	
	public void saveCart ( Cart cart );
	public Set<Product> updatecart(long cart_id,long cart_cost,Product cartProd);

}
