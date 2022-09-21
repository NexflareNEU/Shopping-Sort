package edu.neu.csye6200;

import java.text.DecimalFormat;

/**
 * @author nexflare
 */
public class Cart {
  private double myCash;
  private double myTotal;
  private double myChange;
  private static final DecimalFormat df = new DecimalFormat("0.00");

  /**
   * @param cash
   */
  Cart(int cash) {
    this.myCash = cash;
    this.myChange = cash;
  }


  /**
   * @param cash
   * @param price
   * @param total
   * @param change
   */
  public void sillyCheckout(double cash, double price, double total, double change) {
    this.myTotal = total + price;
    this.myChange = change - price;
  }

  /**
   * @return the value of myCash
   */
  public double getMyCash() {
    return myCash;
  }

  /**
   * @return the value of myTotal
   */
  public double getMyTotal() {
    return myTotal;
  }

  /**
   * @return the value of myChange
   */
  public double getMyChange() {
    return myChange;
  }

  /**
   * @param myItem
   * @return the change left with the user
   */
  public double checkout(Item myItem) {
    this.myTotal += myItem.getPrice();
    this.myChange -= myItem.getPrice();
    return this.myChange;
  }

  /**
   * @param myCart
   * @param myItem
   * @return the change left with the user
   */
  public double checkout(Cart myCart, Item myItem) {
    myCart.myChange -= myItem.getPrice();
    myCart.myTotal += myItem.getPrice();
    return myCart.myChange;
  }

  /**
   * @return the final values of cash, total and change
   */
  public String toString() {
    StringBuilder str = new StringBuilder("");
    str.append("Cash given = " + String.valueOf(df.format(myCash)));
    str.append("/n");
    str.append("Total Cost = " + String.valueOf(df.format(this.myTotal)));
    str.append("/n");
    str.append("Change = " + String.valueOf(df.format(this.myChange)));
    return str.toString();
  }
}
