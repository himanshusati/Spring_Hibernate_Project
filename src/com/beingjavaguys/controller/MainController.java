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

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.ModelAndView;

import com.beingjavaguys.domain.Product;
import com.beingjavaguys.domain.User;
import com.beingjavaguys.service.ProductService;

@Controller
public class MainController implements ServletContextAware{
	
	@Autowired
	private ProductService productService;
	
	private ServletContext context;
	
	@RequestMapping( value="/HomePage", method=RequestMethod.GET)
	public ModelAndView getHomePage(Model mode) {
		Map<String, Object> model = new HashMap<String, Object>();
		List<Product> product = productService.getProduct();
		String contextpath = context.getRealPath("");
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
		return new ModelAndView("HomePage", model);

	
	}
	
	
	@RequestMapping("/login")
	public ModelAndView getLoginPage(@ModelAttribute("userLogin") User user,
			BindingResult result) {
		
		System.out.println("Login Form");
		return new ModelAndView("login");
	}
	
	@RequestMapping("/logout")
	public ModelAndView logoutPage(@ModelAttribute("userLogin") User user,
			BindingResult result,HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.invalidate();
		
		return new ModelAndView("login");
	}


	@Override
	public void setServletContext(ServletContext arg0) {
		// TODO Auto-generated method stub
		this.context=arg0;
	}
}
