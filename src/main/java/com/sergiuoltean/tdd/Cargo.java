package com.sergiuoltean.tdd;

public class Cargo extends Wagon {

  public Cargo() {
    super("|CARGO|");
  }

  @Override
  String reversed() {
    return "|CARGO|";
  }
}
