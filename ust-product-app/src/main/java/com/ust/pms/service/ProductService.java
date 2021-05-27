package com.ust.pms.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ust.pms.Model.Product;
@Service
public class ProductService {
	
	private List<Product> products= new ArrayList<>( Arrays.asList(
			new Product(1,"Mouse",1500,125),
			new Product(2,"Laptop",85500,225),
			new Product(3,"Mobile",1699,85),
			new Product(4,"Toys",500,725),
			new Product(5,"Shoes",999,250)
			))  ;
	
	public List<Product> getproducts() {
		return products;
	}

	public Product getproduct(Integer productId) {
		return products.stream().filter(t-> t.getProductId()== productId).findFirst().get();
	}
	
	public void saveproduct(Product product) {
		products.add(product);
	}
	
	public void deleteProduct(Integer productid) {
		products.removeIf(t->t.getProductId()==productid);
	}
	
	public void updateProduct(Product product) {
		for(int i=0;i<products.size();i++) {
			Product p=products.get(i);
			if(p.getProductId()==product.getProductId()) {
				products.set(i, product);
				return;
			}
		}
	}
}
