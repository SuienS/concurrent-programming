package Lecture5.SimpleThread;

class TwoThreadsTest {

    public static void main(String[] args) {
        Thread firstThread;
        Thread secondThread, thirdThread, fourthThread;

        // Create the 2 threads
        firstThread = new SimpleThread( "FirstThread",   2 ) ;
        secondThread = new SimpleThread( "SecondThread", 7 ) ;
        thirdThread = new SimpleThread( "ThirdThread",   2 ) ;
        fourthThread = new SimpleThread( "FourthThread", 7 ) ;

        firstThread.start();
        secondThread.start();
        thirdThread.start();
        fourthThread.start();
    }

}