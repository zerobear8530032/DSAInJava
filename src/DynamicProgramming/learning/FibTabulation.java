package DynamicProgramming.learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FibTabulation {

    public static long fibonacci(int n){
        long [] table= new long [n+3];
        table[1]=1;
        for(int i =0;i<=n;i++){
            table[i]=table[i-1]+table[i-2];
        }
        return table[n];
    }

    public static void main(String[] args) {

        System.out.println(fibonacci(6));
        System.out.println(fibonacci(7));
        System.out.println(fibonacci(8));
        System.out.println(fibonacci(50));

    }
}
