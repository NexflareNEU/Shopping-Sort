package edu.neu.csye6200;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nexflare
 */
public class Item {
  /**
   * default price of item.
   */
  private Double price;
  /**
   * default name of item.
   */
  private String name;

  /**
   * @param itemName
   * @param itemPrice
   */
  Item(final String itemName, final Double itemPrice) {
    this.name = itemName;
    this.price = itemPrice;
  }

  /**
   * @return price of item
   */
  public Double getPrice() {
    return price;
  }


  /**
   * @return name of item
   */
  public String getName() {
    return name;
  }


  /**
   * @return get item name and price as a string
   */
  public String toString() {
    String itemString = getName() + " " + getPrice().toString();
    return itemString;
  }


  /**
   * @author nexflare
   */
  public static void demo() {
    List<Item> cartItems = new ArrayList<Item>();
    Item oil = new Item("Oil", Constants.OIL_PRICE);
    Item chicken = new Item("Chicken", Constants.CHICKEN_PRICE);
    Item spices = new Item("Spices", Constants.SPICES_PRICE);
    Item milk = new Item("Milk", Constants.MILK_PRICE);
    Item choclate = new Item("Choclate", Constants.CHOCLATE_PRICE);
    Item pizza = new Item("Pizza", Constants.PIZZA_PRICE);
    cartItems.add(oil);
    cartItems.add(chicken);
    cartItems.add(spices);
    cartItems.add(milk);
    cartItems.add(pizza);
    cartItems.add(choclate);

    useSillyCheckout(cartItems);
    System.out.println("\n\n\n\n");
    useCheckout(cartItems);
  }

  /**
   * @param items
   */
  public static void useSillyCheckout(final List<Item> items) {
    Cart myCart = new Cart(Constants.INITAL_CHANGE);
    for (Item item : items) {
      System.out.println("Silly checkout " + item.name);
      myCart.sillyCheckout(myCart.getMyCash(), item.getPrice(),
          (double) myCart.getMyTotal(), (double) myCart.getMyChange());
    }
    StringBuilder str = new StringBuilder("");

    System.out.println("\n");
    System.out.println("SILLY CHECKOUT BILL RECEIPT\n");
    for (Item item : items) {
      str.append(item.toString() + "\n");
    }
    System.out.print(str.toString());
    System.out.println(myCart.toString());

  }

  /**
   * @param items
   */
  public static void useCheckout(final List<Item> items) {
    Cart myCart = new Cart(Constants.INITAL_CHANGE);
    for (Item item : items) {
      myCart.checkout(myCart, item);
    }
    StringBuilder str = new StringBuilder("");
    System.out.println("CHECKOUT BILL RECEIPT\n");
    for (Item item : items) {
      str.append(item.toString() + "\n");
    }
    System.out.print(str.toString());
    System.out.println(myCart.toString());
  }
}
