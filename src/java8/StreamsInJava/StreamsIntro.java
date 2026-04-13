package java8.StreamsInJava;

import java.util.Arrays;
import java.util.function.IntUnaryOperator;

public class StreamsIntro {
    public static void main(String[] args) {
        int [] arr = {9,8,7,6,5,4,3,2,1,0};
        long count=Arrays.stream(arr).filter(x->x%2==0).count();
        System.out.println(count);
    }
}
