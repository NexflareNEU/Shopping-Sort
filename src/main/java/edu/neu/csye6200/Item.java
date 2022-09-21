package edu.neu.csye6200;

import java.util.ArrayList;
import java.util.List;

public class Item {
  private Double price;
  private String name;

  Item(String name, Double price) {
    this.name = name;
    this.price = price;
  }

  public Double getPrice() {
    return price;
  }


  public String getName() {
    return name;
  }


  public String toString() {
    String itemString = getName() + " " + getPrice().toString();
    return itemString;
  }


  public static void demo() {
    List<Item> cartItems = new ArrayList<Item>();
    Item oil = new Item("Oil", 2.0);
    Item chicken = new Item("Chicken", 5.6);
    Item spices = new Item("Spices", 3.0);
    Item milk = new Item("Milk", 2.3);
    Item choclate = new Item("Choclate", 1.29);
    Item pizza = new Item("Pizza", 4.0);
    cartItems.add(oil);
    cartItems.add(chicken);
    cartItems.add(spices);
    cartItems.add(milk);
    cartItems.add(pizza);
    cartItems.add(choclate);

    useSillyCheckout(cartItems);
    useCheckout(cartItems);
  }

  public static void useSillyCheckout(List<Item> items) {
    Cart myCart = new Cart(20);
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

  public static void useCheckout(List<Item> items) {
    Cart myCart = new Cart(20);
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
