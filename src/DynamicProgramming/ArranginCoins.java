package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArranginCoins {
    public static List<Long> arrangeCoins(List<Long> coins){
        List<Long> res= new ArrayList<>();
        for(long x:coins){
            res.add(findRows(x));
        }
        return res;
    }
    public static long findRows(long n){
        long s=0;
        long e= n;
        while(s<=e){
            long mid = s+(e-s)/2;
            long coins = mid*(mid+1)/2;
            if(coins<n){
                s=mid+1;
            }else if(coins>n){
                e=mid-1;
            }else {
                return mid;
            }
        }
        return e;
    }
    public static void main(String[] args) {

       List<Long> coins = new ArrayList<>(Arrays.asList(6l,7l,8l,9l));
       List<Long> ans1= arrangeCoins(coins);
    }
}
