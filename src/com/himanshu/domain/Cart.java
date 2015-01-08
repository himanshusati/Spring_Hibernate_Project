package com.himanshu.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

@Entity
@Table(name = "CART")
public class Cart {

	@Id
	@GeneratedValue
	@Column(name = "Id")
	private long cart_Id;
	
	
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "cart_product", joinColumns = { 
			@JoinColumn(name = "cart_Id") }, 
			inverseJoinColumns = { @JoinColumn(name = "prod_id", 
					nullable = false, updatable = false) })
	private Set<Product> cartProducts = new HashSet<Product>(0);
	
	public Set<Product> getCartProducts() {
		return cartProducts;
	}

	public void setCartProducts(Set<Product> cartProducts) {
		this.cartProducts = cartProducts;
	}

	public long getCart_Id() {
		return cart_Id;
	}

	public void setCart_Id(long cart_Id) {
		this.cart_Id = cart_Id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public long getCartCost() {
		return cartCost;
	}

	public void setCartCost(long cartCost) {
		this.cartCost = cartCost;
	}

	@OneToOne
    @PrimaryKeyJoinColumn
    private User user;
	
	@Column(name = "cart_cost")
	private long cartCost;
}
