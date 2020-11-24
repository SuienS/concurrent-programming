package Lecture7.Exercise7_3;

class RaceTest {
    final static int NumRunners = 2 ;
    public static void main( String args[] )
    {
        PoliteRunner runners[] = new PoliteRunner[ NumRunners ] ;
        for ( int i = 0 ; i < NumRunners ; i++ )
        {
            runners[i] = new PoliteRunner( i ) ;
            runners[i].setPriority( 2 ) ;
        }
        for ( int i = 0 ; i < NumRunners ; i++ )
        {
            runners[i].start() ;
        }
    }
}
