package Lecture6.Exercise6_8;

public class Writer extends Thread {
    private String name;
    private SharedVariable sharedVariable1, sharedVariable2;
    private int iterations;
    private boolean terminate;

    public Writer(String name, SharedVariable sharedVariable1, SharedVariable sharedVariable2, int iterations){
        this.name = name;
        this.sharedVariable1 = sharedVariable1;
        this.sharedVariable2 = sharedVariable2;
        this.iterations = iterations;
        this.terminate = false;
    }

    public void setTerminate(boolean terminate){
        this.terminate = terminate;
    }

    public void run(){
        while (!terminate){
            int randInt1 = (int)( Math.random()*10000 );
            sharedVariable1.assign(randInt1);
            System.out.println( this.name + " assigned: X " + randInt1 ) ;
            int randInt2 = (int)( Math.random()*10000 );
            sharedVariable2.assign(randInt2);
            System.out.println( this.name + " assigned: Y " + randInt2 ) ;
            try {
                //sleep( 2000 ) ;
                sleep( (int)( Math.random()*10 ) );
            }
            catch ( InterruptedException e ) {}
        }
    }
}
