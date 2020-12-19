package Tutorial10.Exercise10_6;

/**
The Producer/Consumer problem
=============================

With multiple producers & consumers.

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

class MultiProdCon
{

    protected final int NUMPRODS = 3 ;
    protected final int NUMCONS  = 3 ;

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


    protected Thread producer[] = new Thread[NUMPRODS] ;

    protected Thread consumer[] = new Thread[NUMCONS] ;


    MultiProdCon()
    {

      // create  producers 
      for( int pid = 0 ; pid < NUMPRODS ; pid++ )
      {
	 producer[pid] = new Producer( "Producer" + pid,
				       mutex, free_space, num_items, 
				       buffer) ; 
      }

      // create  consumers
      for( int pid = 0 ; pid < NUMCONS ; pid++ )
      {
  	 consumer[pid] = new Consumer( "Consumer" + pid,
				       mutex, free_space, num_items, 
				       buffer) ; 
      }

      reportSemaphoresStatus( "Initial State" ) ;

      // start them 
      for( int pid = 0 ; pid < NUMPRODS ; pid++ )
          {
              producer[pid].start() ;
          }
 
      // start them 
      for( int pid = 0 ; pid < NUMCONS ; pid++ )
          {
	      consumer[pid].start() ;
          }


      // wait for them all to die
      try { 
	    
	  for( int pid = 0 ; pid < NUMPRODS ; pid++ )
	      {
		  producer[pid].join() ;
	      }
 
	  for( int pid = 0 ; pid < NUMCONS ; pid++ )
	      {
		  consumer[pid].join() ;
	      }
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
