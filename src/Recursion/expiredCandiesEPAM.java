package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class expiredCandiesEPAM {

    public static int waysToEat(int N , List<Integer> expired){
        int [] candies = new int [N];
        for(int x:expired){
            candies[x-1]=-1;
        }
        return helper(candies,0,true)+ helper(candies,1,true);
    }
    public static int helper(int [] candies, int i , boolean skip){
        if(i>=candies.length-1){
            return 1;
        }
        if(candies[i]==-1){
            return 0;
        }
        int skipped = 0;
        int continuos = 0;
        if(skip){
            skipped+= helper(candies,i+1,skip); // here we can eat the next candy
            skipped+= helper(candies,i+2,!skip);// here we skip next one
        }else{
            continuos+=  helper(candies,i+1,!skip);
        }
        return  skipped+continuos;
    }


    public static void main(String[] args) {

        int N1= 4;
        List<Integer> expired1= new ArrayList<>(Arrays.asList(3));

        System.out.println(waysToEat(N1,expired1));
    }
}
