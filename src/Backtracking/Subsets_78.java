//78. Subsets
//Medium
//Topics
//Companies
//Given an integer array nums of unique elements, return all possible subsets (the power set).
//
//The solution set must not contain duplicate subsets. Return the solution in any order.
//
// 
//
//Example 1:
//
//Input: nums = [1,2,3]
//Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
//Example 2:
//
//Input: nums = [0]
//Output: [[],[0]]
// 
//
//Constraints:
//
//1 <= nums.length <= 10
//-10 <= nums[i] <= 10
//All the numbers of nums are unique.

package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Subsets_78 {
//	brute force approch :
	
    public static List<List<Integer>> subsets(int[] nums) {
        double end = Math.pow(2,nums.length);
        int n=nums.length;
        List<List<Integer>> ans  = new ArrayList();
        ans.add(new ArrayList());// for no value sub set
        for(int i=1;i<end;i++){
            String x =Integer.toBinaryString(i);
            
            List<Integer> temp = new ArrayList();
            int index=0;
            for(int j =x.length()-1;j>=0;j--) {
            	if(x.charAt(j)=='1') {
            		temp.add(nums[index]);
            	}
            	index++;
            }
            ans.add(temp);
        }
        return ans;
    }
    public static void main(String[] args) {
    	//Example 1:

    	int [] nums1 = {1,2,3};
    	List<List<Integer>> output1= new ArrayList(Arrays.asList(Arrays.asList(),Arrays.asList(1),Arrays.asList(2),Arrays.asList(1,2),Arrays.asList(3),Arrays.asList(1,3),Arrays.asList(2,3),Arrays.asList(1,2,3)));
    	
    	//Example 2:

    	int [] nums2 = {0};    	
    	List<List<Integer>> output2= new ArrayList(Arrays.asList(Arrays.asList(),Arrays.asList(0)));



        List<List<Integer>> ans1 = subsets(nums1);
        List<List<Integer>>  ans2 = subsets(nums2);


        if(output1.equals(ans1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+ output1);
            System.out.println("Your Answer :"+ ans1);
        }

        if(output2.equals(ans2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+ output2);
            System.out.println("Your Answer :"+ ans2);
        }
    }

}
