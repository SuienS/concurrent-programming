package Lecture5.SimpleThread;

class SimpleThread extends Thread {

    private final int OneSecond = 1000 ;
    private int time = 1 ;

    public SimpleThread( String str, int time )
    {
        super( str ) ; // "Thread( String )" constructor
        this.time = time;
    }

    public void run() // "body" of the thread
    {
        for ( int i = 0 ; i < 10 ; i++ )
        {
            System.out.println( getName() + ": " + i ) ;
            try {
                sleep( (int)( Math.random() * OneSecond * time ) ) ;
            }
            catch ( InterruptedException e ) {}
        }
    }
}
