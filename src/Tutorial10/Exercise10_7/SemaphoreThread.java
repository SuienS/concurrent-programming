package Tutorial10.Exercise10_7;


abstract class SemaphoreThread extends Thread
{

    SemaphoreThread( String id )
    {
	super( id ) ;
    }

 
    abstract public void run() ;


    protected void report ( String message )
    {
	System.out.println( getName() + ": " + message ) ;

    }

    protected void reportClaim ( String semaName )
    {
	System.out.println( getName() + ": CLAIMED:  " + semaName ) ;

    }

    protected void reportRelease ( String semaName )
    {
	System.out.println( getName() + ": RELEASED: " + semaName ) ;

    }

}

