package edu.neu.csye6200;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nexflare
 */
public class Item {
  private Double price;
  private String name;

  public static final double OIL_PRICE = 2.0;
  public static final double CHICKEN_PRICE = 5.6;
  public static final double SPICES_PRICE = 3.0;
  public static final double MILK_PRICE = 2.3;
  public static final double PIZZA_PRICE = 1.29;
  public static final double CHOCLATE_PRICE = 4.0;
  public static final int INITAL_CHANGE = 20;

  /**
   * @param itemName
   * @param itemPrice
   */
  Item(String itemName, Double itemPrice) {
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
    Item oil = new Item("Oil", OIL_PRICE);
    Item chicken = new Item("Chicken", CHICKEN_PRICE);
    Item spices = new Item("Spices", SPICES_PRICE);
    Item milk = new Item("Milk", MILK_PRICE);
    Item choclate = new Item("Choclate", CHOCLATE_PRICE);
    Item pizza = new Item("Pizza", PIZZA_PRICE);
    cartItems.add(oil);
    cartItems.add(chicken);
    cartItems.add(spices);
    cartItems.add(milk);
    cartItems.add(pizza);
    cartItems.add(choclate);

    useSillyCheckout(cartItems);
    useCheckout(cartItems);
  }

  /**
   * @param items
   */
  public static void useSillyCheckout(List<Item> items) {
    Cart myCart = new Cart(INITAL_CHANGE);
    for (Item item : items) {
      myCart.sillyCheckout(myCart.getMyCash(), item.getPrice(), myCart.getMyTotal(),
          myCart.getMyChange());
    }
    StringBuilder str = new StringBuilder("");
    for (Item item : items) {
      str.append(item.toString() + "\n");
    }
    System.out.print(str.toString());
    System.out.println(myCart.toString());

  }

  /**
   * @param items
   */
  public static void useCheckout(List<Item> items) {
    Cart myCart = new Cart(INITAL_CHANGE);
    for (Item item : items) {
      myCart.checkout(myCart, item);
    }
    StringBuilder str = new StringBuilder("");
    for (Item item : items) {
      str.append(item.toString() + "\n");
    }
    System.out.print(str.toString());
    System.out.println(myCart.toString());
  }
}
