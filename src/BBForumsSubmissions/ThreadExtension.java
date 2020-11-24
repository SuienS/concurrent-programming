package BBForumsSubmissions;

public class ThreadExtension extends Thread{

    public void run() {
        System.out.println("ThreadExtension is running...");
        try{
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("State of the threadObj, while it called join() on threadTwoExtended : " + ThreadExampleExercise2.threadObj.getState());

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
