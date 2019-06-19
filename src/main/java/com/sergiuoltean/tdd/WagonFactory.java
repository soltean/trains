package com.sergiuoltean.tdd;

public class WagonFactory {

  public Wagon build(char c) {
    switch (c) {
      case 'L':
        return new Locomotive();
      case 'P':
        return new Passenger();
      case 'R':
        return new Restaurant();
      case 'C':
        return new Cargo();
    }
    throw new IllegalArgumentException("Cannot recognise wagon type " + c);
  }
}
