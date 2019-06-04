package com.sergiuoltean.tdd;

public class Restaurant extends Wagon {

  public Restaurant() {
    super("|RESTAURANT|");
  }

  @Override
  String reversed() {
    return "|RESTAURANT|";
  }
}
