package com.sergiuoltean.tdd;

public class WagonFactory {

  //SOLID
  //SRP
  public Wagon build(char in) {
    if (in == 'L') {
      return new Locomotive();
    }
    if (in == 'P') {
      return new Passenger();
    }
    if (in == 'R') {
      return new Restaurant();
    }
    if (in == 'C') {
      return new Cargo();
    }
    throw new IllegalArgumentException("Don't know this type of wagon");
  }

}
