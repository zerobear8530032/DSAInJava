//Boolean Parenthesization
//Solved
//Difficulty: HardAccuracy: 20.15%Submissions: 159K+Points: 8Average Time: 30m
//You are given a boolean expression s containing
//    'T' ---> true
//    'F' ---> false
//and following operators between symbols
//   &   ---> boolean AND
//    |   ---> boolean OR
//   ^   ---> boolean XOR
//Count the number of ways we can parenthesize the expression so that the value of expression evaluates to true.
//
//Note: The answer is guaranteed to fit within a 32-bit integer.
//
//Examples:
//
//Input: s = "T|T&F^T"
//Output: 4
//Explaination: The expression evaluates to true in 4 ways: ((T|T)&(F^T)), (T|(T&(F^T))), (((T|T)&F)^T) and (T|((T&F)^T)).
//Input: s = "T^F|F"
//Output: 2
//Explaination: The expression evaluates to true in 2 ways: ((T^F)|F) and (T^(F|F)).
//Constraints:
//1 ≤ |s| ≤ 100
package DynamicProgramming;

public class BooleanParenthesization_GFG {
//    approch :
//    here we have to use MCM where we try to find how we can make true and false on every sub problem in left andd right side
//    to try every single possibility
//    time complexity : O(m*n*k)
//    space complexity : O(m*n*k)
        static int countWays(String s) {
            Integer [][][] memo = new Integer[s.length()+1][s.length()+1][2];
            return solve(s,0,s.length()-1,true,memo);
        }

        public static int solve(String s , int i, int j , boolean isTrue, Integer [][][] memo){
            if(isTrue && memo[i][j][1]!=null){
                return memo[i][j][1];
            }else if(!isTrue && memo[i][j][0]!=null){
                return memo[i][j][0];
            }
            if(i==j){
                if(s.charAt(i)=='T'){
                    return isTrue==true ? 1:0;
                }else{
                    return isTrue==false?1:0;
                }
            }
            if(i>j){
                return 0;
            }
            int ans =0;
            for(int k = i+1;k<=j-1;k+=2){
                int lt= solve(s,i,k-1,true,memo);
                int lf= solve(s,i,k-1,false,memo);
                int rt= solve(s,k+1,j,true,memo);
                int rf= solve(s,k+1,j,false,memo);
                char ch = s.charAt(k);
                if(ch=='&'){
                    if(isTrue){
                        ans+= lt * rt;
                    }else{
                        ans+= lt * rf + lf * rt + lf* rf;
                    }
                }else if(ch=='|'){
                    if(isTrue){
                        ans+= lt * rt + lt * rf + lf * rt;
                    }else{
                        ans+= lf * rf;
                    }
                }else if(ch=='^'){
                    if(isTrue){
                        ans+= lt * rf + lf * rt;
                    }else{
                        ans+= lt * rt + lf * rf;
                    }
                }
            }
            if(isTrue){
                memo[i][j][1]=ans;
            }else{
                memo[i][j][0]=ans;
            }
            return ans;
        }

    public static void main(String[] args) {
        //Examples:

        String s1 = "T|T&F^T";
        int output1=4;



        String s2 = "T^F|F";
        int output2= 2;


        int ans1=countWays(s1);
        int ans2=countWays(s2);
        if(ans1==output1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Output :"+ (output1));
            System.out.println("Your Answer :"+ (ans1));
        }
        if(ans2== output2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Output :"+ (output2));
            System.out.println("Your Answer :"+ (ans2));
        }
    }
}
