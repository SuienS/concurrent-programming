package Tutorial8.Exercise8_3;

public class ProdConMonitorMailbox {
    public static void main( String args[] )
    {
        final int NUMBITEMS = 10 ;

        System.out.println( "Create: MonitorMailbox, Producer & Consumer" ) ;

        Mailbox mmb = new MonitorMailbox( ) ;

        Producer p1 = new Producer( mmb, 1, NUMBITEMS ) ;
        Consumer c1 = new Consumer( mmb, 1, NUMBITEMS ) ;

        Producer p2 = new Producer( mmb, 2, NUMBITEMS ) ;
        Consumer c2 = new Consumer( mmb, 2, NUMBITEMS ) ;

        System.out.println( "Start Producer & Consumer" ) ;

        p1.start( ) ;
        c1.start( ) ;
        p2.start( ) ;
        c2.start( ) ;

        // wait for both threads to terminate
        try {
            p1.join() ;
            c1.join() ;
            p2.join() ;
            c2.join() ;
        }
        catch (InterruptedException e){ }

        System.out.println( "Producer & Consumer have terminated" ) ;
    }
}
