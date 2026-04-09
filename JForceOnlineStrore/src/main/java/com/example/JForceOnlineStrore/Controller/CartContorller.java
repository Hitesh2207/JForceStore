package com.example.JForceOnlineStrore.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.JForceOnlineStrore.Model.Cart;
import com.example.JForceOnlineStrore.Service.CartService;

@RestController
@RequestMapping("/apiCart")
@CrossOrigin("http://localhost:5173/")
public class CartContorller {

	@Autowired
	CartService service;

	@GetMapping("/cartData")
	public ResponseEntity<List<Cart>> showProduct() {

		try {
			List<Cart> cartData = service.showCart();

			return new ResponseEntity<>(cartData, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

}
