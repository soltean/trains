package com.winnowsolutions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import com.sergiuoltean.tdd.Cargo;
import com.sergiuoltean.tdd.Passenger;
import com.sergiuoltean.tdd.Train;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TrainTest {

  @Test
  @DisplayName("Should built a passenger train")
  void shouldBuildPassengerTrain() {
    Train train = new Train("LPP");
    assertThat(train.print()).isEqualTo("<˳˳_L_˳˳|--[˳˳_P_˳˳]--[˳˳_P_˳˳]-");
  }

  @Test
  @DisplayName("Should build passenger train with restaurant")
  void shouldBuildRestaurant() {
    Train train = new Train("LPPRP");
    assertThat(train.print()).isEqualTo("<˳˳_L_˳˳|--[˳˳_P_˳˳]--[˳˳_P_˳˳]--[˳˳_R_˳˳]--[˳˳_P_˳˳]-");
  }

  @Test
  @DisplayName("Should not build unkown wagons")
  void shouldNotBuildUnknownWagons() {
    assertThatIllegalArgumentException().isThrownBy(() -> new Train("LPPX"));
  }

  @Test
  @DisplayName("Should build cargo and pulled either way")
  void shouldBuildCargoWagonAndPulledEitherWay() {
    Train train = new Train("LPPRPCPL");
    assertThat(train.print()).isEqualTo("<˳˳_L_˳˳|--[˳˳_P_˳˳]--[˳˳_P_˳˳]--[˳˳_R_˳˳]--[˳˳_P_˳˳]--[˳˳_C_˳˳]--[˳˳_P_˳˳]--|˳˳_L_˳˳>");
  }

  @Test
  @DisplayName("Should remove head of train")
  void shouldRemoveHeadOfTrain(){
    Train train = new Train("LPPRPCPL");
    assertThat(train.print()).isEqualTo("<˳˳_L_˳˳|--[˳˳_P_˳˳]--[˳˳_P_˳˳]--[˳˳_R_˳˳]--[˳˳_P_˳˳]--[˳˳_C_˳˳]--[˳˳_P_˳˳]--|˳˳_L_˳˳>");
    train.removeHead();
    assertThat(train.print()).isEqualTo("-[˳˳_P_˳˳]--[˳˳_P_˳˳]--[˳˳_R_˳˳]--[˳˳_P_˳˳]--[˳˳_C_˳˳]--[˳˳_P_˳˳]--|˳˳_L_˳˳>");
  }

  @Test
  @DisplayName("Should remove tail of train")
  void shouldRemoveTailOfTrain(){
    Train train = new Train("LPPRPCPL");
    train.removeTail();
    assertThat(train.print()).isEqualTo("<˳˳_L_˳˳|--[˳˳_P_˳˳]--[˳˳_P_˳˳]--[˳˳_R_˳˳]--[˳˳_P_˳˳]--[˳˳_C_˳˳]--[˳˳_P_˳˳]-");
  }

  @Test
  @DisplayName("Should add tail of train")
  void shouldAddTailOfTrain(){
    Train train = new Train("LPPRPCP");
    train.addTail(new Passenger());
    assertThat(train.print()).isEqualTo("<˳˳_L_˳˳|--[˳˳_P_˳˳]--[˳˳_P_˳˳]--[˳˳_R_˳˳]--[˳˳_P_˳˳]--[˳˳_C_˳˳]--[˳˳_P_˳˳]-"+"-[˳˳_P_˳˳]-");
  }

  @Test
  @DisplayName("Should add head of train")
  void shouldAddHeadOfTrain(){
    Train train = new Train("LPPRPCP");
    train.addHead(new Cargo());
    assertThat(train.print()).isEqualTo("-[˳˳_C_˳˳]-"+"<˳˳_L_˳˳|--[˳˳_P_˳˳]--[˳˳_P_˳˳]--[˳˳_R_˳˳]--[˳˳_P_˳˳]--[˳˳_C_˳˳]--[˳˳_P_˳˳]-");
  }

}
