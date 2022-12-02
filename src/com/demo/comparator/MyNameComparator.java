package com.demo.comparator;

import java.util.Comparator;

import com.demo.beans.Product;

public class MyNameComparator implements Comparator<Product> {
	public int compare(Product p1,Product p2)
	{
		System.out.println("In Comparator...");
		System.out.println(p1.getName()+"==="+p2.getName());
		if(p1.getName().equals(p2.getName()))
			return p1.getId()-p2.getId();
		else {
			return p1.getName().compareTo(p2.getName());
		}
		//return p1.getName().compareTo(p2.getName());//String method
	
	}
}
