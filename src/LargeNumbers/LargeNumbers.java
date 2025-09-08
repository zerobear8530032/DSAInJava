package LargeNumbers;

import java.math.BigInteger;

public class LargeNumbers {
    public static void main(String[] args) {
        int a= 23;
        int b = 67;
//        this will create a big integer by long values
        BigInteger A= BigInteger.valueOf(234234235);
//        this create big integer using stirng
        BigInteger B= new BigInteger("234234234234234234234234");
//        constants in big integers:

        BigInteger C=BigInteger.ZERO;
        BigInteger D=BigInteger.TEN;

//        adding bigintegers:

        BigInteger sum=A.add(B);
        BigInteger sub = A.subtract(B);
        BigInteger mul = A.multiply(B);
        BigInteger div = A.divide(B);
        BigInteger mode = A.remainder(B);


        System.out.println("A : " +A);
        System.out.println("B : "+B);
        System.out.println(sum);
        System.out.println(sub);
        System.out.println(mul);
        System.out.println(div);
        System.out.println(mode);

        System.out.println(A.max(A));


    }
}
