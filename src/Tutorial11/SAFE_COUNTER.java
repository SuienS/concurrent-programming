package Tutorial11;

/**
 * File:      SAFE_COUNTER.java
 * Contents:  See the FSP Ornamental Garden problem, used in 
 *            the "FSP to Java" Lecture. 
 * Created:   6/12/18
 * Modified:  6/12/18
 *
 * Usage:     to get equivalent of the FSP: "US_COUNT[ 0 ]", use:
 *
 *            SAFE_COUNTER counter = new SAFE_COUNTER( 0 ) ; 
 */


class SAFE_COUNTER   // a ‘‘monitor’’
{

    private int value = 0 ;

    public SAFE_COUNTER( int initial )
    {
	value = initial ;
    }

    
    public synchronized void increment()
    {
	int temp = value ;   // "read[ x : CR ]"

	value = temp + 1 ;   // "write[ x + 1]"
    }
    
}

