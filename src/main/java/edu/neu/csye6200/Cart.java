package edu.neu.csye6200;

import java.text.DecimalFormat;

/**
 * @author nexflare
 */
public class Cart {
  /**
   * myCash is the initial cash user gives in the constructor.
   */
  private double myCash;

  /**
   * myTotal is the total value of cart during checkout.
   */
  private double myTotal;

  /**
   * myChange is final change user will get after checkout.
   */
  private double myChange;


  /**
   * decimal formatter to get only 2 values after a decimal.
   */
  private static final DecimalFormat DF = new DecimalFormat("0.00");

  /**
   * @param cash
   */
  Cart(final int cash) {
    this.myCash = cash;
    this.myChange = cash;
  }


  /**
   * @param cash
   * @param price
   * @param total
   * @param change
   */
  public void sillyCheckout(final double cash, final double price,
      final double total, final double change) {
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
  public double checkout(final Item myItem) {
    this.myTotal += myItem.getPrice();
    this.myChange -= myItem.getPrice();
    return this.myChange;
  }

  /**
   * @param myCart
   * @param myItem
   * @return the change left with the user
   */
  public double checkout(final Cart myCart, final Item myItem) {
    myCart.myChange -= myItem.getPrice();
    myCart.myTotal += myItem.getPrice();
    return myCart.myChange;
  }

  /**
   * @return the final values of cash, total and change
   */
  public String toString() {
    StringBuilder str = new StringBuilder("");
    str.append("Cash given = " + String.valueOf(DF.format(myCash)));
    str.append("/n");
    str.append("Total Cost = " + String.valueOf(DF.format(this.myTotal)));
    str.append("/n");
    str.append("Change = " + String.valueOf(DF.format(this.myChange)));
    return str.toString();
  }
}
