package Tutorial6.Exercise6_4;

public class SharedVariable implements Variable {
    private int data;

    public SharedVariable(){
        this.data = 0;
    }

    public SharedVariable(int data){
        this.data = data;
    }

    @Override
    public void assign(int value) {
        this.data = value;
    }

    @Override
    public int value() {
        return this.data;
    }

    @Override
    public boolean isZero() {
        boolean isZero = false;
        if (this.data == 0) {
            isZero = true;
        }
        return isZero;
    }

    @Override
    public boolean isDivisibleBy(int divisor) {
        boolean isDivisible = false;
        if((this.data % divisor) ==0) {
            isDivisible = true;
        }
        return isDivisible;
    }
}
