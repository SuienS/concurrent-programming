package Tutorial11;

/**
 * File:      State.java
 * Contents:  See "Condition Synchronisation in FSP", from 
 *            the "FSP to Java" Lecture. 
 * Created:   6/12/18
 * Modified:  6/12/18
 *
 * Notes:     Just a dummy class to use with the GuardedAction class 
 *            in GuardedAction.java.
 */


class State  // a dummy "data" class
{

    private int state ;               // using an int as the "state"
    
    public State( )
    {
	state = 0 ;
    }
    
    public State( int initialState )
    {
	state = initialState ;
    }
    
    public int  getState()
    {
	return state ;
    }

    public boolean cond()    // "cond" defined on the "sate"
    {
        return state == 0  ;   // just chose "== 0" as an arbitrary condition.
    }	
    
} // State

