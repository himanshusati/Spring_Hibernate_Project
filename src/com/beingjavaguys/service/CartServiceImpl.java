package com.beingjavaguys.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.beingjavaguys.dao.CartDao;
import com.beingjavaguys.domain.Cart;
import com.beingjavaguys.domain.Product;


@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CartServiceImpl implements CartService{

	
	@Autowired
	CartDao cartDao;


	@Override
	public void createCart(Cart cart) {
		// TODO Auto-generated method stub
		
		cartDao.saveCart(cart);
	}


	@Override
	public Set<Product> updateCart(long cart_id,long cart_cost,Product cartProd) {
		// TODO Auto-generated method stub
		return cartDao.updatecart(cart_id,cart_cost,cartProd);
		
	}
	
}
