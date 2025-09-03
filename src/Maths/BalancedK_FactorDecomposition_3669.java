//3669. Balanced K-Factor Decomposition
//Solved
//Medium
//premium lock icon
//Companies
//Hint
//Given two integers n and k, split the number n into exactly k positive integers such that the product of these integers is equal to n.
//
//Return any one split in which the maximum difference between any two numbers is minimized. You may return the result in any order.
//
//
//
//Example 1:
//
//Input: n = 100, k = 2
//
//Output: [10,10]
//
//Explanation:
//
//The split [10, 10] yields 10 * 10 = 100 and a max-min difference of 0, which is minimal.
//
//Example 2:
//
//Input: n = 44, k = 3
//
//Output: [2,2,11]
//
//Explanation:
//
//Split [1, 1, 44] yields a difference of 43
//Split [1, 2, 22] yields a difference of 21
//Split [1, 4, 11] yields a difference of 10
//Split [2, 2, 11] yields a difference of 9
//Therefore, [2, 2, 11] is the optimal split with the smallest difference 9.
//
//
//
//Constraints:
//
//4 <= n <= 105
//2 <= k <= 5
//k is strictly less than the total number of positive divisors of n.

package Maths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class BalancedK_FactorDecomposition_3669 {
//    approch simple just find all factors of n
//    and try every possible way to get the product equal to n with k elements
//    at the end we can find max and min difference by checking all the wyas
//    time and space complexity :
//    Aspect	Complexity
//Number of factors	O(√n)
//Time for generating all k-tuples	O((√n)^k)
//Sorting factors	O(√n log √n)
//Space for factors	O(√n)
//Space for recursion stack	O(k)
//Space for storing all ways	O((√n)^k * k)
    public static int[] minDifference(int n, int k) {
        List<Integer> factors = new ArrayList<>();
        for(int i =1;i*i<=n;i++){
            if(n%i==0){
                factors.add(i);
                if(n/i!=i){
                    factors.add(n/i);
                }
            }
        }
        // now check every single pairs
        // first sort the prime factors to keep the rest sorted
        Collections.sort(factors);
        List<List<Integer>> ways = new ArrayList();
        generateWays(n,ways,new ArrayList(),factors,0,k,1);
        List<Integer>res=null;
        int minDiff= Integer.MAX_VALUE;
        for(List<Integer> way:ways){
            int max = way.get(0);
            int min = way.get(way.size()-1);
            int diff= max-min;
            if(diff<minDiff){
                res=way;
            }
        }

        return  res.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void generateWays(int n, List<List<Integer>> ways,List<Integer> currRes, List<Integer> factors, int idx, int k, int prod ){
        // Base case: found a valid combination
        if (prod == n && k == 0) {
            ways.add(new ArrayList<>(currRes));
            return;
        }

        // Stop exploring invalid paths
        if (prod > n || k == 0 || idx >= factors.size()) return;

        if(idx>=factors.size()){
            return ;
        }
        for(int i =idx;i<factors.size();i++){
            int curr= factors.get(i);
            currRes.add(curr);
            generateWays(n,ways,currRes,factors,i,k-1,prod*curr);
            currRes.remove(currRes.size()-1);
        }
    }

    public static void main(String[] args) {
        //Example 1:

        int  n1 = 100, k1 = 2;
        int [] output1={10,10};

        //Example 2:

        int n2=44, k2=3;
        int [] output2={2,2,11};



        int [] ans1= minDifference(n1,k1);
        int [] ans2= minDifference(n2,k2);


        if(Arrays.equals(ans1,output1)) {
            System.out.println("Case 1 Passed ");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Excepted Output : "+ Arrays.toString(output1));
            System.out.println("Your Output : "+ Arrays.toString(ans1));
        }
        if(Arrays.equals(ans2,output2)) {
            System.out.println("Case 2 Passed ");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Excepted Output : "+ Arrays.toString(output2));
            System.out.println("Your Output : "+ Arrays.toString(ans2));
        }


    }
}