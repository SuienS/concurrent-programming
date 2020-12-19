package Tutorial09.Exercise9_3;

public interface Buffer {
    // Place an item into the buffer
    public void put ( int item ) ;

    // Remove an item from the buffer
    public int take ( ) ;

    // Return a string representation of the buffer
    public String toString ( ) ;
}
