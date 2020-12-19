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

class SEMADEMO
{
    public static void main( String args[] )
    {
	
	final int UNLOCKED = 1 ;
	
	SimpleSemaphore mutex = new SimpleSemaphore( UNLOCKED ) ;
	
	Thread mp[] = new Thread[3] ;
	
	// create 3 MutexProcess
	mp[0] = new MutexProcess( mutex, 0 ) ;
	mp[1] = new MutexProcess( mutex, 1 ) ;
	mp[2] = new MutexProcess( mutex, 2 ) ;
	
	// start MutexProcess
	mp[0].start() ;
	mp[1].start() ;
	mp[2].start() ;
    }
    
} // SEMADEMO
