package com.example.JForceOnlineStrore.Service;

import java.util.List;

import com.example.JForceOnlineStrore.Model.Product;

public interface ProductService {

	public List<Product> showProducts();

	public String addToCart(String userId, String productId);

	public String buyNow(String userId, String productId);

	public String updateStatus(Integer cartId);

}
