package Lecture6.Exercise6_8;

public class Reader extends Thread{
    private SharedVariable sharedVariable1, sharedVariable2;
    private String name;
    private int iterations;
    private boolean terminate;



    public Reader(String name, SharedVariable sharedVariable1, SharedVariable sharedVariable2, int iterations){
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
            System.out.println( this.name + " read X: " + sharedVariable1.value() ) ;
            System.out.println( this.name + " read Y: " + sharedVariable2.value() ) ;
            try {
                sleep( (int)( Math.random()*10 ) );
            }
            catch ( InterruptedException e ) {}
        }
    }

}
