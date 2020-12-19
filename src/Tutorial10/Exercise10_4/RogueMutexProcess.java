package Tutorial10.Exercise10_4;


class RogueMutexProcess extends MutexProcess
{

    // private static int procsInCS = 0 ;  // in MutexProcess

    // private BinarySemaphore mutex ;     // in MutexProcess

    public RogueMutexProcess (int pid, BinarySemaphore sema)
    {
	super( pid, sema ) ;
    }

    public void run() 
    {

	report( "Attempting to ENTER Critical Section" ) ;

	//	mutex.claim() ;

	reportClaim( "*** DID NOT CLAIM --> mutex ***" ) ;

    
	report( "ENTERED Critical Section" 
			    + " [Procs In CS = " + ++procsInCS + "]" ) ;

	// do something that takes 2 seconds 
	try {  sleep( 2 * 1000) ; } catch (InterruptedException e) {}
	
	report( "LEAVING Critical Section" 
			    + " [Procs In CS = " + --procsInCS + "]" ) ;

	mutex.release() ;

	reportRelease( "mutex" ) ;

	report( "LEFT    Critical Section" ) ;

  }
}

