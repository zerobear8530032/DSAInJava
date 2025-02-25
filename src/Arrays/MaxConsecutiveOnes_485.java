//485. Max Consecutive Ones
//Solved
//Easy
//Topics
//Companies
//Hint
//Given a binary array nums, return the maximum number of consecutive 1's in the array.
//
// 
//
//Example 1:
//
//Input: nums = [1,1,0,1,1,1]
//Output: 3
//Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
//Example 2:
//
//Input: nums = [1,0,1,1,0,1]
//Output: 2
// 
//
//Constraints:
//
//1 <= nums.length <= 105
//nums[i] is either 0 or 1.
package Arrays;
public class MaxConsecutiveOnes_485 {

//    Naive approch :use a simple outer loop and the nested loop to count the number of 1
//	get max number of count and return as output
	
//	time complexity :O(N)
//	Space complexity :O(1)
	
	public static int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0;
        int idx=0;
        while(idx<nums.length){// this will exceute for entire array 
        int count =0;
            while(idx<nums.length && nums[idx]==1){// this will execute until there are consicutive 1 the end we will have the count 
            	
                count++;
                idx++;
            }
        idx++;
        ans=Math.max(ans,count);
        }
        return ans;
    }
// other approch : using single loop :

//	time complexity :O(N)
//	Space complexity :O(1)
	
	public static int findMaxConsecutiveOnesBetter(int[] nums) {
		int ans = 0;
		int count=0;
		for(int idx =0;idx<nums.length;idx++) {
			if(nums[idx]==1) {
				count++;
			}else {
				ans=Math.max(ans, count);
				count=0;
			}
		}
		return Math.max(ans, count);// this is nessasry for checking the last  1 be counted in the output
	}
    public static void main(String[] args) {

    	//Example 1:
    	
    	int [] nums1 = {1,1,0,1,1,1};
    	int output1= 3;
    	
    	//Example 2:
    	
    	int []nums2 = {1,0,1,1,0,1};
    	int output2= 2;
    	
    	int ans1=findMaxConsecutiveOnes(nums1);
    	int ans2=findMaxConsecutiveOnes(nums2);
    	
    	System.out.println("Iterative Approch :");
    	
    	if(output1==ans1) {
    		System.out.println("Case 1 Passed");
    	}else {
    		System.out.println("Case 1 Failed");
    		System.out.println("Expected Ouput :"+ output1);
			System.out.println("Your Answer :"+ ans1);  		
    	}
    	if(output2==ans2) {
    		System.out.println("Case 2 Passed");
    	}else {
    		System.out.println("Case 2 Failed");
    		System.out.println("Expected Ouput :"+ output2);
    		System.out.println("Your Answer :"+ ans2);  		
    	}
    	
//    	different approch no inner loop 
    	
    	ans1=findMaxConsecutiveOnesBetter(nums1);
    	ans2=findMaxConsecutiveOnesBetter(nums2);
    	
    	System.out.println("Iterative Approch :");
    	
    	if(output1==ans1) {
    		System.out.println("Case 1 Passed");
    	}else {
    		System.out.println("Case 1 Failed");
    		System.out.println("Expected Ouput :"+ output1);
    		System.out.println("Your Answer :"+ ans1);  		
    	}
    	if(output2==ans2) {
    		System.out.println("Case 2 Passed");
    	}else {
    		System.out.println("Case 2 Failed");
    		System.out.println("Expected Ouput :"+ output2);
    		System.out.println("Your Answer :"+ ans2);  		
    	}
    	

	}
}