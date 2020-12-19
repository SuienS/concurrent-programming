package Tutorial6.Exercise6_4;

public class Reader extends Thread{
    private SharedVariable sharedVariable1, sharedVariable2;
    private String name;
    private int iterations;


    public Reader(String name, SharedVariable sharedVariable1, SharedVariable sharedVariable2, int iterations){
        this.name = name;
        this.sharedVariable1 = sharedVariable1;
        this.sharedVariable2 = sharedVariable2;
        this.iterations = iterations;

    }

    public void run(){
        synchronized ( sharedVariable1 )  // the "X" object acts as the LOCK
        {
            for ( int i = 0 ; i < iterations ; i++ ){
                System.out.println( this.name + " read X: " + sharedVariable1.value() ) ;
                System.out.println( this.name + " read Y: " + sharedVariable2.value() ) ;
                try {
                    sleep( (int)( Math.random()*1000 ) );
                    System.out.println(getState());
                }
                catch ( InterruptedException e ) {}
            }
        }
    }

}
