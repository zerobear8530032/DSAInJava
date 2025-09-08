package LargeNumbers;

import java.math.BigInteger;

public class Factorial {
    public BigInteger  factorial(int  num){
        BigInteger fact= BigInteger.ONE;
        for(int i =2;i<=num;i++){
            fact= fact.multiply(BigInteger.valueOf(i));
        }
        return fact;
    }
    public static void main(String[] args) {

        Factorial obj = new Factorial();
        BigInteger f1=obj.factorial(5);
        BigInteger f2=obj.factorial(25);
        BigInteger f3=obj.factorial(100);
        BigInteger f4=obj.factorial(1000);

        System.out.println(f1);
        System.out.println(f2);
        System.out.println(f3);
        System.out.println(f4);

    }
}
