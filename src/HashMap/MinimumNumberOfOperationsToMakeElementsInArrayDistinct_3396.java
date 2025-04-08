//3396. Minimum Number of Operations to Make Elements in Array Distinct
//Easy
//Topics
//Companies
//Hint
//You are given an integer array nums. You need to ensure that the elements in the array are distinct. To achieve this, you can perform the following operation any number of times:
//
//Remove 3 elements from the beginning of the array. If the array has fewer than 3 elements, remove all remaining elements.
//Note that an empty array is considered to have distinct elements. Return the minimum number of operations needed to make the elements in the array distinct.
//
// 
//
//Example 1:
//
//Input: nums = [1,2,3,4,2,3,3,5,7]
//
//Output: 2
//
//Explanation:
//
//In the first operation, the first 3 elements are removed, resulting in the array [4, 2, 3, 3, 5, 7].
//In the second operation, the next 3 elements are removed, resulting in the array [3, 5, 7], which has distinct elements.
//Therefore, the answer is 2.
//
//Example 2:
//
//Input: nums = [4,5,6,4,4]
//
//Output: 2
//
//Explanation:
//
//In the first operation, the first 3 elements are removed, resulting in the array [4, 4].
//In the second operation, all remaining elements are removed, resulting in an empty array.
//Therefore, the answer is 2.
//
//Example 3:
//
//Input: nums = [6,7,8,9]
//
//Output: 0
//
//Explanation:
//
//The array already contains distinct elements. Therefore, the answer is 0.
//
// 
//
//Constraints:
//
//1 <= nums.length <= 100
//1 <= nums[i] <= 100

package HashMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MinimumNumberOfOperationsToMakeElementsInArrayDistinct_3396 {
//	approch : create a hashmap to keep track of ferquency 
//	and remove 3 elements if it does not satisfy condition update hash map
//	we can update hash map efficiently by decrementing the frequency in hash map rather 
//	then re calculating frequency
//	time complexity : O(n*n)
//	space complexity : O(n)
	    public static int minimumOperationsBruteForce(int[] nums) {
	        HashMap <Integer,Integer> map = new HashMap();
	        for(int x:nums){
	            if(map.containsKey(x)){
	                map.put(x,map.get(x)+1);
	            }else{
	            map.put(x,1);
	            }
	        }
	        
	        int count=0;
	        int index=0;
	        while(checkfrequency(map)){
	            for(int i =0;i<3;i++){
	                if(index>=nums.length) break;
	                map.put(nums[index],map.get(nums[index])-1);
	                index++;
	            }
	            count++;
	        }
	        return count;
	    }
	    public static boolean checkfrequency(HashMap <Integer,Integer> map){
	        for(Map.Entry<Integer,Integer> e:map.entrySet()){
	            if(e.getValue()>1){
	               return true; 
	            }
	        }
	        return false;
	    }
	    
	    
//	approch:
//	intution and observation when we see a thing
//	when we find the last repeating element we can eliminate all the 3 pairs before that element
//	by doing that we can find the count of operations 
//	so we can keep hash set to keep track of each element we seen
//	and iterate in revese find first element repeating if found we will check
//	how much element are before it so we can elimniate all 3 pairs elements we can caluate it
//	using current index +1 which will tell us count and /3 will give pairs
//	now what if the elements are still repeating so we will check whather its a perfect divisible by 3
//	if not we need to deduct extra element means it will take one more extra operations    
//	Time Complexity :O(n) 
//	Space Complexity :O(n) 
	    public static int minimumOperationsBetter(int[] nums) {
	    	        int n=nums.length;// length
	    	        HashSet<Integer> set = new HashSet();// hash set to track
	    	        for(int i =n-1;i>=0;i--){// reverse iteartion
	    	            if(set.contains(nums[i])){// check element present in set
	    	            int ans= (i+1)/3;// if yes we will cehck its position using index+1 now will /3 to get number of opeation till mutiple of 3  
	    	            if(((i+1)%3)!=0){// if the position is not a perfect mulitple of 3 means we need one extra operations
	    	                return ans+1;
	    	            }    
	    	            return ans;
	    	            }
	    	            set.add(nums[i]);// if element is not repeating we will add that element in set
	    	        }
	    	        return 0;// if no number repeated above we can say 0
	    	    }
	    	 
	    
	    
	    
	    public static void main(String[] args) {
	    	
	    	
	    	//Example 1:
	    	
	    	int []nums1 = {1,2,3,4,2,3,3,5,7};
	    	int output1=2;

	    	//Example 2:
	    	
	    	int []nums2 = {4,5,6,4,4};
	    	int output2=2;
	    	
	    	//Example 3:

	    	int []nums3 = {6,7,8,9};
	    	int output3=0;
	    	
	    	System.out.println("Brute Force Approch :");
	    	
	    	int ans1=minimumOperationsBruteForce(nums1);
	    	int ans2=minimumOperationsBruteForce(nums2);
	    	int ans3=minimumOperationsBruteForce(nums3);
	    	
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
	    		System.out.println("Actual Output :"+output3);
	    		System.out.println("Your Output :"+ans3);
	    	}
	    	System.out.println("Better Force Approch :");
			
			ans1=minimumOperationsBruteForce(nums1);
			ans2=minimumOperationsBruteForce(nums2);
			ans3=minimumOperationsBruteForce(nums3);
			
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
				System.out.println("Actual Output :"+output3);
				System.out.println("Your Output :"+ans3);
			}
		}
}
