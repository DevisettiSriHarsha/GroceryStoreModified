package com.capg.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.capg.beans.Product;
import com.capg.beans.ProductDetails;
import com.capg.beans.User;
import com.capg.beans.UserDetails;
import com.capg.service.RetailShop;
import com.capg.service.RetailShopImp;

class AffiliateTest {
	
	@Test
	void test() {
		
		RetailShop retail=new RetailShopImp();
		List<Product> list=new ArrayList<Product>();
		Product product=new Product();
		Product product1=new Product();
		User user=new User();
		
		user.setUserId(2);
		user.setUserName("Bhantu");
		user.setUsertype(UserDetails.AFFILIATE );
		user.setRegistrationDate(LocalDate.now());
		
		product.setProductId(182938);
		product.setProductName("Colgate ToothPaste");
		product.setProductType(ProductDetails.GROCERIES);
		product.setQuantity(1);
		product.setRatePerQuantity(56);
		list.add(product);
		
		product1.setProductId(10037282);
		product1.setProductName("Curd");
		product1.setProductType(ProductDetails.DAIRYPRODUCTS);
		product1.setQuantity(3);
		product1.setRatePerQuantity(42);
		list.add(product1);
		
		user.setProduct(list);
		double bill=retail.calculateBill(user);
		System.out.println(bill);
		assertEquals(185, bill);
		
	}


}
