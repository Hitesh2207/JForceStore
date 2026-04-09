package com.example.JForceOnlineStrore.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.JForceOnlineStrore.Model.Product;
import com.example.JForceOnlineStrore.Service.HomeService;
import com.example.JForceOnlineStrore.Service.ProductService;

@RestController
@RequestMapping("/apiHome")
@CrossOrigin("http://localhost:5173/")
public class HomeContoller {

	@Autowired
	HomeService homeService;

	@Autowired
	ProductService service;

	@GetMapping("/products")
	public ResponseEntity<List<Product>> showProduct() {

		try {
			List<Product> userRegister = service.showProducts();
			return new ResponseEntity<>(userRegister, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

}
