package Lecture5.Exercise5_7;

public class Sharing {
    public static void main(String[] args) {
        SharedVariable X = new SharedVariable();
        Reader reader1 = new Reader("Reader-1", X ,5) ;
        Writer writer1 = new Writer("Writer-1", X ,10);
        Reader reader2 = new Reader("Reader-2", X ,5) ;
        Writer writer2 = new Writer("Writer-2", X ,10);

        reader1.start();
        writer1.start();
        reader2.start();
        writer2.start();

    }
}
