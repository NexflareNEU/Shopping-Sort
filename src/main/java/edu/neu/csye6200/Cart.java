package edu.neu.csye6200;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

  private List<Item> shoppingBag;


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
    this.shoppingBag = new ArrayList<>();
  }


  /**
   * @param cash
   * @param price
   * @param total
   * @param change
   */
  public void sillyCheckout(final double cash, final double price,
      final double total, final double change) {
    double totalVal = total + price * Constants.HUNDRED;
    double changeVal = change - price * Constants.HUNDRED;
    System.out.println("Total = " + DF.format(totalVal / Constants.HUNDRED)
        + " Change = " + DF.format(changeVal / Constants.HUNDRED));
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
  public double checkoutCart(final Cart myCart, final Item myItem) {
    myCart.myChange -= (myItem.getPrice() * Constants.HUNDRED);
    myCart.myTotal += (myItem.getPrice() * Constants.HUNDRED);
    double change = ((double) myCart.myChange) / Constants.HUNDRED;
    return change;
  }

  public void addItem(Item item) {
    shoppingBag.add(item);
  }

  public void checkout() {
    System.out.println("Hey CSYE6000!!");
    System.out.println("Here is your bill :)");
    for (int i = 0; i < this.shoppingBag.size(); i++) {
      checkoutCart(this, this.shoppingBag.get(i));
      System.out.println(this.shoppingBag.get(i).toString());
    }
    // System.out.println(String.valueOf(this.myChange));
    System.out.println(this.toString());
  }


  /**
   * @return the final values of cash, total and change
   */
  public String toString() {
    StringBuilder str = new StringBuilder("");
    double cash = (double) this.myCash / Constants.HUNDRED;
    double total = (double) this.myTotal / Constants.HUNDRED;
    double change = (double) this.myChange / Constants.HUNDRED;
    str.append("Cash given = " + String.valueOf(DF.format(cash)));
    str.append(" ");
    str.append("Total Cost = " + String.valueOf(DF.format(total)));
    str.append(" ");
    str.append("Change = " + String.valueOf(DF.format(change)));
    return str.toString();
  }


  public void sortByName() {
    // shoppingBag.sort(new SortByName());
    Collections.sort(shoppingBag, new SortByName());
    System.out.println("Sort by Name");
    for (int i = 0; i < shoppingBag.size(); i++) {
      System.out.println(shoppingBag.get(i).toString());
    }
    System.out.println("\n \n");
  }

  public void sortById() {
    System.out.println("Sort by Id");
    Collections.sort(shoppingBag, new SortById());
    for (int i = 0; i < shoppingBag.size(); i++) {
      System.out.println(shoppingBag.get(i).toString());
    }
    System.out.println("\n \n");
  }

  public void sortByPrice() {
    System.out.println("Sort by Price");
    Collections.sort(shoppingBag, new SortByPrice());
    for (int i = 0; i < shoppingBag.size(); i++) {
      System.out.println(shoppingBag.get(i).toString());
    }
    System.out.println("\n \n");
  }

  public static void demo() {

    Item milk = new Item("#2", "Milk", 2.49);
    Item Bread = new Item("#4", "Bread", 1.49);
    Item OJ = new Item("#3", "OJ", 3.49);
    Item Candy = new Item("#1", "Candy", 0.99);

    Cart cartObj = new Cart(20);
    cartObj.addItem(milk);
    cartObj.addItem(Bread);
    cartObj.addItem(OJ);
    cartObj.addItem(Candy);
    cartObj.checkout();
    System.out.println("\n \n");
    cartObj.sortByName();
    cartObj.sortById();
    cartObj.sortByPrice();

  }
}
