package com.example.JForceOnlineStrore.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.JForceOnlineStrore.Service.ProductService;

@RestController
@RequestMapping("/apiProduct")
@CrossOrigin("http://localhost:5173/")
public class ProductController {

	@Autowired
	ProductService service;

	@GetMapping("/addToCart/{userId}/{productId}")
	public String addToCart(@PathVariable String userId, @PathVariable String productId) {

		try {
			String addCart = service.addToCart(userId, productId);
			return addCart;
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}

	}

	@GetMapping("/buyProduct/{userId}/{productId}")
	public String buyProduct(@PathVariable String userId, @PathVariable String productId) {

		try {
			String buyNow = service.buyNow(userId, productId);
			return buyNow;
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}

	}

	@GetMapping("/updateProduct/{cartId}")
	public String updateProduct(@PathVariable Integer cartId) {

		try {
			String buyNow = service.updateStatus(cartId);
			return buyNow;
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}

	}
	
}
