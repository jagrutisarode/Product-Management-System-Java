package com.demo.service;

import java.util.List;

import com.demo.beans.Product;

public interface ProductService {

	void addNewProduct();

	List<Product> displayAll();

	Product findById(int id);

	Product findByName(String nm);

	boolean removeById(int id);

	boolean removeByName(String name);

	List<Product> sortByPrice();

	List<Product> displayByQuantity(int qty);

	boolean modifyPrice(int id, float pr);

	

	
	
	

}
