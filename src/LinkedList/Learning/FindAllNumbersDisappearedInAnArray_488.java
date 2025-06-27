//448. Find All Numbers Disappeared in an Array

//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Hint
//Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.
//
// 
//
//Example 1:
//
//Input: nums = [4,3,2,7,8,2,3,1]
//Output: [5,6]
//Example 2:
//
//Input: nums = [1,1]
//Output: [2]
// 
//
//Constraints:
//
//n == nums.length
//1 <= n <= 105
//1 <= nums[i] <= n
// 
//
//Follow up: Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.


package LinkedList.Learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray_488 {
	
//	BruteForce approch :
//	put all element in hashset and iterate from 1 to n and check whic are not present in teh set
//	time complexity :O(n)
//	space complexity :O(1)
	public static List<Integer> findDisappearedNumbersBruteForce(int[] nums) {
		List<Integer> res =  new ArrayList<Integer>();
		HashSet<Integer> set= new HashSet<Integer>();
		for(int i =0;i<nums.length;i++){
			set.add(nums[i]);
		}
		
		for(int i =1;i<=nums.length;i++){
			if(set.contains(i)) {
				res.add(i);
			}
		}
		
		return res;
	}
	
//	best approch:
//	use count sort approch from kunal dsa series 
//	time complexity :O(n)
//	space complexity :O(1)
	  public static List<Integer> findDisappearedNumbersBest(int[] nums) {
	        List<Integer> res =  new ArrayList<Integer>();
	        for(int i =0;i<nums.length;i++){
	            while(nums[i]-1!=i){
	                if(nums[i] == nums[nums[i]-1]){
	                    break;
	                }
	                int temp= nums[i];
	                nums[i]= nums[temp-1];
	                nums[temp-1]=temp;
	            }
	        }
	
	        for(int i =0;i<nums.length;i++){
	            if(nums[i]!=i+1){
	                res.add(i+1);
	            }
	        }
	        return res;
	    }
	  
	  
	  public static void main(String[] args) {
		  //Example 1:

		  int [] nums1 =  {4,3,2,7,8,2,3,1};
		  List<Integer> output1= new ArrayList(Arrays.asList(5,6));
		  //Example 2:
		  
		  int [] nums2 =  {1,1};
		  List<Integer> output2= new ArrayList(Arrays.asList(2));		  
			
		  System.out.println("Brute Force Approch :");
	    	List<Integer>ans1=findDisappearedNumbersBruteForce(nums1);
	    	List<Integer>ans2=findDisappearedNumbersBruteForce(nums2);
	    	
	    	
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
		    	
		    System.out.println("Better Approch :");
		    ans1=findDisappearedNumbersBest(nums1);
		    ans2=findDisappearedNumbersBest(nums2);
		    
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

