package Lecture5.Exercise5_7;

public class Writer extends Thread {
    private String name;
    private SharedVariable sharedVariable;
    private int iterations;

    public Writer(String name, SharedVariable sharedVariable, int iterations){
        this.name = name;
        this.sharedVariable = sharedVariable;
        this.iterations = iterations;
    }

    public void run(){
        for ( int i = 0 ; i < iterations ; i++ ){
            int randInt = (int)( Math.random()*10000 );
            sharedVariable.assign(randInt);
            System.out.println( this.name + ": " + randInt ) ;
            try {
                //sleep( 2000 ) ;
                sleep( (int)( Math.random()*10 ) );
            }
            catch ( InterruptedException e ) {}
        }
    }
}
