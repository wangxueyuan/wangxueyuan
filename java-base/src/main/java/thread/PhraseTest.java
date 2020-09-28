package thread;

import java.util.concurrent.Phaser;

/**
 * @Author: Wang X.Y.
 * @CreateTime: 7/14/2020 14:23
 * @Version: 1.0
 **/
public class PhraseTest {

    public static final int PARTIES = 30;
    public static final int PHASES = 4;

    public static void main(String[] args) {

        //设置几个阶段，
        Phaser phaser = new Phaser(PARTIES) {
            @Override
            protected boolean onAdvance(int phase, int registeredParties) {
                System.out.println("=======phase: " + phase + " finished=============");
                return super.onAdvance(phase, registeredParties);
            }
        };

        for (int i = 0; i < PARTIES; i++) {
            new Thread(() -> {
                for (int j = 0; j < PHASES; j++) {
                    System.out.println(String.format("%s: phase: %d", Thread.currentThread().getName(), j));
                    phaser.arriveAndAwaitAdvance();
                }
            }, "Thread " + i).start();
        }
    }
}
