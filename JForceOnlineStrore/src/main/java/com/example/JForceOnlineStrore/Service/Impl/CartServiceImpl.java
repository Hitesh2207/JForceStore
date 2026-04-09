package com.example.JForceOnlineStrore.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.JForceOnlineStrore.Model.Cart;
import com.example.JForceOnlineStrore.Repository.CartRepository;
import com.example.JForceOnlineStrore.Service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	CartRepository cartRepository;

	@Override
	public List<Cart> showCart() {
		return cartRepository.findAll();

	}

}
