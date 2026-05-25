//2657. Find the Prefix Common Array of Two Arrays
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//You are given two 0-indexed integer permutations A and B of length n.
//
//A prefix common array of A and B is an array C such that C[i] is equal to the count of numbers that are present at or before the index i in both A and B.
//
//Return the prefix common array of A and B.
//
//A sequence of n integers is called a permutation if it contains all integers from 1 to n exactly once.
//
//
//
//Example 1:
//
//Input: A = [1,3,2,4], B = [3,1,2,4]
//Output: [0,2,3,4]
//Explanation: At i = 0: no number is common, so C[0] = 0.
//At i = 1: 1 and 3 are common in A and B, so C[1] = 2.
//At i = 2: 1, 2, and 3 are common in A and B, so C[2] = 3.
//At i = 3: 1, 2, 3, and 4 are common in A and B, so C[3] = 4.
//Example 2:
//
//Input: A = [2,3,1], B = [3,1,2]
//Output: [0,1,3]
//Explanation: At i = 0: no number is common, so C[0] = 0.
//At i = 1: only 3 is common in A and B, so C[1] = 1.
//At i = 2: 1, 2, and 3 are common in A and B, so C[2] = 3.
//
//
//Constraints:
//
//1 <= A.length == B.length == n <= 50
//1 <= A[i], B[i] <= n
//It is guaranteed that A and B are both a permutation of n integers.
package HashMap;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class FindThePrefixCommonArrayOfTwoArrays_2657 {
//    approch : here we can use a hashmap and keep a frequnecy if it reach 2 for any value we will
//    increament count by 1
//    if both a[i] && b[i] are different then we check seperately and increament count independenty
//    time complexity : O(n)
//    space complexity : O(n)
    public static int[] findThePrefixCommonArrayHashMap(int[] A, int[] B) {
        HashMap<Integer,Integer> map= new HashMap<>();
        int [] res= new int [A.length];
        int count =0;
        for(int i =0;i<A.length;i++){
            map.put(A[i],map.getOrDefault(A[i],0)+1);
            map.put(B[i],map.getOrDefault(B[i],0)+1);
            if(A[i]==B[i]){
                count++;
                res[i]=count;
                continue;
            }
            if(map.containsKey(A[i]) && map.get(A[i])==2){
                count++;
            }
            if (map.containsKey(B[i]) && map.get(B[i])==2){
                count++;
            }
            res[i]=count;
        }
        return res;
    }
//    approch : here we can create 2 hashset and then iterate over one to find its intersection of bpth sets and put its count at res[i]
//    time complexity : O(n*n)
//    space complexity : O(n)

    public static int[] findThePrefixCommonArrayHashSet(int[] A, int[] B) {
        HashSet<Integer> set1= new HashSet<>();
        HashSet<Integer> set2= new HashSet<>();
        int [] res= new int [A.length];
        for(int i =0;i<A.length;i++){
            set1.add(A[i]);
            set2.add(B[i]);
            res[i]=getCount(set1,set2);

        }
        return res;
    }

    public static int getCount(HashSet<Integer> set1 , HashSet<Integer> set2){
        int res=0;
        for(int x:set1){
            if(set2.contains(x)){
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        //Example 1:

        int [] A1 = {1,3,2,4}, B1 = {3,1,2,4};
        int [] output1= {0,2,3,4};

        //Example 2:

        int [] A2 = {2,3,1}, B2 = {3,1,2};
        int []output2= {0,1,3};


        System.out.println("HashSet Approch :");
        int [] ans1= findThePrefixCommonArrayHashSet(A1,B1);
        int [] ans2= findThePrefixCommonArrayHashSet(A2,B2);
        if (Arrays.equals(output1,ans1)) {
            System.out.println("Case 1 Passed");
        } else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :" + Arrays.toString(output1));
            System.out.println("Your Output :" + Arrays.toString(ans1));
        }

        if (Arrays.equals(output2,ans2)) {
            System.out.println("Case 2 Passed");
        } else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output :" + Arrays.toString(output2));
            System.out.println("Your Output :" + Arrays.toString(ans2));
        }
        System.out.println("HashMap Approch :");
        ans1= findThePrefixCommonArrayHashSet(A1,B1);
        ans2= findThePrefixCommonArrayHashSet(A2,B2);

        if (Arrays.equals(output1,ans1)) {
            System.out.println("Case 1 Passed");
        } else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :" + Arrays.toString(output1));
            System.out.println("Your Output :" + Arrays.toString(ans1));
        }

        if (Arrays.equals(output2,ans2)) {
            System.out.println("Case 2 Passed");
        } else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output :" + Arrays.toString(output2));
            System.out.println("Your Output :" + Arrays.toString(ans2));
        }
    }
}
