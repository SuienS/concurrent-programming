package Tutorial10.Exercise10_4;

/**

Binary Semaphores 
=================

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


class BinarySemaphore extends Semaphore
{

    private static final int NumberOfPermits = 1 ;

    public BinarySemaphore( int initial_value )  // [1 mark]
    {
	super( NumberOfPermits ) ;

	if ( initial_value == 1 )
	    {
		// Semaphore = "1", ie. an aquire (claim) would be ok
		// default => no action
	    }
	else if ( initial_value == 0 )
	    { 
		// set Semaphore to "0". ie. an aquire (claim) would get blocked
		int numbpermits = this.drainPermits() ;
	    }
	else 
	    {
		throw new IllegalArgumentException("\n\t\t" + 
			   "BinarySemaphore: arg must be 0 or 1" ) ;
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


    /**    public String toString() 
    {
	return new String( getName() + " = " + this.availablePermits() ) ;
    }

    public String getName() 
    {
    extract or get its name possibly as an arg to constructor??
	return  this.super.toString() ;
    }
    **/



}

