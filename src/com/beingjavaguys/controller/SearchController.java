package com.beingjavaguys.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.beingjavaguys.domain.Cart;
import com.beingjavaguys.domain.Product;
import com.beingjavaguys.domain.User;
import com.beingjavaguys.service.CartService;
import com.beingjavaguys.service.ProductService;

@Controller
public class SearchController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CartService cartService;
	
	@RequestMapping("/searchProduct")
	public ModelAndView getProductList(@RequestParam("searchText") String searchText) {
		Map<String, Object> model = new HashMap<String, Object>();
		List<Product> product = productService.getProduct();
		Iterator<Product> iterator = product.iterator();
		List<Product> lstSearch= new ArrayList<Product>();
		while(iterator.hasNext())
		{
			Product next = iterator.next();
			
			if(next.getProdBrand().contains(searchText)||next.getProdDesc().contains(searchText)||next.getProdName().contains(searchText))
			{
				try {
					File img=new File("C:\\storeimages\\"+next.getProdName()+".jpeg");

	                //
	                // Get the binary stream of our BLOB data
	                //
					byte[] prodImage = next.getProdImage();
					
	               
					FileOutputStream fos = new FileOutputStream(img);
				    fos.write(prodImage);
				    fos.close();
				
						next.setProdimgURL(img.getAbsolutePath());
					} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				lstSearch.add(next);
			}
			
		}
		model.put("product", lstSearch);
		return new ModelAndView("productDetails", model);

	}
	
	
	@RequestMapping("/addCart")
	public ModelAndView addProduct(@RequestParam("selectedItems") String selected_prod,HttpServletRequest request, HttpServletResponse response,@ModelAttribute("userLogin") User user,BindingResult result) {
		System.out.println("inside addCart mapping -----id for selected product is :----"+ selected_prod);
		
		Map<String, Object> model = new HashMap<String, Object>();
		int parseInt = Integer.parseInt(selected_prod);
		Product cartProd = productService.addcartProduct(parseInt);
		HttpSession httpSession = request.getSession();
		User attribute = (User)httpSession.getAttribute("userdetails");
		
		if(attribute==null)
		{	System.out.println("redirecting to Login page ");
			String message="LOGIN FIRST";
			return new ModelAndView("login","text", message);
			
		}
		Cart cart = attribute.getCart();
		if(cart==null)
		{
		cart = new Cart();
		cart.setUser(attribute);
		cartService.createCart(cart);
		}
		long cart_Id = cart.getCart_Id();
		long cartCost = cart.getCartCost();
		int prodPrice = cartProd.getProdPrice();
		cart.setCartCost(cartCost+prodPrice);
		Set<Product> updateCart = cartService.updateCart(cart_Id,cart.getCartCost(),cartProd);
		long cartCost2 = cart.getCartCost();
		model.put("carCost", cartCost2);
		model.put("products", updateCart);
		System.out.println("cart id for user " + attribute.getFirstName()+ " is " + cart_Id);
		System.out.println(cart.getCartCost());
		return new ModelAndView("UserCart", model);
		
		
	}
	
	
	@RequestMapping("/openProduct")
	public ModelAndView openProduct(@RequestParam(value = "name") String name,HttpServletRequest request, HttpServletResponse response) {
		System.out.println("id for selected product is :----"+ name);
		Map<String, Object> model = new HashMap<String, Object>();
		Product cartProd = productService.addcartProduct(Integer.parseInt(name));
		model.put("item", cartProd);
		return new ModelAndView("ProductDescription",model);
		
	}
	
	@RequestMapping("/cartCheckout")
	public ModelAndView cartCheckout(@RequestParam(value = "cartValue") String Value,HttpServletRequest request, HttpServletResponse response) {
		
		int parseInt = Integer.parseInt(Value);
		System.out.println(parseInt);
		return null;
		
	}
	
	
}
