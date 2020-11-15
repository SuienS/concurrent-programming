package Lecture6.Exercise6_2;

public class Sharing {
    public static void main(String[] args) {
        SharedVariable X = new SharedVariable();
        SharedVariable Y = new SharedVariable();
        Reader reader1 = new Reader("Reader-1", X, Y,5) ;
        Writer writer1 = new Writer("Writer-1", X, Y ,5);
        Reader reader2 = new Reader("Reader-2", X, Y ,5) ;
        Writer writer2 = new Writer("Writer-2", X, Y ,5);

        reader1.start();
        System.out.println(reader1.getState());

        writer1.start();
        System.out.println(writer1.getState());

        reader2.start();
        System.out.println(reader2.getState());

        writer2.start();
        System.out.println(writer2.getState());
    }
}
