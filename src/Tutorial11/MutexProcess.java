package Tutorial11;

/**
 * File:      MutexProcess.java
 * Contents:  See "Implementing FSP’s MutexProcess Process using a 
 *            Java Thread", from the "FSP to Java" Lecture. 
 * Created:   6/12/18
 * Modified:  6/12/18
 *
 * Notes:  This uses the SimpleSemaphore class.
 *
 */

class MutexProcess extends Thread
{

    private final SimpleSemaphore mutex ;

    MutexProcess( SimpleSemaphore sema, int id )
    {
	super( "MutexProcess-" + id ) ;    // Thread( String ) constructor
	mutex = sema ;
    }

    
    public void run()
    {
	try {
	       // while ( true )
 	       for ( int i = 1 ; i <= 10 ; i++ )
	       {
		  mutex.claim() ;       // get ME

		    // critical section
		    System.out.println( getName() + " executing Critical Section " ) ;

		 mutex.release() ;      // release ME

		 this.sleep( ( int ) Math.random() * 2000 ) ;
	       }
	       
	    }
	catch (InterruptedException e){}
    }
    
    
} // MutexProcess


