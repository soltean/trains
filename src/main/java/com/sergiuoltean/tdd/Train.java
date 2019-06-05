package com.sergiuoltean.tdd;

import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class Train {

  private WagonFactory wagonFactory = new WagonFactory();
  private Deque<Wagon> wagons = new LinkedList<>();

  //SOLID
  //OPEN-CLOSE PRINCIPLE
  //FACTORY
  public Train(String input) {
    input.chars().forEach(value -> {
      var character = (char) value;
      var wagon = wagonFactory.buildWagon(character);
      wagons.add(wagon);
    });
    checkIfLastWagonIsLocomotive();
  }

  private void checkIfLastWagonIsLocomotive() {
    var lastWagon = wagons.getLast();
    if (lastWagon.isLocomotive()) {
      lastWagon.setReverse(true);
    }
  }

  public String print() {
    return wagons.stream().map(Wagon::print).collect(Collectors.joining());
  }

  public void detachHead() {
    wagons.removeFirst();
  }

  public void detachTail() {
    wagons.removeLast();
  }
}
