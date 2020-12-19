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


class RunDiningPhils
{

    public static void main(String args[]) 
    {

	System.out.println( "Starting the Dining Philosophers" ) ;

	DiningPhils diningphils = new DiningPhils() ; 

    }

}

