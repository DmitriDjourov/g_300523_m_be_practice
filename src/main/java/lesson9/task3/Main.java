package lesson9.task3;

import java.util.concurrent.Phaser;

public class Main {
  public static void main(String[] args) {
    Phaser phaser = new Phaser();

    Competitor c1 = new Competitor("Name 1", 1000, phaser);
    Competitor c2 = new Competitor("Name 2", 2000, phaser);
    Competitor c3 = new Competitor("Name 3", 3000, phaser);

    new Thread(c1).start();
    new Thread(c2).start();
    new Thread(c3).start();
  }
}
