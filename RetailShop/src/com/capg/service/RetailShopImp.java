package com.capg.service;

import java.time.LocalDate;

import com.capg.beans.Product;
import com.capg.beans.ProductDetails;
import com.capg.beans.User;
import com.capg.beans.UserDetails;

public class RetailShopImp implements RetailShop{

	@Override
	public double calculateBill(User user) {

		double discount=0.0,withoutGroceryTotal=0.0,groceryTotal=0.0,totalPrice=0.0;
		int commonDiscount=0;
		
		for(Product product:user.getProduct())
		{
			if(product.getProductType()==ProductDetails.GROCERIES)
			{
				groceryTotal=groceryTotal+(product.getQuantity()*product.getRatePerQuantity());
			}
			else
			{
				withoutGroceryTotal=withoutGroceryTotal+(product.getQuantity()*product.getRatePerQuantity());
			}
		}
		
		if(user.getUsertype()==UserDetails.EMPLOYEE) {
			discount=withoutGroceryTotal*0.30;
			totalPrice=(groceryTotal+withoutGroceryTotal)-discount;
		}
		
		else if(user.getUsertype()==UserDetails.AFFILIATE) {
			discount=withoutGroceryTotal*0.10;
			totalPrice=(groceryTotal+withoutGroceryTotal)-discount;
		}
		
		else
		{
			int yearDifference=LocalDate.now().getYear()-user.getRegistrationDate().getYear();
			if(yearDifference>=2) {
				discount=withoutGroceryTotal*0.05;
				totalPrice=(groceryTotal+withoutGroceryTotal)-discount;
			}
			else {
				user.setRegistrationDate(LocalDate.now());
				totalPrice=(groceryTotal+withoutGroceryTotal);
			}
		}
		commonDiscount=(int)totalPrice;
		totalPrice=totalPrice-((commonDiscount/100)*5);
		return totalPrice;
		}
	}


