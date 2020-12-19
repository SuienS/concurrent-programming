package Tutorial10.Exercise10_4;

/**

Mutual Exclusion
================

The abstract mutual exclusion problem has the general form:

    locking-protocol
    critical section 
    unlocking-protocol  

Mutual exclusion is very easy to achieve using semaphores \& can be done using 
a single binary semaphore.

**/



class MutexProcess extends SemaphoreThread
{

    // Used to keep track of how many processes are in the 
    // critical section at a time

    protected static int procsInCS = 0 ;  // "protected" for RogueMutexProcess
    
    protected BinarySemaphore mutex ; 

    public MutexProcess (int pid, BinarySemaphore sema)
    {
	super( "MutexProcess_" + pid ) ;
	mutex = sema ;
    }

    public void run() 
    {

	report( "Attempting to ENTER Critical Section" ) ;

	// locking-protocol 
	mutex.claim() ;

	reportClaim( "mutex" ) ;

	report( "ENTERED Critical Section" 
			    + " [Procs In CS = " + ++procsInCS + "]" ) ;

	// do something that takes 2 seconds 
	try {  sleep( 2 * 1000) ; } catch (InterruptedException e) {}
	
	report( "LEAVING Critical Section" 
			    + " [Procs In CS = " + --procsInCS + "]" ) ;

	// unlocking-protocol 
	mutex.release() ;

	reportRelease( "mutex" ) ;

	report( "LEFT    Critical Section" ) ;
  }

}

