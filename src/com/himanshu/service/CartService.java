package com.himanshu.service;

import java.util.Set;

import com.himanshu.domain.Cart;
import com.himanshu.domain.Product;

public interface CartService {

	public void createCart(Cart cart);
	
	public  Set<Product> updateCart(long cart_id,long cart_cost,Product cartProd);
}
