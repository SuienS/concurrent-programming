package Lecture5.Exercise5_5;

public class Writer extends Thread {
    private String name;
    private SharedVariable sharedVariable;

    public Writer(String name, SharedVariable sharedVariable){
        this.name = name;
        this.sharedVariable = sharedVariable;
    }

    public void run(){
        for ( int i = 0 ; i < 10 ; i++ ){
            int randInt = (int)( Math.random()*10 );
            sharedVariable.assign(randInt);
            System.out.println( this.name + ": " + randInt ) ;
            try {
                sleep( 2000 ) ;
                //sleep( (int)( Math.random()*10 ) );
            }
            catch ( InterruptedException e ) {}
        }
    }
}
