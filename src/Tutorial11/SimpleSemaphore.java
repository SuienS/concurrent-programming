package Tutorial11;

/**
 * File:      SimpleSemaphore.java
 * Contents:  See "Implementing FSP’s SEMAPHORE Process using a 
 *            Java Semaphore class", from the "FSP to Java" Lecture. 
 * Created:   6/12/18
 * Modified:  6/12/18
 *
 * Notes:  This is a very simple implementation of a semaphore.
 *
 */

public class SimpleSemaphore
{

    private int value ;

    public SimpleSemaphore ( int initial )
    {
	value = initial ;
    }

    public synchronized void claim( ) throws InterruptedException
    {
	while ( value == 0 )
	{
	    wait() ;
	}
	
	value-- ;
    }
    

    public synchronized void release( )
    {
	value++ ;
	notify() ;
    }

    
} // SimpleSemaphore


