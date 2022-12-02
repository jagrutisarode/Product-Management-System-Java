package com.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.demo.beans.Product;
import com.demo.comparator.MyIdComparator;
import com.demo.comparator.MyNameComparator;

public class ProductServiceimpl implements ProductService {

	static List<Product> plist;
	static {
		plist=new ArrayList<>();
		plist.add(new Product(11,"Chocos",80,358.9f));
		plist.add(new Product(301,"Mobile",10,25000f));
		plist.add(new Product(302,"Charger",25,1000f));
		plist.add(new Product(303,"Power Bank",23,2100.6f));
		plist.add(new Product(12,"Aloo Bhujia",325,40.2f));
	}

	@Override
	public void addNewProduct() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Product ID :");
		int id=sc.nextInt();
		System.out.println("Enter the Product Name :");
		String nm=sc.next();
		System.out.println("Enter the Product qty :");
		int qty=sc.nextInt();
		System.out.println("Enter the Price of Product :");
		float price=sc.nextFloat();
		Product p=new Product(id,nm,qty,price);
		plist.add(p);
	}
	
	@Override
	public List<Product> displayAll() {
		if(plist.size()>0) {
			return plist;
		}
		return null;	
	}

	@Override
	public Product findById(int id) {
		int pos=plist.indexOf(new Product(id));
		if(pos!=-1) {
			return plist.get(pos);
		}	
		return null;
	}
	
	@Override
	public Product findByName(String nm) {
		for(Product p:plist) {
			if(p.getName().equals(nm)) {
				return p;
			}
		}
		return null;
	}

	@Override
	public boolean removeById(int id) {
	
		return plist.remove(new Product(id));
		
	}

	@Override
	public boolean removeByName(String name) {
		Product p=findByName(name);
		
		if(p!=null) {
			Scanner sc=new Scanner(System.in);
			System.out.println("Do you want to remove the item (y/n)?");
			String read=sc.next();
			if(read.equals("y")) {
				plist.remove(p);
				return true;
			}
		}else {
			return false;
		}return false;		
	}

	@Override
	public List<Product> sortByPrice() {
		//for comparable interface use this.
		
		/*plist.sort(null);
		return plist;*/
		//for comparator use this.
		plist.sort(new MyIdComparator());
		return plist;
	}

	@Override
	public List<Product> displayByQuantity(int qty) {
		 List<Product> newlist = plist.stream().filter(x -> x.getQty()>=qty).collect(Collectors.toList());
		return newlist;
	}

	@Override
	public boolean modifyPrice(int id, float pr) {
		int pos = plist.indexOf(new Product(id));
		if(pos!=-1)
		{
			Product p = plist.get(pos);
			p.setPrice(pr);
			return true;
		}
		
		return false;
	}

	

	
	


	
		
	
		
		// Remove by name // alternative Not functional
		/*for(Product p:plist)
		{
			if(p.getName().equals(name))
			{
				System.out.println(p.getName()+"==="+name);
				plist.remove(p);
				return true;
			}
			return false;
		}return false;*/
		
	
}
