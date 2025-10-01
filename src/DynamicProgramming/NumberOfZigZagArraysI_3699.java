//3699. Number of ZigZag Arrays I
//Hard
//premium lock icon
//Companies
//Hint
//You are given three integers n, l, and r.
//
//A ZigZag array of length n is defined as follows:
//
//Each element lies in the range [l, r].
//No two adjacent elements are equal.
//No three consecutive elements form a strictly increasing or strictly decreasing sequence.
//Return the total number of valid ZigZag arrays.
//
//Since the answer may be large, return it modulo 109 + 7.
//
//A sequence is said to be strictly increasing if each element is strictly greater than its previous one (if exists).
//
//A sequence is said to be strictly decreasing if each element is strictly smaller than its previous one (if exists).
//
//
//
//Example 1:
//
//Input: n = 3, l = 4, r = 5
//
//Output: 2
//
//Explanation:
//
//There are only 2 valid ZigZag arrays of length n = 3 using values in the range [4, 5]:
//
//[4, 5, 4]
//[5, 4, 5]​​​​​​​
//Example 2:
//
//Input: n = 3, l = 1, r = 3
//
//Output: 10
//
//Explanation:
//
//There are 10 valid ZigZag arrays of length n = 3 using values in the range [1, 3]:
//
//[1, 2, 1], [1, 3, 1], [1, 3, 2]
//[2, 1, 2], [2, 1, 3], [2, 3, 1], [2, 3, 2]
//[3, 1, 2], [3, 1, 3], [3, 2, 3]
//All arrays meet the ZigZag conditions.
//
//
//
//Constraints:
//
//3 <= n <= 2000
//1 <= l < r <= 2000
package DynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// even after memorization thsi is giving me TLE
public class NumberOfZigZagArraysI_3699 {
//   approch :
//    we can create a zig zag array by just making a array of length where one element is greater then prev or smaller then prev
//    by repeating this pattern we can do that
//    but we can only use range of element l-r
//    so in order to get element
//    to choose smaller we need to use element which are on left hand side of previous choosen element
//    to choose greater we need to use element which are on right hand side of previous choosen element
//    by simulating this we can just create the  zigzag array using recursion
//    a small optimization here we can do we can start the answer in both direction
//    but we can reduce computation by trying a single direction first
//    and then multiply it by 2
//    this will give answer of both directions
//   time complexity : O(r-l+1)^n
//   space complexity : O(n)

    static int MOD = 1000000007;
    public static int zigZagArraysBruteForce(int n, int l, int r) {
        List<Integer> nums = new ArrayList<>();
//        here one origin is from left and one form right
//        return (helperBruteForce(n,l,r,nums,'R',l)+helperBruteForce(n,l,r,nums,'L',r))%MOD;// here we explore both directions
//        here we explored a single direction and multiply it by 2
        return (helperBruteForce(n,l,r,nums,'R',l)*2)%MOD;
    }

    public static int helperBruteForce(int n ,int l , int r ,List<Integer> nums,  char direction, int origin){
        if(n==nums.size()){
//            System.out.println(nums);
            return 1;
        }
        if(origin <l || origin>r){
            return 0;
        }
        int res=0;
        if(direction=='R'){
            for(int i =origin;i<=r;i++){
                nums.add(i);
                res=(res+helperBruteForce(n,l,r,nums,'L',i-1))%MOD;
                nums.remove(nums.size()-1);
            }
        }else{
            for(int i =origin;i>=l;i--){
                nums.add(i);
                res=(res+helperBruteForce(n,l,r,nums,'R',i+1))%MOD;
                nums.remove(nums.size()-1);
            }
        }
        return res%MOD;
    }


    public static int zigZagArraysBetter(int n, int l, int r) {
        List<Integer> nums = new ArrayList<>();
        HashMap<String,Integer> memo= new HashMap<String,Integer>();
//        here one origin is from left and one form right
//        return (helperBetter(n,l,r,nums,'R',l,memo)+helperBetter(n,l,r,nums,'L',r,memo))%MOD;// here we explore both directions
//        here we explored a single direction and multiply it by 2
        return (helperBetter(n,l,r,nums,'R',l,memo)*2)%MOD;
    }

    public static int helperBetter(int n ,int l , int r ,List<Integer> nums,  char direction, int origin, HashMap<String,Integer> memo){
        String key = origin+","+direction+","+nums.size();
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        if(n==nums.size()){
//            System.out.println(nums);
            return 1;
        }
        if(origin <l || origin>r){
            return 0;
        }
        int res=0;
        if(direction=='R'){
            for(int i =origin;i<=r;i++){
                nums.add(i);
                res=(helperBetter(n,l,r,nums,'L',i-1,memo)+res)%MOD;
                nums.remove(nums.size()-1);
            }
        }else{
            for(int i =origin;i>=l;i--){
                nums.add(i);
                res=(helperBetter(n,l,r,nums,'R',i+1,memo)+res)%MOD;
                nums.remove(nums.size()-1);
            }
        }
        memo.put(key,res%MOD);
        return res%MOD;
    }

    public static void main(String[] args) {
        //Example 1:

        int n1 = 3, l1= 4, r1 = 5;
        int output1=2;

        //Example 2:

        int n2 = 3, l2= 1, r2 = 3;
        int output2=10;

        //Example 3:

        int n3 = 7, l3=9, r3 = 39;
        int output3=650716800;
        System.out.println("Brute Force Approch :");

        int ans1 = zigZagArraysBruteForce(n1,l1,r1);
        int ans2 = zigZagArraysBruteForce(n2,l2,r2);
        int ans3 = zigZagArraysBruteForce(n3,l3,r3);

        if(output1==ans1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+(output1));
            System.out.println("Your Answer :"+ (ans1));
        }
        if(output2==ans2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+(output2));
            System.out.println("Your Answer :"+ (ans2));
        }if(output3==ans3) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Ouput :"+(output3));
            System.out.println("Your Answer :"+ (ans3));
        }

        System.out.println("Better Force Approch :");

        ans1 = zigZagArraysBetter(n1,l1,r1);
        ans2 = zigZagArraysBetter(n2,l2,r2);
        ans3 = zigZagArraysBetter(n3,l3,r3);



        if(output1==ans1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+(output1));
            System.out.println("Your Answer :"+ (ans1));
        }
        if(output2==ans2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+(output2));
            System.out.println("Your Answer :"+ (ans2));
        }if(output3==ans3) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Ouput :"+(output3));
            System.out.println("Your Answer :"+ (ans3));
        }

    }
}
