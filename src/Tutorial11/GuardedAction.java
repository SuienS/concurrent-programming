package Tutorial11;

/**
 * File:      GuardedAction.java
 * Contents:  See "Condition Synchronisation in FSP", from 
 *            the "FSP to Java" Lecture. 
 * Created:   6/12/18
 * Modified:  6/12/18
 *
 * Notes:  The basic format for modelling a "guarded action" for 
 *         some condition "cond" & action "action" using FSP is 
 *         shown below:
 *
 *                 FSP: when ( cond ) action -> NEWSTATE
 *
 */


class GuardedAction         // a "monitor"
{

    private State state ;   // using a dummy "State" class
                            // to represent the systems state.

    private boolean cond ; 
    
    public GuardedAction( State initialState )
    {
	state = initialState ;
    }

    
    public synchronized void  action()  throws InterruptedException
    {
	
	while ( ! state.cond() )             // "when ( cond )"
	{
	    wait() ;                  // cond = false
	}
	
	// cond == true
	// "action -> NEWSTATE"
	// modify monitor data based on "action -> NEWSTATE"

        State newState = new State( /* NEWSTATE data */ ) ;
	
	state = newState ;

	notifyAll() ;

    } // action
    
} // GuardedAction

