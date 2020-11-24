package BBForumsSubmissions;
class ThreadExampleExercise implements Runnable {
    public static Thread threadObj;
    public static ThreadExampleExercise obj;

    public static void main(String args[]) {
        obj = new ThreadExampleExercise();
        threadObj = new Thread(obj);
        System.out.println("threadObj state after the creation but just before starting - " + threadObj.getState());
        threadObj.start();
        System.out.println("threadObj state after calling start() on threadObj object - " + threadObj.getState());
    }


    public void run() {
        ThreadRunnable threadRunnable = new ThreadRunnable();
        Thread threadTwoRunnable = new Thread(threadRunnable);
        System.out.println("threadTwoRunnable state after the creation - " + threadTwoRunnable.getState());
        threadTwoRunnable.start();
        System.out.println("threadTwoRunnable state after calling start() - " + threadTwoRunnable.getState());

        try {
            threadTwoRunnable.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("State of the threadTwoRunnable after calling sleep() on it : " + threadTwoRunnable.getState());

        try {
            threadTwoRunnable.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("State of the threadTwoRunnable while it finished the execution : " + threadTwoRunnable.getState());
    }
}