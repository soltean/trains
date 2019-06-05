package com.winnowsolutions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import com.sergiuoltean.tdd.Train;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TrainTest {

  @Test
  @DisplayName("I should build a train")
  void shouldBuildATrain() {
    Train train = new Train("LPP");
    assertThat(train.print()).isEqualTo("<˳˳_L_˳˳|--[˳˳_P_˳˳]--[˳˳_P_˳˳]-");
  }

  @Test
  @DisplayName("I should not build a train with a wagon type I don't know")
  void shouldNotBuildATrain() {
    assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new Train("LPPX"));
  }

  @Test
  @DisplayName("I should build a train with a restaurant wagon")
  void shouldBuildTrainWithRestaurant() {
    Train train = new Train("LPPRP");
    assertThat(train.print()).isEqualTo("<˳˳_L_˳˳|--[˳˳_P_˳˳]--[˳˳_P_˳˳]--[˳˳_R_˳˳]--[˳˳_P_˳˳]-");

  }

  @Test
  @DisplayName("I should build cargo wagons")
  void shouldBuildCargoWagons() {
    Train train = new Train("LPPRPCP");
    assertThat(train.print()).isEqualTo("<˳˳_L_˳˳|--[˳˳_P_˳˳]--[˳˳_P_˳˳]--[˳˳_R_˳˳]--[˳˳_P_˳˳]--[˳˳_C_˳˳]--[˳˳_P_˳˳]-");
  }

  @Test
  @DisplayName("Train can be pulled either way")
  void shouldPullTrainEitherWay() {
    Train train = new Train("LPPRPCPL");
    assertThat(train.print())
            .isEqualTo("<˳˳_L_˳˳|--[˳˳_P_˳˳]--[˳˳_P_˳˳]--[˳˳_R_˳˳]--[˳˳_P_˳˳]--[˳˳_C_˳˳]--[˳˳_P_˳˳]--|˳˳_L_˳˳>");
  }

  @Test
  @DisplayName("I should detach the head of the train")
  void shouldDetachHeadOfTheTrain(){
    Train train = new Train("LPPRPCPL");
    assertThat(train.print())
            .isEqualTo("<˳˳_L_˳˳|--[˳˳_P_˳˳]--[˳˳_P_˳˳]--[˳˳_R_˳˳]--[˳˳_P_˳˳]--[˳˳_C_˳˳]--[˳˳_P_˳˳]--|˳˳_L_˳˳>");
    train.detachHead();
    assertThat(train.print())
            .isEqualTo("-[˳˳_P_˳˳]--[˳˳_P_˳˳]--[˳˳_R_˳˳]--[˳˳_P_˳˳]--[˳˳_C_˳˳]--[˳˳_P_˳˳]--|˳˳_L_˳˳>");
    train.detachHead();
    assertThat(train.print())
            .isEqualTo("-[˳˳_P_˳˳]--[˳˳_R_˳˳]--[˳˳_P_˳˳]--[˳˳_C_˳˳]--[˳˳_P_˳˳]--|˳˳_L_˳˳>");
  }

  @Test
  @DisplayName("I should detach the tail of the train")
  void shouldDetachTailOfTheTrain(){
    Train train = new Train("LPPRPCPL");
    assertThat(train.print())
            .isEqualTo("<˳˳_L_˳˳|--[˳˳_P_˳˳]--[˳˳_P_˳˳]--[˳˳_R_˳˳]--[˳˳_P_˳˳]--[˳˳_C_˳˳]--[˳˳_P_˳˳]--|˳˳_L_˳˳>");
    train.detachTail();
    assertThat(train.print())
            .isEqualTo("<˳˳_L_˳˳|--[˳˳_P_˳˳]--[˳˳_P_˳˳]--[˳˳_R_˳˳]--[˳˳_P_˳˳]--[˳˳_C_˳˳]--[˳˳_P_˳˳]-");

  }

}
