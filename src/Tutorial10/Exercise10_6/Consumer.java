package Tutorial10.Exercise10_6;

class Consumer extends SemaphoreThread
{

    private BinarySemaphore  mutex ; 
    private GeneralSemaphore free_space ;
    private GeneralSemaphore num_items ;

    private Buffer buffer ;

 
    Consumer( String id,
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
	    num_items.claim() ; 

	    reportClaim( "num_items" ) ;

	    mutex.claim() ; 

	    reportClaim( "mutex" ) ;

	    item = buffer.buffer[buffer.out] ;

	    mutex.release() ; 

	    reportRelease( "mutex" ) ;

	    buffer.out = (buffer.out + 1) % buffer.SIZE ; 

	    reportRelease("free_space" ) ;

	    free_space.release() ; 

	    report( " retrieved: " + item ) ;

	}
    }

}

