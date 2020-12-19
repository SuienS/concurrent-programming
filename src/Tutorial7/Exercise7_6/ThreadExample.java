package Tutorial7.Exercise7_6;

public class ThreadExample extends Thread{
    ThreadDescriptor threadDescriptor = new ThreadDescriptor("Thread 1", "ThreadGroup A", "6");;

    public ThreadExample(ThreadDescriptor threadDescriptor){
        this.threadDescriptor = threadDescriptor;
    }

    public ThreadDescriptor getThreadDescriptor(){
        return this.threadDescriptor;
    }
}
