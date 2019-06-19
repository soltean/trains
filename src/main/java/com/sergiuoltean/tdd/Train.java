package com.sergiuoltean.tdd;

import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class Train {

  private WagonFactory wagonFactory = new WagonFactory();
  private Deque<Wagon> wagons = new LinkedList<>();

  public Train(String input) {
    input.chars().forEach(value -> {
      char c = (char) value;
      wagons.add(wagonFactory.build(c));
    });

    checkIfLastIsLocomotiveAndReverse(wagons);
  }

  private void checkIfLastIsLocomotiveAndReverse(Deque<Wagon> wagons) {
    Wagon lastWagon = wagons.getLast();
    if (lastWagon.isLocomotive()) {
      lastWagon.setReversed(true);
    }
  }

  public String print() {
    return wagons.stream().map(Wagon::print).collect(Collectors.joining());
  }

  public void removeHead() {
    wagons.removeFirst();
  }

  public void removeTail() {
    wagons.removeLast();
  }

  public void addTail(Wagon wagon) {
    wagons.addLast(wagon);
  }

  public void addHead(Wagon wagon) {
    wagons.addFirst(wagon);
  }
}
