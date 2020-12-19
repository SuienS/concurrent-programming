package Tutorial8.Exercise8_3;

public class Producer extends Thread{
    private final Mailbox mailbox ; // Mailbox "interface"
    private final int numberOfItems ;

    public Producer( Mailbox mailbox,
                     int Pid,
                     int numberOfItems )
    {
        super( "Producer #" + Pid ) ;  // Thread( thrd_name )
        this.mailbox = mailbox ;
        this.numberOfItems = numberOfItems ;
    }

    public void run()
    {
        for (int i = 0; i < numberOfItems; i++)
        {
            mailbox.put(i) ;
            System.out.println(getName() + " put:   " + i) ;
            try {
                sleep( (int)(Math.random() * 1000) ) ;
            }
            catch (InterruptedException e) { }
        }
    }
}
