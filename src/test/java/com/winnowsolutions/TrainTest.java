package com.winnowsolutions;

import com.sergiuoltean.tdd.Cargo;
import com.sergiuoltean.tdd.Passenger;
import com.sergiuoltean.tdd.Train;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TrainTest {

  @Test
  @DisplayName("I should build a train with passanger wagons")
  public void shouldBuildTrain() {
    Train train = new Train("LPP");
    Assertions.assertThat(train.print()).isEqualTo("<LOCOMOTIVE||PASSENGER||PASSENGER|");
  }

  @Test
  @DisplayName("I should build a train with restaurant wagons")
  public void shouldBuildTrainWithRestaurantWagon() {
    Train train = new Train("LPPRP");
    Assertions.assertThat(train.print()).isEqualTo("<LOCOMOTIVE||PASSENGER||PASSENGER||RESTAURANT||PASSENGER|");
  }

  @Test
  @DisplayName("I should add a wagon")
  public void shouldAddWagon() {
    Train train = new Train("LPPRP");
    Assertions.assertThat(train.print()).isEqualTo("<LOCOMOTIVE||PASSENGER||PASSENGER||RESTAURANT||PASSENGER|");
    train.add(new Passenger());
    Assertions.assertThat(train.print()).isEqualTo("<LOCOMOTIVE||PASSENGER||PASSENGER||RESTAURANT||PASSENGER||PASSENGER|");
  }

  @Test
  @DisplayName("I should add a cargo wagon")
  public void shouldAddCargoWagon() {
    Train train = new Train("LPPRPCC");
    Assertions.assertThat(train.print()).isEqualTo("<LOCOMOTIVE||PASSENGER||PASSENGER||RESTAURANT||PASSENGER||CARGO||CARGO|");
    train.add(new Cargo());
    Assertions.assertThat(train.print()).isEqualTo("<LOCOMOTIVE||PASSENGER||PASSENGER||RESTAURANT||PASSENGER||CARGO||CARGO||CARGO|");
  }

  @Test
  @DisplayName("I should be able to add another locomotive")
  public void shouldAddAnotherLocomotive() {
    Train train = new Train("LPPRPCCL");
    Assertions.assertThat(train.print()).isEqualTo("<LOCOMOTIVE||PASSENGER||PASSENGER||RESTAURANT||PASSENGER||CARGO||CARGO||LOCOMOTIVE>");
  }

  @Test
  @DisplayName("I should be able to remove the head of the train")
  public void shouldRemoveTheHeadOfTheTrain() {
    Train train = new Train("LPPRPCCL");
    Assertions.assertThat(train.print()).isEqualTo("<LOCOMOTIVE||PASSENGER||PASSENGER||RESTAURANT||PASSENGER||CARGO||CARGO||LOCOMOTIVE>");
    train.detachHead();
    Assertions.assertThat(train.print()).isEqualTo("|PASSENGER||PASSENGER||RESTAURANT||PASSENGER||CARGO||CARGO||LOCOMOTIVE>");
  }

  @Test
  @DisplayName("I should be able to remove the tail of the train")
  public void shouldRemoveTheTailOfTheTrain() {
    Train train = new Train("PPRPCCL");
    Assertions.assertThat(train.print()).isEqualTo("|PASSENGER||PASSENGER||RESTAURANT||PASSENGER||CARGO||CARGO||LOCOMOTIVE>");
    train.detachTail();
    Assertions.assertThat(train.print()).isEqualTo("|PASSENGER||PASSENGER||RESTAURANT||PASSENGER||CARGO||CARGO|");
  }

}
