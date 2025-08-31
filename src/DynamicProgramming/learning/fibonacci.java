package DynamicProgramming.learning;

import java.util.HashMap;

public class fibonacci {

//    time complexity : O(2^n)
//    space complexity : O(n)
    public long fib(int n){
        if(n<2){
            return 1;
        }
        return fib(n-1) + fib(n-2);
    }

//     pattern 1 :
//   memorization of fibonacci series to stop recomputing  pre computed values
//    for memo we can use a hashmap
//    now this is O(n)
//    time complexity : O(n)
//    space complexity : O(n)
    HashMap<Integer,Long> memo = new HashMap<>();

    public long fibmemo(int n){
        if(n<2){
            return 1;
        }
        if(memo.containsKey(n)){
            return memo.get(n);
        }
        long ans = fibmemo(n-1) + fibmemo(n-2);
        memo.put(n,ans);// here we store the computed answer in memo
        return ans;
    }
    public static void main(String[] args) {
        fibonacci main = new fibonacci();
        System.out.println(main.fib(4));
        System.out.println(main.fib(14));
        System.out.println(main.fib(25));
//        System.out.println(main.fib(50));

        System.out.println(main.fibmemo(4));
        System.out.println(main.fibmemo(14));
        System.out.println(main.fibmemo(25));
        System.out.println(main.fibmemo(50));

    }
}
