package Lecture5.Exercise5_5;

public class Sharing {
    public static void main(String[] args) {
        SharedVariable X = new SharedVariable();
        Reader reader1 = new Reader("Reader-1", X ) ;
        Writer writer1 = new Writer("Writer-1", X ) ;

        reader1.start();
        writer1.start();

    }
}
