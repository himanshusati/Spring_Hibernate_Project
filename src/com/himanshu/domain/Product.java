package com.himanshu.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT")
public class Product {

	@Id
	@GeneratedValue
	@Column(name = "prod_id")
	private int id;
	
	@Column(name = "prod_name")
	private String prodName;
	
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "cartProducts")
	private Set<Cart> stocks = new HashSet<Cart>(0);
	
	public Set<Cart> getStocks() {
		return stocks;
	}

	public void setStocks(Set<Cart> stocks) {
		this.stocks = stocks;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getProdBrand() {
		return prodBrand;
	}

	public void setProdBrand(String prodBrand) {
		this.prodBrand = prodBrand;
	}

	public int getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(int prodPrice) {
		this.prodPrice = prodPrice;
	}

	public String getProdDesc() {
		return prodDesc;
	}

	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}

	@Column(name="prod_image",columnDefinition="mediumblob")
	private byte[] prodImage;
	public byte[] getProdImage() {
		return prodImage;
	}

	public void setProdImage(byte[] bFile) {
		this.prodImage = bFile;
	}

	@Column(name="prod_imgURL")
	private String prodimgURL;
	public String getProdimgURL() {
		return prodimgURL;
	}

	public void setProdimgURL(String prodimgURL) {
		this.prodimgURL = prodimgURL;
	}

	@Column(name = "prod_brand")
	private String prodBrand;
	
	@Column(name = "prod_price")
	private int prodPrice;
	
	@Column(name = "prod_Desc")
	private String prodDesc;
}
