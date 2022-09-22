package edu.neu.csye6200;

import java.text.DecimalFormat;

/**
 * @author nexflare
 */
public class Cart {
  /**
   * myCash is the initial cash user gives in the constructor.
   */
  private int myCash;

  /**
   * myTotal is the total value of cart during checkout.
   */
  private int myTotal;

  /**
   * myChange is final change user will get after checkout.
   */
  private int myChange;


  /**
   * decimal formatter to get only 2 values after a decimal.
   */
  private static final DecimalFormat DF = new DecimalFormat("0.00");

  /**
   * @param cash
   */
  Cart(final int cash) {
    this.myCash = cash * 100;
    this.myChange = cash * 100;
  }


  /**
   * @param cash
   * @param price
   * @param total
   * @param change
   */
  public void sillyCheckout(final double cash, final double price, double total,
      double change) {
    total += price * 100;
    change -= price * 100;
    System.out.println("Total = " + DF.format(total / 100) + " Change = "
        + DF.format(change / 100));
  }

  /**
   * @return the value of myCash
   */
  public int getMyCash() {
    return myCash;
  }

  /**
   * @return the value of myTotal
   */
  public int getMyTotal() {
    return myTotal;
  }

  /**
   * @return the value of myChange
   */
  public int getMyChange() {
    return myChange;
  }

  /**
   * @param myItem
   * @return the change left with the user
   */
  public double checkout(final Item myItem) {
    this.myTotal += (myItem.getPrice() * 100);
    this.myChange -= (myItem.getPrice() * 100);
    return this.myChange;
  }

  /**
   * @param myCart
   * @param myItem
   * @return the change left with the user
   */
  public double checkout(final Cart myCart, final Item myItem) {
    myCart.myChange -= (myItem.getPrice() * 100);
    myCart.myTotal += (myItem.getPrice() * 100);
    double change = ((double) myCart.myChange) / 100;
    return change;
  }

  /**
   * @return the final values of cash, total and change
   */
  public String toString() {
    StringBuilder str = new StringBuilder("");
    double myCash = (double) this.myCash / 100;
    double myTotal = (double) this.myTotal / 100;
    double myChange = (double) this.myChange / 100;
    str.append("Cash given = " + String.valueOf(DF.format(myCash)));
    str.append("\n");
    str.append("Total Cost = " + String.valueOf(DF.format(myTotal)));
    str.append("\n");
    str.append("Change = " + String.valueOf(DF.format(myChange)));
    return str.toString();
  }
}
