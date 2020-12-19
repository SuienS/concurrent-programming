package Tutorial10.Exercise10_7;

/** 
    Dining Philosophers Problem using Semaphores

    This version has no deadlock avoidance, so it will deadlock if it 
    is run several (this is unpredictable) times.

    If it deadlocks then it "hangs" & the last thing it will 
    printed out is: 
    " ... PickedUpForks = 5"
    i.e, each philosopher has picked up one fork

**/


class DiningPhils
{
    protected final int NUMPHILS = 5 ;
    protected final int NUMFORKS = NUMPHILS ;

    protected BinarySemaphore fork[] = new BinarySemaphore[NUMFORKS] ;

    protected Thread philosopher[] = new Thread[NUMPHILS] ;

    DiningPhils()
    {

	// create  fork semaphores 
	for( int fid = 0 ; fid < NUMFORKS ; fid++ )
	    {
		fork[fid] = new BinarySemaphore( 1 ) ; 
	    } ;

	// create  philosophers 
	for( int pid = 0 ; pid < NUMPHILS ; pid++ )
	    {
		philosopher[pid] = new Philosopher( "Phil" + pid,
				       fork[pid % NUMPHILS],
				       fork[(pid + 1) % NUMPHILS] ) ; 
	    } ;
	
	reportSemaphoresStatus( "Initial State" ) ;

	// start the philosophers
	for( int pid = 0 ; pid < NUMPHILS ; pid++ )
	    {
		philosopher[pid].start() ;
	    } ;
	
	
	// wait for the philosophers to die
	try { 
	    
	    for( int pid = 0 ; pid < NUMPHILS ; pid++ )
	    {
		philosopher[pid].join() ;
	    } ;

	} 
	catch ( InterruptedException ie ) {} ;

	reportSemaphoresStatus( "Final State" ) ;
    }


    protected void reportSemaphoresStatus(String caption) 
    {
	System.out.println( caption +": " ) ;

	System.out.print( "5 Forks: " ) ;

	for( int fid = 0 ; fid < NUMFORKS ; fid++ )
	    {
		System.out.print( " fork[" + fid + "] = " 
				  + fork[fid].availablePermits() ) ; 
	    } ;
	
	System.out.println() ;

    }
}

