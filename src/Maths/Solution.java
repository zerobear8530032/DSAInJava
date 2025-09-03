package Maths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
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