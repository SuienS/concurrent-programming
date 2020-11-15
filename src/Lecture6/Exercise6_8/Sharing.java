package Lecture6.Exercise6_8;

public class Sharing {
    public static void main(String[] args) {
        SharedVariable X = new SharedVariable();
        SharedVariable Y = new SharedVariable();
        Reader reader1 = new Reader("Reader-1", X, Y,5) ;
        Writer writer1 = new Writer("Writer-1", X, Y ,5);
        Reader reader2 = new Reader("Reader-2", X, Y ,5) ;
        Writer writer2 = new Writer("Writer-2", X, Y ,5);

        reader1.start();
        writer1.start();
        reader2.start();
        writer2.start();

        reader1.setTerminate(true);
        reader2.setTerminate(true);
        writer1.setTerminate(true);
        writer2.setTerminate(true);

    }
}
