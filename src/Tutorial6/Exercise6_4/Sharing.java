package Tutorial6.Exercise6_4;

public class Sharing {
    public static void main(String[] args) {
        SharedVariable X = new SharedVariable();
        SharedVariable Y = new SharedVariable();
        Reader reader1 = new Reader("Reader-1", X, Y,5) ;
        System.out.println( "Main gets state of reader1: " + reader1.getState() ) ;
        System.out.println( "Main tests reader1 status: " + reader1.isAlive() ) ;


        Writer writer1 = new Writer("Writer-1", X, Y ,5);
        Reader reader2 = new Reader("Reader-2", X, Y ,5) ;
        System.out.println( "Main gets state of reader2: " + reader2.getState() ) ;
        System.out.println( "Main tests reader2 status: " + reader2.isAlive() ) ;

        Writer writer2 = new Writer("Writer-2", X, Y ,5);


        reader1.start();
        System.out.println( "Main gets state of reader1: " + reader1.getState() ) ;
        System.out.println( "Main tests reader1 status: " + reader1.isAlive() ) ;


        writer1.start();
        System.out.println( "Main gets state of writer1: " + writer1.getState() ) ;
        System.out.println( "Main tests writer1 status: " + writer1.isAlive() ) ;


        reader2.start();
        System.out.println( "Main gets state of reader2: " + reader2.getState() ) ;
        System.out.println( "Main tests reader2 status: " + reader2.isAlive() ) ;


        writer2.start();
        System.out.println(writer2.getState());
        System.out.println( "Main gets state of writer2: " + writer2.getState() ) ;
        System.out.println( "Main tests writer2 status: " + writer2.isAlive() ) ;
    }
}
