package com.sergiuoltean.tdd;

public abstract class Wagon {

  private boolean isReverse = false;
  private boolean isLocomotive = false;
  private String value;
  private String reverseValue;

  protected Wagon(String value, String reverseValue) {
    this.value = value;
    this.reverseValue = reverseValue;
  }

  public boolean isReverse() {
    return isReverse;
  }

  public void setReverse(boolean reverse) {
    isReverse = reverse;
  }

  public String print() {
    return isReverse() ? reverseValue : value;
  }

  public boolean isLocomotive() {
    return isLocomotive;
  }

  public void setLocomotive(boolean locomotive) {
    isLocomotive = locomotive;
  }
}
