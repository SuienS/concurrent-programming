package BBForumsSubmissions;

public class ThreadRunnable implements Runnable{
    public void run() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("State of the threadObj, while it called join() on threadTwoRunnable : " + ThreadExampleExercise.threadObj.getState());

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

