package edu.neu.csye6200;

import java.text.DecimalFormat;

public class Cart {
	private double myCash;
	private double myTotal;
	private double myChange;
	private static final DecimalFormat df = new DecimalFormat("0.00");
	
	Cart(int cash) {
		this.myCash = cash;
		this.myChange = cash;
//		this.items = new ArrayList<>();
	}
	
	// to calculate change (using copies of values and can't modify any originals).
	
	/* 
	 * If we don't change the value of originals (data members) then how will we be
	 * able to calculate the change properly.
	 * Also we don't have a return type
	*/
	
	public void sillyCheckout(double cash, double price, double total, double change) {
		this.myTotal = total + price;
		this.myChange = change - price;
	}
	
//	What is the use of passing Cart object in checkout if checkout is inside Cart class;
	
//	public double checkout(Cart myCart, Item myItem) {
//		return 0.0;
//	}
	
	public double getMyCash() {
		return myCash;
	}


	public double getMyTotal() {
		return myTotal;
	}


	public double getMyChange() {
		return myChange;
	}



	public double checkout(Item myItem) {
		this.myTotal+= myItem.getPrice();
		this.myChange-=myItem.getPrice();
		return this.myChange;
	}
	
	public double checkout(Cart myCart,Item myItem) {
		myCart.myChange-=myItem.getPrice();
		myCart.myTotal+=myItem.getPrice();
		return myCart.myChange;
	}
	

	public String toString() {
		StringBuilder str = new StringBuilder("");
		str.append("Cash given=" + String.valueOf(df.format(myCash))+"\n");
		str.append("Total Cost= "+String.valueOf(df.format(this.myTotal))+"\n");
		str.append("Change =" + String.valueOf(df.format(this.myChange)));
		return str.toString();
	}
}
