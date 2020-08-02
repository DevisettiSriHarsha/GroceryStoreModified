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

class CustomerTest {

	@Test
	void test() {
		
		RetailShop retail=new RetailShopImp();
		List<Product> list=new ArrayList<Product>();
		
		Product product=new Product();
		Product product1=new Product();
		
		User user=new User();
		user.setUserId(45);
		user.setUserName("Chintu");
		user.setUsertype(UserDetails.CUSTOMER);
		user.setRegistrationDate(LocalDate.now());
		
		product.setProductId(5021);
		product.setProductName("Rice");
		product.setProductType(ProductDetails.GROCERIES);
		product.setQuantity(15);
		product.setRatePerQuantity(45);
		
		list.add(product);
		
		product1.setProductId(100234);
		product1.setProductName("Panner");
		product1.setProductType(ProductDetails.DAIRYPRODUCTS);
		product1.setQuantity(2);
		product1.setRatePerQuantity(120);
		
		list.add(product1);
		user.setProduct(list);
		double bill=retail.calculateBill(user);
		System.out.println(bill);
		assertEquals(190, bill);
}

}
