package Tutorial10.Exercise10_6;

class Buffer
{

    public Integer[] buffer ;

    public int in  = 0 ;
    public int out = 0 ;

    public final int SIZE ;


    Buffer ( int SIZE )
    {
	buffer = new Integer[ SIZE ] ;
	this.SIZE = SIZE ;
    }

}
