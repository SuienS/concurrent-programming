package Tutorial10.Exercise10_6;

/**
The Producer/Consumer problem
=============================

Semaphores used in Producer/Consumer Problem:

* mutex:
   is a BinarySemaphore used to ensure mutual exclusion for access to the 
   buffer.

* free_space:
   is a GeneralSemaphore which indicates how many free slots there are in
   the buffer.

* num_item:
   is a GeneralSemaphore which indicates the number of items which are 
   currently in the buffer.


What should the initial values of these semaphores be?

**/


import java.util.concurrent.Semaphore ;

class ProdCon
{

    protected final int BUFFERSIZE = 3 ; // size of the buffer ;

    protected Buffer buffer  = new Buffer( BUFFERSIZE ) ;

    // create a binary semaphore, initialised to 1
    protected BinarySemaphore mutex = new BinarySemaphore( 1 ) ; 
      
    // create a General semaphore, initialised to BUFFERSIZE
    protected GeneralSemaphore free_space 
			= new GeneralSemaphore(BUFFERSIZE, BUFFERSIZE) ;

    // create a General semaphore, initialised to 0
    protected GeneralSemaphore num_items  
			= new GeneralSemaphore(BUFFERSIZE, 0) ;


    ProdCon() 
    {

	Producer producer = new Producer("Producer" ,
					 mutex, free_space, num_items, 
					 buffer) ; 

	Consumer consumer = new Consumer("Consumer",
					 mutex, free_space, num_items, 
					 buffer) ; 


	reportSemaphoresStatus( "Initial State" ) ;

	consumer.start() ;

	producer.start() ;


	try {
	    producer.join() ;
	    consumer.join() ;
	} 
	catch ( InterruptedException ie ) {} ;

       reportSemaphoresStatus( "Final State" ) ;

    }


    protected void reportSemaphoresStatus(String caption) 
    {
	System.out.println( caption +" [BUFFERSIZE = " + BUFFERSIZE +"]: " ) ;
	
	System.out.println( "Semaphores: " 
		   + " mutex = "      + mutex.availablePermits() 
		   + " free_space = " + free_space.availablePermits() 
		   + " num_items = "  + num_items.availablePermits()  ) ;
    }


}
