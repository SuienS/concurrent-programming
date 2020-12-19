package Tutorial10.Exercise10_6;
/**

General Semaphores 
==================

There are two types of semaphores: binary semaphores (0 or 1) and
general semaphores (n $\geq$ {\tt s} $\geq$ 0).  
\marks{1}
 
Description of semaphore operations: 
\verb|claim(s)|, \verb|release(s)| \& \verb|initialize(s, v)|
\marks{3}
 
The operations \verb|claim(s)| \& \verb|release(s)| are primitive,
i.e.  non--overlapping \& atomic .  Thus they can not be executed
simultaneously, only serially.  


Note: this extends the Java java.util.concurrent.Semaphore class, 
this allows us to use the standard "claim()" method.

**/


import java.util.concurrent.Semaphore ;


class GeneralSemaphore extends Semaphore
{

    //  private static final int NumberOfPermits  ;

    public GeneralSemaphore( int MaxNumberOfPermits, int initialValue ) 
    {
	/** create a Semaphore with:
	    - "MaxNumberOfPermits" permits
	    - "fairness" (true) , ie. FIFO granting of permits 
	       under contention
	**/

	super( MaxNumberOfPermits, true ) ;

	if ( (initialValue < 0 )  || (initialValue > MaxNumberOfPermits) )
	    {
		throw new IllegalArgumentException("\n\t\t" + 
			   "GeneralSemaphore: arg must in 0 .. MaxValue" ) ;
	    }
	else 
	    { // 0 <= initialValue <= MaxNumberOfPermits

		// initially General Semaphore = MaxNumberOfPermits
		// calculate number of permits to acquire:

		int decPermits =  MaxNumberOfPermits - initialValue ;

		// reduce permits by decPermits, i.e. GS = initialValue
		try {
		       acquire( decPermits ) ;
		    } 
		catch (  InterruptedException ie ) {} 
		
	    }
	
    }
    
    public void claim() 
    {
       try{
	   super.acquire() ;
       } catch ( InterruptedException ie ){} ;

    }

    public void release() 
    { 
	super.release() ;
    }

}

