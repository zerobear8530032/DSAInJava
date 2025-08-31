//2787. Ways to Express an Integer as Sum of Powers
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//Given two positive integers n and x.
//
//Return the number of ways n can be expressed as the sum of the xth power of unique positive integers, in other words, the number of sets of unique integers [n1, n2, ..., nk] where n = n1x + n2x + ... + nkx.
//
//Since the result can be very large, return it modulo 109 + 7.
//
//For example, if n = 160 and x = 3, one way to express n is n = 23 + 33 + 53.
//
//
//
//Example 1:
//
//Input: n = 10, x = 2
//Output: 1
//Explanation: We can express n as the following: n = 32 + 12 = 10.
//It can be shown that it is the only way to express 10 as the sum of the 2nd power of unique integers.
//Example 2:
//
//Input: n = 4, x = 1
//Output: 2
//Explanation: We can express n in the following ways:
//- n = 41 = 4.
//- n = 31 + 11 = 4.
//
//
//Constraints:
//
//1 <= n <= 300
//1 <= x <= 5
package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class WaysToExpressAnIntegerAsSumOfPowers_2787 {

    public static int numberOfWays(int n, int x) {
        List<Integer> nums = new ArrayList<>();
        int num=1;
        while(Math.pow(num,x)<=n){
            nums.add(num);
            num++;
        }
        return dfs(nums,n,0,x);
    }

    public static int dfs(List<Integer> values, int target, int idx, int exp){
        if(target==0){
            return 1;
        }
        if(target<0){
            return 0;
        }
        if(idx>=values.size()){
            return 0;
        }
        int res=0;
        for(int i =idx;i<values.size();i++){
            int num =(int)Math.pow(values.get(i),exp);
            if(target-num>=0){
                res+=dfs(values,target-num,i+1,exp);
            }
        }
        return res;
    }
    public static void main(String[] args) {

        //Example 1:

        int n1 = 10, x1 = 2;
        int output1=1;

        //Example 2:

        int n2 = 4, x2 = 1;
        int output2=2;

        int ans1= numberOfWays(n1,x1);
        int ans2= numberOfWays(n2,x2);

        System.out.println(ans1);
        System.out.println(ans2);



    }
}
