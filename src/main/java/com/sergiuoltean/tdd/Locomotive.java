package com.sergiuoltean.tdd;

public class Locomotive extends Wagon {

  public Locomotive() {
    super("<LOCOMOTIVE|");
    setLocomotive(true);
  }

  @Override
  String reversed() {
    return "|LOCOMOTIVE>";
  }
}