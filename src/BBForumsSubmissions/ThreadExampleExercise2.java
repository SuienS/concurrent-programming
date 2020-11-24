package BBForumsSubmissions;
class ThreadExampleExercise2 implements Runnable {
    public static Thread threadObj;
    public static ThreadExampleExercise2 obj;

    public static void main(String args[]) {
        obj = new ThreadExampleExercise2();
        threadObj = new Thread(obj);
        System.out.println("threadObj state after the creation but just before starting - " + threadObj.getState());
        threadObj.start();
        System.out.println("threadObj state after calling start() on threadObj object - " + threadObj.getState());
    }


    public void run() {
        ThreadExtension threadExtension = new ThreadExtension();
        Thread threadTwoExtended = new Thread(threadExtension);
        System.out.println("threadTwoExtended state after the creation - " + threadTwoExtended.getState());
        threadTwoExtended.start();
        System.out.println("threadTwoExtended state after calling start() - " + threadTwoExtended.getState());

        try {
            threadTwoExtended.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("State of the threadTwoExtended after calling sleep() on it : " + threadTwoExtended.getState());

        try {
            threadTwoExtended.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("State of the threadTwoExtended while it finished the execution : " + threadTwoExtended.getState());
    }
}