package Tutorial10.Exercise10_7;

/**
    First Deadlock Free Solution to the Dining Philosophers Problem

    In this version of the Dining Philosophers Problem deadlock is
    avoided by introducing an additional semaphore, i.e., the butler,
    which has the effect of limiting the number of Philosophers which
    are allowed to enter the dining room to 4, thus ensuring that one
    philosopher can always pick up two forks.  Dining Philosophers
    Problem using Semaphores with a Butler

**/


class ButlerDiningPhils
{
    protected static final int NUMPHILS     = 5 ;
    protected static final int NUMFORKS     = NUMPHILS ;
    protected static final int ROOMCAPACITY = NUMPHILS - 1 ;

    protected BinarySemaphore fork[] = new BinarySemaphore[NUMFORKS] ;

    protected GeneralSemaphore butler 
	    = new GeneralSemaphore(ROOMCAPACITY,ROOMCAPACITY) ;

    protected Thread philosopher[] = new Thread[NUMPHILS] ;


    ButlerDiningPhils()
    {

	// create  fork semaphores 
	for( int fid = 0 ; fid < NUMFORKS ; fid++ )
	    {
		fork[fid] = new BinarySemaphore( 1 ) ; 
	    }


	// create  philosophers 
	for( int pid = 0 ; pid < NUMPHILS ; pid++ )
	    {
		philosopher[pid] 
		    = new ButlerPhilosopher( "Phil" + pid,
				       fork[pid % NUMPHILS],
				       fork[(pid + 1) % NUMPHILS],
				       butler ) ; 
	    }


	reportSemaphoresStatus( "Initial State" ) ;

	// start  philosophers
	for( int pid = 0 ; pid < NUMPHILS ; pid++ )
	    {
		philosopher[pid].start() ;
	    }
	
	
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
	
	System.out.println( "1 Butler: butler = " 
			    + butler.availablePermits() ) ;


    }

}

