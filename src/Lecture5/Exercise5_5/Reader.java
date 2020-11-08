package Lecture5.Exercise5_5;

public class Reader extends Thread{
    private SharedVariable sharedVariable;
    private String name;

    public Reader(String name, SharedVariable sharedVariable){
        this.name = name;
        this.sharedVariable = sharedVariable;
    }

    public void run(){
        for ( int i = 0 ; i < 10 ; i++ ){
            System.out.println( this.name + ": " + sharedVariable.value() ) ;
            try {
                sleep( (int)( Math.random()*10 ) );
            }
            catch ( InterruptedException e ) {}
        }
    }

}
