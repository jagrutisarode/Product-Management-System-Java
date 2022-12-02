package com.demo.comparator;

import java.util.Comparator;

import com.demo.beans.Product;

public class MyIdComparator implements Comparator<Product>{

	@Override
	public int compare(Product p1,Product p2) {
		
		return p1.getId()-p2.getId();
	}
			
	
}
