package com.sergiuoltean.tdd;

public abstract class Wagon {

  private boolean isReversed = false;
  private boolean isLocomotive = false;
  private String value;
  private String reverseValue;

  protected Wagon(String value, String reverseValue) {
    this.value = value;
    this.reverseValue = reverseValue;
  }

  String print() {
    return isReversed ? reverseValue : value;
  }

  public void setReversed(boolean reversed) {
    isReversed = reversed;
  }

  public boolean isLocomotive() {
    return isLocomotive;
  }

  public void setLocomotive(boolean locomotive) {
    isLocomotive = locomotive;
  }
}
