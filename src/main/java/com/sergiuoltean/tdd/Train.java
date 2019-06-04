package com.sergiuoltean.tdd;

import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class Train {

  private Deque<Wagon> wagons = new LinkedList<>();
  private WagonFactory factory = new WagonFactory();

  //OPEN CLOSE
  //FACTORY
  public Train(String input) {
    var parsed = parse(input);
    reverseIfLocomotiveLast(parsed);
  }

  private Deque<Wagon> parse(String input) {
    input.chars().forEach(value -> {
      var type = (char) value;
      wagons.add(factory.build(type));
    });
    return wagons;
  }

  private void reverseIfLocomotiveLast(Deque<Wagon> wagons) {
    var lastWagon = wagons.getLast();
    if (lastWagon.isLocomotive()) {
      lastWagon.setReversed(true);
    }
  }

  public String print() {
    return wagons.stream().map(Wagon::print).collect(Collectors.joining());
  }

  public void add(Wagon wagon) {
    wagons.add(wagon);
  }

  public void detachHead() {
    wagons.removeFirst();
  }

  public void detachTail() {
    wagons.removeLast();
  }
}
