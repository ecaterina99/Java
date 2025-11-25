package org.example;

public class MyMath {

    public static double divide(int a, int b) {
        if(b==0){
            throw new ArithmeticException("Can't divide by zero");
        }
        return a / b;
    }
}
