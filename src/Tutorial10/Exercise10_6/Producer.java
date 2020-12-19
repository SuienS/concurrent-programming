package Tutorial10.Exercise10_6;

class Producer extends SemaphoreThread
{

    private BinarySemaphore  mutex ; 
    private GeneralSemaphore free_space ;
    private GeneralSemaphore num_items ;

    private Buffer buffer ;

 
    Producer( String id,
	      BinarySemaphore  mutex, 
	      GeneralSemaphore free_space, 
	      GeneralSemaphore num_items,
	      Buffer buffer )
    {
	super( id ) ;

	this.mutex = mutex ; 
	this.free_space = free_space ;
	this.num_items = num_items ;
 	this.buffer = buffer ;
    }


    public void run()
    { 
	Integer item = null ;

	for (int i = 0 ; i < 10 ; i++ )
	{
	    item = new Integer ( i ) ;
   
	    free_space.claim() ; 

	    reportClaim( "free_space" ) ;

	    mutex.claim() ; 

	    reportClaim( "mutex" ) ;

	    buffer.buffer[buffer.in] = item ; 

	    report( " inserted:  " + item ) ;

	    mutex.release() ; 

	    reportRelease( "mutex" ) ;

	    buffer.in = (buffer.in + 1) % buffer.SIZE ; 

	    num_items.release() ; 

	    reportRelease( "num_items" ) ;
	}
    }
}

