package com.epam.JUnit;

public class Calculator {

    public  double sum(double firstoperand, double secondoperand){
        return  firstoperand+secondoperand;
    }

    public  double subtract(double firstoperand, double secondoperand){
        return  firstoperand-secondoperand;
    }

    public  double multiplication(double firstoperand, double secondoperand){
        return  firstoperand*secondoperand;
    }

    public  double division(double firstoperand, double secondoperand){
        if (secondoperand==0) {
            throw new ArithmeticException("Divide by zero");
        }
        return  firstoperand/ secondoperand;
    }

    public  double getSin(double operand){
        return Math.sin(Math.toRadians(operand));
    }

    public  double getCos(double operand){
        return Math.cos(Math.toRadians(operand));
    }

    public  double getTan(double operand){
        return Math.tan(Math.toRadians(operand));
    }
}
