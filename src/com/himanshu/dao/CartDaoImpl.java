package com.himanshu.dao;

import java.util.Set;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.himanshu.domain.Cart;
import com.himanshu.domain.Product;
@Repository("cartDao")
public class CartDaoImpl implements CartDao {

	@Autowired
	private SessionFactory sessionfactory;
	
	@Autowired
	private HibernateTransactionManager hibernateTransactionManager;
	
	@Override
	public void saveCart(Cart cart) {
		// TODO Auto-generated method stub
		sessionfactory.getCurrentSession().saveOrUpdate(cart);
	}

	@Override
	@Transactional
	public Set<Product> updatecart(long cart_id,long cart_cost,Product cartProd) {
		// TODO Auto-generated method stub
		
		boolean check=false;
		
		Cart cart = (Cart)sessionfactory.getCurrentSession().get(Cart.class, cart_id);
		cart.setCartCost(cart_cost);
		Set<Product> cartProducts = cart.getCartProducts();
		
		for(Product p: cartProducts)
		{
			int id = p.getId();
			if(cartProd.getId()==id)
				check=true;
			
		}
		
		if(check==false)
		{
		cart.getCartProducts().add(cartProd);
		sessionfactory.getCurrentSession().update(cart);
		
		}
		
		Set<Product> cartProducts2 = cart.getCartProducts();
		
		return cartProducts2;
		}
		
		

}
