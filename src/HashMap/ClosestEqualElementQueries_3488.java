//3488. Closest Equal Element Queries
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//You are given a circular array nums and an array queries.
//
//For each query i, you have to find the following:
//
//The minimum distance between the element at index queries[i] and any other index j in the circular array, where nums[j] == nums[queries[i]]. If no such index exists, the answer for that query should be -1.
//Return an array answer of the same size as queries, where answer[i] represents the result for query i.
//
//
//
//Example 1:
//
//Input: nums = [1,3,1,4,1,3,2], queries = [0,3,5]
//
//Output: [2,-1,3]
//
//Explanation:
//
//Query 0: The element at queries[0] = 0 is nums[0] = 1. The nearest index with the same value is 2, and the distance between them is 2.
//Query 1: The element at queries[1] = 3 is nums[3] = 4. No other index contains 4, so the result is -1.
//Query 2: The element at queries[2] = 5 is nums[5] = 3. The nearest index with the same value is 1, and the distance between them is 3 (following the circular path: 5 -> 6 -> 0 -> 1).
//Example 2:
//
//Input: nums = [1,2,3,4], queries = [0,1,2,3]
//
//Output: [-1,-1,-1,-1]
//
//Explanation:
//
//Each value in nums is unique, so no index shares the same value as the queried element. This results in -1 for all queries.
//
//
//
//Constraints:
//
//1 <= queries.length <= nums.length <= 105
//1 <= nums[i] <= 106
//0 <= queries[i] < nums.length
package HashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ClosestEqualElementQueries_3488 {
//    pproch: we can crete a map where key is the nums , and value is the list of index where it was present
//    now we can go through queries and serch through list using binary search and
//    find the left , right index of current index because its closest using both cyclic , acylic distance
//    nd return the min of both
//    Time complexity : O(n)+ O(log n)
//    space complexity : O(n)

    public static List<Integer> solveQueries(int[] nums, int[] queries) {
        HashMap<Integer,List<Integer>> map = new HashMap();
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.get(nums[i]).add(i);
            }else{
                map.put(nums[i],new ArrayList(Arrays.asList(i)));
            }
        }

        for(int index:queries){
            List<Integer> indexes= map.get(nums[index]);
            // find the index :
            int i= binarySearch(indexes,index);
            res.add(getClosestPair(i,indexes,nums.length));

        }
        return res;
    }

    public static int binarySearch(List<Integer> index, int target){
        int s =0;
        int e = index.size()-1;
        while(s<=e){
            int mid= s+(e-s)/2;
            if(index.get(mid)==target){return mid;}
            if(index.get(mid)<target){s=mid+1;}
            if(index.get(mid)>target){e=mid-1;}
        }
        return -1;
    }

    public static int getClosestPair(int i,List<Integer> pairs,int size){
        int n = pairs.size();

        if(n<=1){return -1;}
        int right =  (i+1)%n;
        int left = i-1;
        if(left<0){left = n+left;}
        int leftDistance= getMinDistance(pairs.get(i),pairs.get(left),size) ;
        int rightDistance=  getMinDistance(pairs.get(i),pairs.get(right),size) ;;
        int res = Math.min(leftDistance,rightDistance);
        return res;
    }

    public static int getMinDistance(int p1, int p2, int size){
        int lowIdx =Math.min(p1, p2);
        int highIdx =Math.max(p1,p2);
        int clockWise = highIdx-lowIdx;
        int antiClockWise = size-clockWise;
        return  Math.min(clockWise,antiClockWise);
    }

    public static void main(String[] args) {
        //Example 1:

        int [] nums1 = {1,3,1,4,1,3,2}, queries1 = {0,3,5};
        List<Integer> output1 = Arrays.asList(2,-1,3);

        //Example 2:

        int [] nums2 = {1,2,3,4}, queries2 = {0,1,2,3};
        List<Integer> output2 = Arrays.asList(-1,-1,-1,-1);

        List<Integer> ans1= solveQueries(nums1,queries1);
        List<Integer> ans2= solveQueries(nums2,queries2);
        if(output1.equals(ans1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :"+output1 );
            System.out.println("Your Output :"+ans1);
        }
        if(output2.equals(ans2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output :"+output2 );
            System.out.println("Your Output :"+ans2);
        }


    }
}
