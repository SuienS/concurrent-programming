package Lecture5.Exercise5_6;

public class Sharing {
    public static void main(String[] args) {
        SharedVariable X = new SharedVariable();
        Reader reader1 = new Reader("Reader-1", X ,5) ;
        Writer writer1 = new Writer("Writer-1", X ,7);

        reader1.start();
        writer1.start();

    }
}
