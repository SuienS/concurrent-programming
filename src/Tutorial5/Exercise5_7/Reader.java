package Tutorial5.Exercise5_7;

public class Reader extends Thread{
    private SharedVariable sharedVariable;
    private String name;
    private int iterations;


    public Reader(String name, SharedVariable sharedVariable, int iterations){
        this.name = name;
        this.sharedVariable = sharedVariable;
        this.iterations = iterations;

    }

    public void run(){
        for ( int i = 0 ; i < iterations ; i++ ){
            System.out.println( this.name + ": " + sharedVariable.value() ) ;
            try {
                sleep( (int)( Math.random()*10 ) );
            }
            catch ( InterruptedException e ) {}
        }
    }

}
