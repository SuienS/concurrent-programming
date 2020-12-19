package Tutorial10.Exercise10_4;

import java.util.concurrent.Semaphore ;

class Mutex 
{

  public static void main(String args[]) 
  {

      // create a binary semaphore, initialised to 1
      BinarySemaphore mutex = new BinarySemaphore(1) ; 

      Thread mutexprocess[] = new Thread[5] ;

      // create 5 mutex processes
      for( int pid = 0 ; pid < 5 ; pid++ )
	  {
	      mutexprocess[pid] = new MutexProcess( pid, mutex ) ;
	  }

       System.out.println( "Initial State: " 
		   + " mutex = "      + mutex.availablePermits() ) ;


      // start them 
      for( int pid = 0 ; pid < 5 ; pid++ )
	  {
	      mutexprocess[pid].start() ;
	  }


      // wait for them all to die
      try { 
	    
	  for( int pid = 0 ; pid < 5 ; pid++ )
	      {
		  mutexprocess[pid].join() ;
	      }
       } 
      catch ( InterruptedException ie ) {} ;

      System.out.println( "Final State: " 
		   + " mutex = " + mutex.availablePermits() ) ;



  }

}
