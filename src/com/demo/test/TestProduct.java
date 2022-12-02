package com.demo.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.demo.beans.Product;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceimpl;

public class TestProduct {

	public static void main(String[] args) {
		ProductService pservice=new ProductServiceimpl();

		Scanner sc=new Scanner(System.in);
		int choice=0;
		do {
			System.out.println("1. Add new product\n2. Remove by id\n3. Remove by name");
			System.out.print("4. Display all\n5. Find by id\n6. Sort by price\n");
			System.out.print("7. Display all with qty > Given qty\n8. Modify price "
					+ "\n9.Find by name \n10. Exit\n ");

			System.out.println("Enter your choice...");
			choice=sc.nextInt();

			switch(choice) {
			
			case 1:
				pservice.addNewProduct();
				break;

			case 2:
				System.out.println("Enter the Id : ");
				int id1 = sc.nextInt();
				boolean status = pservice.removeById(id1);
				if(status)
				{
					System.out.println("Removed Successfully");
				}
				else
				{
					System.out.println("Not found");
				}
				break;

			case 3:
				
				System.out.println("Enter the name of product you want to remove :");
				String name = sc.next();
				boolean status1 = pservice.removeByName(name);
				if(status1)
				{
					System.out.println("Removed Successfully");
				}
				else
				{
					System.out.println("Not found");
				}
				break;

			case 4:
				List<Product> plist=pservice.displayAll();
				Iterator<Product> it=plist.iterator();
				while(it.hasNext()) {
					System.out.println(it.next());
				}
				break;

			case 5:
				System.out.println("Enter the ID of the product which you want to find : ");
				int id=sc.nextInt();
				Product p=pservice.findById(id);
				if(p!=null) {
					System.out.println(p);
				}else {
					System.out.println("Product not found");
				}
				break;

			case 6:
				List<Product> plist1=pservice.sortByPrice();
				if(plist1!=null)
				{
					for(Product p1 : plist1)
					{
						System.out.println(p1);
					}
				}
				break;

			case 7:
				System.out.println("Enter the quantity : ");
				int qty = sc.nextInt();
				List<Product> plist11 = pservice.displayByQuantity(qty);
				for(Product p1:plist11)
				{
					System.out.println(p1);
				}
				break;

			case 8:
				System.out.println("Enter the Product id :");
				int id11 = sc.nextInt();
				System.out.println("Enter the price you want to update: ");
				float pr=sc.nextFloat();
				boolean setpr=pservice.modifyPrice(id11, pr);
				if(setpr) {
					System.out.println("Updated Successfully");
					
				}else {
					System.out.println("Can't Update the price");
				}

				break;

			case 9:
				System.out.println("Enter the name of the product which you want to find : ");
				String nm=sc.next();
				Product p1=pservice.findByName(nm);
				if(p1!=null) {
					System.out.println(p1);
				}else {
					System.out.println("Product not found");
				}
				break;

			case 10:
				System.out.println("Thank you...");
				sc.close();
				break;

			}

		}while(choice!=10);
	}

}
