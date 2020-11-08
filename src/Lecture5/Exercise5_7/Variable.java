package Lecture5.Exercise5_7;

public interface Variable {
    void assign(int value);           // assigns it the value

    int value();                       // returns its current value

    boolean isZero();                     // returns true if 0; false if != 0

    boolean isDivisibleBy(int divisor);  // returns true if value is divisible by argument, false otherwise
}
