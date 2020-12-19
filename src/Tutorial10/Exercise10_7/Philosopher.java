package Tutorial10.Exercise10_7;


/** 
A Philosopher's Behaviour
=========================

The behaviour of each philosopher is a cycle:

1.	think, 
2.	when they get hungry they enter the dining room,
3.	sit down at their allotted place,
4.	pickup the fork on their right,
5.	pickup the fork on their left,
6.	eat,
7.	put down the fork on their right,
8.	put down the fork on their left,
9.	leave the dining room.


procedure Philosopher(i : integer);
begin 
   while true do 
   begin 
     Think; 
     claim(Fork[i]); 
     claim(Fork[(i+1) MOD 5]); 
     Eat; 
     release(Fork[i]); 
     release(Fork[(i+1) MOD 5]); 
   end 
end; 

**/


class Philosopher extends SemaphoreThread
{

    // Keeps a count of number of PickedUpForks
    protected static int PickedUpForks = 0 ;

    protected final int NUMGOES = 3 ;

    protected final BinarySemaphore rightfork ;
    protected final BinarySemaphore leftfork  ;

    Philosopher( String id,
		 BinarySemaphore  rightfork, 
		 BinarySemaphore  leftfork  )
    {
	super( id ) ;

	this.rightfork = rightfork ; 
	this.leftfork  = leftfork  ; 
    }

 
    public void run()
    {
	for (int i = 0 ; i < NUMGOES ; i++ )
	{
   
	    report( "Thinking" ) ;

	    rightfork.claim() ; 

	    reportClaim( "rightfork" 
			 + " PickedUpForks = " + ++PickedUpForks ) ;

	    leftfork.claim() ; 

	    reportClaim( "leftfork" 
			 + "  PickedUpForks = " + ++PickedUpForks ) ;

	    report( "Eating" ) ;

	    rightfork.release() ; 

	    reportRelease( "rightfork" 
			 + " PickedUpForks = " + --PickedUpForks ) ;

	    leftfork.release() ; 

	    reportRelease( "leftfork" 
			 + "  PickedUpForks = " + --PickedUpForks ) ;
	}

    report( "TERMINATED" ) ;

    }

}

