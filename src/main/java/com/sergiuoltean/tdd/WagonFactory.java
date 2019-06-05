package com.sergiuoltean.tdd;

public class WagonFactory {

  public Wagon buildWagon(char type) {
    switch (type) {
      case 'L': return new Locomotive();
      case 'P': return new Passenger();
      case 'R': return new Restaurant();
      case 'C': return new Cargo();
    }
    throw new IllegalArgumentException("Unrecognized wagon type " + type);
  }

}
