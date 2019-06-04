package com.sergiuoltean.tdd;

public class Passenger extends Wagon {

  public Passenger() {
    super("|PASSENGER|");
  }

  @Override
  String reversed() {
    return "|PASSENGER|";
  }
}
