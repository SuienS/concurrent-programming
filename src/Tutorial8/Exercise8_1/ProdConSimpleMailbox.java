package Tutorial8.Exercise8_1;

public class ProdConSimpleMailbox {
    public static void main( String args[] )
    {
        final int NUMBITEMS = 15 ;

        System.out.println( "Create: SimpleMailbox, Producer & Consumer" ) ;

        Mailbox smb = new SimpleMailbox( ) ;

        Producer p1 = new Producer( smb, 1, NUMBITEMS ) ;
        Consumer c1 = new Consumer( smb, 1, NUMBITEMS ) ;

        System.out.println( "Start Producer & Consumer" ) ;

        p1.start( ) ;
        c1.start( ) ;

        // wait for both threads to terminate
        try {
            p1.join() ;
            c1.join() ;
        }
        catch (InterruptedException e){ }

        System.out.println( "Producer & Consumer have terminated" ) ;
    }
}
