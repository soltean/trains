package com.sergiuoltean.tdd;

import java.util.Scanner;

public class TrainApp {

  public static void main(String[] args) throws InterruptedException {
    System.out.print("\033[H \033[2J");
    Scanner scan = new Scanner(System.in);
    System.out.println("*******************************************************************************");
    System.out.println("************** Welcome Customer! What train you want to build? ****************");
    System.out.println("L for locomotive");
    System.out.println("P for passenger");
    System.out.println("R for restaurant");
    System.out.println("C for cargo");
    System.out.println("Make your pick (start from the back)");
    String result = scan.nextLine();

    for (int i = 0; i < 5; i++) {
      Thread.sleep(1000);
      prettyPrint("Building in progress " + i * 25 + "%", 0);
    }

    Train train = new Train(result);
    printTrain(train);
    repeat(scan, train);
  }

  private static void printTrain(Train train) throws InterruptedException {
    for (int i = 0; i < 20; i++) {
      Thread.sleep(1000);
      prettyPrint(train.print(), i);
    }
  }

  private static void repeat(Scanner scan, Train train) throws InterruptedException {

    var wagonFactory = new WagonFactory();
    String result;
    System.out.println();
    System.out.println("Wanna change something in the train?");
    System.out.println("1. Remove head");
    System.out.println("2. Remove tail");
    System.out.println("3. Add head");
    System.out.println("4. Add tail");
    System.out.println("0. Exit");
    result = scan.nextLine();
    if (result.equals("1")) {
      train.removeHead();
      printTrain(train);
    }
    if (result.equals("2")) {
      train.removeTail();
      printTrain(train);
    }
    if (result.equals("3")) {
      System.out.println("What type of wagon you want to put in the head of the train?");
      train.addHead(wagonFactory.build(scan.nextLine().charAt(0)));
      printTrain(train);
    }
    if (result.equals("4")) {
      System.out.println("What type of wagon you want to put in the tail of the train?");
      train.addTail(wagonFactory.build(scan.nextLine().charAt(0)));
      printTrain(train);
    }
    if (result.equals("0")) {
      System.exit(0);
    }
    repeat(scan, train);
  }

  public static void prettyPrint(String text, int position) {
    System.out.print("\033[H \033[2J");
    System.out.print("\033[31m ");
    System.out.print(" ".repeat(position * 3) + text);
    System.out.print("\033[0m");
  }


}
