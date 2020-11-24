package Lecture7.Exercise7_5;

public class ThreadGroupHierarchy extends Thread {


    final int NUM_GROUPS = 5;
    final int NUM_THREADS = 7;
    final int main = 0;

    public static ThreadGroup groups[];
    public static Thread threads[];

    public ThreadGroupHierarchy() {
        groups = new ThreadGroup[NUM_GROUPS];
        threads = new Thread[NUM_THREADS];
        // getting ‘‘main’’ system group
        groups[main] = Thread.currentThread().getThreadGroup();

        // creating the thread group hierarchy
        //Groups under main
        groups[1] = new ThreadGroup(groups[main], "ThreadGroup A");
        groups[2] = new ThreadGroup(groups[main], "ThreadGroup B");

        //Groups under B1
        groups[3] = new ThreadGroup(groups[2], "ThreadGroup B1");
        groups[4] = new ThreadGroup(groups[2], "ThreadGroup B2");

        // create the threads & place them in the hierarchy
        threads[0] = new Thread(groups[1], "Thread 1");
        threads[1] = new Thread(groups[1], "Thread 2");
        threads[2] = new Thread(groups[1], "Thread 3");
        threads[3] = new Thread(groups[3], "Thread 4");
        threads[4] = new Thread(groups[3], "Thread 5");
        threads[5] = new Thread(groups[4], "Thread 6");
        threads[6] = new Thread(groups[4], "Thread 7");
    }


    public void getThreadGroupInfo(ThreadGroup threadGroup) {
        int ac_count = threadGroup.activeCount();

        Thread listOfThreads[] = new Thread[ac_count * 2];
        int e_count = threadGroup.enumerate(listOfThreads);
        System.out.println("Threads in " + threadGroup.getName());
        for (int i = 0; i < e_count; i++) {
            System.out.println("Thread #" + i + " = " + listOfThreads[i].getName());
        }

    }

}
