package com.example.JForceOnlineStrore.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.JForceOnlineStrore.Model.Cart;
import com.example.JForceOnlineStrore.Model.Product;
import com.example.JForceOnlineStrore.Model.User;
import com.example.JForceOnlineStrore.Repository.CartRepository;
import com.example.JForceOnlineStrore.Repository.ProductRepository;
import com.example.JForceOnlineStrore.Repository.UserRepository;
import com.example.JForceOnlineStrore.Service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository repository;

	@Autowired
	CartRepository cartRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	ProductRepository productRepository;

	@Override
	public List<Product> showProducts() {
		return repository.findAll();
	}

	@Override
	public String addToCart(String userId, String productId) {

		String response = addProduct(userId, productId, "Cart");
		System.out.println("Product Added In Cart");

		return response;
	}

	@Override
	public String buyNow(String userId, String productId) {

		String response = addProduct(userId, productId, "Order");
		System.out.println("Product Order");

		return response;
	}

	public String addProduct(String userId, String productId, String orderType) {

		Cart cart = new Cart();
		Product product = productRepository.findById(Integer.valueOf(productId)).orElseThrow();
		User user = userRepository.findById(Integer.valueOf(userId)).orElseThrow();

		cart.setUserid(user);
		cart.setProductid(product);
		cart.setCartororder(orderType);

		cartRepository.save(cart);

		if (orderType.equals("Cart")) {
			return "Product Added To Cart";
		} else {
			return "Product Ordered Successfully";
		}
	}

	@Override
	public String updateStatus(Integer cartId) {
		Cart cart = cartRepository.findById(cartId).get();
		cart.setCartororder("Order");
		cartRepository.save(cart);

		return "Product Ordered Successfully";
	}

}
