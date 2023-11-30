package lesson9.task3;

import java.util.concurrent.Phaser;

public class Competitor implements Runnable {
  private final String name;
  private final int delayTime;
  private final Phaser phaser;

  public Competitor(String name, int delayTime, Phaser phaser) {
    this.name = name;
    this.delayTime = delayTime;
    this.phaser = phaser;
    phaser.register();
  }

  @Override
  public void run() {
    try {
      Thread.sleep(delayTime);
      System.out.printf("Участник %s приступил к соревнованию #1\n", name);
      Thread.sleep(delayTime);
      System.out.printf("Участник %s закончил соревнование #1\n", name);
      phaser.arriveAndAwaitAdvance();
      Thread.sleep(delayTime);
      System.out.printf("Участник %s приступил к соревнованию #2\n", name);
      Thread.sleep(delayTime);
      System.out.printf("Участник %s закончил соревнование #2\n", name);
      phaser.arriveAndAwaitAdvance();
      Thread.sleep(delayTime);
      System.out.printf("Участник %s приступил к соревнованию #3\n", name);
      Thread.sleep(delayTime);
      System.out.printf("Участник %s закончил соревнование #3\n", name);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
