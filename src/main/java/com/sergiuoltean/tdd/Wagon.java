package com.sergiuoltean.tdd;

public abstract class Wagon {

  private boolean reversed = false;
  private String value;
  private boolean isLocomotive = false;

  protected Wagon(String value) {
    this.value = value;
  }

  protected String print() {
    return reversed ? reversed() : value;
  }

  protected void setReversed(boolean reversed) {
    this.reversed = reversed;
  }

  abstract String reversed();

  public void setLocomotive(boolean locomotive) {
    isLocomotive = locomotive;
  }

  public boolean isLocomotive() {
    return isLocomotive;
  }
}
