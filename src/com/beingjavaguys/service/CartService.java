package com.beingjavaguys.service;

import java.util.Set;

import com.beingjavaguys.domain.Cart;
import com.beingjavaguys.domain.Product;

public interface CartService {

	public void createCart(Cart cart);
	
	public  Set<Product> updateCart(long cart_id,long cart_cost,Product cartProd);
}
