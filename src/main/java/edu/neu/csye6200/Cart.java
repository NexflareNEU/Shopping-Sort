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
    this.myCash = cash * Constants.HUNDRED;
    this.myChange = cash * Constants.HUNDRED;
  }


  /**
   * @param cash
   * @param price
   * @param total
   * @param change
   */
  public void sillyCheckout(final double cash, final double price,
      final double total, final double change) {
    double _total = total + price * Constants.HUNDRED;
    double _change = change - price * Constants.HUNDRED;
    System.out.println("Total = " + DF.format(_total / Constants.HUNDRED)
        + " Change = " + DF.format(_change / Constants.HUNDRED));
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
    this.myTotal += (myItem.getPrice() * Constants.HUNDRED);
    this.myChange -= (myItem.getPrice() * Constants.HUNDRED);
    return this.myChange;
  }

  /**
   * @param myCart
   * @param myItem
   * @return the change left with the user
   */
  public double checkout(final Cart myCart, final Item myItem) {
    myCart.myChange -= (myItem.getPrice() * Constants.HUNDRED);
    myCart.myTotal += (myItem.getPrice() * Constants.HUNDRED);
    double change = ((double) myCart.myChange) / Constants.HUNDRED;
    return change;
  }

  /**
   * @return the final values of cash, total and change
   */
  public String toString() {
    StringBuilder str = new StringBuilder("");
    double _myCash = (double) this.myCash / Constants.HUNDRED;
    double _myTotal = (double) this.myTotal / Constants.HUNDRED;
    double _myChange = (double) this.myChange / Constants.HUNDRED;
    str.append("Cash given = " + String.valueOf(DF.format(_myCash)));
    str.append("\n");
    str.append("Total Cost = " + String.valueOf(DF.format(_myTotal)));
    str.append("\n");
    str.append("Change = " + String.valueOf(DF.format(_myChange)));
    return str.toString();
  }
}
