package edu.neu.csye6200;

import java.util.Comparator;

class SortByPrice implements Comparator<Item> {

  @Override
  public int compare(Item o1, Item o2) {
    // TODO Auto-generated method stub
    return (int) (o1.getPrice() - o2.getPrice());
  }

}
