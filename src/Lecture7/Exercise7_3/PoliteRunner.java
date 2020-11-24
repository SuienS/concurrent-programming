package Lecture7.Exercise7_3;

public class PoliteRunner extends Thread{
    public int tick = 1;

    PoliteRunner(int id) {
        super("PoliteRunner-" + id);
    }

    public void run() {
        while (tick < 400000) {
            tick++;
            if ((tick % 50000) == 0) {
                System.out.println(getName() + ": tick = " + tick);
                yield();
            }
        }
    }
}
