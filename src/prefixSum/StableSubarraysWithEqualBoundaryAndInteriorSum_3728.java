//3728. Stable Subarrays With Equal Boundary and Interior Sum
//Attempted
//Medium
//premium lock icon
//Companies
//Hint
//You are given an integer array capacity.
//
//A subarray capacity[l..r] is considered stable if:
//
//Its length is at least 3.
//The first and last elements are each equal to the sum of all elements strictly between them (i.e., capacity[l] = capacity[r] = capacity[l + 1] + capacity[l + 2] + ... + capacity[r - 1]).
//Return an integer denoting the number of stable subarrays.
//
//
//
//Example 1:
//
//Input: capacity = [9,3,3,3,9]
//
//Output: 2
//
//Explanation:
//
//[9,3,3,3,9] is stable because the first and last elements are both 9, and the sum of the elements strictly between them is 3 + 3 + 3 = 9.
//[3,3,3] is stable because the first and last elements are both 3, and the sum of the elements strictly between them is 3.
//Example 2:
//
//Input: capacity = [1,2,3,4,5]
//
//Output: 0
//
//Explanation:
//
//No subarray of length at least 3 has equal first and last elements, so the answer is 0.
//
//Example 3:
//
//Input: capacity = [-4,4,0,0,-8,-4]
//
//Output: 1
//
//Explanation:
//
//[-4,4,0,0,-8,-4] is stable because the first and last elements are both -4, and the sum of the elements strictly between them is 4 + 0 + 0 + (-8) = -4
//
//
//
//Constraints:
//
//3 <= capacity.length <= 105
//-109 <= capacity[i] <= 109
package prefixSum;

import java.util.*;

public class StableSubarraysWithEqualBoundaryAndInteriorSum_3728 {
    public static long countStableSubarrays(int[] capacity) {
        int [] prefixSum = new int [capacity.length];
        int sum = 0;

        HashMap<Integer, List<Integer>> indexMap= new HashMap<>();
        for(int i=0;i<capacity.length;i++){
            sum+= capacity[i];
            prefixSum[i]=sum;
            if(indexMap.containsKey(capacity[i])){
                indexMap.get(capacity[i]).add(i);
            }else{
                List<Integer> indexes= new ArrayList<>();
                indexes.add(i);
                indexMap.put(capacity[i],indexes);
            }
        }

        long res=0;
        for(Map.Entry<Integer,List<Integer>> entry:indexMap.entrySet()){
            int boundaryValue = entry.getKey();
            List<Integer> indexes = entry.getValue();
            for(int i =0;i<indexes.size();i++){
                for(int j =i+1;j<indexes.size();j++){
                    if(checkValid(boundaryValue,indexes.get(i),indexes.get(j),prefixSum)){
                        res++;
                    }
                }
            }
        }

        return res;

    }


    public static boolean checkValid(int boundary, int lidx, int ridx, int [] prefixArr){
        if((ridx-lidx+1)<3){
            return false;
        }
        int left = prefixArr[lidx];
        int right = prefixArr[ridx-1];
        int sum = right-left;
        return sum==boundary;
    }
    public static void main(String[] args) {
        //Example 1:

        int [] capacity1 = {9,3,3,3,9};
        int output1= 2;

        //Example 2:

        int [] capacity2 = {1,2,3,4,5};
        int output2= 0;

        //Example 3:

        int [] capacity3 = {-4,4,0,0,-8,-4};
        int output3= 1;

        long ans1= countStableSubarrays(capacity1);
        long ans2= countStableSubarrays(capacity2);
        long ans3= countStableSubarrays(capacity3);

        if(output1==ans1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :"+output1 );
            System.out.println("Your Output :"+ans1);
        }
        if(output2==ans2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output :"+output2 );
            System.out.println("Your Output :"+ans2);
        }
        if(output3==ans3) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Actual Output :"+output3 );
            System.out.println("Your Output :"+ans3);
        }



    }
}
