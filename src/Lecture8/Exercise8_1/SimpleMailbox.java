package Lecture8.Exercise8_1;

public class SimpleMailbox implements Mailbox{
    private int contents ;

    public int take( )
    {
        printState( "take():"+ contents ) ;

        return contents ;
    }

    public void put( int value )
    {
        printState( "put(" + value + ")  " ) ;

        contents = value ;
    }

    public void printState ( String operation )
    {
        System.out.println( "SimpleMailbox." + operation + this ) ;
    }

    public String toString ( )
    {
        return new String ( "[ contents = " + contents + " ]" ) ;
    }
}
