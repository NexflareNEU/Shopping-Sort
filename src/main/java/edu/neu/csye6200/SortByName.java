package edu.neu.csye6200;

import java.util.Comparator;

class SortByName implements Comparator<Item> {

  @Override
  public int compare(Item o1, Item o2) {
    // TODO Auto-generated method stub
    return o1.getName().compareTo(o2.getName());
  }

}
