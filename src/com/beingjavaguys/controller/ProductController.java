package com.beingjavaguys.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.ModelAndView;

import com.beingjavaguys.domain.Product;
import com.beingjavaguys.service.ProductService;

@Controller
public class ProductController implements ServletContextAware {
	
	@Autowired
	private ProductService productService;
	
	private ServletContext context;

	@RequestMapping("/AddProduct")
	public ModelAndView getRegisterForm(@ModelAttribute("product") Product product,
			BindingResult result) {
		ArrayList<String> Brand = new ArrayList<String>();
		Brand.add("Canon");
		Brand.add("Sony");
		Brand.add("LG");
		Brand.add("Samsung");
		Brand.add("Philips");
		Brand.add("Apple");
		Brand.add("Motorola");
		Map<String, Object> model = new HashMap<String, Object>();
		
		model.put("brand", Brand);
		System.out.println("Product Form");
		return new ModelAndView("AddProduct", "model", model);
	}
	
	@RequestMapping("/saveProduct")
	public ModelAndView saveProduct(@RequestParam("prodImage") File file,@ModelAttribute("product") Product product,
			BindingResult result) {
		 byte[] bFile = new byte[(int) file.length()];
		 
	        try {
		     FileInputStream fileInputStream = new FileInputStream(file);
		     //convert file into array of bytes
		     fileInputStream.read(bFile);
		     fileInputStream.close();
	        } catch (Exception e) {
		     e.printStackTrace();
	        }
	        
	        product.setProdImage(bFile);
		productService.addProduct(product);
		System.out.println("Product Added Successfully");
		return new ModelAndView("redirect:/productList.html");
	}
	
	@RequestMapping("/productList")
	public ModelAndView getProductList(Model mode) {
		Map<String, Object> model = new HashMap<String, Object>();
		List<Product> product = productService.getProduct();
		
		Iterator<Product> iterator = product.iterator();
		List<Product> lstSearch= new ArrayList<Product>();
		if(!mode.containsAttribute("cart")) {
		      mode.addAttribute("cart", new ArrayList<Product>());
		    }
		while(iterator.hasNext())
		{
			Product next = iterator.next();
			
			
				try {
					File img=new File("C:\\Users\\himanshu.sati\\Downloads\\Spring-hibernate-integration-helloworld\\Spring-hibernate-integration-helloworld\\Spring-hibernate-integration-helloworld\\WebContent\\images\\"+next.getProdName()+".jpeg");

                //
                // Get the binary stream of our BLOB data
                //
				byte[] prodImage = next.getProdImage();
				
               
				FileOutputStream fos = new FileOutputStream(img);
			    fos.write(prodImage);
			    fos.close();
			
					next.setProdimgURL("http://localhost:9080/Spring-hibernate/images/"+next.getProdName()+".jpeg");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				lstSearch.add(next);
			}
			
		
		model.put("product", lstSearch);
		return new ModelAndView("productDetails", model);

	
	}

	@Override
	public void setServletContext(ServletContext arg0) {
		// TODO Auto-generated method stub
		this.context=arg0;
		
	}
}
